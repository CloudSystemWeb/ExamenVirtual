package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidades.Alumno;
import entidades.Curso;

public class AlumnoModel {

	public static EntityManagerFactory emf =	
			Persistence.createEntityManagerFactory("DAW2-Semana03-Generacion");

	public void inserta(Alumno a){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(a);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally{
			manager.close();
		}
	}
	
	public void elimina(Alumno a){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			//manager.find --> es como select por ID
			Alumno aux = manager.find(Alumno.class, a.getIdalumno());
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
	
	
	public void actualiza(Alumno a){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(a);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally{
			manager.close();
		}
	}
	
	public List<Alumno> listaAlumno(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<Alumno> q = manager.createQuery("select a from Alumno a",Alumno.class);
		return q.getResultList();
	}
}









