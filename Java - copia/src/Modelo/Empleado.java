package Modelo;

public class Empleado {

	//#######################
	// campos
	//#######################
	private String id_empleado;
	private String nombre;
	private String apellido;
	private String telefono;	
	
	//#######################
	// propiedades
	//#######################
	public String getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(String id_empleado) {
		this.id_empleado = id_empleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	//#######################
	// constructores
	//#######################	
	// constructor con id => pará búsquedas
	public Empleado(String id_empleado)
	{
		this.id_empleado = id_empleado;	
	}
	
	// constructor completo
	public Empleado(String id_empleado, String nombre, String apellido, String telefono) {
		super();
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	
	//#######################
	// métodos 
	//#######################
	public void setDataEmpleado()
	{
		// setear el empleado con la bbdd a través del ID
	}
	
	// crear empleado
	public void insert_Empleado()
	{
	
	}
	// modificar empleado
	public void update_Empleado()
	{
	
	}
	// borrar empleado
	public void delete_Empleado()
	{
	
	}
	
	
}
