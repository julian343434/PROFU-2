/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.LogicaNegocio.LogicaNegocio;

import com.mycompany.componentescapas.Persistencia.Entidades.Curso;
import com.mycompany.componentescapas.Persistencia.Entidades.Programa;
import com.mycompany.componentescapas.Persistencia.Persistencia.CursoDAO;
import com.mycompany.componentescapas.Persistencia.Persistencia.ProgramaDAO;
import com.mycompany.componentescapas.Utilidades.DTO.*;
import com.mycompany.componentescapas.Utilidades.FabricaObjetos.Factory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PYKE
 */
public class ProgramaServicios {
    private final Factory factory;

    public ProgramaServicios() {
        this.factory = Factory.getInstance();
    }
    
    public String crearPrograma(ProgramaDTO programaDTO) throws SQLException{
        ProgramaDAO programaDAO = factory.crearProgramaDAO();
        Programa programa = factory.crearPrograma(programaDTO);
        programaDAO.crearPrograma(programa);
        return "Programa " + programa.getNombre() + " Creado Exitosamente...";
    }
    
    public ProgramaDTO obtenerPrograma(int id) throws SQLException{
        ProgramaDAO programaDAO = factory.crearProgramaDAO();
        Programa programa = programaDAO.obtenerPrograma(id);
        return factory.crearProgramaDTO(programa);
    }
    
    public List<ProgramaDTO> obtenerTodosLosProgramas() throws SQLException{
        ProgramaDAO programaDAO = factory.crearProgramaDAO();
        List<Programa> programas = programaDAO.obtenerTodosLosProgramas();
        
        List<ProgramaDTO> programasDTO = new ArrayList<>();

        for (Programa programa : programas) {
            ProgramaDTO programaDTO = factory.crearProgramaDTO(programa);
            programasDTO.add(programaDTO);
        }

        return programasDTO;
    }
    
    public List<CursoDTO> obtenerCursosDelPrograma(int programaId) throws SQLException {
        ProgramaDAO programaDAO = factory.crearProgramaDAO();
        List<Curso> cursos = programaDAO.obtenerCursosDelPrograma(programaId);

        List<CursoDTO> cursosDTO = new ArrayList<>();

        for (Curso curso : cursos) {
            CursoDTO cursoDTO = factory.crearCursoDTO(curso);
            cursosDTO.add(cursoDTO);
        }

        return cursosDTO;
    }
}
