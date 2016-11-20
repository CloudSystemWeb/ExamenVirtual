package entidades;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;



@Entity
@NamedQuery(name="Alternativa.findAll", query="SELECT c FROM Alternativa c")
public class Alternativa implements Serializable{
	private static final long serialVersionUID = 1L;

	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int idalternativa;
	

    @ManyToOne
    @JoinColumn(name="idpregunta")
	public Pregunta pregunta;
    
	
    public String descripcion,tema; 
    
	public Alternativa() {

		pregunta = new Pregunta();

	}
    
	public int getIdalternativa() {
		return idalternativa;
	}

	public void setIdalternativa(int idalternativa) {
		this.idalternativa = idalternativa;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	

	
	

	
	
	
	
	
}
