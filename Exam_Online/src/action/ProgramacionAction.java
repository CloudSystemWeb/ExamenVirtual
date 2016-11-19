package action;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.UIData;

import entidades.Curso;
import entidades.Programacion;
import model.CursoModel;
import model.ProgramacionModel;

@ManagedBean
public class ProgramacionAction {
	
	//Para el Insertar, actualizar
	private Programacion programacion = new Programacion();
	//Para el listar
	private List<Programacion> programaciones;
	//Para obtener el elemento seleccionado
	private UIData dataProgramacion;
	
	//LISTAR
	public List<Programacion> getProgramaciones() {
		ProgramacionModel model = new ProgramacionModel();
		programaciones = model.listaProgramacion();
		return programaciones;
	}
	
	//REGISTRAR
	public String irRegistraProgramacion(){
		return "/ui/registroProgramacion.jsf";
	}
	public String registraProgramacion(){
		ProgramacionModel model = new ProgramacionModel();
		
		model.inserta(programacion);
		try {
			FacesContext.getCurrentInstance().
			getExternalContext().redirect("listaProgramacion.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	//ELIMINAR
	public String eliminaProgramacion(){
		//getRowData--> devuelve el elemento seleccionado
		programacion = (Programacion) dataProgramacion.getRowData();
		
		ProgramacionModel model = new ProgramacionModel();
		model.elimina(programacion);
		
		return "/ui/listaProgramacion.jsf";
	}
	
	//VER DETALLE
	public String detalleProgramacion(){
			//getRowData--> devuelve el elemento seleccionado
		programacion = (Programacion) dataProgramacion.getRowData();
			return "/ui/detalleProgramacion.jsf";
	}
	public String salirProgramacion(){
		return "/ui/listaProgramacion.jsf";
	}
	
	//ACTUALIZAR
	public String buscaProgramacion(){
		programacion = (Programacion) dataProgramacion.getRowData();
		return "/ui/modificaProgramacion.jsf";
	}
	public String modificaProgramacion(){
		ProgramacionModel model = new ProgramacionModel();
		model.actualiza(programacion);
	
		return "/ui/listaProgramacion.jsf";
	}
	//------
	public Programacion getProgramacion() {
		return programacion;
	}
	public void setProgramacion(Programacion programacion) {
		this.programacion = programacion;
	}
	
	public void setProgramacion(List<Programacion> programacion) {
		this.programaciones = programacion;
	}
	public UIData getDataProgramacion() {
		return dataProgramacion;
	}
	public void setDataProgramacion(UIData dataProgramacion) {
		this.dataProgramacion = dataProgramacion;
	}
	
	
}




