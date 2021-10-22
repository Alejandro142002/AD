package ObjectOutput;

public class Revista extends Biblioteca{
	int numero;
	public Revista(String codigo, String titulo, int añoPublicacion,int numero) {
		super(codigo, titulo, añoPublicacion);
		this.numero=numero;
	}
	@Override
	public String toString() {
		return "Revista [numero=" + numero + ", codigo=" + codigo + ", titulo=" + titulo + ", AñoPublicacion="
				+ añopub + "]";
	}

	public  int getAño( ) {
		return añopub;
	}
	public String getCodigo() {
		return codigo;
	}
	public String gettitulo() {
		// TODO Auto-generated method stub
		return titulo;
	}
	public int getnumero() {
		// TODO Auto-generated method stub
		return numero;
	}


}