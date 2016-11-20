package action;


import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.UIData;

import entidades.Pregunta;
import model.PreguntaModel;

@ManagedBean
public class PreguntaAction{
	
	//prvate Pregunta pregunta;
	
	
	// 	Para el Insertar, actualizar
	private Pregunta pregunta = new Pregunta();
	
	// Para el listar
	private List<Pregunta> listpregunta;
	// Para obtener el elemento seleccionado
	private UIData dataPregunta;

	//public PreguntaAction() {
	//	pregunta = new Pregunta();
	//}
	
	
	public String modificaPregunta() {
		PreguntaModel model = new PreguntaModel();
		model.actualiza(pregunta);
		return "/ui/listaPregunta.jsf";
	}
	
	public List<Pregunta> getListpregunta() {
		PreguntaModel model = new PreguntaModel();
		listpregunta = model.listaPregunta();
		return listpregunta;
	}
	
	public String registraPregunta() {

		PreguntaModel model = new PreguntaModel();
		model.registrar(pregunta);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listaPregunta.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	//Eliminar Pregunta
	public String eliminaPregunta() {
		// getRowData--> devuelve el elemento seleccionado
		pregunta = (Pregunta) dataPregunta.getRowData();

		PreguntaModel model = new PreguntaModel();
		model.elimina(pregunta);

		return "/ui/listaPregunta.jsf";
	}
	
	// VER DETALLE
	public String detallePregunta() {
		// getRowData--> devuelve el elemento seleccionado
		pregunta = (Pregunta) dataPregunta.getRowData();
		return "/ui/detallePregunta.jsf";
	}
	
	// ACTUALIZAR
	public String buscaPregunta() {
		pregunta = (Pregunta) dataPregunta.getRowData();
		return "/ui/modificaPregunta.jsf";
	}
	
	public String registra(){
		
		PreguntaModel m = new PreguntaModel();
		m.registrar(pregunta);
		
		return "/ui/registroPregunta.jsf";
	}

	public String irRegistraPregunta() {
		return "/ui/registroPreguntas.jsf";
	}
	public String salirPregunta() {
		return "/ui/listaPregunta.jsf";
	}


	public Pregunta getPregunta() {
		return pregunta;
	}



	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}


	public void setListpregunta(List<Pregunta> listpregunta) {
		this.listpregunta = listpregunta;
	}

	public UIData getDataPregunta() {
		return dataPregunta;
	}

	public void setDataPregunta(UIData dataPregunta) {
		this.dataPregunta = dataPregunta;
	}
	
	
	
}
