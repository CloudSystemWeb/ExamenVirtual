package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidades.Programacion;

public class ProgramacionModel {

	public static EntityManagerFactory emf =	
			Persistence.createEntityManagerFactory("DAW2-Semana03-Generacion");

	public void inserta(Programacion c){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(c);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally{
			manager.close();
		}
	}
	
	public void elimina(Programacion c){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			//manager.find --> es como select por ID
			Programacion aux = manager.find(Programacion.class, c.getIdprogramacion());
			manager.getTransaction().begin();
			manager.remove(aux);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally{
			manager.close();
		}
	}
	
	
	public void actualiza(Programacion c){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(c);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally{
			manager.close();
		}
	}
	
	public List<Programacion> listaProgramacion(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<Programacion> q = manager.createQuery("select c from Programacion c",Programacion.class);
		return q.getResultList();
	}
}









