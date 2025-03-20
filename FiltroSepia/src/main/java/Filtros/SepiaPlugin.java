package Filtros;

import contratos.PluginContract;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class SepiaPlugin implements PluginContract {

    @Override
    public String getPluginName() {
        return "Sepia Plugin";
    }

    @Override
    public String processImage(String imagePath) {
        try {
            File imgFile = new File(imagePath);
            BufferedImage bufferedImage = ImageIO.read(imgFile);

            BufferedImage sepiaImage = applySepiaFilter(bufferedImage);

            File output = new File("sepia_" + imgFile.getName());
            ImageIO.write(sepiaImage, "jpg", output);

            return "Imagen procesada y guardada como: " + output.getAbsolutePath();
        } catch (Exception e) {
            return "Error al procesar la imagen: " + e.getMessage();
        }
    }

    @Override
    public String getOutputDescription() {
        return "Imagen con filtro sepia aplicado.";
    }

    private BufferedImage applySepiaFilter(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                int tr = (int)(0.393 * r + 0.769 * g + 0.189 * b);
                int tg = (int)(0.349 * r + 0.686 * g + 0.168 * b);
                int tb = (int)(0.272 * r + 0.534 * g + 0.131 * b);

                if (tr > 255) {
                    r = 255;
                } else {
                    r = tr;
                }

                if (tg > 255) {
                    g = 255;
                } else {
                    g = tg;
                }

                if (tb > 255) {
                    b = 255;
                } else {
                    b = tb;
                }

                p = (a << 24) | (r << 16) | (g << 8) | b;

                img.setRGB(x, y, p);
            }
        }
        return img;
    }
}