/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.Utilidades.DTO;

/**
 *
 * @author PYKE
 */
public class ProgramaDTO {
    private int id;
    private String nombre;

    public ProgramaDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ProgramaDTO(String nombre) {
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
        return "ProgramaDTO{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
