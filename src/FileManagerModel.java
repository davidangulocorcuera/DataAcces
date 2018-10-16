import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileManagerModel implements DataManager {
    public String getStr_file() {
        return str_file;
    }

    private String str_file;

    public FileManagerModel(){}
    public FileManagerModel(String str_file) {
        this.str_file = str_file;
    }

    @Override
    public void addEntity(Entity entity) throws FileNotFoundException, IOException {
        try {
            FileWriter fw = new FileWriter("src/Persona.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.write("id: " + entity.getStr_mid() + "\n");
            fw.write("name: " + entity.getStr_mname() + "\n");
            fw.write("first_characteristic: " + entity.getStr_mfirst_characteristic() + "\n");
            fw.write("second_characteristic: " + entity.getStr_msecond_characteristic() + "\n");
            fw.write("third_characteristic: " + entity.getStr_mthird_characteristic() + "\n");
            fw.write("id_curse: " + entity.getCurse().getInt_id() + "\n"
                    + "*" + "\n");

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addCurse(Curse curse) throws FileNotFoundException, IOException {
        try {
            FileWriter fw = new FileWriter("src/Curso.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.write("id: " + curse.getInt_id() + "\n");
            fw.write("name: " + curse.getStr_mname() + "\n");
            fw.write("first_characteristic: " + curse.getStr_mfirst_characteristic() + "\n");
            fw.write("second_characteristic: " + curse.getStr_msecond_characteristic() + "\n");
            fw.write("third_characteristic: " + curse.getStr_mthird_characteristic() + "\n"
                    + "*" + "\n");

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public HashMap<String, Entity> saveEntities() throws FileNotFoundException, IOException {
        HashMap<String, Entity> hm_entities = new  HashMap<String, Entity>();
        HashMap<Integer, Curse> hm_curses;
        String line;
        FileReader f = new FileReader(getStr_file());
        BufferedReader b = new BufferedReader(f);
        // Almacena resultados
        // Extrae listado de personas

        Entity entity = new Entity();
        hm_curses = saveCurses();
        while ((line = b.readLine()) != null) {
            // Itera resultados
            if (!line.equals("*")) {
                String[] data = line.split(":");
                String key = data[0];
                String value = data[1].trim(); //Limpia el string de carácteres vacíos en los extremos

                switch (key) {
                    case "id":
                        entity.setStr_mid(value);
                        break;
                    case "name":
                        entity.setStr_mname(value);
                        break;
                    case "first_characteristic":
                        entity.setStr_mfirst_characteristic(value);
                        break;
                    case "second_characteristic":
                        entity.setStr_msecond_characteristic(value);
                        break;
                    case "third_characteristic":
                        entity.setStr_mthird_characteristic(value);

                        break;
                    case "id_curse":

                        int id_curse = Integer.parseInt(value);
                       // System.out.println("LEIDO" + hm_curses.get(id_curse));

                        entity.setCurse(hm_curses.get(id_curse));
                        break;
                }
            } else {

                hm_entities.put(entity.getStr_mid(), entity);
                // Añado nuevo objeto al hashmap
                entity = new Entity();


            }

        }



        //System.out.println("hola");
        //hm_entities.put(entity.getId(), entity);
        //System.out.println(hm_entities.get(26).getCurse().getId());
       // hm_entities.forEach((k, v) -> System.out.println("Key: " + k + ": Value: " + v));
        // Devuelvo hashmap con los resultados


        return hm_entities;
    }

    public HashMap<Integer, Curse> saveCurses() throws IOException {
        HashMap<Integer, Curse> hm_curses = new  HashMap<Integer, Curse>();
        String line;
        FileReader f = null;
        try {
            f = new FileReader("src/Curso.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader b = new BufferedReader(f);
        // Almacena resultados
        // Extrae listado de personas

        Curse curse = new Curse();
        while ((line = b.readLine()) != null) {
            // Itera resultados
            if (!line.equals("*")) {
                String[] data = line.split(":");
                String key = data[0];
                String value = data[1].trim(); //Limpia el string de carácteres vacíos en los extremos

                switch (key) {
                    case "id":
                       curse.setInt_id(Integer.parseInt(value));
                        break;
                    case "name":
                        curse.setStr_mname(value);
                        break;
                    case "first_characteristic":
                        curse.setStr_mfirst_characteristic(value);
                        break;
                    case "second_characteristic":
                        curse.setStr_msecond_characteristic(value);
                        break;
                    case "third_characteristic":
                        curse.setStr_mthird_characteristic(value);
                        break;
                }
            } else {
                hm_curses.put(curse.getInt_id(), curse);
                // Añado nuevo objeto al hashmap
                curse = new Curse();
            }
        }
        //hm_entities.put(entity.getId(), entity);
        //hm_curses.forEach((k, v) -> System.out.println("Key: " + k + ": Value: " + v));
       // System.out.println(hm_curses);

        // Devuelvo hashmap con los resultados


        return hm_curses;
    }

    @Override
    public void showAll() throws FileNotFoundException, IOException {
        String str_text;
        FileReader f = new FileReader(getStr_file());
        BufferedReader b = new BufferedReader(f);
        while ((str_text = b.readLine()) != null) {
            System.out.println(str_text);
        }
        b.close();
    }
    @Override
    public void addAllEntities(DataManager acces) {

        HashMap<String, Entity> hm_entities = new  HashMap<String, Entity>();
        try {
            hm_entities = saveEntities();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, Entity> entry : hm_entities.entrySet()) {
            String k = entry.getKey();
            Entity v = entry.getValue();
            try {
                acces.addEntity(hm_entities.get(k));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void showAllCurses() throws FileNotFoundException, IOException {
        String str_text;
        FileReader f = new FileReader("src/Curso.txt");
        BufferedReader b = new BufferedReader(f);
        while ((str_text = b.readLine()) != null) {
            System.out.println(str_text);
        }
        b.close();
    }




    @Override
    public void deleteOne(int id) {


        HashMap<String, Entity> hm_entities = new HashMap<String, Entity>();
        try {
            hm_entities = saveEntities();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter fl = null;
        try {
            fl = new FileWriter(getStr_file());
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fl);
        String str_id = id + "";

        hm_entities.remove(str_id);

        for (Map.Entry<String, Entity> entry : hm_entities.entrySet()) {
            String k = entry.getKey();
            Entity v = entry.getValue();
            try {
                addEntity(v);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("deleted!");

    }


}