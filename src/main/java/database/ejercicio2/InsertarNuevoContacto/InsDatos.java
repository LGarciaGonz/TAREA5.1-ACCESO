package database.ejercicio2.InsertarNuevoContacto;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsDatos {

    public static void insContacto() {

        // Variables y llamadas.
        String nombre = PedirDatos.pedirNombre();
        int cantTelfs = PedirDatos.pedirCantTelfs();
        ArrayList<String> listaTelf = PedirDatos.pedirNumeros(cantTelfs);

        System.out.println("""
                \n----------------------------------------------
                \t\t\tINSERTAR UN NUEVO CONTACTO
                ----------------------------------------------""");

        try (Connection miCon = database.ConectionsPool.conectar()) {

            // Establecer conexión con la base de datos
            System.out.println("\n>>> Conexión insContacto OK");

            // Preparar la consulta para insertar un nuevo contacto
            PreparedStatement insContacto = miCon.prepareStatement("INSERT INTO AGENDA (NOMBRE, TELEF) VALUES(?,TELEFONO(?))");

            // Establecer el nombre del contacto en la consulta
            insContacto.setString(1, nombre);

            // Iterar sobre la lista de números de teléfono y agregarlos a la consulta
            for (String numero : listaTelf) {
                insContacto.setString(2, numero);
                insContacto.addBatch();
            }

            // Ejecutar la consulta para insertar el contacto en la base de datos
            insContacto.executeUpdate();

            System.out.println("\n>>> Contacto modificado correctamente");

        } catch (SQLException e) {
            // Manejar errores de SQL
            System.err.println("\n>>> No se ha podido crear el nuevo contacto. ERROR: " + e.getMessage());
        }
    }
}
