package ID1;

import Tuberias.Filtro;

import java.io.*;

public class CargarArchivoDeTexto implements Filtro {

    private final IAutoCompletado autoCompleter;

    public CargarArchivoDeTexto(IAutoCompletado autoCompleter) {
        this.autoCompleter = autoCompleter;
    }

    public static void main(String[] args) {
        IAutoCompletado autoCompleter = new AutoCompletado();
        CargarArchivoDeTexto cargarArchivoDeTexto = new CargarArchivoDeTexto(autoCompleter);

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writer = new PrintWriter(System.out, true);
        ) {
            String inputFilePath = "";
            while (true) {
                writer.print("Enter file path: ");
                writer.flush();
                int ch;
                while ((ch = reader.read()) != -1) {
                    if (ch == '\t') {
                        inputFilePath = cargarArchivoDeTexto.autoCompleter.autoComplete(inputFilePath);
                        writer.print("\r" + inputFilePath);
                        writer.flush();
                    } else if (ch == '\n') {
                        break;
                    } else {
                        inputFilePath += (char) ch;
                    }
                }
                if (inputFilePath == null || inputFilePath.isEmpty()) {
                    System.err.println("Error: La ruta no está bien establecida");
                    return;
                }

                File inputFile = new File(inputFilePath);
                if (!inputFile.exists()) {
                    System.err.println("Error: El archivo de entrada no existe.");
                    return;
                }

                File outputFile = cargarArchivoDeTexto.processFile(inputFile);

                writer.println(outputFile.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File processFile(File inputFile) throws IOException {
        File outputDir = new File("src/main/java/resources/Out");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        File outputFile = new File(outputDir, "output_" + inputFile.getName());
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
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