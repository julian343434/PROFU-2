package ID7;

import Tuberias.Filtro;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DesencriptarArchivoSHA256 implements Filtro {
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

            File outputFile = new DesencriptarArchivoSHA256().processFile(inputFile);

            if (outputFile != null) {
                writer.println(outputFile.getAbsolutePath());
            } else {
                System.err.println("No se pudo procesar el archivo.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File processFile(File inputFile) {
        System.err.println("Error: No se puede desencriptar un hash SHA-256. La operación no es válida.");
        return null;
    }

    @Override
    public String getID() {
        return "";
    }
}
