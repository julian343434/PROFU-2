/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.componentescapas.Presentacion.VistaEscritorio;

import com.mycompany.componentescapas.LogicaNegocio.Controlador.*;
import com.mycompany.componentescapas.Utilidades.DTO.*;
import com.mycompany.componentescapas.Utilidades.FabricaObjetos.Factory;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author PYKE
 */
public class VistaEscritorio extends JFrame {

    private CursoControlador cursoControlador;
    private EstudianteControlador estudianteControlador;
    private ProgramaControlador programaControlador;
    private DocumentosControlador clienteControlador;
    private DocumentosControlador documentoControlador; 
    
    public VistaEscritorio(Factory factory) {
        this.cursoControlador = factory.crearCursoControlador();
        this.estudianteControlador = factory.crearEstudianteControlador();
        this.programaControlador = factory.crearProgramaControlador();
        this.clienteControlador = factory.crearDocumentosControlador();
        this.documentoControlador = factory.crearDocumentosControlador();
        
        initUI();
    }
    
    private void initUI() {
        setTitle("Gestión de Cursos y Estudiantes");
        setSize(620, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        
        // Panel para el primer grupo de botones
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        
        // Botón para crear un curso
        JButton btnCrearCurso = new JButton("Crear Curso");
        btnCrearCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean datosValidos = false; // Variable de control para mantener el bucle

                JPanel panel = new JPanel(new GridLayout(3, 2));

                JLabel lblNombreCurso = new JLabel("Nombre del curso:");
                JTextField txtNombreCurso = new JTextField(10);

                JLabel lblSemestre = new JLabel("Semestre:");
                JTextField txtSemestre = new JTextField(5);

                JLabel lblIdPrograma = new JLabel("ID del programa:");
                JTextField txtIdPrograma = new JTextField(5);

                panel.add(lblNombreCurso);
                panel.add(txtNombreCurso);
                panel.add(lblSemestre);
                panel.add(txtSemestre);
                panel.add(lblIdPrograma);
                panel.add(txtIdPrograma);

                while (!datosValidos) {
                    int result = JOptionPane.showConfirmDialog(null, panel, 
                            "Crear nuevo curso", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.CANCEL_OPTION) {
                        break;
                    }

                    // Validar que los campos no estén vacíos
                    if (txtNombreCurso.getText().trim().isEmpty() || 
                        txtSemestre.getText().trim().isEmpty() || 
                        txtIdPrograma.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {
                            // Validar que los campos numéricos sean correctos
                            String nombreCurso = txtNombreCurso.getText();
                            int semestre = Integer.parseInt(txtSemestre.getText());
                            int idPrograma = Integer.parseInt(txtIdPrograma.getText());

                            CursoDTO cursoDTO = new CursoDTO(nombreCurso, semestre, idPrograma);
                            cursoControlador.crearCurso(cursoDTO);

                            JOptionPane.showMessageDialog(null, "Curso creado con éxito.");
                            datosValidos = true;
                        } catch (NumberFormatException ex) {
                            // Mostrar error si los campos numéricos no son válidos
                            JOptionPane.showMessageDialog(null, "El semestre y el ID del programa deben ser números enteros.", "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (SQLException ex) {
                            Logger.getLogger(VistaEscritorio.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, "Ocurrió un error al crear el curso.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        panel1.add(btnCrearCurso);
        
        // Botón para crear un Estudiante
        JButton btnCrearEstudiante = new JButton("Crear Estudiante");
        btnCrearEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean datosValidos = false;

                JPanel panel = new JPanel(new GridLayout(3, 2));

                JLabel lblNombresEstudiante = new JLabel("Nombres del Estudiante:");
                JTextField txtNombresEstudiante = new JTextField(20);

                JLabel lblApellidosEstudiante = new JLabel("Apellidos del Estudiante:");
                JTextField txtApellidosEstudiante = new JTextField(20);

                panel.add(lblNombresEstudiante);
                panel.add(txtNombresEstudiante);
                panel.add(lblApellidosEstudiante);
                panel.add(txtApellidosEstudiante);

                while (!datosValidos) {
                    int result = JOptionPane.showConfirmDialog(null, panel, 
                            "Crear nuevo Estudiante", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.CANCEL_OPTION) {
                        break;
                    }

                    // Validar que los campos no estén vacíos
                    if (txtNombresEstudiante.getText().trim().isEmpty() || 
                        txtApellidosEstudiante.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {
                            String nombresEstudiante = txtNombresEstudiante.getText();
                            String apellidosEstudiante = txtApellidosEstudiante.getText();

                            EstudianteDTO estudianteDTO = new EstudianteDTO(nombresEstudiante, apellidosEstudiante);
                            estudianteControlador.crearEstudiante(estudianteDTO);

                            JOptionPane.showMessageDialog(null, "Estudiante creado con éxito.");
                            datosValidos = true;
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "", "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (SQLException ex) {
                            Logger.getLogger(VistaEscritorio.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, "Ocurrió un error al crear el estudiante.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        panel1.add(btnCrearEstudiante);
        
        // Botón para listar cursos en una tabla
        JButton btnListarCursos = new JButton("Listar Cursos");
        btnListarCursos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<CursoDTO> cursos = cursoControlador.obtenerTodosLosCursos();

                    String[] columnNames = {"ID", "Nombre", "Semestre", "Programa"};

                    Object[][] data = new Object[cursos.size()][4]; // 4 columnas: ID, Nombre, Semestre, ID Programa

                    for (int i = 0; i < cursos.size(); i++) {
                        CursoDTO curso = cursos.get(i);
                        data[i][0] = curso.getId(); // Asegúrate de tener un getter para el ID
                        data[i][1] = curso.getNombre();
                        data[i][2] = curso.getSemestre();

                        ProgramaDTO programa = programaControlador.obtenerPrograma(curso.getProgramaId());

                        data[i][3] = programa.getNombre();
                    }

                    JTable table = new JTable(data, columnNames);
                    JScrollPane scrollPane = new JScrollPane(table);

                    JOptionPane.showMessageDialog(null, scrollPane, "Listado de Cursos", JOptionPane.PLAIN_MESSAGE);

                } catch (SQLException ex) {
                    Logger.getLogger(VistaEscritorio.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al obtener los cursos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel1.add(btnListarCursos);
        
        JButton btnListarEstudiantes = new JButton("Listar Estudiantes");
        btnListarEstudiantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<EstudianteDTO> estudiantes = estudianteControlador.obtenerTodosLosEstudiantes();

                    String[] columnNames = {"ID", "Nombres", "Apellidos"};

                    Object[][] data = new Object[estudiantes.size()][4]; // 4 columnas: ID, Nombre, Apellido, Correo

                    for (int i = 0; i < estudiantes.size(); i++) {
                        EstudianteDTO estudiante = estudiantes.get(i);
                        data[i][0] = estudiante.getId(); // Asegúrate de tener un getter para el ID
                        data[i][1] = estudiante.getNombres();
                        data[i][2] = estudiante.getApellidos();
                    }

                    JTable table = new JTable(data, columnNames);
                    JScrollPane scrollPane = new JScrollPane(table);

                    JOptionPane.showMessageDialog(null, scrollPane, "Listado de Estudiantes", JOptionPane.PLAIN_MESSAGE);

                } catch (SQLException ex) {
                    Logger.getLogger(VistaEscritorio.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al obtener los estudiantes.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel1.add(btnListarEstudiantes);
        
        add(panel1);
        
        // Panel para el primer grupo de botones
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        
       // Botón para listar los estudiantes de un curso específico
        JButton btnListarEstudiantesDeCurso = new JButton("Listar Estudiantes de Curso");
        btnListarEstudiantesDeCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener la lista de cursos para poblar el JComboBox
                    List<CursoDTO> cursos = cursoControlador.obtenerTodosLosCursos(); // Método que devuelve todos los cursos

                    // Crear el JComboBox con los nombres de los cursos
                    JComboBox<CursoDTO> comboBoxCursos = new JComboBox<>();
                    for (CursoDTO curso : cursos) {
                        comboBoxCursos.addItem(curso); // Añadir el curso al JComboBox
                    }

                    // Mostrar el JComboBox en un diálogo
                    int option = JOptionPane.showConfirmDialog(null, comboBoxCursos, "Seleccione un curso", JOptionPane.OK_CANCEL_OPTION);

                    // Si se selecciona OK, proceder con la consulta
                    if (option == JOptionPane.OK_OPTION) {
                        CursoDTO cursoSeleccionado = (CursoDTO) comboBoxCursos.getSelectedItem();

                        if (cursoSeleccionado != null) {
                            // Obtener la lista de estudiantes del curso seleccionado
                            List<EstudianteDTO> estudiantes = cursoControlador.obtenerEstudiantesDelCurso(cursoSeleccionado.getId());

                            // Definir los nombres de las columnas
                            String[] columnNames = {"ID", "Nombres", "Apellidos"};

                            // Crear el modelo de la tabla
                            Object[][] data = new Object[estudiantes.size()][3]; // 3 columnas: ID, Nombres, Apellidos

                            // Rellenar los datos de la tabla
                            for (int i = 0; i < estudiantes.size(); i++) {
                                EstudianteDTO estudiante = estudiantes.get(i);
                                data[i][0] = estudiante.getId();
                                data[i][1] = estudiante.getNombres();
                                data[i][2] = estudiante.getApellidos();
                            }

                            // Crear un JTable con los datos
                            JTable table = new JTable(data, columnNames);
                            JScrollPane scrollPane = new JScrollPane(table);

                            // Mostrar la tabla en un cuadro de diálogo
                            JOptionPane.showMessageDialog(null, scrollPane, "Estudiantes del curso: " + cursoSeleccionado.getNombre(), JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEscritorio.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al obtener los estudiantes del curso.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel2.add(btnListarEstudiantesDeCurso);

        // Botón para listar los cursos de un estudiante específico
        JButton btnListarCursosDeEstudiante = new JButton("Listar Cursos de Estudiante");
        btnListarCursosDeEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener la lista de estudiantes para poblar el JComboBox
                    List<EstudianteDTO> estudiantes = estudianteControlador.obtenerTodosLosEstudiantes(); // Método que devuelve todos los estudiantes

                    // Crear el JComboBox con los nombres de los estudiantes
                    JComboBox<EstudianteDTO> comboBoxEstudiantes = new JComboBox<>();
                    for (EstudianteDTO estudiante : estudiantes) {
                        comboBoxEstudiantes.addItem(estudiante); // Añadir el estudiante al JComboBox
                    }

                    // Mostrar el JComboBox en un diálogo
                    int option = JOptionPane.showConfirmDialog(null, comboBoxEstudiantes, "Seleccione un estudiante", JOptionPane.OK_CANCEL_OPTION);

                    // Si se selecciona OK, proceder con la consulta
                    if (option == JOptionPane.OK_OPTION) {
                        EstudianteDTO estudianteSeleccionado = (EstudianteDTO) comboBoxEstudiantes.getSelectedItem();

                        if (estudianteSeleccionado != null) {
                            // Obtener la lista de cursos del estudiante seleccionado
                            List<CursoDTO> cursos = estudianteControlador.obtenerCursosDelEstudiante(estudianteSeleccionado.getId());

                            // Definir los nombres de las columnas
                            String[] columnNames = {"ID", "Nombre", "Semestre", "Programa"};

                            // Crear el modelo de la tabla
                            Object[][] data = new Object[cursos.size()][4]; // 4 columnas: ID, Nombre, Semestre, Programa

                            // Rellenar los datos de la tabla
                            for (int i = 0; i < cursos.size(); i++) {
                                CursoDTO curso = cursos.get(i);
                                data[i][0] = curso.getId();
                                data[i][1] = curso.getNombre();
                                data[i][2] = curso.getSemestre();

                                ProgramaDTO programa = programaControlador.obtenerPrograma(curso.getProgramaId());
                                data[i][3] = programa.getNombre();
                            }

                            // Crear un JTable con los datos
                            JTable table = new JTable(data, columnNames);
                            JScrollPane scrollPane = new JScrollPane(table);

                            // Mostrar la tabla en un cuadro de diálogo
                            JOptionPane.showMessageDialog(null, scrollPane, "Cursos del estudiante: " + estudianteSeleccionado.getNombres() + " " + estudianteSeleccionado.getApellidos(), JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEscritorio.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al obtener los cursos del estudiante.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel2.add(btnListarCursosDeEstudiante);
        
        // Botón para inscribir un estudiante en un curso
        JButton btnInscribirEstudianteEnCurso = new JButton("Inscribir Estudiante en Curso");
        btnInscribirEstudianteEnCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<EstudianteDTO> estudiantes = estudianteControlador.obtenerTodosLosEstudiantes(); // Método que devuelve todos los estudiantes

                    JComboBox<EstudianteDTO> comboBoxEstudiantes = new JComboBox<>();
                    for (EstudianteDTO estudiante : estudiantes) {
                        comboBoxEstudiantes.addItem(estudiante);
                    }

                    List<CursoDTO> cursos = cursoControlador.obtenerTodosLosCursos();

                    JComboBox<CursoDTO> comboBoxCursos = new JComboBox<>();
                    for (CursoDTO curso : cursos) {
                        comboBoxCursos.addItem(curso);
                    }

                    JPanel panel = new JPanel(new GridLayout(2, 2));
                    panel.add(new JLabel("Seleccione un estudiante:"));
                    panel.add(comboBoxEstudiantes);
                    panel.add(new JLabel("Seleccione un curso:"));
                    panel.add(comboBoxCursos);

                    int option = JOptionPane.showConfirmDialog(null, panel, "Inscribir Estudiante en Curso", JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.OK_OPTION) {
                        EstudianteDTO estudianteSeleccionado = (EstudianteDTO) comboBoxEstudiantes.getSelectedItem();
                        CursoDTO cursoSeleccionado = (CursoDTO) comboBoxCursos.getSelectedItem();

                        if (estudianteSeleccionado != null && cursoSeleccionado != null) {
                            estudianteControlador.inscribirCurso(estudianteSeleccionado.getId(), cursoSeleccionado.getId());
                            JOptionPane.showMessageDialog(null, "Estudiante inscrito en el curso con éxito.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe seleccionar tanto un estudiante como un curso.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(VistaEscritorio.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al inscribir el estudiante en el curso.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel2.add(btnInscribirEstudianteEnCurso);
        
        add(panel2);
        
        // Espacio entre grupos de botones
        add(Box.createRigidArea(new Dimension(0, 100))); // Espacio vertical de 30 píxeles

        // Panel para el segundo grupo de botones
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        
        // Botón para crear un cliente
        JButton btnCrearCliente = new JButton("Crear Cliente");
        btnCrearCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean datosValidos = false;

                JPanel panel = new JPanel(new GridLayout(2, 2));

                JLabel lblNombreCliente = new JLabel("Nombre del Cliente:");
                JTextField txtNombreCliente = new JTextField(20);

                JLabel lblDocumentoCliente = new JLabel("Documento:");
                JTextField txtDocumentoCliente = new JTextField(15);

                panel.add(lblNombreCliente);
                panel.add(txtNombreCliente);
                panel.add(lblDocumentoCliente);
                panel.add(txtDocumentoCliente);

                while (!datosValidos) {
                    int result = JOptionPane.showConfirmDialog(null, panel, 
                            "Crear nuevo cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.CANCEL_OPTION) {
                        break;
                    }

                    if (txtNombreCliente.getText().trim().isEmpty() || 
                        txtDocumentoCliente.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String nombreCliente = txtNombreCliente.getText();
                        String emailCliente = txtDocumentoCliente.getText();
                        ClienteDTO clienteDTO = new ClienteDTO(nombreCliente, emailCliente);
                        clienteControlador.crearCliente(clienteDTO);
                        JOptionPane.showMessageDialog(null, "Cliente creado con éxito.");
                        datosValidos = true;
                    }
                }
            }
        });
        panel3.add(btnCrearCliente);
        
        // Botón para crear un nuevo documento
        JButton btnCrearDocumento = new JButton("Crear Documento");
        btnCrearDocumento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear los campos del formulario
                JTextField tfTitulo = new JTextField(20);
                JTextArea taContenido = new JTextArea(5, 20);
                taContenido.setLineWrap(true);
                taContenido.setWrapStyleWord(true);
                JScrollPane scrollPaneContenido = new JScrollPane(taContenido);

                // Panel del formulario
                JPanel panel = new JPanel(new GridLayout(2, 2));
                panel.add(new JLabel("Título:"));
                panel.add(tfTitulo);
                panel.add(new JLabel("Contenido:"));
                panel.add(scrollPaneContenido);

                int option = JOptionPane.showConfirmDialog(null, panel, "Crear Nuevo Documento", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    // Obtener los valores del formulario
                    String titulo = tfTitulo.getText();
                    String contenido = taContenido.getText();

                    // Validar los campos
                    if (titulo.isEmpty() || contenido.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos deben ser completados.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // Crear el documento
                    DocumentoDTO nuevoDocumento = new DocumentoDTO();
                    nuevoDocumento.setTitulo(titulo);
                    nuevoDocumento.setContenido(contenido);

                    // Llamada al controlador para guardar el nuevo documento
                    documentoControlador.crearDocumento(nuevoDocumento);
                }
            }
        });
        panel3.add(btnCrearDocumento);
        
        add(panel3);

        // Panel para el segundo grupo de botones
        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());

        // Botón para asignar un documento a un cliente
        JButton btnAsignarDocumento = new JButton("Asignar Documento a Cliente");
        btnAsignarDocumento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ClienteDTO> clientes = clienteControlador.obtenerTodosLosClientes();
                List<DocumentoDTO> documentos = documentoControlador.obtenerTodosLosDocumentos();
                JComboBox<ClienteDTO> comboBoxClientes = new JComboBox<>();
                for (ClienteDTO cliente : clientes) {
                    comboBoxClientes.addItem(cliente);
                }
                JComboBox<DocumentoDTO> comboBoxDocumentos = new JComboBox<>();
                for (DocumentoDTO documento : documentos) {
                    comboBoxDocumentos.addItem(documento);
                }
                JPanel panel = new JPanel(new GridLayout(2, 2));
                panel.add(new JLabel("Seleccione un cliente:"));
                panel.add(comboBoxClientes);
                panel.add(new JLabel("Seleccione un documento:"));
                panel.add(comboBoxDocumentos);
                int option = JOptionPane.showConfirmDialog(null, panel, "Asignar Documento a Cliente", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    ClienteDTO clienteSeleccionado = (ClienteDTO) comboBoxClientes.getSelectedItem();
                    DocumentoDTO documentoSeleccionado = (DocumentoDTO) comboBoxDocumentos.getSelectedItem();
                    
                    if (clienteSeleccionado != null && documentoSeleccionado != null) {
                        clienteControlador.asignarDocumento(clienteSeleccionado.getId(), documentoSeleccionado.getId());
                        JOptionPane.showMessageDialog(null, "Documento asignado al cliente con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar tanto un cliente como un documento.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        panel4.add(btnAsignarDocumento);

        // Botón para listar clientes
        JButton btnListarClientes = new JButton("Listar Clientes");
        btnListarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ClienteDTO> clientes = clienteControlador.obtenerTodosLosClientes();
                String[] columnNames = {"ID", "Nombre", "Email"};
                Object[][] data = new Object[clientes.size()][3];
                for (int i = 0; i < clientes.size(); i++) {
                    ClienteDTO cliente = clientes.get(i);
                    data[i][0] = cliente.getId();
                    data[i][1] = cliente.getNombre();
                    data[i][2] = cliente.getEmail();
                }
                JTable table = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(table);
                JOptionPane.showMessageDialog(null, scrollPane, "Listado de Clientes", JOptionPane.PLAIN_MESSAGE);
            }
        });
        panel4.add(btnListarClientes);

        // Botón para listar documentos de un cliente
        JButton btnListarDocumentosDeCliente = new JButton("Listar Documentos de Cliente");
        btnListarDocumentosDeCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ClienteDTO> clientes = clienteControlador.obtenerTodosLosClientes();
                JComboBox<ClienteDTO> comboBoxClientes = new JComboBox<>();
                for (ClienteDTO cliente : clientes) {
                    comboBoxClientes.addItem(cliente);
                }
                int option = JOptionPane.showConfirmDialog(null, comboBoxClientes, "Seleccione un cliente", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    ClienteDTO clienteSeleccionado = (ClienteDTO) comboBoxClientes.getSelectedItem();
                    
                    if (clienteSeleccionado != null) {
                        List<DocumentoDTO> documentos = clienteControlador.obtenerDocumentosDelCliente(clienteSeleccionado.getId());
                        
                        String[] columnNames = {"ID", "Contenido"};
                        
                        Object[][] data = new Object[documentos.size()][3];
                        
                        for (int i = 0; i < documentos.size(); i++) {
                            DocumentoDTO documento = documentos.get(i);
                            data[i][0] = documento.getId();
                            data[i][1] = documento.getContenido();
                        }
                        
                        JTable table = new JTable(data, columnNames);
                        JScrollPane scrollPane = new JScrollPane(table);
                        
                        JOptionPane.showMessageDialog(null, scrollPane, "Documentos del cliente: " + clienteSeleccionado.getNombre(), JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });
        panel4.add(btnListarDocumentosDeCliente);
        
        add(panel4);

        setVisible(true);
    }
    
    public static void main(String[] args) {
        Factory factory = Factory.getInstance();
        new VistaEscritorio(factory);
    }
}
