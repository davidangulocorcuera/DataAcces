import java.io.*;
import java.util.HashMap;

public class FileManagerModel implements DataManager {
    @Override
    public void addEntity(String str_file, Entity entitie) throws FileNotFoundException, IOException {
        try {

            FileWriter fw = new FileWriter(str_file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.write("id: " + entitie.getId() + "\n");
            fw.write("name: " + entitie.getName() + "\n");
            fw.write("first_characteristic: " + entitie.getFirstCharacteristic() + "\n");
            fw.write("second_characteristic: " + entitie.getSecondCharacteristic() + "\n");
            fw.write("third_characteristic" + entitie.getThirdCharacteristic() + "\n");

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashMap<String, Entity> saveEntities(HashMap<String, Entity> hm_entities) {

        return hm_entities;
    }

    @Override
    public void showAll(String str_file) throws FileNotFoundException, IOException {
        String str_text;
        FileReader f = new FileReader(str_file);
        BufferedReader b = new BufferedReader(f);
        while ((str_text = b.readLine()) != null) {
            System.out.println(str_text);
        }
        b.close();
    }


}
