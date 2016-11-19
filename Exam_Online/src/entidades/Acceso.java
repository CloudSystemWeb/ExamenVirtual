package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the acceso database table.
 * 
 */
@Entity
@NamedQuery(name="Acceso.findAll", query="SELECT a FROM Acceso a")
public class Acceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="idrol")
	private Rol rol;

	//bi-directional many-to-one association to Submenu
	@ManyToOne
	@JoinColumn(name="idsubmenu")
	private Submenu submenu;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="idmenu")
	private Menu menu;

	public Acceso() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Submenu getSubmenu() {
		return this.submenu;
	}

	public void setSubmenu(Submenu submenu) {
		this.submenu = submenu;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}