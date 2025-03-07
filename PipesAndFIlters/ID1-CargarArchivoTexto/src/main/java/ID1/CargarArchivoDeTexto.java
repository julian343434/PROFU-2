package ID1;

import Tuberias.Filtro;

import java.io.*;
import java.util.Scanner;

public class CargarArchivoDeTexto implements Filtro {

    private final IAutoCompletado autoCompleter;

    public CargarArchivoDeTexto(IAutoCompletado autoCompleter) {
        this.autoCompleter = autoCompleter;
    }

    @Override
    public File processFile(File inputFile) throws IOException {
        // Si no se recibe un archivo, se solicita la ruta al usuario.
        if (inputFile == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Pon la ruta del archivo: ");
            String filePath = scanner.nextLine();
            inputFile = new File(filePath);
            if (!inputFile.exists()) {
                throw new FileNotFoundException("Error: El archivo de entrada no existe.");
            }
        }


        File outputDir = new File("target/classes/Out");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        File outputFile = new File(outputDir, "outputID1");

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
        return outputFile;
    }

    @Override
    public String getID() {
        return "1";
    }
}
