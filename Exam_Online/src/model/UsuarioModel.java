package model;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Usuario;

public class UsuarioModel {

	public static EntityManagerFactory emf =	
			Persistence.createEntityManagerFactory("DAW2-Semana03-Generacion");

	public void inserta(Usuario u){
		EntityManager manager = null;
		try {
			manager = emf.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(u);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally{
			manager.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> obtenerPermisos(Map<String, Object> map){
		EntityManager em=emf.createEntityManager();
		List<Map<String, Object>> salida=null;
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("SELECT DISTINCT(a.id), a.menu.idmenu, a.menu.descripcion, a.submenu.idsubmenu, a.submenu.url, a.submenu.descripcion ,a.rol.idrol "
					+ " FROM Acceso a, Rol r  where a.rol.idrol = :rol", Map.class);
			
			q.setParameter("rol", map.get("rol"));
			salida = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
	
		return salida;
	}

	@SuppressWarnings("unchecked")
	
	public List<Usuario> validarUsuario(Map<String, Object> map){
		EntityManager em=emf.createEntityManager();
		List<Usuario> lista=null;
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("SELECT u FROM Usuario u where u.usuario = :usuario and u.passsword = :clave");
			q.setParameter("usuario", map.get("usuario"));
			q.setParameter("clave", map.get("clave"));    
			lista= q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();	
		}

		return lista;
	}
}









