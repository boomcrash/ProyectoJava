package controlador;

import modelo.Tarea;
import vista.ConsolaVista;
import java.util.*;

public class TareaController {

    private List<Tarea> tareas;
    private ConsolaVista vista;

    public TareaController(ConsolaVista vista) {
        this.tareas = new ArrayList<>();
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    agregarTarea();
                    break;
                case 2:
                    editarTarea();
                    break;
                case 3:
                    eliminarTarea();
                    break;
                case 4:
                    listarTareas();
                    break;
                case 5:
                    marcarComoCompletada();
                    break;
                case 6:
                    ordenarTareas();
                    break;
                case 7:
                    filtrarTareas();
                    break;
                case 8:
                    salir = true;
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Intente de nuevo.");
                    break;
            }
        }

    }

    private void agregarTarea() {
        String titulo = vista.leerTexto("Ingrese el título: ");
        String descripcion = vista.leerTexto("Ingrese la descripción: ");
        String fechaVencimiento = vista.leerTexto("Ingrese la fecha de vencimiento (YYYY-MM-DD): ");
        String prioridad = vista.leerTexto("Ingrese la prioridad (Baja, Media, Alta): ");
        tareas.add(new Tarea(titulo, descripcion, fechaVencimiento, prioridad));
        vista.mostrarMensaje("Tarea agregada correctamente.");
    }

    private void editarTarea() {
        String id = vista.leerTexto("Ingrese el ID de la tarea a editar: ");
        for (Tarea t : tareas) {
            if (t.getId().equals(id)) {
                t.setTitulo(vista.leerTexto("Nuevo título: "));
                t.setDescripcion(vista.leerTexto("Nueva descripción: "));
                t.setFechaVencimiento(vista.leerTexto("Nueva fecha de vencimiento: "));
                t.setPrioridad(vista.leerTexto("Nueva prioridad: "));
                vista.mostrarMensaje("Tarea editada correctamente.");
                return;
            }
        }
        vista.mostrarMensaje("Tarea no encontrada.");
    }

    private void eliminarTarea() {
        String id = vista.leerTexto("Ingrese el ID de la tarea a eliminar: ");
        tareas.removeIf(t -> t.getId().equals(id));
        vista.mostrarMensaje("Tarea eliminada correctamente.");
    }

    private void listarTareas() {
        if (tareas.isEmpty()) {
            vista.mostrarMensaje("No hay tareas registradas.");
        } else {
            tareas.forEach(t -> vista.mostrarMensaje(t.toString()));
        }
    }

    private void marcarComoCompletada() {
        String id = vista.leerTexto("Ingrese el ID de la tarea a marcar como completada: ");
        Optional<Tarea> tareaOptional = tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();

        if (tareaOptional.isPresent()) {
            tareaOptional.get().marcarCompletada();
        } else {
            vista.mostrarMensaje("Tarea no encontrada.");
        }
    }

    private void ordenarTareas() {
        tareas.sort(Comparator.comparing(Tarea::getPrioridad).thenComparing(Tarea::getFechaVencimiento));
        vista.mostrarMensaje("Tareas ordenadas correctamente.");
        listarTareas();
    }

    private void filtrarTareas() {
        String filtro = vista.leerTexto("Mostrar tareas (Pendientes/Completadas): ");
        tareas.stream().filter(t -> (t.isCompletada() && filtro.equalsIgnoreCase("Completadas"))
                || (!t.isCompletada() && filtro.equalsIgnoreCase("Pendientes")))
                .forEach(t -> vista.mostrarMensaje(t.toString()));
    }
}
