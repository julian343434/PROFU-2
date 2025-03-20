package contratos;

/**
 * Interfaz para plugins de procesamiento de imágenes en una arquitectura microkernel.
 */
public interface PluginContract {
    /**
     * Obtiene el nombre del plugin.
     * @return Nombre del plugin.
     */
    String getPluginName();

    /**
     * Procesa una imagen recibida en bytes y devuelve la imagen procesada en bytes.
     * @param image Datos de la imagen en formato byte[].
     * @return Imagen procesada en formato byte[].
     * @throws Exception En caso de error durante el procesamiento.
     */
    byte[] processImage(byte[] image) throws Exception;

    /**
     * Obtiene una descripción de la salida del procesamiento.
     * @return Descripción del resultado del procesamiento.
     */
    String getOutputDescription();

    /**
     * Devuelve un mensaje con información sobre el procesamiento.
     * @return Mensaje de estado o resultado.
     */
    String getProcessingMessage();
}
