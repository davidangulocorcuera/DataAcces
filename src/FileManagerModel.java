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
            FileWriter fw = new FileWriter(getStr_file(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.write("id: " + entity.getId() + "\n");
            fw.write("name: " + entity.getName() + "\n");
            fw.write("first_characteristic: " + entity.getFirstCharacteristic() + "\n");
            fw.write("second_characteristic: " + entity.getSecondCharacteristic() + "\n");
            fw.write("third_characteristic: " + entity.getSecondCharacteristic() + "\n");
            fw.write("id_curse: " + entity.getCurse().getId() + "\n"
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
            fw.write("id: " + curse.getId() + "\n");
            fw.write("name: " + curse.getName() + "\n");
            fw.write("first_characteristic: " + curse.getFirstCharacteristic() + "\n");
            fw.write("second_characteristic: " + curse.getSecondCharacteristic() + "\n");
            fw.write("third_characteristic: " + curse.getThirdCharacteristic() + "\n"
                    + "*" + "\n");

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public HashMap<String, Entity> saveEntities() throws FileNotFoundException, IOException {
        HashMap<String, Entity> hm_entities = new  HashMap<String, Entity>();
        HashMap<Integer, Curse> hm_curses = new  HashMap<Integer, Curse>();
        String line;
        FileReader f = new FileReader(getStr_file());
        BufferedReader b = new BufferedReader(f);
        // Almacena resultados
        // Extrae listado de personas

        Entity entity = new Entity();
        while ((line = b.readLine()) != null) {
            // Itera resultados
            if (!line.equals("*")) {
                String[] data = line.split(":");
                String key = data[0];
                String value = data[1].trim(); //Limpia el string de carácteres vacíos en los extremos

                switch (key) {
                    case "id":
                        entity.setId(value);
                        break;
                    case "name":
                        entity.setName(value);
                        break;
                    case "first_characteristic":
                        entity.setFirstCharacteristic(value);
                        break;
                    case "second_characteristic":
                        entity.setSecondCharacteristic(value);
                        break;
                    case "third_characteristic":
                        entity.setThirdCharacteristic(value);

                        break;
                    case "id_curse":
                        hm_curses = saveCurses();
                        int id_curse = Integer.parseInt(value);
                        entity.setCurse(hm_curses.get(id_curse));
                        break;
                }
            } else {

                hm_entities.put(entity.getId(), entity);

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
                       curse.setId(Integer.parseInt(value));
                        break;
                    case "name":
                        curse.setName(value);
                        break;
                    case "first_characteristic":
                        curse.setFirstCharacteristic(value);
                        break;
                    case "second_characteristic":
                        curse.setSecondCharacteristic(value);
                        break;
                    case "third_characteristic":
                        curse.setThirdCharacteristic(value);
                        break;
                }
            } else {
                hm_curses.put(curse.getId(), curse);
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