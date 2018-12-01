import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class JsonModel implements DataManager {
    private Entity newEntity;
    private Curse newCurse;
    Curse curse;
    ApiRequests encargadoPeticiones;
    private String SERVER_PATH, GET_ENTITY,GET_CURSE, SET_ENTITY,SET_CURSE; // Datos de la conexion

    public JsonModel() {
        char c;

        encargadoPeticiones = new ApiRequests();

        SERVER_PATH = "http://localhost/DavidAngulo/crudJson/";
        GET_ENTITY = "readEntity.php";
        GET_CURSE = "readCurse.php";
        SET_ENTITY = "writeEntity.php";
        SET_CURSE = "writeCurse.php";

    }



    @Override
    public void addEntity(Entity auxEntity) throws FileNotFoundException, IOException {
        try {
            JSONObject objJEntity = new JSONObject();
            JSONObject objPeticion = new JSONObject();

            objJEntity.put("str_mid", auxEntity.getStr_mid());
            objJEntity.put("str_mname", auxEntity.getStr_mname());
            objJEntity.put("str_mfirst_characteristic", auxEntity.getStr_mfirst_characteristic());
            objJEntity.put("str_msecond_characteristic", auxEntity.getStr_msecond_characteristic());
            objJEntity.put("str_mthird_characteristic", auxEntity.getStr_mthird_characteristic());
            objJEntity.put("id_curse", auxEntity.getCurse().getInt_id());



            // Tenemos el jugador como objeto JSON. Lo añadimos a una peticion
            // Lo transformamos a string y llamamos al
            // encargado de peticiones para que lo envie al PHP

            objPeticion.put("peticion", "add");
            objPeticion.put("entity", objJEntity);

            String json = objPeticion.toJSONString();

            System.out.println("Lanzamos peticion JSON para almacenar un jugador");

            String url = SERVER_PATH + SET_ENTITY;

            System.out.println("La url a la que lanzamos la petición es " + url);
            System.out.println("El json que enviamos es: ");
            System.out.println(json);
            //System.exit(-1);

            String response = encargadoPeticiones.postRequest(url, json);

            System.out.println("El json que recibimos es: ");

            System.out.println(response); // Traza para pruebas
            System.exit(-1);

            // Parseamos la respuesta y la convertimos en un JSONObject


            JSONObject respuesta = (JSONObject) JSONValue.parse(response.toString());

            if (respuesta == null) { // Si hay algún error de parseo (json
                // incorrecto porque hay algún caracter
                // raro, etc.) la respuesta será null
                System.out.println("El json recibido no es correcto. Finaliza la ejecución");
                System.exit(-1);
            } else { // El JSON recibido es correcto

                // Sera "ok" si todo ha ido bien o "error" si hay algún problema
                String estado = (String) respuesta.get("estado");
                if (estado.equals("ok")) {

                    System.out.println("Almacenado jugador enviado por JSON Remoto");

                } else { // Hemos recibido el json pero en el estado se nos
                    // indica que ha habido algún error

                    System.out.println("Acceso JSON REMOTO - Error al almacenar los datos");
                    System.out.println("Error: " + (String) respuesta.get("error"));
                    System.out.println("Consulta: " + (String) respuesta.get("query"));

                    System.exit(-1);

                }
            }
        } catch (Exception e) {
            System.out.println(
                    "Excepcion desconocida. Traza de error comentada en el método 'annadirJugador' de la clase JSON REMOTO");
            // e.printStackTrace();
            System.out.println("Fin ejecución");
            System.exit(-1);
        }
    }

    @Override
    public void addCurse(Curse auxCurse) throws FileNotFoundException, IOException {
        try {
            JSONObject objJCurse = new JSONObject();
            JSONObject objPeticion = new JSONObject();

            objJCurse.put("int_id", auxCurse.getInt_id());
            objJCurse.put("str_mname", auxCurse.getStr_mname());
            objJCurse.put("str_mfirst_characteristic", auxCurse.getStr_mfirst_characteristic());
            objJCurse.put("str_msecond_characteristic", auxCurse.getStr_msecond_characteristic());
            objJCurse.put("str_mthird_characteristic", auxCurse.getStr_mthird_characteristic());




            // Tenemos el jugador como objeto JSON. Lo añadimos a una peticion
            // Lo transformamos a string y llamamos al
            // encargado de peticiones para que lo envie al PHP

            objPeticion.put("peticion", "add");
            objPeticion.put("curse", objJCurse);

            String json = objPeticion.toJSONString();

            System.out.println("Lanzamos peticion JSON para almacenar un jugador");

            String url = SERVER_PATH + SET_CURSE;

            System.out.println("La url a la que lanzamos la petición es " + url);
            System.out.println("El json que enviamos es: ");
            System.out.println(json);
            //System.exit(-1);

            String response = encargadoPeticiones.postRequest(url, json);

            System.out.println("El json que recibimos es: ");

            System.out.println(response); // Traza para pruebas
            System.exit(-1);

            // Parseamos la respuesta y la convertimos en un JSONObject


            JSONObject respuesta = (JSONObject) JSONValue.parse(response.toString());

            if (respuesta == null) { // Si hay algún error de parseo (json
                // incorrecto porque hay algún caracter
                // raro, etc.) la respuesta será null
                System.out.println("El json recibido no es correcto. Finaliza la ejecución");
                System.exit(-1);
            } else { // El JSON recibido es correcto

                // Sera "ok" si todo ha ido bien o "error" si hay algún problema
                String estado = (String) respuesta.get("estado");
                if (estado.equals("ok")) {

                    System.out.println("Almacenado jugador enviado por JSON Remoto");

                } else { // Hemos recibido el json pero en el estado se nos
                    // indica que ha habido algún error

                    System.out.println("Acceso JSON REMOTO - Error al almacenar los datos");
                    System.out.println("Error: " + (String) respuesta.get("error"));
                    System.out.println("Consulta: " + (String) respuesta.get("query"));

                    System.exit(-1);

                }
            }
        } catch (Exception e) {
            System.out.println(
                    "Excepcion desconocida. Traza de error comentada en el método 'annadirJugador' de la clase JSON REMOTO");
            // e.printStackTrace();
            System.out.println("Fin ejecución");
            System.exit(-1);
        }
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
        HashMap<String, Entity> hm_entities = new HashMap <String, Entity>();


        try {

            String url = SERVER_PATH + GET_ENTITY; // Sacadas de configuracion
            System.out.println("La url a la que lanzamos la petición es " + url); // Traza para pruebas

            String response = encargadoPeticiones.getRequest(url);



            // Parseamos la respuesta y la convertimos en un JSONObject
            JSONObject respuesta = (JSONObject) JSONValue.parse(response);

             // El JSON recibido es correcto
                String estado = (String) respuesta.get("estado");
                // Si ok, obtenemos array de jugadores para recorrer y generar hashmap
                if (estado.equals("ok")) {
                    JSONArray array = (JSONArray) respuesta.get("Personas");

                    if (array.size() > 0) {
                        for (int i = 0; i < array.size(); i++) {
                            JSONObject row = (JSONObject) array.get(i);

                            String   str_mid = row.get("str_mid").toString();
                            String  str_mname = row.get("str_mname").toString();
                            String  str_mfirst_characteristic = row.get("str_mfirst_characteristic").toString();
                            String  str_msecond_characteristic = row.get("str_msecond_characteristic").toString();
                            String str_mthird_characteristic = row.get("str_mthird_characteristic").toString();
                            curse = saveCurses().get(Integer.parseInt(row.get("curso").toString()));

                            newEntity = new Entity(str_mid,str_mname,str_mfirst_characteristic,str_msecond_characteristic,str_mthird_characteristic,curse);


                            hm_entities.put(str_mid, newEntity);
                        }

                        System.out.println("generado hashmap de entidades");
                        System.out.println();

                    }

                }


        } catch (Exception e) {
            System.out.println("Ha ocurrido un error en la busqueda de datos");

            e.printStackTrace();

            System.exit(-1);
        }

        return hm_entities;
    }

    @Override
    public HashMap<Integer, Curse> saveCurses() throws IOException {
        HashMap<Integer, Curse> hm_curses = new HashMap <Integer, Curse>();


        try {

            String url = SERVER_PATH + GET_CURSE; // Sacadas de configuracion
            System.out.println("La url a la que lanzamos la petición es " + url); // Traza para pruebas

            String response = encargadoPeticiones.getRequest(url);



            // Parseamos la respuesta y la convertimos en un JSONObject
            JSONObject respuesta = (JSONObject) JSONValue.parse(response);

            // El JSON recibido es correcto
            String estado = (String) respuesta.get("estado");
            // Si ok, obtenemos array de jugadores para recorrer y generar hashmap
            if (estado.equals("ok")) {
                JSONArray array = (JSONArray) respuesta.get("cursos");

                if (array.size() > 0) {
                    for (int i = 0; i < array.size(); i++) {
                        JSONObject row = (JSONObject) array.get(i);

                       int int_id =  Integer.parseInt(row.get("int_id").toString());
                        String str_mname = row.get("str_mname").toString();
                        String  str_mfirst_characteristic = row.get("str_mfirst_characteristic").toString();
                        String str_msecond_characteristic = row.get("str_msecond_characteristic").toString();
                        String str_mthird_characteristic = row.get("str_mthird_characteristic").toString();


                        newCurse = new Curse(int_id,str_mname,str_mfirst_characteristic,str_msecond_characteristic,str_mthird_characteristic);


                        hm_curses.put(int_id, newCurse);
                    }

                    System.out.println("generado hashmap de cursos");
                    System.out.println();

                }

            }


        } catch (Exception e) {
            System.out.println("Ha ocurrido un error en la busqueda de datos");

            e.printStackTrace();

            System.exit(-1);
        }

        return hm_curses;
    }

    @Override
    public void addAll(DataManager acces) {

    }

    public void anadirJugadorJSON(Entity auxEntity) {


        }

    }

