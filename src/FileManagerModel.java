import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileManagerModel implements DataManager {
    public String getStr_file() {
        return str_file;
    }

    private String str_file;
    public FileManagerModel(String str_file){
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
            fw.write("third_characteristic: " + entity.getThirdCharacteristic() + "\n"
            + "*" + "\n");

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // con esta funcion comprobamos que el texto actual contiene un id para añadirselo a la entidad
    public boolean testId(String str_text){
        return str_text.charAt(0) == 'i' && str_text.charAt(1) == 'd' && str_text.charAt(2) == ':';
    }

    @Override
    public HashMap<String, Entity> saveEntities(HashMap<String, Entity> hm_entities) throws FileNotFoundException, IOException {
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
                }
            } else {
                hm_entities.put(entity.getId(), entity);
                // Añado nuevo objeto al hashmap
                entity = new Entity();
            }
        }
        //hm_entities.put(entity.getId(), entity);
        hm_entities.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
        // Devuelvo hashmap con los resultados



        return hm_entities;
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
    public void deleteOne(int id) {
        HashMap<String, Entity> hm_entities = new HashMap<String, Entity>();
        try {
            hm_entities = saveEntities(hm_entities);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str_id = id + "";
        System.out.println(hm_entities.size());
        hm_entities.remove(str_id);
        System.out.println(hm_entities.size());
        for (Map.Entry<String, Entity> entry : hm_entities.entrySet()) {
            String k = entry.getKey();
            Entity v = entry.getValue();
            try {
                addEntity(v);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //("Key: " + k + ": Value: " + v))

    }


}
