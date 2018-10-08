import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface DataManager {
    public void addEntity ( ProfileManager profile) throws FileNotFoundException, IOException;
    public HashMap<String, ProfileManager> saveEntities (HashMap<String, ProfileManager> hm_entities)throws FileNotFoundException, IOException;
    public void showAll() throws FileNotFoundException, IOException;
    public void deleteOne(int id);
}
