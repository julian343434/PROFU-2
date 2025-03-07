package ID7;

import Tuberias.Filtro;

import java.io.*;

public class BuscarPalabraEnArchivoTexto implements Filtro {
    private String palabraABuscar;


    public BuscarPalabraEnArchivoTexto() {
        this.palabraABuscar = null;
    }

    public void setPalabraABuscar(String palabra) {
        this.palabraABuscar = palabra;
    }

    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writer = new PrintWriter(System.out, true)
        ) {
            String inputFilePath = reader.readLine();
            if (inputFilePath == null || inputFilePath.isEmpty()) {
                System.err.println("Error: No se proporcionó la ruta del archivo de entrada.");
                return;
            }

            String palabra = reader.readLine();
            if (palabra == null || palabra.isEmpty()) {
                System.err.println("Error: No se proporcionó la palabra a buscar.");
                return;
            }

            File inputFile = new File(inputFilePath);
            if (!inputFile.exists()) {
                System.err.println("Error: El archivo de entrada no existe.");
                return;
            }

            BuscarPalabraEnArchivoTexto filtro = new BuscarPalabraEnArchivoTexto();
            filtro.setPalabraABuscar(palabra);
            File outputFile = filtro.processFile(inputFile);

            writer.println(outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File processFile(File inputFile) throws IOException {
        if (palabraABuscar == null || palabraABuscar.isEmpty()) {
            throw new IllegalArgumentException("Se requiere una palabra para buscar con el filtro ID7.");
        }

        File outputDir = new File("/home/daikyri/Documentos/Profu2/Tarea-3/PROFU-2/PipesAndFIlters/ID7-BuscarPalabra/src/main/resources/Out");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        File outputFile = new File(outputDir, "PalabraBuscada");

        boolean found = false;
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(palabraABuscar)) {
                    writer.write(line);
                    writer.newLine();
                    found = true;
                }
            }
            if (!found) {
                writer.write("La palabra '" + palabraABuscar + "' no se encontró en el archivo.");
            }
        }
        return outputFile;
    }

    @Override
    public String getID() {
        return "7";
    }
}