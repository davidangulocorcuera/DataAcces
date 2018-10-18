import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public interface DataManager {
    public void addEntity ( Entity entitie) throws FileNotFoundException, IOException;
    public void addCurse(Curse curse) throws FileNotFoundException, IOException;
    public void showAll() throws FileNotFoundException, IOException;
    public void showAllCurses() throws FileNotFoundException, IOException;
    public void deleteOne(int id);
    public HashMap<String, Entity> saveEntities ()throws FileNotFoundException, IOException;
    public HashMap<Integer, Curse> saveCurses() throws IOException;
   // public void addAllEntities(DataManager acces);
   // public void addAllCurses(DataManager acces);
    public void addAll(DataManager acces);

}