package com.mycompany.componentescapas.Persistencia.Entidades;

public class Membresia {
    private String tipo;  // Ejemplo: "Mensual", "Anual"
    private boolean activa;

    // Constructor vacío
    public Membresia() {
    }

    // Constructor con parámetros
    public Membresia(String tipo, boolean activa) {
        this.tipo = tipo;
        this.activa = activa;
    }

    // Getters y Setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }

    // Método toString corregido
    @Override
    public String toString() {
        return "Membresia{" +
               "tipo='" + tipo + '\'' +
               ", activa=" + activa +
               '}';
    }
}
