package ObjectOutput;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Biblioteca implements Serializable {

	
	String codigo,titulo;
	int aņopub;
	public Biblioteca(String codigo, String titulo, int aņopublicacion) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.aņopub = aņopublicacion;
	}
	
	
	
}
