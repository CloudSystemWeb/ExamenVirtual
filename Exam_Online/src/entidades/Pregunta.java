package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@NamedQuery(name="Pregunta.findAll", query="SELECT c FROM Pregunta c")
public class Pregunta implements Serializable {
	   private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int idpregunta;
	public String descripcion,tipo,tema,respuesta;
	
	
	@OneToMany(mappedBy="pregunta")
	private List<Alternativa> alternativa; 
	
	
	
	public Pregunta() { }
	
	public List<Alternativa> getObligaciones() {return alternativa;}

	public int getIdpregunta() {
		return idpregunta;
	}

	public void setIdpregunta(int idpregunta) {
		this.idpregunta = idpregunta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	
/*
	public Alternativa addAlternativa(Alternativa obli) {
		getObligaciones().add(obli);
		obli.setActividad(this);

		return obli;
	}

	public Alternativa removeAlternativa(Alternativa obli) {
		getObligaciones().remove(obli);
		obli.setActividad(null);

		return obli;
	}  */
	
	
	
	
	
	
}
