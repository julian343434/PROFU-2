/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.LogicaNegocio.Controlador;

import com.mycompany.componentescapas.LogicaNegocio.LogicaNegocio.CursoServicios;
import com.mycompany.componentescapas.LogicaNegocio.LogicaNegocio.EstudianteCursoServicios;
import com.mycompany.componentescapas.Utilidades.DTO.CursoDTO;
import com.mycompany.componentescapas.Utilidades.DTO.EstudianteDTO;
import com.mycompany.componentescapas.Utilidades.FabricaObjetos.Factory;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PYKE
 */
public class CursoControlador {
    private final Factory factory;

    public CursoControlador() {
        this.factory = Factory.getInstance();
    }
    
    public String crearCurso(CursoDTO cursoDTO) throws SQLException{
        CursoServicios cursoServicios = factory.crearCursoServicios();
        String mensaje = cursoServicios.crearCurso(cursoDTO);
        return mensaje;
    }
    
    public CursoDTO obtenerCurso(int id) throws SQLException{
        CursoServicios cursoServicios = factory.crearCursoServicios();
        CursoDTO cursoDTO = cursoServicios.obtenerCurso(id);
        return cursoDTO;
    }
    
    public List<CursoDTO> obtenerTodosLosCursos() throws SQLException {
        CursoServicios cursoServicios = factory.crearCursoServicios();
        List<CursoDTO> cursosDTO = cursoServicios.obtenerTodosLosCursos();
        return cursosDTO;
    }
    
    public List<EstudianteDTO> obtenerEstudiantesDelCurso(int cursoId) throws SQLException {
        EstudianteCursoServicios estudianteCursoServicios = factory.crearEstudianteCursoServicios();
        List<EstudianteDTO> estudiantesDTO = estudianteCursoServicios.obtenerEstudiantesDelCurso(cursoId);
        return estudiantesDTO;
    }
}
