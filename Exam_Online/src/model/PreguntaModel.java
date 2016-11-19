package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import entidades.Pregunta;



public class PreguntaModel{
	
	
	public static EntityManagerFactory emf =	
			Persistence.createEntityManagerFactory("ProyectoYuncarJPA");
	
public void registrar(Pregunta c){
		
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



public List<Pregunta> listaActividad(){
	EntityManager manager = null;
	try {
		
		manager = emf.createEntityManager();
		String sql = "Select c from Actividad c";
		TypedQuery<Pregunta>  q = manager.createQuery(sql, Pregunta.class);
		return q.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
}
	
}
