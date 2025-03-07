package ID5;

import Tuberias.Filtro;

import java.io.*;
import java.util.Base64;

public class ConvertirArchivoBase64ABinario implements Filtro {
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

            File outputFile = new ConvertirArchivoBase64ABinario().processFile(inputFile);

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
        File outputFile = new File(outputDir, "Base64ABinario");

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                FileOutputStream fos = new FileOutputStream(outputFile)
        ) {
            StringBuilder base64Content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                base64Content.append(line);
            }

            byte[] binaryData = Base64.getDecoder().decode(base64Content.toString());

            fos.write(binaryData);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return outputFile;
    }

    @Override
    public String getID() {
        return "5";
    }
}