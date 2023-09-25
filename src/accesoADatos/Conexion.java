
package accesoADatos;

import java.sql.*;



public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String DB = "UniversidadULP";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    
    
    private static Connection connection;
    
    private Conexion(){  }
    
    
    public static Connection getConexion(){
        if(connection==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);                
                
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al cargar driver");
            } catch (SQLException ex) {
                System.out.println("Error de conexión a base de datos");
            }
        }
        return connection;
        
    }
    
    
}
