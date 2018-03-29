package pe.tuna.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Persona {
	private int id;
	
	@NotBlank
	@NotNull 
	private String nombre;
	
	@NotBlank
	@NotNull
	private String correo;
	
	@Min(18)
	private int edad;
	private int pais;

	public Persona() {
	}

	public Persona(String nombre, String correo, int edad) {
		this.nombre = nombre;
		this.correo = correo;
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPais() {
		return pais;
	}

	public void setPais(int pais) {
		this.pais = pais;
	}
	

}
