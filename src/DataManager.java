import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface DataManager {
    public void addEntity ( Entity entitie) throws FileNotFoundException, IOException;
    public HashMap<String, Entity> saveEntities (HashMap<String, Entity> hm_entities)throws FileNotFoundException, IOException;
    public void showAll() throws FileNotFoundException, IOException;
    public void deleteOne(int id);
}