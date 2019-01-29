import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MongoModel implements DataManager {
    MongoDatabase db;
    private JSONObject obj;
    private JSONArray arr;

    public MongoModel() {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            db = mongoClient.getDatabase("aplicacionjaime4");
            System.out.println("connected");

        } catch (Exception e) {
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
        MongoCollection<Document> colection = db.getCollection("usuarios");
        for (Document document : colection.find()) {
            System.out.println("id entidad" + document.get("id").toString());
            System.out.println("nombre " + document.get("nombre").toString());
            System.out.println("caracteristicaUno " + document.get("caracteristicaUno").toString());
            System.out.println("caracteristicaDos " + document.get("caracteristicaDos").toString());
            System.out.println("caracteristicaTres " + document.get("caracteristicaTres").toString());
            Document obj = (Document) document.get("curso");
            System.out.println("id curso" + obj.get("id").toString());
            System.out.println("-------------------------------------------------------------------");
        }
    }

    @Override
    public void showAllCurses() throws FileNotFoundException, IOException {
        MongoCollection<Document> colection = db.getCollection("usuarios");
        for (Document document : colection.find()) {
            Document obj = (Document) document.get("curso");
            System.out.println("id " + obj.get("id").toString());
            System.out.println("nombre " + obj.get("nombre").toString());
            System.out.println("caracteristicaUno " + obj.get("caracteristicaUno").toString());
            System.out.println("caracteristicaDos " + obj.get("caracteristicaDos").toString());
            System.out.println("caracteristicaTres " + obj.get("caracteristicaTres").toString());
        }
    }

    @Override
    public void deleteOne(int id) {

    }

    @Override
    public HashMap<String, Entity> saveEntities() throws FileNotFoundException, IOException {
        HashMap<String, Entity> entities = new HashMap<>();
        Entity entity = new Entity();
        Curse curse = new Curse();
        MongoCollection<Document> colection = db.getCollection("usuarios");


        for (Document document : colection.find()) {
            curse = new Curse();
            entity = new Entity();
            entity.setStr_mid(document.get("id").toString());
            entity.setStr_mname(document.get("nombre").toString());
            entity.setStr_mfirst_characteristic(document.get("caracteristicaUno").toString());
            entity.setStr_msecond_characteristic(document.get("caracteristicaDos").toString());
            entity.setStr_mthird_characteristic(document.get("caracteristicaTres").toString());


            Document obj = (Document) document.get("curso");

            curse.setInt_id(Integer.parseInt(obj.get("id").toString()));
            curse.setStr_mname(obj.get("nombre").toString());
            curse.setStr_mfirst_characteristic(obj.get("caracteristicaUno").toString());
            curse.setStr_msecond_characteristic(obj.get("caracteristicaDos").toString());
            curse.setStr_mthird_characteristic(obj.get("caracteristicaTres").toString());

            entity.setCurse(curse);

            entities.put(entity.getStr_mid(), entity);

            //metiendo los datos en el map


        }
        System.out.println("hay " + entities.size() + " entidades");

        return entities;
    }

    @Override
    public HashMap<Integer, Curse> saveCurses() throws IOException {
        HashMap<Integer, Curse> curses = new HashMap<>();
        Entity entity = new Entity();
        Curse curse = new Curse();
        MongoCollection<Document> colection = db.getCollection("usuarios");
        for (Document document : colection.find()) {
            curse = new Curse();
            Document obj = (Document) document.get("curso");
            curse.setInt_id(Integer.parseInt(obj.get("id").toString()));
            curse.setStr_mname(obj.get("nombre").toString());
            curse.setStr_mfirst_characteristic(obj.get("caracteristicaUno").toString());
            curse.setStr_msecond_characteristic(obj.get("caracteristicaDos").toString());
            curse.setStr_mthird_characteristic(obj.get("caracteristicaTres").toString());
            curses.put(curse.getInt_id(), curse);

        }
        System.out.println("hay " + curses.size() + " cursos");
        return curses;
    }

    @Override
    public void addAll(DataManager acces) {

    }
}
