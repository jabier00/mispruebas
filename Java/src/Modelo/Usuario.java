package Modelo;

public class Usuario {
	//#######################
	// campos
	//#######################
	private String id_usuario;
	private String password;
	private String perfil;

	//#######################
	// propiedades
	//#######################
	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	//#######################
	// constructor
	//#######################
	public Usuario(String id_usuario, String password, String perfil) {
		this.id_usuario = id_usuario;
		this.password = password;
		this.perfil = perfil;
	}

	//#######################
	// métodos
	//#######################
	public void CheckPassword_Ok() {
		// chequear si la password es correcta
	}

	// crear usuario
	public void insert_Usuario() {

	}

	// modificar usuario
	public void update_Usuario() {

	}

	// borrar empleado
	public void delete_Usuario() {

	}

}
