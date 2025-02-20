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
import com.mycompany.componentescapas.Utilidades.DTO.CursoDTO;
import com.mycompany.componentescapas.Utilidades.DTO.EstudianteDTO;
import com.mycompany.componentescapas.Utilidades.FabricaObjetos.Factory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PYKE
 */
public class EstudianteCursoServicios {
    private final Factory factory;

    public EstudianteCursoServicios() {
        this.factory = Factory.getInstance();
    }
    
    public List<CursoDTO> obtenerCursosDelEstudiante(int cursoId) throws SQLException {
        EstudianteCursoDAO estudianteCursoDAO = factory.crearEstudianteCursoDAO();
        List<EstudianteCurso> estudianteCursos = estudianteCursoDAO.obtenerCursosDelEstudiante(cursoId);

        List<CursoDTO> cursosDTO = new ArrayList<>();

        CursoDAO cursoDAO = factory.crearCursoDAO();

        for (EstudianteCurso estudianteCurso : estudianteCursos) {
            Curso curso = cursoDAO.obtenerCurso(estudianteCurso.getCursoId());
            CursoDTO estudianteDTO = factory.crearCursoDTO(curso);
            cursosDTO.add(estudianteDTO);
        }

        return cursosDTO;
    }
    
    public List<EstudianteDTO> obtenerEstudiantesDelCurso(int cursoId) throws SQLException {
        EstudianteCursoDAO estudianteCursoDAO = factory.crearEstudianteCursoDAO();
        List<EstudianteCurso> estudianteCursos = estudianteCursoDAO.obtenerEstudiantesDelCurso(cursoId);

        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();

        EstudianteDAO estudianteDAO = factory.crearEstudianteDAO();

        for (EstudianteCurso estudianteCurso : estudianteCursos) {
            Estudiante estudiante = estudianteDAO.obtenerEstudiante(estudianteCurso.getEstudianteId());
            EstudianteDTO estudianteDTO = factory.crearEstudianteDTO(estudiante);
            estudiantesDTO.add(estudianteDTO);
        }

        return estudiantesDTO;
    }
}
