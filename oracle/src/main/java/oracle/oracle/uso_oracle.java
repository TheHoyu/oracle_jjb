package oracle.oracle;

public class uso_oracle {
	
	public static void main(String[] args) {
		acces_oracle acces = new acces_oracle();
		acces.abrirConexion();
		acces.listar_alumnos();
		
		
		
		acces.listar_alumnos();
		String query = "INSERT INTO misAlumnos VALUES"
				+ " (estudiante('05C', persona('Bruce Wayne', '123123123')))";
		
		acces.borrarAlumnoPorNombre("Bruce Wayne");
		
		acces.cerrarConexion();
	}

}
