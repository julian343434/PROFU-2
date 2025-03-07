package InicioMain;

import java.io.File;
import java.util.Scanner;

public class InputHandler {
    private static final String DEFAULT_INPUT_PATH = "ID1-CargarArchivoTexto/target/classes/In/Archivo";
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public InputData getInput(String[] args) {
        if (args.length > 0) {
            return processCommandLineArgs(args);
        } else {
            return processInteractiveInput();
        }
    }

    private InputData processCommandLineArgs(String[] args) {
        File file = validateFile(args[0]);
        String sequence = null;
        String findParam = null;

        for (String arg : args) {
            if (arg.startsWith("-s")) {
                sequence = validateSequence(arg.substring(2));
            } else if (arg.startsWith("-f")) {
                findParam = arg.substring(2).replace("\"", "");
            }
        }

        validateInput(sequence, findParam);
        return new InputData(file, sequence, findParam);
    }

    private InputData processInteractiveInput() {
        System.out.println("Ruta predeterminada: " + DEFAULT_INPUT_PATH);
        System.out.print("Pon la ruta del archivo (Enter para usar la predeterminada): ");
        String filePath = scanner.nextLine().trim();
        File file = validateFile(filePath.isEmpty() ? DEFAULT_INPUT_PATH : filePath);

        System.out.print("Ingresa la secuencia de filtros (Ejemplo: 245): ");
        String sequence = validateSequence(scanner.nextLine().trim());

        String findParam = null;
        if (sequence.contains("7")) {
            System.out.print("Ingresa la palabra a buscar: ");
            findParam = validateFindParam(scanner.nextLine().trim());
        }

        return new InputData(file, sequence, findParam);
    }

    private File validateFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("El archivo de entrada no existe: " + file.getAbsolutePath());
        }
        return file;
    }

    private String validateSequence(String sequence) {
        if (sequence == null || sequence.isEmpty()) {
            throw new IllegalArgumentException("Debes especificar una secuencia");
        }
        return sequence;
    }

    private String validateFindParam(String findParam) {
        if (findParam.isEmpty()) {
            throw new IllegalArgumentException("El filtro ID7 requiere una palabra a buscar");
        }
        return findParam;
    }

    private void validateInput(String sequence, String findParam) {
        if (sequence.contains("7") && (findParam == null || findParam.isEmpty())) {
            throw new IllegalArgumentException("El filtro ID7 requiere una palabra a buscar");
        }
    }
}