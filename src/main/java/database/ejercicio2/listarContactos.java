package database.ejercicio2;

import java.sql.*;

public class listarContactos {
    public static void listadoContactos() {

        // Establecer conexión con la base de datos
        try (Connection miCon = database.ConectionsPool.conectar()) {

            System.out.println("\n>>> Conexión listarContactos OK");

            System.out.println("""
                    \n----------------------------------------------
                    \t\t\tAGENDA
                    ----------------------------------------------""");

            // Preparar la consulta para listar los nombres y teléfonos.
            String listCont = "SELECT A.NOMBRE, A.TELEF FROM AGENDA A";
            Statement stmt = miCon.createStatement();
            ResultSet rs = stmt.executeQuery(listCont);

            // Mostrar los nombres de los contactos y sus teléfonos obtenidos.
            while (rs.next()){
                String contRs = rs.getString("NOMBRE");
                Array telefonoArray = rs.getArray("TELEF");
                Object[] telefonos = (Object[]) telefonoArray.getArray();

                System.out.println("\n- " + contRs + ": ");
                for (Object telefono : telefonos) {
                    System.out.println("\t" + telefono.toString());
                }
            }

        } catch (SQLException e) {
            // Manejar errores de SQL
            System.err.println("\n>>> No se han podido listar los contactos. ERROR: ");
            e.printStackTrace();
        }

    }
}