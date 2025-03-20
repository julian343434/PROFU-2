package GUI;

import appMain.PluginManager;
import dto.ImageDTO;
import dto.PluginDTO;
import dto.MessageDTO;

import javax.swing.*;
import java.awt.*;

public class MicrokernelGUI extends JFrame {
    private PluginManager pluginManager;

    public MicrokernelGUI() {
        setTitle("Microkernel Image Processor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Crear DTOs compartidos
        ImageDTO imageDTO = new ImageDTO(null);
        pluginManager = new PluginManager();
        PluginDTO pluginDTO = new PluginDTO(pluginManager.getLoadedPlugins());
        MessageDTO messageDTO = new MessageDTO();

        // Crear secciones
        ImageSection imageSection = new ImageSection(imageDTO);
        ComponentSection componentSection = new ComponentSection(pluginDTO);
        ControlSection controlSection = new ControlSection(imageDTO, imageSection, pluginManager, componentSection);
        MessageSection messageSection = new MessageSection(messageDTO);
        ExecuteFilterSection executeFilterSection = new ExecuteFilterSection(pluginDTO, messageDTO, imageDTO, imageSection, messageSection);

        // Configuración del layout
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Zona de botones de carga (superior izquierda)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.3;
        gbc.weighty = 0.1;
        add(controlSection, gbc);

        // Sección de filtros (debajo de los botones de carga)
        gbc.gridy = 1;
        gbc.weighty = 0.3;
        add(componentSection, gbc);

        // Botón de ejecutar filtro (debajo de la lista de filtros)
        gbc.gridy = 2;
        gbc.weighty = 0.1;
        add(executeFilterSection, gbc);

        // Zona de mensajes (inferior izquierda, pequeño espacio)
        gbc.gridy = 3;
        gbc.weighty = 0.2;
        add(messageSection, gbc);

        // Sección de imágenes (ocupa mitad derecha de arriba a abajo)
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 4;
        gbc.weightx = 0.7;
        gbc.weighty = 1.0;
        add(imageSection, gbc);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MicrokernelGUI::new);
    }
}
