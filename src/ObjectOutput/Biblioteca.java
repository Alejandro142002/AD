package ObjectOutput;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Biblioteca implements Serializable {

	
	String codigo,titulo;
	int añopub;
	public Biblioteca(String codigo, String titulo, int añopublicacion) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.añopub = añopublicacion;
	}
	
	
	
}
