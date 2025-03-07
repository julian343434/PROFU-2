package ID6;

import Tuberias.Filtro;

import java.io.*;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncriptarArchivoTextoSHA256 implements Filtro {
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

            File outputFile = new EncriptarArchivoTextoSHA256().processFile(inputFile);

            writer.println(outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File processFile(File inputFile) throws IOException {
        File outputFile = new File("encrypted_" + inputFile.getName());

        try (InputStream fis = new FileInputStream(inputFile);
             OutputStream fos = new FileOutputStream(outputFile)) {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] byteArray = new byte[1024];
            int bytesCount;

            while ((bytesCount = fis.read(byteArray)) != -1) {
                digest.update(byteArray, 0, bytesCount);
            }

            byte[] hashBytes = digest.digest();

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) fos.write('0');
                fos.write(hex.getBytes());
            }

            fos.write(System.lineSeparator().getBytes());
        }
        catch (IOException | NoSuchAlgorithmException e) {
            System.err.println("Error de entrada/salida al procesar el archivo.");
            e.printStackTrace();
        }
        return outputFile;
    }

    @Override
    public String getID() {
        return "";
    }
}
