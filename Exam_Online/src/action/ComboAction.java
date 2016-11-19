package action;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.CursoModel;
import model.ProgramacionModel;
import entidades.Curso;
import entidades.Programacion;


@SessionScoped
@ManagedBean
public class ComboAction {

	private List<Programacion> programaciones;
	private List<Curso> cursos;

	public List<Programacion> getProgramacions() {
		ProgramacionModel model = new ProgramacionModel();
		programaciones = model.listaProgramacion();
		return programaciones;
	}

	public List<Programacion> getProgramaciones() {
		return programaciones;
	}

	public void setProgramaciones(List<Programacion> programaciones) {
		this.programaciones = programaciones;
	}
	
	
	public List<Curso> getCursoes() {
		CursoModel model = new CursoModel();
		cursos = model.listaCurso();
		return cursos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}	
	
	

	

}
