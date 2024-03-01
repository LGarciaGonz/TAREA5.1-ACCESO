package database.ejercicio2;

import database.ejercicio2.InsertarNuevoContacto.PedirDatos;
import libs.Leer;

import java.sql.*;

public class AccederTlf {
    public static void obtenerPrimerTlf() {

        // Listar contactos.
        listarContactos.listadoContactos();

        // Declaración de variables.
        String nombreAlum = PedirDatos.pedirNombre();
        String numTel;

        try(Connection miCon = database.ConectionsPool.conectar()) {

            System.out.println("""
                    \n----------------------------------------------
                    \t\tCONSULTA DE TELÉFONOS
                    ----------------------------------------------""");

            // Preparamos la llamada a la función almacenada con call y las llaves
            CallableStatement cs = miCon.prepareCall("{? = call OBTENER_TELEF(?)}");

            // Los valores que devuelve la función se definen como OutParameter y hay que asignarles el tipo
            cs.registerOutParameter(1, Types.VARCHAR);

            // Los parámetros que necesita la función se pasan con el set correspondiente
            cs.setString(2, nombreAlum);
            cs.execute();

            // Recuperamos lo que devuelve la función con el correspondiente get
            numTel = cs.getString(1);
            System.out.println(numTel);

        } catch (SQLException e) {
            System.err.println("\n>>> No se han podido obtener los datos del teléfono. ERROR: " + e.getMessage());
        }
    }
}
