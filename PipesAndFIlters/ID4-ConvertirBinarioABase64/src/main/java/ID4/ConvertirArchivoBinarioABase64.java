package ID4;

import Tuberias.Filtro;

import java.io.*;
import java.util.Base64;

public class ConvertirArchivoBinarioABase64 implements Filtro {

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
            if (!isBinary(inputFile)) {
                System.err.println("Error: El archivo de entrada no es un binario.");
                throw new IllegalArgumentException("El archivo proporcionado no es un archivo binario.");
            }
            File outputFile = new ConvertirArchivoBinarioABase64().processFile(inputFile);

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
        File outputFile = new File(outputDir, "BinarioABase64");

        try (
                InputStream inputStream = new FileInputStream(inputFile);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            byte[] binaryData = byteArrayOutputStream.toByteArray();
            String base64Encoded = Base64.getEncoder().encodeToString(binaryData);
            writer.write(base64Encoded);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return outputFile;
    }

    public static boolean isBinary(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.matches("[01 ]+")) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String getID() {
        return "4";
    }
}