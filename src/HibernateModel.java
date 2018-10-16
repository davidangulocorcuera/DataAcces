
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


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

	}

	@Override
	public void addCurse(Curse curse) throws FileNotFoundException, IOException {

	}

	@Override
	public void showAllCurses() throws FileNotFoundException, IOException {
		System.out.println("Consultando cursos");

		Query q= session.createQuery("select e from Curse e");
		List results = q.list();

		Iterator cursesIterator= results.iterator();

		while (cursesIterator.hasNext()){
			Curse curse = (Curse)cursesIterator.next();

			System.out.println ( "Id: " + curse.getInt_id() + ", Nombre: " + curse.getStr_mname() + ", Primera Característica; " + curse.getStr_mfirst_characteristic() + ", Segunda Caracteristica: " + curse.getStr_msecond_characteristic() + ", Tercera Caracteristica: "
			+ curse.getStr_mthird_characteristic());

		}

		System.out.println("Fin Consulta");
	}

	@Override
	public HashMap<String, Entity> saveEntities() throws FileNotFoundException, IOException {
		return null;
	}

	@Override
	public void showAll() throws FileNotFoundException, IOException {

	}

	@Override
	public void deleteOne(int id) {

	}

	@Override
	public HashMap<Integer, Curse> saveCurses() throws IOException {
		return null;
	}
}
