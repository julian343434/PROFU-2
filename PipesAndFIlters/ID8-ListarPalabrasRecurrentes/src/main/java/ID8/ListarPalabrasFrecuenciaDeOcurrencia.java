package ID8;

import Tuberias.Filtro;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ListarPalabrasFrecuenciaDeOcurrencia implements Filtro {
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

            File outputFile = new ListarPalabrasFrecuenciaDeOcurrencia().processFile(inputFile);

            writer.println(outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File processFile(File inputFile) throws IOException {
        File outputDir = new File("target/classes/Out");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        File outputFile = new File(outputDir, "PalabrasFrecuenciaDeOcurrencia");

        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                writer.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return outputFile;
    }

    @Override
    public String getID() {
        return "8";
    }
}