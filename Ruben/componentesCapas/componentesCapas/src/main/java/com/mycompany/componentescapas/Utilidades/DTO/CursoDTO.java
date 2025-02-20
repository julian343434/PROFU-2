/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.Utilidades.DTO;

/**
 *
 * @author PYKE
 */
public class CursoDTO {
    private int id;
    private String nombre;
    private int semestre;
    private int programaId;

    public CursoDTO(int id, String nombre, int semestre, int programaId) {
        this.id = id;
        this.nombre = nombre;
        this.semestre = semestre;
        this.programaId = programaId;
    }

    public CursoDTO(String nombre, int semestre, int programaId) {
        this.id = 0;
        this.nombre = nombre;
        this.semestre = semestre;
        this.programaId = programaId;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public int getProgramaId() {
        return programaId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setProgramaId(int programaId) {
        this.programaId = programaId;
    }

    @Override
    public String toString() {
        return "CursoDTO{" + "id=" + id + ", nombre=" + nombre + ", semestre=" + semestre + ", programaId=" + programaId + '}';
    }
}
