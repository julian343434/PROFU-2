package contractPlugins;

/**
 * Interfaz que define la estructura de un plugin de procesamiento de imágenes.
 */
public interface PluginContract {
    String getPluginName();  // Nombre del plugin
    String processImage(String imagePath);  // Procesar imagen
    String getOutputDescription();  // Descripción de salida
}
