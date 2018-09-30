import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface DataManager {
    public void addEntity (String str_file, Entity entitie) throws FileNotFoundException, IOException;
    public HashMap<String, Entity> saveEntities (HashMap<String, Entity> hm_entities);
    public void showAll(String str_file) throws FileNotFoundException, IOException;
}
