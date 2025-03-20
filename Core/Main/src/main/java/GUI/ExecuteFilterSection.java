package GUI;

import dto.ImageDTO;
import dto.MessageDTO;
import dto.PluginDTO;
import contratos.PluginContract;

import javax.swing.*;
import java.awt.*;

public class ExecuteFilterSection extends JPanel {
    private PluginDTO pluginDTO;
    private MessageDTO messageDTO;
    private ImageDTO imageDTO;
    private ImageSection imageSection;
    private MessageSection messageSection; // ✅ Agregar referencia a MessageSection

    public ExecuteFilterSection(PluginDTO pluginDTO, MessageDTO messageDTO, ImageDTO imageDTO, ImageSection imageSection, MessageSection messageSection) {
        this.pluginDTO = pluginDTO;
        this.messageDTO = messageDTO;
        this.imageDTO = imageDTO;
        this.imageSection = imageSection;
        this.messageSection = messageSection; // ✅ Guardar referencia

        setLayout(new FlowLayout());

        JButton executeButton = new JButton("Ejecutar Filtro");
        executeButton.addActionListener(e -> {
            System.out.println("[DEBUG] Botón 'Ejecutar Filtro' presionado.");
            ejecutarFiltro();
        });

        add(executeButton);
    }

    private void ejecutarFiltro() {
        System.out.println("[DEBUG] Iniciando ejecución del filtro...");

        PluginContract plugin = pluginDTO.getSelectedPlugin();
        if (plugin == null) {
            System.out.println("[ERROR] No se ha seleccionado un plugin.");
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un plugin antes de ejecutar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        byte[] imageData = imageDTO.getOriginalImage();
        if (imageData == null) {
            System.out.println("[ERROR] No hay imagen cargada.");
            JOptionPane.showMessageDialog(this, "No hay imagen cargada para procesar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            System.out.println("[DEBUG] Aplicando filtro...");
            byte[] processedImage = plugin.processImage(imageData);

            // ✅ Actualizar ImageDTO
            imageDTO.setProcessedImage(processedImage);
            imageDTO.setFilterName(plugin.getClass().getSimpleName());
            imageDTO.setStatusMessage("Filtro aplicado correctamente");

            // ✅ Notificar a ImageSection para que se actualice
            imageSection.actualizarImagen();
            System.out.println("[DEBUG] Se actualizó la imagen en ImageSection.");

            // ✅ Actualizar MessageDTO y MessageSection
            String mensajeFiltro = "Filtro aplicado: " + plugin.getOutputDescription();
            messageDTO.setMessage(mensajeFiltro);
            System.out.println("[DEBUG] Mensaje actualizado en MessageDTO: " + mensajeFiltro);

            messageSection.actualizarMensaje(); // ✅ Forzar actualización en la UI
            System.out.println("[DEBUG] Se actualizó el mensaje en MessageSection.");

        } catch (Exception ex) {
            System.out.println("[ERROR] Error al procesar la imagen: " + ex.getMessage());
            imageDTO.setStatusMessage("Error al procesar la imagen.");
            messageDTO.setMessage("Error: " + ex.getMessage());

            messageSection.actualizarMensaje(); // ✅ También actualizar el mensaje en la UI
            JOptionPane.showMessageDialog(this, "Error al procesar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
