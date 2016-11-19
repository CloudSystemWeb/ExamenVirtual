package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmenu;

	private String descripcion;

	//bi-directional many-to-one association to Acceso
	@OneToMany(mappedBy="menu")
	private List<Acceso> accesos;

	//bi-directional many-to-one association to Submenu
	@OneToMany(mappedBy="menu")
	private List<Submenu> submenus;

	public Menu() {
	}

	public int getIdmenu() {
		return this.idmenu;
	}

	public void setIdmenu(int idmenu) {
		this.idmenu = idmenu;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Acceso> getAccesos() {
		return this.accesos;
	}

	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}

	public Acceso addAcceso(Acceso acceso) {
		getAccesos().add(acceso);
		acceso.setMenu(this);

		return acceso;
	}

	public Acceso removeAcceso(Acceso acceso) {
		getAccesos().remove(acceso);
		acceso.setMenu(null);

		return acceso;
	}

	public List<Submenu> getSubmenus() {
		return this.submenus;
	}

	public void setSubmenus(List<Submenu> submenus) {
		this.submenus = submenus;
	}

	public Submenu addSubmenus(Submenu submenus) {
		getSubmenus().add(submenus);
		submenus.setMenu(this);

		return submenus;
	}

	public Submenu removeSubmenus(Submenu submenus) {
		getSubmenus().remove(submenus);
		submenus.setMenu(null);

		return submenus;
	}

}