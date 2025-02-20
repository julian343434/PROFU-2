/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.Utilidades.DTO;

/**
 *
 * @author PYKE
 */
public class EstudianteDTO {
    private int id;
    private String nombres;
    private String apellidos;

    public EstudianteDTO(int id, String nombres, String apellidos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public EstudianteDTO(String nombres, String apellidos) {
        this.id = 0;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "EstudianteDTO{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + '}';
    }
}
