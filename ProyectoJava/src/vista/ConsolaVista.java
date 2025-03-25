package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsolaVista {
    private Scanner scanner;

    public ConsolaVista() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("1. Agregar tarea");
        System.out.println("2. Editar tarea");
        System.out.println("3. Eliminar tarea");
        System.out.println("4. Listar tareas");
        System.out.println("5. Marcar tarea como completada");
        System.out.println("6. Ordenar tareas");
        System.out.println("7. Filtrar tareas");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");

        while (true) {
            try {
                int opcion = scanner.nextInt(); // Captura la opción del usuario
                scanner.nextLine();  // Limpiar el buffer después de capturar el número
                return opcion;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.nextLine(); // Limpia el buffer del scanner en caso de error
            }
        }
    }

    // Cambiado para leer todo el texto, no solo una palabra
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();  // Leer toda la línea de texto
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
