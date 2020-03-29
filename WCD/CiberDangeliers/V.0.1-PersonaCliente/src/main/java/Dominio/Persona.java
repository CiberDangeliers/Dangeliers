package Dominio;

public class Persona {
	/*Atributos*/
	protected String name;
	protected String apellido;
	protected String dni;
	protected String email;
	
	/*Constructor*/
	public Persona(String name, String apellido, String dni, String email) {
		this.name = name;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
	}

	/*Getters*/
	public String getName() {
		return name;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public String getEmail() {
		return email;
	}

	/*Setters*/
	public void setName(String name) {
		this.name = name;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
