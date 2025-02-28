/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.LogicaNegocio.Controlador;

import com.mycompany.componentescapas.LogicaNegocio.LogicaNegocio.EstudianteCursoServicios;
import com.mycompany.componentescapas.LogicaNegocio.LogicaNegocio.EstudianteServicios;
import com.mycompany.componentescapas.Utilidades.DTO.CursoDTO;
import com.mycompany.componentescapas.Utilidades.DTO.EstudianteDTO;
import com.mycompany.componentescapas.Utilidades.FabricaObjetos.Factory;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PYKE
 */
public class EstudianteControlador {
    private final Factory factory;

    public EstudianteControlador() {
        this.factory = Factory.getInstance();
    }
    
    public String crearEstudiante(EstudianteDTO estudianteDTO) throws SQLException{
        EstudianteServicios estudianteServicios = factory.crearEstudianteServicios();
        String mensaje = estudianteServicios.crearEstudiante(estudianteDTO);
        return mensaje;
    }
    
    public EstudianteDTO obtenerEstudiante(int id) throws SQLException{
        EstudianteServicios estudianteServicios = factory.crearEstudianteServicios();
        EstudianteDTO estudianteDTO = estudianteServicios.obtenerEstudiante(id);
        return estudianteDTO;
    }
    
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() throws SQLException {
        EstudianteServicios estudianteServicios = factory.crearEstudianteServicios();
        List<EstudianteDTO> estudiantesDTO = estudianteServicios.obtenerTodosLosEstudiantes();
        return estudiantesDTO;
    }
    
    public List<CursoDTO> obtenerCursosDelEstudiante(int estudianteId) throws SQLException {
        EstudianteCursoServicios estudianteCursoServicios = factory.crearEstudianteCursoServicios();
        List<CursoDTO> cursosDTO = estudianteCursoServicios.obtenerCursosDelEstudiante(estudianteId);
        return cursosDTO;
    }
    
    public String inscribirCurso(int estudianteId, int cursoId) throws SQLException{
        EstudianteServicios estudianteServicios = factory.crearEstudianteServicios();
        String mensaje = estudianteServicios.inscribirCurso(estudianteId, cursoId);
        return mensaje;
    }
}
