package constantes_;

public class Constantes {

	public static void main(String[] args) {
		
		final Empleados worker1 = new Empleados("Emilio");
		Empleados worker2 = new Empleados("Belén");
		
		worker1.setSeccion("RRHH");
	
		System.out.println(worker1+"\n"+worker2);
		
		
	}

}
class Empleados {
	
	private final String nombre;
	private String seccion;
	
	public Empleados(String nombre) {
		this.nombre = nombre;
		this.seccion = "Administración";
	}
	
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	public static String empleados() {
		return "eu sou um workerinho";
	}
	
	@Override
	public String toString() {
		return "El nombre es: "+ nombre +" y la sección es "+ seccion;
	}
	
}