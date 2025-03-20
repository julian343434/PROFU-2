package GUI;

import dto.PluginDTO;
import contratos.PluginContract;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ComponentSection extends JPanel {
    private PluginDTO pluginDTO;
    private List<JRadioButton> pluginRadioButtons;
    private ButtonGroup buttonGroup;

    public ComponentSection(PluginDTO pluginDTO) {
        this.pluginDTO = pluginDTO;
        this.pluginRadioButtons = new ArrayList<>();
        this.buttonGroup = new ButtonGroup();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder("Plugins Cargados"));

        actualizarListaPlugins();
    }

    public void actualizarListaPlugins() {
        removeAll();
        pluginRadioButtons.clear();
        buttonGroup = new ButtonGroup();

        List<PluginContract> plugins = pluginDTO.getLoadedPlugins();
        if (!plugins.isEmpty()) {
            for (PluginContract plugin : plugins) {
                JRadioButton radioButton = new JRadioButton(plugin.getPluginName());
                radioButton.addActionListener(e -> pluginDTO.setSelectedPlugin(plugin)); // Actualiza el DTO
                pluginRadioButtons.add(radioButton);
                buttonGroup.add(radioButton);
                add(radioButton);
            }
        } else {
            add(new JLabel("No hay plugins cargados."));
        }

        revalidate();
        repaint();
    }
}
