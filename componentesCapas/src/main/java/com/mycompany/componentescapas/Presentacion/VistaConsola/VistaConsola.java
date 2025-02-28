package com.mycompany.componentescapas.Presentacion.VistaConsola;

import com.mycompany.componentescapas.LogicaNegocio.Controlador.*;
import com.mycompany.componentescapas.Utilidades.DTO.*;
import com.mycompany.componentescapas.Utilidades.FabricaObjetos.Factory;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PYKE
 */
public class VistaConsola {

    private CursoControlador cursoControlador;
    private EstudianteControlador estudianteControlador;
    private ProgramaControlador programaControlador;
    private DocumentosControlador clienteControlador;
    private DocumentosControlador documentoControlador;
    private Scanner scanner;

    public VistaConsola(Factory factory) {
        this.cursoControlador = factory.crearCursoControlador();
        this.estudianteControlador = factory.crearEstudianteControlador();
        this.programaControlador = factory.crearProgramaControlador();
        this.clienteControlador = factory.crearDocumentosControlador();
        this.documentoControlador = factory.crearDocumentosControlador();

        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;
        
        while (!salir) {
            System.out.println("\nEscoja lo que desea Gestionar");
            System.out.println("1. Gestión de Cursos y Estudiantes");
            System.out.println("2. Gestión de Clientes y Documentos");
            System.out.print("Seleccione una opción: ");
            
            int opcion1 = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion1) {
                case 1:
                    System.out.println("\nGestión de Cursos y Estudiantes");
                    System.out.println("1. Crear Curso");
                    System.out.println("2. Crear Estudiante");
                    System.out.println("3. Listar Cursos");
                    System.out.println("4. Listar Estudiantes");
                    System.out.println("5. Listar Estudiantes de un Curso");
                    System.out.println("6. Listar Cursos de un Estudiante");
                    System.out.println("7. Inscribir Estudiante en Curso");
                    System.out.println("8. Salir");
                    System.out.print("Seleccione una opción: ");
                    
                    int opcion = scanner.nextInt();
                    scanner.nextLine();
            
                    switch (opcion) {
                        case 1:
                            crearCurso();
                            break;
                        case 2:
                            crearEstudiante();
                            break;
                        case 3:
                            listarCursos();
                            break;
                        case 4:
                            listarEstudiantes();
                            break;
                        case 5:
                            listarEstudiantesDeCurso();
                            break;
                        case 6:
                            listarCursosDeEstudiante();
                            break;
                        case 7:
                            inscribirEstudianteEnCurso();
                        break;
                        case 8:
                            salir = true;
                        break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }
                    break;
                case 2:
                    System.out.println("\nGestión de Clientes y Documentos");
                    System.out.println("1. Crear Cliente");
                    System.out.println("2. Crear Documento");
                    System.out.println("3. Asignar Documento a Cliente");
                    System.out.println("4. Listar Clientes");
                    System.out.println("5. Listar Documentos de Cliente");
                    System.out.println("6. Salir");
                    System.out.print("Seleccione una opción: ");
                    
                    int opcion2 = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (opcion2) {
                        case 1:
                            crearCliente();
                            break;
                        case 2:
                            crearDocumento();
                            break;
                        case 3:
                            asignarDocumento();
                            break;
                        case 4:
                            listarClientes();
                            break;
                        case 5:
                            listarDocumentosDeCliente();
                            break;
                        case 6:
                            salir = true;
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void crearCurso() {
        System.out.println("\n--- Crear Curso ---");
        
        System.out.print("Nombre del curso: ");
        String nombreCurso = scanner.nextLine();
        
        System.out.print("Semestre: ");
        int semestre = scanner.nextInt();
        
        System.out.print("ID del programa: ");
        int idPrograma = scanner.nextInt();
        scanner.nextLine();

        try {
            CursoDTO cursoDTO = new CursoDTO(nombreCurso, semestre, idPrograma);
            cursoControlador.crearCurso(cursoDTO);
            System.out.println("Curso creado con éxito.");
        } catch (SQLException ex) {
            Logger.getLogger(VistaConsola.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al crear el curso.");
        }
    }

    private void crearEstudiante() {
        System.out.println("\n--- Crear Estudiante ---");
        
        System.out.print("Nombres del estudiante: ");
        String nombresEstudiante = scanner.nextLine();
        
        System.out.print("Apellidos del estudiante: ");
        String apellidosEstudiante = scanner.nextLine();

        try {
            EstudianteDTO estudianteDTO = new EstudianteDTO(nombresEstudiante, apellidosEstudiante);
            estudianteControlador.crearEstudiante(estudianteDTO);
            System.out.println("Estudiante creado con éxito.");
        } catch (SQLException ex) {
            Logger.getLogger(VistaConsola.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al crear el estudiante.");
        }
    }

    private void listarCursos() {
        System.out.println("\n--- Listar Cursos ---");
        try {
            List<CursoDTO> cursos = cursoControlador.obtenerTodosLosCursos();
            for (CursoDTO curso : cursos) {
                ProgramaDTO programa = programaControlador.obtenerPrograma(curso.getProgramaId());
                System.out.printf("ID: %d, Nombre: %s, Semestre: %d, Programa: %s\n", 
                                  curso.getId(), curso.getNombre(), curso.getSemestre(), programa.getNombre());
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaConsola.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al obtener los cursos.");
        }
    }

    private void listarEstudiantes() {
        System.out.println("\n--- Listar Estudiantes ---");
        try {
            List<EstudianteDTO> estudiantes = estudianteControlador.obtenerTodosLosEstudiantes();
            for (EstudianteDTO estudiante : estudiantes) {
                System.out.printf("ID: %d, Nombres: %s, Apellidos: %s\n", 
                                  estudiante.getId(), estudiante.getNombres(), estudiante.getApellidos());
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaConsola.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al obtener los estudiantes.");
        }
    }

    private void listarEstudiantesDeCurso() {
        System.out.println("\n--- Listar Estudiantes de un Curso ---");
        try {
            listarCursos();
            System.out.print("Ingrese el ID del curso: ");
            int cursoId = scanner.nextInt();
            scanner.nextLine();
            
            CursoDTO curso = cursoControlador.obtenerCurso(cursoId);
            System.out.print("Estudiantes del curso " + curso.getNombre() + ": \n");
            
            List<EstudianteDTO> estudiantes = cursoControlador.obtenerEstudiantesDelCurso(cursoId);
            for (EstudianteDTO estudiante : estudiantes) {
                System.out.printf("ID: %d, Nombres: %s, Apellidos: %s\n", 
                                  estudiante.getId(), estudiante.getNombres(), estudiante.getApellidos());
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaConsola.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al obtener los estudiantes del curso.");
        }
    }

    private void listarCursosDeEstudiante() {
        System.out.println("\n--- Listar Cursos de un Estudiante ---");
        try {
            listarEstudiantes();
            System.out.print("Ingrese el ID del estudiante: ");
            int estudianteId = scanner.nextInt();
            scanner.nextLine();
            
            EstudianteDTO estudiante = estudianteControlador.obtenerEstudiante(estudianteId);
            System.out.print("Cursos del Estudiante " + estudiante.getNombres() + " " + estudiante.getApellidos() + ": \n");
            
            List<CursoDTO> cursos = estudianteControlador.obtenerCursosDelEstudiante(estudianteId);
            for (CursoDTO curso : cursos) {
                ProgramaDTO programa = programaControlador.obtenerPrograma(curso.getProgramaId());
                System.out.printf("ID: %d, Nombre: %s, Semestre: %d, Programa: %s\n", 
                                  curso.getId(), curso.getNombre(), curso.getSemestre(), programa.getNombre());
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaConsola.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al obtener los cursos del estudiante.");
        }
    }
    
    private void inscribirEstudianteEnCurso() {
        System.out.println("\n--- Inscribir Estudiante en Curso ---");
        try {
            listarEstudiantes();
            System.out.print("Ingrese el ID del estudiante: ");
            int estudianteId = scanner.nextInt();
            scanner.nextLine();

            listarCursos();
            System.out.print("Ingrese el ID del curso: ");
            int cursoId = scanner.nextInt();
            scanner.nextLine();

            estudianteControlador.inscribirCurso(estudianteId, cursoId);
            System.out.println("Estudiante inscrito en el curso con éxito.");

        } catch (SQLException ex) {
            Logger.getLogger(VistaConsola.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al inscribir el estudiante en el curso.");
        }
    }
    
    private void crearCliente() {
        System.out.println("\n--- Crear Cliente ---");
        
        System.out.print("Nombre del Cliente: ");
        String nombreCliente = scanner.nextLine();
        
        System.out.print("Documento: ");
        String documentoCliente = scanner.nextLine();

        ClienteDTO clienteDTO = new ClienteDTO(nombreCliente, documentoCliente);
        clienteControlador.crearCliente(clienteDTO);
        System.out.println("Cliente creado con éxito.");
    }

    private void crearDocumento() {
        System.out.println("\n--- Crear Documento ---");
        
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Contenido: ");
        String contenido = scanner.nextLine();

        if (titulo.isEmpty() || contenido.isEmpty()) {
            System.out.println("Todos los campos deben ser completados.");
            return;
        }

        DocumentoDTO documentoDTO = new DocumentoDTO();
        documentoDTO.setTitulo(titulo);
        documentoDTO.setContenido(contenido);

        documentoControlador.crearDocumento(documentoDTO);
        System.out.println("Documento creado con éxito.");
    }

    private void asignarDocumento() {
        System.out.println("\n--- Asignar Documento a Cliente ---");
        
        List<ClienteDTO> clientes = clienteControlador.obtenerTodosLosClientes();
        List<DocumentoDTO> documentos = documentoControlador.obtenerTodosLosDocumentos();

        System.out.println("Clientes disponibles:");
        for (int i = 0; i < clientes.size(); i++) {
            ClienteDTO cliente = clientes.get(i);
            System.out.println((i + 1) + ". " + cliente.getNombre());
        }

        System.out.print("Seleccione el número del cliente: ");
        int clienteIndex = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        if (clienteIndex < 1 || clienteIndex > clientes.size()) {
            System.out.println("Selección de cliente inválida.");
            return;
        }

        ClienteDTO clienteSeleccionado = clientes.get(clienteIndex - 1);

        System.out.println("Documentos disponibles:");
        for (int i = 0; i < documentos.size(); i++) {
            DocumentoDTO documento = documentos.get(i);
            System.out.println((i + 1) + ". " + documento.getTitulo());
        }

        System.out.print("Seleccione el número del documento: ");
        int documentoIndex = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        if (documentoIndex < 1 || documentoIndex > documentos.size()) {
            System.out.println("Selección de documento inválida.");
            return;
        }

        DocumentoDTO documentoSeleccionado = documentos.get(documentoIndex - 1);

        clienteControlador.asignarDocumento(clienteSeleccionado.getId(), documentoSeleccionado.getId());
        System.out.println("Documento asignado al cliente con éxito.");
    }

    private void listarClientes() {
        System.out.println("\n--- Listar Clientes ---");
        
        List<ClienteDTO> clientes = clienteControlador.obtenerTodosLosClientes();
        System.out.printf("%-5s %-30s %-30s\n", "ID", "Nombre", "Email");
        for (ClienteDTO cliente : clientes) {
            System.out.printf("%-5d %-30s %-30s\n", cliente.getId(), cliente.getNombre(), cliente.getEmail());
        }
    }

    private void listarDocumentosDeCliente() {
        System.out.println("\n--- Listar Documentos de Cliente ---");

        List<ClienteDTO> clientes = clienteControlador.obtenerTodosLosClientes();
        System.out.println("Clientes disponibles:");
        for (int i = 0; i < clientes.size(); i++) {
            ClienteDTO cliente = clientes.get(i);
            System.out.println((i + 1) + ". " + cliente.getNombre());
        }
        System.out.print("Seleccione el número del cliente: ");
        int clienteIndex = scanner.nextInt();
        scanner.nextLine();
        if (clienteIndex < 1 || clienteIndex > clientes.size()) {
            System.out.println("Selección de cliente inválida.");
            return;
        }
        ClienteDTO clienteSeleccionado = clientes.get(clienteIndex - 1);
        List<DocumentoDTO> documentos = clienteControlador.obtenerDocumentosDelCliente(clienteSeleccionado.getId());

        // Mostrar los documentos
        System.out.printf("%-5s %-20s %-30s\n", "ID", "Título", "Contenido");
        for (DocumentoDTO documento : documentos) {
            System.out.printf("%-5d %-20s %-30s\n", documento.getId(), documento.getTitulo(), documento.getContenido());
        }
    }
}