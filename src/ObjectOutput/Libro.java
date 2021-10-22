package ObjectOutput;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Libro extends Biblioteca implements Prestable,Serializable {
	
	boolean prestado;
	
	public Libro(String codigo, String titulo, int añopublicacion) {
		super(codigo,titulo,añopublicacion);
		this.prestado=false;
	}

	@Override
	public String toString() {
		return "Libro [prestado=" + prestado + ", codigo=" + codigo + ", titulo=" + titulo + ", añopublicacion="
				+ añopub + "]";
	}
	
	public int getaño() {
		return añopub;
	}
	public String getcodigo() {
		return codigo;
	}
	
	public boolean getPrestado() {
		return prestado;
	}

	@Override
	public void Prestar() {
		 this.prestado=true;
	}

	@Override
	public void Devolver() {
		this.prestado=false;
	}

	
	
 
}
