package database;

import java.lang.module.InvalidModuleDescriptorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionDB {

    private static final String URL = "jdbc:oracle:thin:@//localhost:1523/ObjRel";
    private static final String USUARIO = "admin";
    private static final String CLAVE = "admin";

    public static Connection conectar() {

        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("\nConexion OK a la BBDD de Oracle");
        } catch (SQLException e) {
            System.err.println("\nError en la conexión a la BBDD de Oracle");
            e.getMessage();
        } catch (InvalidModuleDescriptorException e) {
            System.err.println("\nError PAM --> conexión BBDD Oracle");
        }

        return conexion;
    }

}
