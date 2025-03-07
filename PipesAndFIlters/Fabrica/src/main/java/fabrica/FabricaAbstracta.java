package fabrica;

import Tuberias.Filtro;

public interface FabricaAbstracta {
    public abstract Filtro crearFiltro(String id);
    public static FabricaAbstracta getFabrica() {
        return new FabricaFiltros();
    }
}
