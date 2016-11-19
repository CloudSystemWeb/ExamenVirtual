package action;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.AlumnoModel;
import model.UsuarioModel;

import org.primefaces.component.api.UIData;

import entidades.Alumno;
import entidades.Rol;
import entidades.Usuario;

@ManagedBean
public class AlumnoAction {

	// Para el Insertar, actualizar
	private Alumno alumno = new Alumno();
	// Para el listar
	private List<Alumno> alumnos;
	// Para obtener el elemento seleccionado
	private UIData dataAlumno;

	// LISTAR
	public List<Alumno> getAlumnos() {
		AlumnoModel model = new AlumnoModel();
		alumnos = model.listaAlumno();
		return alumnos;
	}

	// REGISTRAR
	public String irRegistraAlumno() {
		return "/ui/registroAlumno.jsf";
	}

	public String registraAlumno() {

		AlumnoModel model = new AlumnoModel();

		String cadena= alumno.getNombre().toLowerCase();
		char obtener= cadena.charAt(0);
		
		Usuario u = new Usuario();
		UsuarioModel uModel = new UsuarioModel();
		u.setPasssword(obtener + alumno.getApePaterno());
		u.setUsuario(obtener + alumno.getApeMaterno());
		Rol rol=new Rol();
		rol.setIdrol(2);
		u.setRol(rol);
		uModel.inserta(u);

		alumno.setUsuario(u);

		model.inserta(alumno);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listaAlumno.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	// ELIMINAR
	public String eliminaAlumno() {
		// getRowData--> devuelve el elemento seleccionado
		alumno = (Alumno) dataAlumno.getRowData();

		AlumnoModel model = new AlumnoModel();
		model.elimina(alumno);

		return "/ui/listaAlumno.jsf";
	}

	// VER DETALLE
	public String detalleAlumno() {
		// getRowData--> devuelve el elemento seleccionado
		alumno = (Alumno) dataAlumno.getRowData();
		return "/ui/detalleAlumno.jsf";
	}

	public String salirAlumno() {
		return "/ui/listaAlumno.jsf";
	}

	// ACTUALIZAR
	public String buscaAlumno() {
		alumno = (Alumno) dataAlumno.getRowData();
		return "/ui/modificaAlumno.jsf";
	}

	public String modificaAlumno() {
		AlumnoModel model = new AlumnoModel();
		Usuario u = new Usuario();
		UsuarioModel uModel = new UsuarioModel();
		
		Rol rol=new Rol();
		rol.setIdrol(2);
		u.setRol(rol);
		uModel.inserta(u);

		alumno.setUsuario(u);
		model.actualiza(alumno);

		return "/ui/listaAlumno.jsf";
	}

	// ------

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public UIData getDataAlumno() {
		return dataAlumno;
	}

	public void setDataAlumno(UIData dataAlumno) {
		this.dataAlumno = dataAlumno;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}
