package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the curso_programacion database table.
 * 
 */
@Entity
@Table(name="curso_programacion")
@NamedQuery(name="CursoProgramacion.findAll", query="SELECT c FROM CursoProgramacion c")
public class CursoProgramacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CursoProgramacionPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFinExamen;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicioExamen;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="idprogramacion")
	private Curso curso;

	//bi-directional many-to-one association to Examen
	@ManyToOne
	@JoinColumn(name="idexamen")
	private Examen examen;

	//bi-directional many-to-one association to Programacion
	@ManyToOne
	@JoinColumn(name="idcurso")
	private Programacion programacion;

	public CursoProgramacion() {
	}

	public CursoProgramacionPK getId() {
		return this.id;
	}

	public void setId(CursoProgramacionPK id) {
		this.id = id;
	}

	public Date getFechaFinExamen() {
		return this.fechaFinExamen;
	}

	public void setFechaFinExamen(Date fechaFinExamen) {
		this.fechaFinExamen = fechaFinExamen;
	}

	public Date getFechaInicioExamen() {
		return this.fechaInicioExamen;
	}

	public void setFechaInicioExamen(Date fechaInicioExamen) {
		this.fechaInicioExamen = fechaInicioExamen;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Examen getExamen() {
		return this.examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public Programacion getProgramacion() {
		return this.programacion;
	}

	public void setProgramacion(Programacion programacion) {
		this.programacion = programacion;
	}

}