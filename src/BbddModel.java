import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Properties;

public class BbddModel implements DataManager {
    private Connection conexion = null;
    HashMap<Integer, Curse> hm_curses = new HashMap<Integer, Curse>();
    // Para hacer la conexion con la bbdd ya no es necesario acceder al fichero ini porque esta todo en el hashmap
    public BbddModel() {


        HashMap<String, String> hm_config = this.saveBbddConfig("src/BbddConexion.ini");
        try {
            conexion = DriverManager.getConnection(hm_config.get("url") + (hm_config.get("dbName"))
                    , (hm_config.get("userName")), (hm_config.get("password")));
            if (!conexion.isClosed())
                System.out.println("conected into bbdd");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // Con este metodo guardamos la configuracion del fichero ini en un hashmap
    public HashMap<String, String> saveBbddConfig(String fichero) {
        Properties p = new Properties();
        FileInputStream fl = null;
        try {
            fl = new FileInputStream(fichero);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            p.load(fl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, String> config = new HashMap<String, String>();
        config.put("url", p.getProperty("url"));
        config.put("dbName", p.getProperty("dbName"));
        config.put("driver", p.getProperty("driver"));
        config.put("userName", p.getProperty("userName"));
        config.put("password", p.getProperty("password"));
        return config;

    }

 // método para añadir una entidad a la bbdd.
    @Override
    public void addEntity(Entity entitie) throws FileNotFoundException, IOException {
        // comprobamos que el id no este ya en la base de datos, en ese caso no realizaremos el insert
        boolean bl_ok = true;
        try (PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM personas")) {
            ResultSet rs = stmt.executeQuery();
            try {
                int id = Integer.parseInt(entitie.getStr_mid());
                while (rs.next()) {
                    if (rs.getInt("ID") == id) {
                        bl_ok = false;
                    }

                }
            } catch (NumberFormatException excepcion) {
                System.out.println("the id have to be a number");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (bl_ok) {
            try (PreparedStatement stmt = conexion.prepareStatement("INSERT INTO personas(ID,Nombre,CaracteristicaUno,CaracteristicaDos,CaracteristicaTres,ID_curso) VALUES (?,?,?,?,?,?)")) {
                try {
                    int id = Integer.parseInt(entitie.getStr_mid());
                    stmt.setInt(1, id);
                    stmt.setString(2, entitie.getStr_mname());
                    stmt.setString(3, entitie.getStr_mfirst_characteristic());
                    stmt.setString(4, entitie.getStr_msecond_characteristic());
                    stmt.setString(5, entitie.getStr_mthird_characteristic());
                    stmt.setInt(6, entitie.getCurse().getInt_id()) ;

                    System.out.println(stmt.toString());

                    stmt.executeUpdate();
                    System.out.println("insert do it!");
                } catch (NumberFormatException excepcion) {
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else {
            System.out.println("the id is already exists ");
        }
    }
    public void addCurse(Curse curse) throws FileNotFoundException, IOException {
        // comprobamos que el id no este ya en la base de datos, en ese caso no realizaremos el insert
        boolean bl_ok = true;
        try (PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM curso")) {
            ResultSet rs = stmt.executeQuery();
            try {
                int id = curse.getInt_id();
                while (rs.next()) {
                    if (rs.getInt("ID") == id) {
                        bl_ok = false;
                    }

                }
            } catch (NumberFormatException excepcion) {
                System.out.println("the id have to be a number");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (bl_ok) {
            try (PreparedStatement stmt = conexion.prepareStatement("INSERT INTO curso(ID,Nombre,CaracteristicaUno,CaracteristicaDos,CaracteristicaTres) VALUES (?,?,?,?,?)")) {
                try {
                    stmt.setInt(1, curse.getInt_id());
                    stmt.setString(2, curse.getStr_mname());
                    stmt.setString(3, curse.getStr_mfirst_characteristic());
                    stmt.setString(4, curse.getStr_msecond_characteristic());
                    stmt.setString(5, curse.getStr_mthird_characteristic());


                    System.out.println(stmt.toString());

                    stmt.executeUpdate();
                    System.out.println("insert do it!");
                } catch (NumberFormatException excepcion) {
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else {
            System.out.println("the id is already exists ");
        }
    }
    //con esta funcion nos devuelve el curso entero mandandole el id.
    public Curse searchCurse(int id_curse) {
        Curse curse = new Curse();
        try (PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM curso WHERE ID = " + id_curse)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                curse = new Curse(rs.getInt("ID"), rs.getString("Nombre"), rs.getString("CaracteristicaUno")
                        , rs.getString("CaracteristicaDos"),
                        rs.getString("CaracteristicaTres"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return curse;
    }


    @Override
    public HashMap<String, Entity> saveEntities() {
        HashMap<String, Entity> hm_entities = new  HashMap<String, Entity>();
        Curse curse = new Curse();
        try (PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM personas")) { // Extrae listado de personas
            ResultSet rs = stmt.executeQuery(); // Almacena resultados
            while (rs.next()) { // Itera resultados
                Entity entitie = new Entity(
                        rs.getInt("ID") + "",
                        rs.getString("Nombre"),
                        rs.getString("CaracteristicaUno"),
                        rs.getString("CaracteristicaDos"),
                        rs.getString("CaracteristicaTres"),
                        searchCurse(rs.getInt("ID_curso"))
                ); // Extraes parametros e instancias objeto (Entity)
                hm_entities.put(rs.getInt("ID") + " ", entitie); // Añado nuevo objeto al hashmap
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hm_entities; // Devuelvo hashmap con los resultados
    }

    public HashMap<Integer, Curse>  saveCurses() {
        HashMap<Integer, Curse> hm_curses =new HashMap<Integer,Curse>();
        Curse curse = new Curse();
        try (PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM curso")) { // Extrae listado de cursos
            ResultSet rs = stmt.executeQuery(); // Almacena resultados
            while (rs.next()) { // Itera resultados
                curse = new Curse(
                        rs.getInt("ID"),
                        rs.getString("Nombre"),
                        rs.getString("CaracteristicaUno"),
                        rs.getString("CaracteristicaDos"),
                        rs.getString("CaracteristicaTres")
                ); // Extraes parametros e instancias objeto (Entity)
                hm_curses.put(rs.getInt("ID"), curse); // Añado nuevo objeto al hashmap
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hm_curses; // Devuelvo hashmap con los resultados
    }
    public void showAllCurses() throws FileNotFoundException, IOException {
        try (PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM curso")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("ID") + "\n" + "name: " + rs.getString("Nombre") +
                        "\n" + "first_characteristic: " + rs.getString("CaracteristicaUno") + "\n" + "second_characteristic: " + rs.getString("CaracteristicaDos")
                        + "\n" + "third_characteristic: " + rs.getString("CaracteristicaDos"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void showAll() throws FileNotFoundException, IOException {
        try (PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM personas")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("ID") + "\n" + "name: " + rs.getString("Nombre") +
                        "\n" + "first_characteristic: " + rs.getString("CaracteristicaUno") + "\n" + "second_characteristic: " + rs.getString("CaracteristicaDos")
                        + "\n" + "third_characteristic: " + rs.getString("CaracteristicaDos") + "\n" + "curse: " + rs.getInt("ID_curso"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOne(int id) {
        try {
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM personas WHERE id = ? ");
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}