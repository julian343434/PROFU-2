package com.core;

import javax.swing.*;


import java.io.File;

public class MicroKernel {
    private final PluginManager pluginManager;

    public MicroKernel() {
        this.pluginManager = new PluginManager();
    }

    public void start() {
        System.out.println("Bienvenido al sistema MicroKernel");

        while (true) {
            String[] options = {"Cargar Plugin", "Procesar Imagen", "Salir"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "MicroKernel",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0 -> seleccionarYcargarPlugin();
                case 1 -> procesarImagen();
                case 2 -> {
                    System.out.println("Saliendo del sistema MicroKernel.");
                    System.exit(0);
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void seleccionarYcargarPlugin() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona un Plugin (JAR)");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos JAR", "jar"));

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String jarPath = selectedFile.getAbsolutePath();

            String className = JOptionPane.showInputDialog("Ingrese el nombre de la clase del plugin:");
            if (className != null && !className.isEmpty()) {
                pluginManager.loadPlugin(jarPath, className);
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de clase válido.");
            }
        }
    }

    private void procesarImagen() {
        PluginContract plugin = pluginManager.getLoadedPlugin();
        if (plugin != null) {
            String result = plugin.processImage("imagen.jpg");
            JOptionPane.showMessageDialog(null, "Resultado del procesamiento: " + result);
        } else {
            JOptionPane.showMessageDialog(null, "Error: No hay ningún plugin cargado.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MicroKernel core = new MicroKernel();
            core.start();
        });
    }
}
