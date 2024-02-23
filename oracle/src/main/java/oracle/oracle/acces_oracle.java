package oracle.oracle;

import java.sql.*;

public class acces_oracle {
	private Connection con;

	void abrirConexion() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYS  as SYSDBA", "1234");
			System.out.println("Conexion OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void cerrarConexion() {
		try {
			System.out.println("Conexion cerrada");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void mostrarContactos() {
		try {
			// Create a statement
			Statement st = con.createStatement();
			ResultSet resul = st.executeQuery("SELECT c.nombre, c.telefono FROM contactos c");
			System.out.println("Mostrando contactos:");
			while (resul.next()) {
				
				System.out.printf("\nnombre: %s\ntelefono: %s", resul.getString(1), resul.getString(2));
			}
			System.out.println("\n--------------");
			resul.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void insert_alumno(String query) {
		try {
			Statement st = con.createStatement();
			ResultSet resul = st.executeQuery(query);
			resul.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void borrarAlumnoPorNombre(String nombreAlumno) {
	    try {
	        //SQL PARA BORRAR
	        String query = "DELETE FROM misAlumnos a  WHERE  a.DATOS_PERSONALES.NOMBRE = '" + nombreAlumno + "'";

	        // DECLARAMOS Y EJECTUAMOS 
	        Statement st = con.createStatement();
	        int filasAfectadas = st.executeUpdate(query);

	        // CHEKEAMOS SI SE HA BORRADO 
	        if (filasAfectadas > 0) {
	            System.out.println("ALUMNO '" + nombreAlumno + "' BORRADO.");
	        } else {
	            System.out.println("404- NO SE ENCUENTRA NINGÚN ALUMNO: '" + nombreAlumno + "'.");
	        }

	        // CERRAMOS CONEXIÓN
	        st.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
}
