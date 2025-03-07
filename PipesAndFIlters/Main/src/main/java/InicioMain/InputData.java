package InicioMain;

import java.io.File;

public class InputData {
    private final File initialFile;
    private final String sequence;
    private final String findParam;

    public InputData(File initialFile, String sequence, String findParam) {
        this.initialFile = initialFile;
        this.sequence = sequence;
        this.findParam = findParam;
    }

    public File getInitialFile() {
        return initialFile;
    }

    public String getSequence() {
        return sequence;
    }

    public String getFindParam() {
        return findParam;
    }
}