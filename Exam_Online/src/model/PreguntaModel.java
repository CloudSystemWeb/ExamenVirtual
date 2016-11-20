package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidades.Pregunta;

public class PreguntaModel {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW2-Semana03-Generacion");

	public void registrar(Pregunta c) {

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
		} finally {
			manager.close();
		}

	}

	public List<Pregunta> listaPregunta() {
		EntityManager manager = null;
		try {

			manager = emf.createEntityManager();
			String sql = "Select c from Pregunta c";
			TypedQuery<Pregunta> q = manager.createQuery(sql, Pregunta.class);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void elimina(Pregunta a) {
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			// manager.find --> es como select por ID
			Pregunta aux = manager.find(Pregunta.class, a.getIdpregunta());
			manager.getTransaction().begin();
			manager.remove(aux);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.close();
		}
	}
	
	public void actualiza(Pregunta a){
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

}
