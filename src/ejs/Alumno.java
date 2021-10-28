package ejs;

public class Alumno {
	private int edad;
	private String nombre;
	
	public Alumno(int edad, String nombre) {
		super();
		this.edad = edad;
		this.nombre = nombre;
	}
	
	public Alumno() {
		super();
	}
	
	@Override
	public String toString() {
		return "Alumno [edad=" + edad + ", nombre=" + nombre + "]";
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	 
}

