package database.ejercicio2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EliminarContacto {

    static Scanner sc = new Scanner(System.in);

    public static void eliminarContacto() {

        System.out.println("""
                    \n----------------------------------------------
                    \t\tELIMINAR CONTACTOS
                    ----------------------------------------------""");

        listarContactos.listadoContactos();     // Llamada a la función para mostrar al usuario los contactos disponibles.

        // Establecer conexión con la base de datos
        try (Connection miCon = database.ConectionsPool.conectar()) {

            System.out.println("\n>>> Conexión eliminarContacto OK");

            System.out.println("\nIntroduce el nombre del contacto a eliminar: ");
            String nombreContacto = sc.nextLine();


            // Preparar la consulta para eliminar un contacto
            PreparedStatement elimCont = miCon.prepareStatement("DELETE AGENDA A WHERE A.NOMBRE = ?");

            // Establecer el nombre del contacto en la consulta
            elimCont.setString(1, nombreContacto);

            elimCont.executeUpdate();

            System.out.println("\n>>> Contacto eliminado correctamente");

        } catch (SQLException e) {
            // Manejar errores de SQL
            System.err.println("\n>>> No se ha podido eliminar el contacto. ERROR: " + e.getMessage());
        }

    }

}
