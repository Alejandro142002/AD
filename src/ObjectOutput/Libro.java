package ObjectOutput;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Libro extends Biblioteca implements Prestable,Serializable {
	
	boolean prestado;
	
	public Libro(String codigo, String titulo, int aņopublicacion) {
		super(codigo,titulo,aņopublicacion);
		this.prestado=false;
	}

	@Override
	public String toString() {
		return "Libro [prestado=" + prestado + ", codigo=" + codigo + ", titulo=" + titulo + ", aņopublicacion="
				+ aņopub + "]";
	}
	
	public int getaņo() {
		return aņopub;
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
