package fabrica;

import fabrica.FabricaTuberias;
import Tuberias.Filtro;

public interface FabricaAbstracta {
    public abstract Filtro crearFiltro(String id);
    public static FabricaAbstracta getFabrica() {
        return new FabricaTuberias();
    }
}
