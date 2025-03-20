package appMain;

import contratos.PluginContract;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class PluginManager {
    private List<PluginContract> loadedPlugins = new ArrayList<>();

    /**
     * Carga un plugin desde un archivo .jar y lo instancia dinámicamente.
     *
     * @param jarPath   Ruta del archivo .jar del plugin.
     * @param className Nombre completo de la clase a cargar (paquete incluido).
     */
    public void loadPlugin(String jarPath, String className) {
        try {
            File jarFile = new File(jarPath);
            URL jarURL = jarFile.toURI().toURL();
            URLClassLoader classLoader = new URLClassLoader(new URL[]{jarURL}, this.getClass().getClassLoader());

            Class<?> clazz = classLoader.loadClass(className);

            if (!PluginContract.class.isAssignableFrom(clazz)) {
                System.err.println("Error: La clase " + className + " no implementa PluginContract.");
                return;
            }

            Constructor<?> constructor = clazz.getDeclaredConstructor();
            PluginContract plugin = (PluginContract) constructor.newInstance();
            loadedPlugins.add(plugin);
            System.out.println("Plugin cargado exitosamente: " + plugin.getPluginName());

        } catch (Exception e) {
            System.err.println("Error al cargar el plugin: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<PluginContract> getLoadedPlugins() {
        return loadedPlugins;
    }

}
