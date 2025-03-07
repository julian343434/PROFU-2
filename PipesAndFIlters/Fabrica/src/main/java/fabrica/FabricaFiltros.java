package fabrica;

import ID1.CargarArchivoDeTexto;
import ID1.IAutoCompletado;
import ID1.AutoCompletado;
import ID2.ConvertirArchivoTextoABinario;
import ID3.ConvertirArchivoBinarioATexto;
import ID4.ConvertirArchivoBinarioABase64;
import ID5.ConvertirArchivoBase64ABinario;
import ID6.EncriptarArchivoTextoSHA256;
import ID7.BuscarPalabraEnArchivoTexto;
import ID8.ListarPalabrasFrecuenciaDeOcurrencia;
import Tuberias.Filtro;

import java.util.Map;
import java.util.function.Supplier;

public class FabricaFiltros implements FabricaAbstracta {

    private final IAutoCompletado autoCompleter = new AutoCompletado();

    public Map<String, Supplier<Filtro>> FILTRO_MAP = Map.of(
            new CargarArchivoDeTexto(autoCompleter).getID(), () -> new CargarArchivoDeTexto(autoCompleter),
            new ConvertirArchivoTextoABinario().getID(), ConvertirArchivoTextoABinario::new,
            new ConvertirArchivoBinarioATexto().getID(), ConvertirArchivoBinarioATexto::new,
            new ConvertirArchivoBinarioABase64().getID(), ConvertirArchivoBinarioABase64::new,
            new ConvertirArchivoBase64ABinario().getID(), ConvertirArchivoBase64ABinario::new,
            new EncriptarArchivoTextoSHA256().getID(), EncriptarArchivoTextoSHA256::new,
            new BuscarPalabraEnArchivoTexto().getID(), BuscarPalabraEnArchivoTexto::new,
            new ListarPalabrasFrecuenciaDeOcurrencia().getID(), ListarPalabrasFrecuenciaDeOcurrencia::new
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