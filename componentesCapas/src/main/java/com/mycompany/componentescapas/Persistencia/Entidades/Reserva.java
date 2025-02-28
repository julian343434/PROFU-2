package com.mycompany.componentescapas.Persistencia.Entidades;

import java.time.LocalDateTime;

public class Reserva {
    private Cliente cliente;
    private Clase clase;
    private LocalDateTime fecha;
    private boolean confirmada;

    // Constructor vacío
    public Reserva() {
    }

    // Constructor con parámetros
    public Reserva(Cliente cliente, Clase clase, LocalDateTime fecha, boolean confirmada) {
        this.cliente = cliente;
        this.clase = clase;
        this.fecha = fecha;
        this.confirmada = confirmada;
    }

    // Getters y Setters
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Clase getClase() { return clase; }
    public void setClase(Clase clase) { this.clase = clase; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public boolean isConfirmada() { return confirmada; }
    public void setConfirmada(boolean confirmada) { this.confirmada = confirmada; }

    // Método toString mejorado
    @Override
    public String toString() {
        return "Reserva{" +
               "cliente=" + cliente +
               ", clase=" + clase +
               ", fecha=" + fecha +
               ", confirmada=" + confirmada +
               '}';
    }
}
