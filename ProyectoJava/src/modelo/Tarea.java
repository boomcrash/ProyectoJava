package modelo;

import java.util.UUID;

public class Tarea {
    private String id;
    private String titulo;
    private String descripcion;
    private String fechaVencimiento;
    private String prioridad;
    private boolean estado; // false = Pendiente, true = Completada

    public Tarea(String titulo, String descripcion, String fechaVencimiento, String prioridad) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
        this.estado = false;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }
    public boolean isCompletada() { return estado; }
    public void marcarCompletada() { this.estado = true; }
    
    @Override
    public String toString() {
        return "[" + id + "] " + titulo + " - " + descripcion + " (Vence: " + fechaVencimiento + ", Prioridad: " + prioridad + ", Estado: " + (estado ? "Completada" : "Pendiente") + ")";
    }
}