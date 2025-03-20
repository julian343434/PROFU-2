package GUI;

import dto.ImageDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageSection extends JPanel {
    private JLabel originalImageLabel;
    private JLabel processedImageLabel;
    private ImageDTO imageDTO;

    public ImageSection(ImageDTO imageDTO) {
        this.imageDTO = imageDTO;

        setLayout(new GridLayout(2, 1, 10, 10));  // 2 filas, 1 columna
        setBorder(BorderFactory.createTitledBorder("Visualización de Imágenes"));

        // Panel para la imagen original
        originalImageLabel = new JLabel("Imagen Original", SwingConstants.CENTER);
        originalImageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        originalImageLabel.setOpaque(true);
        originalImageLabel.setBackground(Color.LIGHT_GRAY);

        // Panel para la imagen procesada
        processedImageLabel = new JLabel("Imagen Procesada", SwingConstants.CENTER);
        processedImageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        processedImageLabel.setOpaque(true);
        processedImageLabel.setBackground(Color.LIGHT_GRAY);

        add(originalImageLabel);
        add(processedImageLabel);
    }
    public void actualizarImagen() {
        System.out.println("[DEBUG] Actualizando imágenes...");

        mostrarImagen(originalImageLabel, imageDTO.getOriginalImage(), "Original");
        mostrarImagen(processedImageLabel, imageDTO.getProcessedImage(), "Procesada");

        // 🔄 Forzar actualización del panel
        revalidate();
        repaint();
    }


    private void mostrarImagen(JLabel label, byte[] imageBytes, String tipoImagen) {
        if (imageBytes != null) {
            System.out.println("[DEBUG] Cargando imagen " + tipoImagen + " - Tamaño en bytes: " + imageBytes.length);
            try {
                BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imageBytes));
                if (bufferedImage != null) {
                    System.out.println("[DEBUG] Imagen " + tipoImagen + " cargada correctamente. Dimensiones: " +
                            bufferedImage.getWidth() + "x" + bufferedImage.getHeight());

                    Image scaledImage = bufferedImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(scaledImage));
                    label.setText("");
                } else {
                    System.out.println("[ERROR] La imagen " + tipoImagen + " no se pudo decodificar correctamente.");
                }
            } catch (IOException e) {
                System.out.println("[ERROR] Error al mostrar la imagen " + tipoImagen + ": " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Error al mostrar la imagen " + tipoImagen, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("[WARN] No hay datos de imagen disponibles para la imagen " + tipoImagen);
            label.setIcon(null);
            label.setText("Sin imagen");
        }
    }
}
