
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class HibernateModel implements DataManager {

    Session session;

    public HibernateModel() {

        HibernateUtil util = new HibernateUtil();

        session = util.getSessionFactory().openSession();
        System.out.println("conected");
    }
	
   /*
	public void borrarDatos(){
    	System.out.println("Inicio Borrado");

		session.beginTransaction();
    	
		Query q = session.createQuery("delete from JugadorPosicion");
		q.executeUpdate();
		q = session.createQuery("delete from Posicion");
		q.executeUpdate();
		q = session.createQuery("delete from Jugador");
		q.executeUpdate();
		q = session.createQuery("delete from Equipo");
		q.executeUpdate();
		
		session.getTransaction().commit();
		System.out.println("Fin Borrado");
	}
	
    public void consultaEquipo() {
    	System.out.println("Inicio Consulta Simple Equipos");
    	
        Query q= session.createQuery("select e from Equipo e");
        List results = q.list();
        
        Iterator equiposIterator= results.iterator();

        while (equiposIterator.hasNext()){
            Equipo team = (Equipo)equiposIterator.next();
            
        	System.out.println ( "		Id: " + team.getId() + " - Nombre: " + team.getNombre());
            
        }

    	System.out.println("Fin Consulta Equipos");
    }
	
	
    public void consultaJugadorPosicion() {
    	System.out.println("Inicio Consulta");
    	
        Query q= session.createQuery("select jp from JugadorPosicion jp order by jp.j.numero");
        List results = q.list();
        
        Iterator jugadoresIterator= results.iterator();
        int idJug;
        int auxId = 0;
        while (jugadoresIterator.hasNext()){
            JugadorPosicion jp = (JugadorPosicion)jugadoresIterator.next();
            Jugador j = jp.getJ();
            idJug = j.getIdJugador();
            if(idJug != auxId){
            	System.out.println ( "(" + j.getNumero() + ") " + j.getNombre());
            }
        	System.out.println ( "		Posicion: " + jp.getP().getPosicion() + " - numero de Veces: " + jp.getNumVeces());
        	auxId = idJug;
            
        }

    	System.out.println("Fin Consulta");
    } 
*/

    public void cerrarSesion() {

        session.close();

    }


    @Override
    public void addEntity(Entity entitie) throws FileNotFoundException, IOException {
        session.beginTransaction();
        session.save(entitie);
        session.getTransaction().commit();
        System.out.println("insert do it!");
    }

    @Override
    public void addCurse(Curse curse) throws FileNotFoundException, IOException {
        session.beginTransaction();
        session.save(curse);
        session.getTransaction().commit();
        System.out.println("insert do it!");
    }
    @Override
    public void addAllEntities(DataManager acces) {
        HashMap<String, Entity> hm_entities = new  HashMap<String, Entity>();
        try {
            hm_entities = saveEntities();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, Entity> entry : hm_entities.entrySet()) {
            String k = entry.getKey();
            Entity v = entry.getValue();
            try {
                acces.addEntity(hm_entities.get(k));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void showAllCurses() throws FileNotFoundException, IOException {
        System.out.println("Consultando cursos");

        Query q = session.createQuery("select e from Curse e");
        List results = q.list();

        Iterator cursesIterator = results.iterator();

        while (cursesIterator.hasNext()) {
            Curse curse = (Curse) cursesIterator.next();

            System.out.println("Id: " + curse.getInt_id() + ", Nombre: " + curse.getStr_mname() + ", Primera Característica; " + curse.getStr_mfirst_characteristic() + ", Segunda Caracteristica: " + curse.getStr_msecond_characteristic() + ", Tercera Caracteristica: "
                    + curse.getStr_mthird_characteristic());

        }

        System.out.println("Fin Consulta");
    }

    @Override
    public HashMap<String, Entity> saveEntities() throws FileNotFoundException, IOException {
        HashMap<String, Entity> hm_entities = new HashMap<String, Entity>();


        Query q = session.createQuery("select e from Entity e");
        List results = q.list();

        Iterator entitiesIterator = results.iterator();

        while (entitiesIterator.hasNext()) {
            Entity entity = (Entity) entitiesIterator.next();
            hm_entities.put(entity.getStr_mid(), entity);

        }


        return hm_entities;
    }

    @Override
    public void showAll() throws FileNotFoundException, IOException {
        System.out.println("Consultando entidades");

        Query q = session.createQuery("select e from Entity e");
        List results = q.list();

        Iterator entitiesIterator = results.iterator();

        while (entitiesIterator.hasNext()) {
            Entity entity = (Entity) entitiesIterator.next();

            System.out.println("Id: " + entity.getStr_mid() + ", Nombre: " + entity.getStr_mname() + ", Primera Característica; " + entity.getStr_mfirst_characteristic() + ", Segunda Caracteristica: " + entity.getStr_msecond_characteristic() + ", Tercera Caracteristica: "
                    + entity.getStr_mthird_characteristic() + " , id del curso: " + entity.getCurse().getInt_id());

        }

        System.out.println("Fin Consulta");
    }

    @Override
    public void deleteOne(int id) {

    }

    @Override
    public HashMap<Integer, Curse> saveCurses() throws IOException {
        HashMap<Integer, Curse> hm_curses = new HashMap<Integer, Curse>();


        Query q = session.createQuery("select e from Curse e");
        List results = q.list();

        Iterator cursesIterator = results.iterator();

        while (cursesIterator.hasNext()) {
            Curse curse = (Curse) cursesIterator.next();
            hm_curses.put(curse.getInt_id(), curse);

        }


        return hm_curses;
    }
}
