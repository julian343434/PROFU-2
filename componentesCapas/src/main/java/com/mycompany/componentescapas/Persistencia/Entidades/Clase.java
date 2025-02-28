package com.mycompany.componentescapas.Persistencia.Entidades;

import java.time.LocalDateTime;

public class Clase {
    private String tipo;
    private Entrenador entrenador;
    private LocalDateTime horario;

    // Constructor vacío
    public Clase() {
    }

    // Constructor con parámetros
    public Clase(String tipo, Entrenador entrenador, LocalDateTime horario) {
        this.tipo = tipo;
        this.entrenador = entrenador;
        this.horario = horario;
    }

    // Getters y Setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Entrenador getEntrenador() { return entrenador; }
    public void setEntrenador(Entrenador entrenador) { this.entrenador = entrenador; }

    public LocalDateTime getHorario() { return horario; }
    public void setHorario(LocalDateTime horario) { this.horario = horario; }

    // Método toString corregido
    @Override
    public String toString() {
        return "Clase{" +
               "tipo='" + tipo + '\'' +
               ", entrenador=" + (entrenador != null ? entrenador.getNombre() : "N/A") +
               ", horario=" + horario +
               '}';
    }
}
