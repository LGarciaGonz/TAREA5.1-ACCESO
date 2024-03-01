package database.ejercicio2;

import database.ejercicio2.InsertarNuevoContacto.PedirDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ModificarTelefono {

    public static void modificarTelf() {

        System.out.println("""
                    \n----------------------------------------------
                    \t\tMODIFICAR CONTACTOS
                    ----------------------------------------------""");

        listarContactos.listadoContactos();     // Llamada a la función para mostrar al usuario los contactos disponibles.

        // Establecer conexión con la base de datos
        try (Connection miCon = database.ConectionsPool.conectar()) {

            System.out.println("\n>>> Conexión modificarContacto OK");

            // Variables y llamadas.
            String nombreContacto = PedirDatos.pedirNombre();
            int cantTelfs = PedirDatos.pedirCantTelfs();
            ArrayList<String> listaTelf = PedirDatos.pedirNumeros(cantTelfs);

            // Preparar la consulta para modificar un contacto
            PreparedStatement updateContacto = miCon.prepareStatement("UPDATE AGENDA SET TELEFONO(?) WHERE NOMBRE = ?");
            // Iterar sobre la lista de números de teléfono y agregarlos a la consulta
            for (String numero : listaTelf) {
                updateContacto.setString(2, numero);
                updateContacto.addBatch();
            }

            System.out.println("\n\t>> DATOS ANTERIORES: ");
            listarContactos.listadoContactos();

            updateContacto.executeUpdate();

            System.out.println("\n>>> Contacto modificado correctamente");

            System.out.println("\n\t>> NUEVOS DATOS: ");
            listarContactos.listadoContactos();

        } catch (SQLException e) {
            // Manejar errores de SQL
            System.err.println("\n>>> No se ha podido eliminar el contacto. ERROR: " + e.getMessage());
        }


    }

}
