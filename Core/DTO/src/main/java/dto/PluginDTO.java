package dto;

import contratos.PluginContract;
import java.util.List;

public class PluginDTO {
    private List<PluginContract> loadedPlugins; // Lista de plugins cargados
    private PluginContract selectedPlugin; // Plugin seleccionado
    private byte[] imageData; // Imagen cargada en formato byte[]

    public PluginDTO(List<PluginContract> loadedPlugins) {
        this.loadedPlugins = loadedPlugins;
        this.selectedPlugin = null; // No hay plugin seleccionado por defecto
        this.imageData = null; // Imagen vacía al inicio
    }

    public List<PluginContract> getLoadedPlugins() {
        return loadedPlugins;
    }

    public void setLoadedPlugins(List<PluginContract> loadedPlugins) {
        this.loadedPlugins = loadedPlugins;
    }

    public PluginContract getSelectedPlugin() {
        return selectedPlugin;
    }

    public void setSelectedPlugin(PluginContract selectedPlugin) {
        this.selectedPlugin = selectedPlugin;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
