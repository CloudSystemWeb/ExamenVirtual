package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidades.Curso;

public class CursoModel {

	public static EntityManagerFactory emf =	
			Persistence.createEntityManagerFactory("DAW2-Semana03-Generacion");

	public void inserta(Curso c){
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
	
	public void elimina(Curso c){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			//manager.find --> es como select por ID
			Curso aux = manager.find(Curso.class, c.getIdcurso());
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
	
	
	public void actualiza(Curso c){
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
	
	public List<Curso> listaCurso(){
		EntityManager manager = emf.createEntityManager();
		TypedQuery<Curso> q = manager.createQuery("select c from Curso c",Curso.class);
		return q.getResultList();
	}
}









