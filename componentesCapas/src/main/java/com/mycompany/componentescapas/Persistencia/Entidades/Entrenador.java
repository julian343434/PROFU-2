package com.mycompany.componentescapas.Persistencia.Entidades;

public class Entrenador {
    private String nombre;
    private String especialidad;

    // Constructor vacío
    public Entrenador() {
    }

    // Constructor con parámetros
    public Entrenador(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    // Método toString corregido
    @Override
    public String toString() {
        return "Entrenador{" +
               "nombre='" + nombre + '\'' +
               ", especialidad='" + especialidad + '\'' +
               '}';
    }
}
