package org.example;

import org.example.PluginContract`;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Constructor;

public class PluginManager {
    private PluginContract loadedPlugin;

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

            // Verificar si la clase implementa PluginContract
            if (!PluginContract.class.isAssignableFrom(clazz)) {
                System.err.println("Error: La clase " + className + " no implementa PluginContract.");
                return;
            }

            // Crear una instancia del plugin
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            loadedPlugin = (PluginContract) constructor.newInstance();
            System.out.println("Plugin cargado exitosamente: " + loadedPlugin.getPluginName());

        } catch (Exception e) {
            System.err.println("Error al cargar el plugin: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public PluginContract getLoadedPlugin() {
        return loadedPlugin;
    }
}
