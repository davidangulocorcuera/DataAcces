import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class MongoModel implements DataManager {

    public static void main(String[] args) {
        try{
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
            MongoDatabase db = mongoClient.getDatabase("maquinarefrescos");
            MongoCollection<Document> colection = db.getCollection("depositos");
            System.out.println("connected");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }



    @Override
    public void addEntity(Entity entitie) throws FileNotFoundException, IOException {

    }

    @Override
    public void addCurse(Curse curse) throws FileNotFoundException, IOException {

    }

    @Override
    public void showAll() throws FileNotFoundException, IOException {

    }

    @Override
    public void showAllCurses() throws FileNotFoundException, IOException {

    }

    @Override
    public void deleteOne(int id) {

    }

    @Override
    public HashMap<String, Entity> saveEntities() throws FileNotFoundException, IOException {
        return null;
    }

    @Override
    public HashMap<Integer, Curse> saveCurses() throws IOException {
        return null;
    }

    @Override
    public void addAll(DataManager acces) {

    }
}
