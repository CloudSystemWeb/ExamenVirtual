package action;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.UIData;

import entidades.Curso;
import model.CursoModel;

@ManagedBean
public class CursoAction {
	
	//Para el Insertar, actualizar
	private Curso curso = new Curso();
	//Para el listar
	private List<Curso> cursos;
	//Para obtener el elemento seleccionado
	private UIData dataCurso;
	
	//LISTAR
	public List<Curso> getCursos() {
		CursoModel model = new CursoModel();
		cursos = model.listaCurso();
		return cursos;
	}
	
	//REGISTRAR
	public String irRegistraCurso(){
		return "/ui/registroCurso.jsf";
	}
	public String registraCurso(){
		CursoModel model = new CursoModel();
		
		model.inserta(curso);
		try {
			FacesContext.getCurrentInstance().
			getExternalContext().redirect("listaCurso.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	//ELIMINAR
	public String eliminaCurso(){
		//getRowData--> devuelve el elemento seleccionado
		curso = (Curso) dataCurso.getRowData();
		
		CursoModel model = new CursoModel();
		model.elimina(curso);
		
		return "/ui/listaCurso.jsf";
	}
	
	//VER DETALLE
	public String detalleCurso(){
			//getRowData--> devuelve el elemento seleccionado
		curso = (Curso) dataCurso.getRowData();
			return "/ui/detalleCurso.jsf";
	}
	public String salirCurso(){
		return "/ui/listaCurso.jsf";
	}
	
	//ACTUALIZAR
	public String buscaCurso(){
		curso = (Curso) dataCurso.getRowData();
		return "/ui/modificaCurso.jsf";
	}
	public String modificaCurso(){
		CursoModel model = new CursoModel();
		model.actualiza(curso);
	
		return "/ui/listaCurso.jsf";
	}
	//------
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public void setCurso(List<Curso> curso) {
		this.cursos = curso;
	}
	public UIData getDataCurso() {
		return dataCurso;
	}
	public void setDataCurso(UIData dataCurso) {
		this.dataCurso = dataCurso;
	}
	
	
}




