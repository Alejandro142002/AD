package ObjectOutput;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Biblioteca implements Serializable {

	
	String codigo,titulo;
	int a�opub;
	public Biblioteca(String codigo, String titulo, int a�opublicacion) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.a�opub = a�opublicacion;
	}
	
	
	
}
