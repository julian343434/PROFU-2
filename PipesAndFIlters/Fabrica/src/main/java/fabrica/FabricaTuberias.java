package fabrica;

import ID1.CargarArchivoDeTexto;
import ID1.IAutoCompletado;
import ID1.AutoCompletado;
import Tuberias.Filtro;

import java.util.Map;
import java.util.function.Supplier;

public class FabricaTuberias implements FabricaAbstracta {

    private final IAutoCompletado autoCompleter = new AutoCompletado();

    public Map<String, Supplier<Filtro>> FILTRO_MAP = Map.of(
        new CargarArchivoDeTexto(autoCompleter).getID(), () -> new CargarArchivoDeTexto(autoCompleter)
    );

    @Override
    public Filtro crearFiltro(String id) {
        Supplier<Filtro> filtroSupplier = FILTRO_MAP.get(id);
        if (filtroSupplier == null) {
            throw new IllegalArgumentException("Filtro No valido " + id);
        }
        return filtroSupplier.get();
    }
}