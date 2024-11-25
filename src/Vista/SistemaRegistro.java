package Vista;

import Controlador.GestionLenguaje;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaRegistro {
    public static void main(String[] args) {        
        Scanner scanner = new Scanner(System.in);
        GestionLenguaje gestionLenguaje = new GestionLenguaje();
        
        while (true) {            
            Menu();
            int opcion = 0;
            // Usar try-catch para manejar la opción seleccionada
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer
                continue;  // Volver al inicio del bucle
            }

            switch (opcion) {
                case 1 -> {                    
                    try {
                        scanner.nextLine();  // Limpiar el buffer

                        // Pedir los datos del lenguaje
                        System.out.println("Ingrese el nombre del lenguaje:");
                        String Nombre = scanner.nextLine();

                        System.out.println("Ingrese la característica principal del lenguaje:");
                        String CaracteristicaPrincipal = scanner.nextLine();

                        System.out.println("Ingrese el año de creación del lenguaje:");
                        int AnioCreacion = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer

                        System.out.println("Ingrese la utilización del lenguaje:");
                        String Utilizacion = scanner.nextLine();

                        // Agregar el lenguaje con los datos ingresados
                        gestionLenguaje.AgregarLenguaje(AnioCreacion, CaracteristicaPrincipal, Nombre, Utilizacion);  
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Por favor ingrese un valor numérico válido para el año de creación.");
                        scanner.nextLine(); // Limpiar el buffer
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                    }
                }
                case 2 -> {                   
                    try {
                        scanner.nextLine();  // Limpiar el buffer

                        // Pedir el nombre del lenguaje a buscar
                        System.out.println("INGRESE EL NOMBRE DEL LENGUAJE A BUSCAR:");
                        String nombre = scanner.nextLine();

                        // Buscar el lenguaje
                        if (gestionLenguaje.BuscarLenguaje(nombre) != null) {
                            System.out.println("El lenguaje existe");
                        } else {
                            System.out.println("El lenguaje no existe");
                        }
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error al buscar el lenguaje: " + e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        scanner.nextLine();  // Limpiar el buffer

                        // Pedir el nombre del lenguaje a eliminar
                        System.out.println("INGRESE EL NOMBRE DEL LENGUAJE A ELIMINAR:");
                        String nombre = scanner.nextLine();

                        // Eliminar el lenguaje
                        boolean exitoOperacion = gestionLenguaje.EliminarLenguaje(nombre);
                        if (exitoOperacion) {
                            System.out.println("Lenguaje eliminado con éxito");
                        } else {
                            System.out.println("No existe el lenguaje a eliminar");
                        }
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error al eliminar el lenguaje: " + e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        scanner.nextLine();  // Limpiar el buffer
                        gestionLenguaje.ImprimirLenguajes();
                    } catch (Exception e) {
                        System.out.println("Ocurrió un error al imprimir los lenguajes: " + e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.println("Saliendo del sistema...");
                    return;  // Salir del programa
                }
                default -> {
                    scanner.nextLine();  // Limpiar el buffer
                    System.out.println("OPCIÓN INVÁLIDA. Por favor, elija una opción válida.");
                }
            }
        }        
    }
    
    private static void Menu() {
        String menu = """
                      OPCIONES
                      
                      1. Agregar Lenguaje
                      2. Buscar Lenguaje
                      3. Eliminar Lenguaje
                      4. Imprimir
                      
                      5. Cerrar                                       
                      """;
        
        System.out.println(menu);
    }
    
}
