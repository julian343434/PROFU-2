package InicioMain;

import fabrica.FabricaAbstracta;
import Tuberias.Filtro;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilterSequenceProcessor {
    private final FabricaAbstracta filterFactory;
    private final FilterConfigurer filterConfigurer;

    public FilterSequenceProcessor(FabricaAbstracta filterFactory) {
        this.filterFactory = filterFactory;
        this.filterConfigurer = new FilterConfigurer();
    }

    public void executeSequence(InputData inputData) throws IOException {
        List<Filtro> filters = buildFilterList(inputData);
        File currentFile = processFilters(inputData.getInitialFile(), filters);
        System.out.println("Procesamiento completado. Última salida: " + currentFile.getAbsolutePath());
    }

    private List<Filtro> buildFilterList(InputData inputData) {
        List<Filtro> filters = new ArrayList<>();
        for (char id : inputData.getSequence().toCharArray()) {
            Filtro filter = filterFactory.crearFiltro(String.valueOf(id));
            if (filter == null) {
                throw new IllegalArgumentException("Filtro no válido: " + id);
            }
            filterConfigurer.configure(filter, inputData.getFindParam());
            filters.add(filter);
        }
        return filters;
    }

    private File processFilters(File initialFile, List<Filtro> filters) throws IOException {
        File currentFile = initialFile;
        for (Filtro filter : filters) {
            currentFile = filter.processFile(currentFile);
            if (currentFile == null) {
                throw new IOException("Error en el filtro " + filter.getID());
            }
            System.out.println("Filtro " + filter.getID() + " ejecutado. Salida: " + currentFile.getAbsolutePath());
        }
        return currentFile;
    }
}