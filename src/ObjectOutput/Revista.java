package ObjectOutput;

public class Revista extends Biblioteca{
	int numero;
	public Revista(String codigo, String titulo, int a�oPublicacion,int numero) {
		super(codigo, titulo, a�oPublicacion);
		this.numero=numero;
	}
	@Override
	public String toString() {
		return "Revista [numero=" + numero + ", codigo=" + codigo + ", titulo=" + titulo + ", A�oPublicacion="
				+ a�opub + "]";
	}

	public  int getA�o( ) {
		return a�opub;
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