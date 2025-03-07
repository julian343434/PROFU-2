package ID2;

import Tuberias.Filtro;

import java.io.*;

public class ConvertirArchivoTextoABinario implements Filtro {
    @Override
    public File processFile(File inputFile) throws IOException {
        File outputDir = new File("target/classes/Out");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        File outputFile = new File(outputDir, "TextoABinario");

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder binary = new StringBuilder();
                for (char character : line.toCharArray()) {
                    binary.append(String.format("%8s", Integer.toBinaryString(character)).replace(' ', '0')).append(" ");
                }
                writer.write(binary.toString().trim());
                writer.newLine();
            }
        }
        return outputFile;
    }

    @Override
    public String getID() {
        return "2";
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
            File inputFile = new File(inputFilePath);
            if (!inputFile.exists()) {
                System.err.println("Error: El archivo de entrada no existe.");
                return;
            }
            File outputFile = new ConvertirArchivoTextoABinario().processFile(inputFile);
            writer.println(outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}