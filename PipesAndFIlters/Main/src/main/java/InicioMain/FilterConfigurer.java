package InicioMain;

import Tuberias.Filtro;
import ID7.BuscarPalabraEnArchivoTexto;

public class FilterConfigurer {
    public void configure(Filtro filter, String findParam) {
        if (filter.getID().equals("7") && findParam != null) {
            ((BuscarPalabraEnArchivoTexto) filter).setPalabraABuscar(findParam);
        }
    }
}