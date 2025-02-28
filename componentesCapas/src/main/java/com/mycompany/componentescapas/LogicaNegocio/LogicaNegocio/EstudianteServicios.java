/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.LogicaNegocio.LogicaNegocio;

import com.mycompany.componentescapas.Persistencia.Entidades.Curso;
import com.mycompany.componentescapas.Persistencia.Entidades.Estudiante;
import com.mycompany.componentescapas.Persistencia.Entidades.EstudianteCurso;
import com.mycompany.componentescapas.Persistencia.Persistencia.CursoDAO;
import com.mycompany.componentescapas.Persistencia.Persistencia.EstudianteCursoDAO;
import com.mycompany.componentescapas.Persistencia.Persistencia.EstudianteDAO;
import com.mycompany.componentescapas.Utilidades.DTO.*;
import com.mycompany.componentescapas.Utilidades.FabricaObjetos.Factory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PYKE
 */
public class EstudianteServicios {
    private final Factory factory;

    public EstudianteServicios() {
        this.factory = Factory.getInstance();
    }
    
    public String crearEstudiante(EstudianteDTO estudianteDTO) throws SQLException{
        EstudianteDAO estudianteDAO = factory.crearEstudianteDAO();
        Estudiante estudiante = factory.crearEstudiante(estudianteDTO);
        estudianteDAO.crearEstudiante(estudiante);
        return "Estudiante " + estudiante.getNombres() + " " + estudiante.getApellidos() + " Creado Exitosamente...";
    }
    
    public EstudianteDTO obtenerEstudiante(int id) throws SQLException{
        EstudianteDAO estudianteDAO = factory.crearEstudianteDAO();
        Estudiante estudiante = estudianteDAO.obtenerEstudiante(id);
        return factory.crearEstudianteDTO(estudiante);
    }
    
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() throws SQLException{
        EstudianteDAO estudianteDAO = factory.crearEstudianteDAO();
        List<Estudiante> estudiantes = estudianteDAO.obtenerTodosLosEstudiantes();
        
        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();

        for (Estudiante estudiante : estudiantes) {
            EstudianteDTO estudianteDTO = factory.crearEstudianteDTO(estudiante);
            estudiantesDTO.add(estudianteDTO);
        }

        return estudiantesDTO;
    }
    
    public String inscribirCurso(int estudianteId, int cursoId) throws SQLException{
        EstudianteCursoDAO estudianteCursoDAO = factory.crearEstudianteCursoDAO();
        EstudianteDAO estudianteDAO = factory.crearEstudianteDAO();
        CursoDAO cursoDAO = factory.crearCursoDAO();
        EstudianteCurso estudianteCurso = factory.crearEstudianteCurso(estudianteId, cursoId);
        estudianteCursoDAO.crearEstudianteCurso(estudianteCurso);
        Curso curso = cursoDAO.obtenerCurso(cursoId);
        Estudiante estudiante = estudianteDAO.obtenerEstudiante(estudianteId);
        return "Estudiante " + estudiante.getNombres() + " " + estudiante.getApellidos() + " inscrito al Curso: " + curso.getNombre() + "...";
    }
}
