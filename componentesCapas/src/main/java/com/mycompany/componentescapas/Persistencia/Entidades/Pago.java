package com.mycompany.componentescapas.Persistencia.Entidades;

public class Pago {
    private Cliente cliente;
    private double monto;
    private String metodo;  // Ejemplo: "Tarjeta", "Efectivo"
    private boolean pagado;

    // Constructor vacío
    public Pago() {
    }

    // Constructor con parámetros
    public Pago(Cliente cliente, double monto, String metodo, boolean pagado) {
        this.cliente = cliente;
        this.monto = monto;
        this.metodo = metodo;
        this.pagado = pagado;
    }

    // Getters y Setters
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }

    public boolean isPagado() { return pagado; }
    public void setPagado(boolean pagado) { this.pagado = pagado; }

    // Método toString para imprimir la información de la clase correctamente
    @Override
    public String toString() {
        return "Pago{" +
               "cliente=" + cliente +
               ", monto=" + monto +
               ", metodo='" + metodo + '\'' +
               ", pagado=" + pagado +
               '}';
    }
}
