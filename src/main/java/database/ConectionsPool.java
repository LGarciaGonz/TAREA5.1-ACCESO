package database;

import oracle.jdbc.pool.OracleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConectionsPool {

    private static String SERVER = "jdbc:oracle:thin:@//localhost:1523"; // Ruta del SGBD
    private static String BD = "ObjRel";    // Nombre de la base de datos.
    private static String USER = "admin";   // Usuario.
    private static String PASW = "admin";   // Contraseña.

    // Crear el pool de conexiones como un DataSource que utilizará el resto del código.
    static DataSource poolconexiones() {
        String URL = SERVER + "/" + BD;

        /**
         * En este caso usamos un OracleDataSource, pero también sería posible
         * usar un BasixDataSource por ejemplo de Apache.
         */
        OracleDataSource oracleDataSource = null;

        try {
            oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL(URL);
            oracleDataSource.setUser(USER);
            oracleDataSource.setPassword(PASW);
            oracleDataSource.setConnectionProperty("maxpoolsize", "10");
        } catch (SQLException e) {
            System.err.println("\n>>> ERROR: error al conectar a la base de datos");
        }

        // Pasamos el data source a quien pide la conexión.
        return oracleDataSource;
    }

    // Método para realizar la conexión.
    public static Connection conectar() throws SQLException {
        System.out.println("\n>>> Conexión BBDD OK.");
        return poolconexiones().getConnection();    // Cogemos una conexión del DataSource que nos devuelve el pool.
    }
}
