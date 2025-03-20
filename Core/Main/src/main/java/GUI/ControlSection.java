package GUI;

import appMain.PluginManager;
import dto.ImageDTO;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;

public class ControlSection extends JPanel {
    private JButton loadImageButton;
    private JButton loadPluginButton;
    private ImageDTO imageDTO;
    private ImageSection imageSection;
    private PluginManager pluginManager;
    private ComponentSection componentSection;

    public ControlSection(ImageDTO imageDTO, ImageSection imageSection, PluginManager pluginManager, ComponentSection componentSection) {
        this.imageDTO = imageDTO;
        this.imageSection = imageSection;
        this.pluginManager = pluginManager;
        this.componentSection = componentSection;

        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder("Control"));

        // Botón para cargar imagen
        loadImageButton = new JButton("Cargar Imagen");
        loadImageButton.addActionListener(e -> {
            System.out.println("[DEBUG] Botón 'Cargar Imagen' presionado.");
            cargarImagen();
        });

        // Botón para cargar plugins
        loadPluginButton = new JButton("Cargar Plugin");
        loadPluginButton.addActionListener(e -> {
            System.out.println("[DEBUG] Botón 'Cargar Plugin' presionado.");
            cargarPlugin();
        });

        add(loadImageButton);
        add(loadPluginButton);
    }

    private void cargarImagen() {
        System.out.println("[DEBUG] Abriendo selector de archivos para cargar imagen.");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("[DEBUG] Imagen seleccionada: " + selectedFile.getAbsolutePath());

            try {
                byte[] imageBytes = Files.readAllBytes(selectedFile.toPath());
                System.out.println("[DEBUG] Imagen leída correctamente, tamaño: " + imageBytes.length + " bytes.");
                imageDTO.setOriginalImage(imageBytes);

                System.out.println("[DEBUG] Actualizando sección de imagen.");
                imageSection.actualizarImagen();
            } catch (Exception ex) {
                System.out.println("[ERROR] No se pudo cargar la imagen: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error al cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } else {
            System.out.println("[DEBUG] Selección de imagen cancelada.");
        }
    }

    private void cargarPlugin() {
        System.out.println("[DEBUG] Abriendo selector de archivos para cargar plugin.");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String jarPath = selectedFile.getAbsolutePath();
            System.out.println("[DEBUG] Plugin seleccionado: " + jarPath);

            try {
                System.out.println("[DEBUG] Intentando cargar el plugin 'Filtros.Main'.");
                pluginManager.loadPlugin(jarPath, "Filtros.Main");
                System.out.println("[DEBUG] Plugin cargado exitosamente.");

                System.out.println("[DEBUG] Actualizando lista de plugins en la GUI.");
                componentSection.actualizarListaPlugins();
            } catch (Exception ex) {
                System.out.println("[ERROR] Error al cargar el plugin: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error al cargar el plugin", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } else {
            System.out.println("[DEBUG] Selección de plugin cancelada.");
        }
    }
}
