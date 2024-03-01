package database.ejercicio2.InsertarNuevoContacto;

import libs.Leer;

import java.util.ArrayList;

public class PedirDatos {

    public static String pedirNombre() {
        // Solicitar al usuario que ingrese el nombre del contacto
        String nombre = Leer.pedirCadena("\nIntroduce el nombre del contacto:");

        return nombre;
    }

    public static int pedirCantTelfs() {

        // Declaración de variables
        int numTelefonos = 0;

        // Solicitar al usuario que ingrese el número de teléfonos a insertar
        do {
            numTelefonos = Leer.pedirEntero("\n¿Cuántos teléfonos quieres insertar? (1, 2, ó 3)");

            if (numTelefonos > 3 || numTelefonos < 1) {
                System.err.println("\n>>> ERROR: debe ser un número entre 1 y 3");
            }
        } while (numTelefonos > 3 || numTelefonos < 1);

        return numTelefonos;
    }

    public static ArrayList<String> pedirNumeros(int numTelefonos) {

        // Variables
        int i = 0;

        // Crear una lista para almacenar los números de teléfono
        ArrayList<String> listaTelf = new ArrayList<>();

        // Pedir al usuario que ingrese los números de teléfono y agregarlos a la lista
        while (i < numTelefonos) {

            String numeroTelf = "";

            // Validar que el número de teléfono tenga 9 dígitos
            do {
                numeroTelf = Leer.pedirCadena("\nIntroduce el número de teléfono (debe tener 9 dígitos):");

                if (numeroTelf.length() != 9) {
                    System.err.println("\n>>> ERROR: el número de teléfono debe tener 9 dígitos.");
                }
            } while (numeroTelf.length() != 9);

            // Agregar el número de teléfono a la lista
            listaTelf.add(numeroTelf);
            i++;
        }

        return listaTelf;

    }

}
