import database.ejercicio2.AccederTlf;
import database.ejercicio2.EliminarContacto;
import database.ejercicio2.InsertarNuevoContacto.InsDatos;
import database.ejercicio2.InsertarNuevoContacto.PedirDatos;
import database.ejercicio2.ModificarTelefono;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        // DECLARACIONES
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        String opcion = "";

        // BUCLE PARA MOSTRAR EL MENÚ DE OPCIONES
        while (!salir) {

            System.out.println("""
                    \n----------------------------------------------
                    \t\t\tBASE DE DATOS DE ORACLE
                    ----------------------------------------------
                    1. Insertar nuevo contacto.                   
                    2. Modificar el teléfono de un contacto.
                    3. Eliminar contacto.
                    4. Obtener el primer número de teléfono.
                    0. Salir
                    ----------------------------------------------""");

            opcion = sc.nextLine();                                                                         // Leer y guardar la opción del usuario.

            // ESTRUCTURA PARA LA LLAMADA A LOS MÉTODOS
            switch (opcion) {
                case "0" ->
                        salir = true;                                                                   // Fin de la ejecución del menú.

                case "1" -> InsDatos.insContacto();

                case "2" -> ModificarTelefono.modificarTelf();

                case "3" -> EliminarContacto.eliminarContacto();

                case "4" -> AccederTlf.obtenerPrimerTlf();

                default ->
                        System.out.println("\n>>>OPCIÓN NO VÁLIDA: Introduzca una opción del menú");        // Informar al usuario de un error cometido.
            }
        }

    }
}
