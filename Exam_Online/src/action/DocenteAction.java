package action;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import model.DocenteModel;
import model.UsuarioModel;

import org.primefaces.component.api.UIData;

import entidades.Docente;
import entidades.Rol;
import entidades.Usuario;

@ManagedBean
public class DocenteAction {

	// Para el Insertar, actualizar
	private Docente docente = new Docente();
	// Para el listar
	private List<Docente> docentes;
	// Para obtener el elemento seleccionado
	private UIData dataDocente;

	// LISTAR
	public List<Docente> getDocentes() {
		DocenteModel model = new DocenteModel();
		docentes = model.listaDocente();
		return docentes;
	}

	// REGISTRAR
	public String irRegistraDocente() {
		return "/ui/registroDocente.jsf";
	}

	public String registraDocente() {

		DocenteModel model = new DocenteModel();

		String cadena= docente.getNombre().toLowerCase();
		char obtener= cadena.charAt(0);
		
		Usuario u = new Usuario();
		UsuarioModel uModel = new UsuarioModel();
		u.setPasssword(obtener + docente.getApePaterno());
		u.setUsuario(obtener + docente.getApeMaterno());
		Rol rol=new Rol();
		rol.setIdrol(2);
		u.setRol(rol);
		uModel.inserta(u);

		docente.setUsuario(u);

		model.inserta(docente);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listaDocente.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	// ELIMINAR
	public String eliminaDocente() {
		// getRowData--> devuelve el elemento seleccionado
		docente = (Docente) dataDocente.getRowData();

		DocenteModel model = new DocenteModel();
		model.elimina(docente);

		return "/ui/listaDocente.jsf";
	}

	// VER DETALLE
	public String detalleDocente() {
		// getRowData--> devuelve el elemento seleccionado
		docente = (Docente) dataDocente.getRowData();
		return "/ui/detalleDocente.jsf";
	}

	public String salirDocente() {
		return "/ui/listaDocente.jsf";
	}

	// ACTUALIZAR
	public String buscaDocente() {
		docente = (Docente) dataDocente.getRowData();
		return "/ui/modificaDocente.jsf";
	}

	public String modificaDocente() {
		DocenteModel model = new DocenteModel();
		Usuario u = new Usuario();
		UsuarioModel uModel = new UsuarioModel();
		
		Rol rol=new Rol();
		rol.setIdrol(2);
		u.setRol(rol);
		uModel.inserta(u);

		docente.setUsuario(u);
		model.actualiza(docente);

		return "/ui/listaDocente.jsf";
	}

	// ------

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public UIData getDataDocente() {
		return dataDocente;
	}

	public void setDataDocente(UIData dataDocente) {
		this.dataDocente = dataDocente;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

}
