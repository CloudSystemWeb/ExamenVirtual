package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the curso_programacion database table.
 * 
 */
@Embeddable
public class CursoProgramacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	
	private int idprogramacion;	
	private int idcurso;	
	private int idexamen;

	public CursoProgramacionPK() {
	}
	public int getIdprogramacion() {
		return this.idprogramacion;
	}
	public void setIdprogramacion(int idprogramacion) {
		this.idprogramacion = idprogramacion;
	}
	public int getIdcurso() {
		return this.idcurso;
	}
	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}
	public int getIdexamen() {
		return this.idexamen;
	}
	public void setIdexamen(int idexamen) {
		this.idexamen = idexamen;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CursoProgramacionPK)) {
			return false;
		}
		CursoProgramacionPK castOther = (CursoProgramacionPK)other;
		return 
			(this.idprogramacion == castOther.idprogramacion)
			&& (this.idcurso == castOther.idcurso)
			&& (this.idexamen == castOther.idexamen);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idprogramacion;
		hash = hash * prime + this.idcurso;
		hash = hash * prime + this.idexamen;
		
		return hash;
	}
}