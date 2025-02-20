/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.componentescapas;

//import com.mycompany.componentescapas.LogicaNegocio.Controlador.*;
//import com.mycompany.componentescapas.Persistencia.Entidades.*;
//import com.mycompany.componentescapas.Persistencia.Persistencia.*;
//import com.mycompany.componentescapas.Utilidades.DTO.*;
//import java.util.List;

import com.mycompany.componentescapas.LogicaNegocio.Controlador.DocumentosControlador;
import com.mycompany.componentescapas.LogicaNegocio.Fachada.Fachada;
import com.mycompany.componentescapas.LogicaNegocio.Fachada.IFachada;
import com.mycompany.componentescapas.Persistencia.GestorDocumentos.Documento;
import com.mycompany.componentescapas.Persistencia.SistemaClientes.Cliente;
import com.mycompany.componentescapas.Presentacion.VistaConsola.VistaConsola;
import com.mycompany.componentescapas.Presentacion.VistaEscritorio.VistaEscritorio;
import com.mycompany.componentescapas.Utilidades.FabricaObjetos.Factory;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author PYKE
 */
public class ComponentesCapas {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");
        
        Factory factory = Factory.getInstance();
        
        // Iniciar la vista de consola en un hilo separado
        Thread consolaThread = new Thread(new Runnable() {
            @Override
            public void run() {
                VistaConsola vistaConsola = new VistaConsola(factory);
                vistaConsola.iniciar();
            }
        });
        
        // Iniciar la vista de escritorio en el hilo principal de Swing
        Thread escritorioThread = new Thread(new Runnable() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new VistaEscritorio(factory);
                    }
                });
            }
        });
        
        // Iniciar ambos hilos
        consolaThread.start();
        escritorioThread.start();

        
//        Factory factory = null;
//        factory = factory.getInstance();
//        
//        ProgramaDAO programaDAO = factory.crearProgramaDAO();
//        CursoDAO cursoDAO = factory.crearCursoDAO();
//        EstudianteDAO estudianteDAO = factory.crearEstudianteDAO();
//        EstudianteCursoDAO estudianteCursoDAO = factory.crearEstudianteCursoDAO();
//        
//        Programa programa1 = factory.crearPrograma("Ing Sistemas");
//        Programa programa2 = factory.crearPrograma("Ing Electronica");
//        programaDAO.crearPrograma(programa1);
//        programaDAO.crearPrograma(programa2);
//        programa1 = programaDAO.obtenerPrograma(1);
//        programa2 = programaDAO.obtenerPrograma(2);
//        
//        System.out.println("Todos los Programas desde DAO: ");
//        System.out.println(programaDAO.obtenerTodosLosProgramas());
//
//        CursoDTO cursoDTO1 = factory.crearCursoDTO("Ing Software II", 9, programa1.getId());
//        CursoDTO cursoDTO2 = factory.crearCursoDTO("Programacion en GO", 6, programa1.getId());
//        CursoDTO cursoDTO3 = factory.crearCursoDTO("Introduccion a Ing Electronica", 1, programa2.getId());
//        CursoDTO cursoDTO4 = factory.crearCursoDTO("Ecuaciones Diferenciales", 3, programa2.getId());
//        
//        CursoControlador cursoControlador = factory.crearCursoControlador();
//        
//        System.out.println(cursoControlador.crearCurso(cursoDTO1));
//        System.out.println(cursoControlador.crearCurso(cursoDTO2));
//        System.out.println(cursoControlador.crearCurso(cursoDTO3));
//        System.out.println(cursoControlador.crearCurso(cursoDTO4));
//        
//        System.out.println("Todos los Cursos desde Controlador: ");
//        System.out.println(cursoControlador.obtenerTodosLosCursos());
//        
//        EstudianteDTO estudianteDTO1 = factory.crearEstudianteDTO("Nelson", "Arango");
//        EstudianteDTO estudianteDTO2 = factory.crearEstudianteDTO("Maykol", "Gomez");
//        EstudianteDTO estudianteDTO3 = factory.crearEstudianteDTO("Brahian", "Pulido");
//        EstudianteDTO estudianteDTO4 = factory.crearEstudianteDTO("Coscu", "Firme");
//        EstudianteDTO estudianteDTO5 = factory.crearEstudianteDTO("Martin", "Avila");
//        EstudianteDTO estudianteDTO6 = factory.crearEstudianteDTO("Juan", "Lopez");
//     
//        EstudianteControlador estudianteControlador = factory.crearEstudianteControlador();
//        
//        System.out.println(estudianteControlador.crearEstudiante(estudianteDTO1));
//        System.out.println(estudianteControlador.crearEstudiante(estudianteDTO2));
//        System.out.println(estudianteControlador.crearEstudiante(estudianteDTO3));
//        System.out.println(estudianteControlador.crearEstudiante(estudianteDTO4));
//        System.out.println(estudianteControlador.crearEstudiante(estudianteDTO5));
//        System.out.println(estudianteControlador.crearEstudiante(estudianteDTO6));
//        
//        System.out.println("Todos los Estudiantes desde Controlador: ");
//        System.out.println(estudianteControlador.obtenerTodosLosEstudiantes());
//        
//        estudianteControlador.inscribirCurso(1, 1);
//        estudianteControlador.inscribirCurso(1, 2);
//        estudianteControlador.inscribirCurso(1, 3);
//        estudianteControlador.inscribirCurso(1, 4);
//        estudianteControlador.inscribirCurso(2, 1);
//        estudianteControlador.inscribirCurso(2, 2);
//        estudianteControlador.inscribirCurso(3, 1);
//        estudianteControlador.inscribirCurso(4, 1);
//        estudianteControlador.inscribirCurso(5, 1);
//        estudianteControlador.inscribirCurso(5, 2);
//        estudianteControlador.inscribirCurso(5, 3);
//        estudianteControlador.inscribirCurso(6, 1);
//        estudianteControlador.inscribirCurso(1, 2);
//        
//        cursoDTO1 = cursoControlador.obtenerCurso(1);
//        System.out.println("Todos los Estudiantes del curso " + cursoDTO1.getNombre() + " desde Controlador: ");
//        List<EstudianteDTO> estudiantesDTO1 = cursoControlador.obtenerEstudiantesDelCurso(1);
//        for(EstudianteDTO estudiante : estudiantesDTO1){
//            System.out.println(estudiante.getNombres() + " " + estudiante.getApellidos());
//        }
//        
//        cursoDTO2 = cursoControlador.obtenerCurso(2);
//        System.out.println("Todos los Estudiantes del curso " + cursoDTO2.getNombre() + " desde Controlador: ");
//        List<EstudianteDTO> estudiantesDTO2 = cursoControlador.obtenerEstudiantesDelCurso(cursoDTO2.getId());
//        for(EstudianteDTO estudiante : estudiantesDTO2){
//            System.out.println(estudiante.getNombres() + " " + estudiante.getApellidos());
//        }
//        
//        estudianteDTO1 = estudianteControlador.obtenerEstudiante(1);
//        System.out.println("Todos los Cursos del estudiante " + estudianteDTO1.getNombres() + " " + estudianteDTO1.getApellidos() + " desde Controlador: ");
//        List<CursoDTO> cursosDTO1 = estudianteControlador.obtenerCursosDelEstudiante(estudianteDTO1.getId());
//        for(CursoDTO curso : cursosDTO1){
//            System.out.println(curso.toString());
//        }
//        
//        estudianteDTO2 = estudianteControlador.obtenerEstudiante(2);
//        System.out.println("Todos los Cursos del estudiante " + estudianteDTO2.getNombres() + " " + estudianteDTO2.getApellidos() + " desde Controlador: ");
//        List<CursoDTO> cursosDTO2 = estudianteControlador.obtenerCursosDelEstudiante(estudianteDTO2.getId());
//        for(CursoDTO curso : cursosDTO2){
//            System.out.println(curso.getNombre());
//        }
    }
}
