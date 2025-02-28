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
public class CursoServicios {
    private final Factory factory;

    public CursoServicios() {
        this.factory = Factory.getInstance();
    }
    
    public String crearCurso(CursoDTO cursoDTO) throws SQLException{
        CursoDAO cursoDAO = factory.crearCursoDAO();
        Curso curso = factory.crearCurso(cursoDTO);
        cursoDAO.crearCurso(curso);
        return "Curso " + curso.getNombre() + " Creado Exitosamente...";
    }
    
    public CursoDTO obtenerCurso(int id) throws SQLException{
        CursoDAO cursoDAO = factory.crearCursoDAO();
        Curso curso = cursoDAO.obtenerCurso(id);
        return factory.crearCursoDTO(curso);
    }
    
    public List<CursoDTO> obtenerTodosLosCursos() throws SQLException{
        CursoDAO cursoDAO = factory.crearCursoDAO();
        List<Curso> cursos = cursoDAO.obtenerTodosLosCursos();
        
        List<CursoDTO> cursosDTO = new ArrayList<>();

        for (Curso curso : cursos) {
            CursoDTO cursoDTO = factory.crearCursoDTO(curso);
            cursosDTO.add(cursoDTO);
        }

        return cursosDTO;
    }
}
