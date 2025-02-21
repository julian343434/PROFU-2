package factory;

import Interfaces.Documento;
import java.util.Map;

public class FabricaDocumento {
    private final Map<String, Documento> documentosDisponibles;

    public FabricaDocumento(Map<String, Documento> documentosDisponibles) {
        this.documentosDisponibles = documentosDisponibles;
    }

    public Documento crearDocumento(String tipo) {
        Documento documento = documentosDisponibles.get(tipo.toLowerCase());
        if (documento == null) {
            throw new IllegalArgumentException("Tipo de documento no soportado: " + tipo);
        }
        return documento;
    }
}

