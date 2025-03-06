package Tuberias;

import java.io.IOException;
import java.io.File;

public interface Filtro {
    public File processFile(File file) throws IOException;
    String getID();

}
