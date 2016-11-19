package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the examen database table.
 * 
 */
@Entity
@NamedQuery(name="Examen.findAll", query="SELECT e FROM Examen e")
public class Examen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idexamen;

	private String estado;

	private String nivel;

	private String nombre;

	//bi-directional many-to-one association to CursoProgramacion
	@OneToMany(mappedBy="examen")
	private List<CursoProgramacion> cursoProgramacions;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="idcurso")
	private Curso curso;

	public Examen() {
	}

	public int getIdexamen() {
		return this.idexamen;
	}

	public void setIdexamen(int idexamen) {
		this.idexamen = idexamen;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<CursoProgramacion> getCursoProgramacions() {
		return this.cursoProgramacions;
	}

	public void setCursoProgramacions(List<CursoProgramacion> cursoProgramacions) {
		this.cursoProgramacions = cursoProgramacions;
	}

	public CursoProgramacion addCursoProgramacion(CursoProgramacion cursoProgramacion) {
		getCursoProgramacions().add(cursoProgramacion);
		cursoProgramacion.setExamen(this);

		return cursoProgramacion;
	}

	public CursoProgramacion removeCursoProgramacion(CursoProgramacion cursoProgramacion) {
		getCursoProgramacions().remove(cursoProgramacion);
		cursoProgramacion.setExamen(null);

		return cursoProgramacion;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}