/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.Utilidades.FabricaObjetos;

import com.mycompany.componentescapas.LogicaNegocio.Controlador.*;
import com.mycompany.componentescapas.LogicaNegocio.LogicaNegocio.*;
import com.mycompany.componentescapas.Persistencia.Entidades.*;
import com.mycompany.componentescapas.Persistencia.Persistencia.*;
import com.mycompany.componentescapas.Utilidades.DTO.*;

/**
 *
 * @author PYKE
 */
public class Factory {

    private static Factory instancia;
    
    private Factory() {
    }
    
    public static Factory getInstance() {
        if (instancia == null) {
            instancia = new Factory();
        }
        return instancia;
    }

    public CursoDTO crearCursoDTO(String nombre, int semestre, int programaId) {
        CursoDTO cursoDTO = new CursoDTO(nombre, semestre, programaId);
        return cursoDTO;
    }
    
    public CursoDTO crearCursoDTO(Curso curso) {
        CursoDTO cursoDTO = new CursoDTO(curso.getNombre(), curso.getSemestre(), curso.getProgramaId());
        if(curso.getId() != 0){
            cursoDTO.setId(curso.getId());
        }
        return cursoDTO;
    }
    
    public EstudianteDTO crearEstudianteDTO(String nombre, String apellidos) {
        EstudianteDTO estudianteDTO = new EstudianteDTO(nombre, apellidos);
        return estudianteDTO;
    }
    
    public EstudianteDTO crearEstudianteDTO(Estudiante estudiante) {
        EstudianteDTO estudianteDTO = new EstudianteDTO(estudiante.getNombres(), estudiante.getApellidos());
        if(estudiante.getId() != 0){
            estudianteDTO.setId(estudiante.getId());
        }
        return estudianteDTO;
    }
    
    public ProgramaDTO crearProgramaDTO(String nombre) {
        ProgramaDTO programaDTO = new ProgramaDTO(nombre);
        return programaDTO;
    }
    
    public ProgramaDTO crearProgramaDTO(Programa programa) {
        ProgramaDTO programaDTO = new ProgramaDTO(programa.getNombre());
        if(programa.getId() != 0){
            programaDTO.setId(programa.getId());
        }
        return programaDTO;
    }
    
    public EstudianteCursoDTO crearEstudianteCursoDTO(int estudianteId, int cursoId) {
        EstudianteCursoDTO estudianteCursoDTO = new EstudianteCursoDTO(estudianteId, cursoId);
        return estudianteCursoDTO;
    }
    
    public EstudianteCursoDTO crearEstudianteCursoDTO(EstudianteCurso estudianteCurso) {
        EstudianteCursoDTO estudianteCursoDTO = new EstudianteCursoDTO(estudianteCurso.getEstudianteId(), estudianteCurso.getCursoId());
        if(estudianteCurso.getId() != 0){
            estudianteCursoDTO.setId(estudianteCurso.getId());
        }
        return estudianteCursoDTO;
    }
    
    public Curso crearCurso(String nombre, int semestre, int programaId) {
        Curso curso = new Curso(nombre, semestre, programaId);
        return curso;
    }
    
    public Curso crearCurso(CursoDTO cursoDTO) {
        Curso curso = new Curso(cursoDTO.getNombre(), cursoDTO.getSemestre(), cursoDTO.getProgramaId());
        if(cursoDTO.getId() != 0){
            curso.setId(cursoDTO.getId());
        }
        return curso;
    }
    
    public Estudiante crearEstudiante(String nombre, String apellidos) {
        Estudiante estudiante = new Estudiante(nombre, apellidos);
        return estudiante;
    }
    
    public Estudiante crearEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = new Estudiante(estudianteDTO.getNombres(), estudianteDTO.getApellidos());
        if(estudianteDTO.getId() != 0){
            estudiante.setId(estudianteDTO.getId());
        }
        return estudiante;
    }
    
    public Programa crearPrograma(String nombre) {
        Programa programa = new Programa(nombre);
        return programa;
    }
    
    public Programa crearPrograma(ProgramaDTO programaDTO) {
        Programa programa = new Programa(programaDTO.getNombre());
        if(programaDTO.getId() != 0){
            programa.setId(programaDTO.getId());
        }
        return programa;
    }
    
    public EstudianteCurso crearEstudianteCurso(int estudianteId, int cursoId) {
        EstudianteCurso estudianteCurso = new EstudianteCurso(estudianteId, cursoId);
        return estudianteCurso;
    }
    
    public EstudianteCurso crearEstudianteCurso(EstudianteCursoDTO estudianteCursoDTO) {
        EstudianteCurso estudianteCurso = new EstudianteCurso(estudianteCursoDTO.getEstudianteId(), estudianteCursoDTO.getCursoId());
        if(estudianteCursoDTO.getId() != 0){
            estudianteCurso.setId(estudianteCursoDTO.getId());
        }
        return estudianteCurso;
    }
    
    public CursoDAO crearCursoDAO(){
        CursoDAO cursoDAO = new CursoDAO();
        return cursoDAO;
    }
    
    public EstudianteDAO crearEstudianteDAO(){
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        return estudianteDAO;
    }
    
    public ProgramaDAO crearProgramaDAO(){
        ProgramaDAO programaDAO = new ProgramaDAO();
        return programaDAO;
    }
    
    public EstudianteCursoDAO crearEstudianteCursoDAO(){
        EstudianteCursoDAO estudianteCursoDAO = new EstudianteCursoDAO();
        return estudianteCursoDAO;
    }
    
    public CursoServicios crearCursoServicios(){
        CursoServicios cursoServicios = new CursoServicios();
        return cursoServicios;
    }
    
    public EstudianteServicios crearEstudianteServicios(){
        EstudianteServicios estudianteServicios = new EstudianteServicios();
        return estudianteServicios;
    }
    
    public ProgramaServicios crearProgramaServicios(){
        ProgramaServicios programaServicios = new ProgramaServicios();
        return programaServicios;
    }
    
    public EstudianteCursoServicios crearEstudianteCursoServicios(){
        EstudianteCursoServicios estudianteCursoServicios = new EstudianteCursoServicios();
        return estudianteCursoServicios;
    }
    
    public CursoControlador crearCursoControlador(){
        CursoControlador cursoControlador = new CursoControlador();
        return cursoControlador;
    }
    
    public EstudianteControlador crearEstudianteControlador(){
        EstudianteControlador estudianteControlador = new EstudianteControlador();
        return estudianteControlador;
    }
    
    public ProgramaControlador crearProgramaControlador(){
        ProgramaControlador programaControlador = new ProgramaControlador();
        return programaControlador;
    }
    
    public DocumentosControlador crearDocumentosControlador(){
        DocumentosControlador documentosControlador = new DocumentosControlador();
        return documentosControlador;
    }
}
