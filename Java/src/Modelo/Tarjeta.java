package Modelo;

public class Tarjeta {

	//#######################
	// campos
	//#######################
	private int id;
	private Empleado empleado;

	//#######################
	// propiedades
	//#######################
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	//#######################
	// constructores
	//#######################
	public Tarjeta() {

	}    
	// con el empleado de la tarjeta
	public Tarjeta(Empleado empleado) {
		this.empleado = empleado;
	}

	//#######################
	// métodos
	//#######################
	public boolean Acceso_Permitido() {
		// TODO => chequear si la tarjeta tiene acceso y setear empleado
		return false;
	}

	// crear empleado
	public void tarjeta() {

	}

	// modificar tarjeta
	public void Update_Tarjeta() {

	}

	// borrar tarjeta
	public void Delete_Tarjeta() {

	}

}
