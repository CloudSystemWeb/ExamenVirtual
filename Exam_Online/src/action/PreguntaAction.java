package action;


import javax.faces.bean.ManagedBean;

import entidades.Pregunta;
import model.PreguntaModel;




@ManagedBean
public class PreguntaAction{
	
private Pregunta pregunta;
	
	
	
	public PreguntaAction() {
		pregunta = new Pregunta();
	}
	
	
	
	public String registra(){
		
		PreguntaModel m = new PreguntaModel();
		m.registrar(pregunta);
		
		return "/ui/registroActividad.jsf";
	}



	public Pregunta getPregunta() {
		return pregunta;
	}



	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}




	
	
}
