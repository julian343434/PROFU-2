/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.LogicaNegocio.Controlador;

import com.mycompany.componentescapas.LogicaNegocio.LogicaNegocio.ProgramaServicios;
import com.mycompany.componentescapas.Utilidades.DTO.CursoDTO;
import com.mycompany.componentescapas.Utilidades.DTO.ProgramaDTO;
import com.mycompany.componentescapas.Utilidades.FabricaObjetos.Factory;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PYKE
 */
public class ProgramaControlador {
    private final Factory factory;

    public ProgramaControlador() {
        this.factory = Factory.getInstance();
    }
    
    public String crearPrograma(ProgramaDTO programaDTO) throws SQLException{
        ProgramaServicios programaServicios = factory.crearProgramaServicios();
        String mensaje = programaServicios.crearPrograma(programaDTO);
        return mensaje;
    }
    
    public ProgramaDTO obtenerPrograma(int id) throws SQLException{
        ProgramaServicios programaServicios = factory.crearProgramaServicios();
        ProgramaDTO programaDTO = programaServicios.obtenerPrograma(id);
        return programaDTO;
    }
    
    public List<ProgramaDTO> obtenerTodosLosProgramas() throws SQLException {
        ProgramaServicios programaServicios = factory.crearProgramaServicios();
        List<ProgramaDTO> programasDTO = programaServicios.obtenerTodosLosProgramas();
        return programasDTO;
    }
    
    public List<CursoDTO> obtenerCursosDelPrograma(int programaId) throws SQLException {
        ProgramaServicios programaServicios = factory.crearProgramaServicios();
        List<CursoDTO> cursosDTO = programaServicios.obtenerCursosDelPrograma(programaId);
        return cursosDTO;
    }
}
