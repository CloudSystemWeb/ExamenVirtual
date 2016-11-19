package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the submenu database table.
 * 
 */
@Entity
@NamedQuery(name="Submenu.findAll", query="SELECT s FROM Submenu s")
public class Submenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsubmenu;

	private String descripcion;

	private String url;

	//bi-directional many-to-one association to Acceso
	@OneToMany(mappedBy="submenu")
	private List<Acceso> accesos;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="idmenu")
	private Menu menu;

	public Submenu() {
	}

	public int getIdsubmenu() {
		return this.idsubmenu;
	}

	public void setIdsubmenu(int idsubmenu) {
		this.idsubmenu = idsubmenu;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Acceso> getAccesos() {
		return this.accesos;
	}

	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}

	public Acceso addAcceso(Acceso acceso) {
		getAccesos().add(acceso);
		acceso.setSubmenu(this);

		return acceso;
	}

	public Acceso removeAcceso(Acceso acceso) {
		getAccesos().remove(acceso);
		acceso.setSubmenu(null);

		return acceso;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}