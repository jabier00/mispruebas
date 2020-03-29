package Modelo;

import java.util.Date;

public class Registro {
	// campos
	private String id_registro;
	private Empleado empleado;
	private String accion;
	private Date fechahora;
    
	//#######################
	// propiedades
	//#######################
	public String getId_registro() {
		return id_registro;
	}

	public void setId_registro(String id_registro) {
		this.id_registro = id_registro;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Date getFechahora() {
		return fechahora;
	}

	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}
	//#######################
	// constructor
	//#######################
	public Registro(String id_registro, Empleado empleado, String accion, Date fechahora) {
		super();
		this.id_registro = id_registro;
		this.empleado = empleado;
		this.accion = accion;
		this.fechahora = fechahora;
	}

	//#######################
	// métodos
	//#######################
	
    // listar 50 últimos registros
	public void buscar_Registro() {

	}
	
	// registros de un empleado
	public void buscar_Registro_Empleado() {
		
	}

	// crear registro
	public void insert_Registro() {

	}

	// borrar registro
	public void delete_Registro() {

	}

}
