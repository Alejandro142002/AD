package ejs;

public class Alumno {
	private int edad;
	private String nombre;
	public Alumno()  {
		super();
		
		
	}
	
	@Override
	public String toString() {
		String nombre = null;
		String edad = null;
		return "Alumnos [nombre=" + nombre + ", edad=" + edad + "]";
	}
		String getNombre() {
			return nombre;
		}
		public int getedad() {
			return edad;
		}

		public void getNombre(String string) {
			// TODO Auto-generated method stub
			
		}

		public void getEdad(int parseInt) {
			// TODO Auto-generated method stub
			
		}
	
	 
	}

