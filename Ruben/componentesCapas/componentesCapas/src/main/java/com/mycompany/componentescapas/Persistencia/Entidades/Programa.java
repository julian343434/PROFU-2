/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.Persistencia.Entidades;

/**
 *
 * @author PYKE
 */
public class Programa {
    private int id;
    private String nombre;

    public Programa(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Programa(String nombre) {
        this.id = 0;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Programa{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
