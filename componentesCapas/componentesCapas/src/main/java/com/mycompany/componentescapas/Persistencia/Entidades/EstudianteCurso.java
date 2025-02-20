/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.Persistencia.Entidades;

/**
 *
 * @author PYKE
 */
public class EstudianteCurso {
    private int id;
    private int estudianteId;
    private int cursoId;

    public EstudianteCurso(int id, int estudianteId, int cursoId) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.cursoId = cursoId;
    }
    
    public EstudianteCurso(int estudianteId, int cursoId) {
        this.id = 0;
        this.estudianteId = estudianteId;
        this.cursoId = cursoId;
    }

    public int getId() {
        return id;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    @Override
    public String toString() {
        return "EstudianteCurso{" + "id=" + id + ", estudianteId=" + estudianteId + ", cursoId=" + cursoId + '}';
    }
}
