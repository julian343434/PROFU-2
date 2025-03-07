package ID3;

import Tuberias.Filtro;

import java.io.*;

public class ConvertirArchivoBinarioATexto implements Filtro {
    @Override
    public File processFile(File inputFile) throws IOException {
        if (!isBinary(inputFile)) {
            System.err.println("Contenido del archivo no válido: " + inputFile.getAbsolutePath());
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.err.println("Línea: '" + line + "'");
                }
            }
            throw new IllegalArgumentException("El archivo proporcionado no es un archivo binario válido.");
        }

        File outputDir = new File("target/classes/Out");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        File outputFile = new File(outputDir, "BinarioATexto");

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder text = new StringBuilder();
                String[] binaryChars = line.trim().split("\\s+");
                for (String binaryChar : binaryChars) {
                    if (!binaryChar.isEmpty()) {
                        char character = (char) Integer.parseInt(binaryChar, 2);
                        text.append(character);
                    }
                }
                writer.write(text.toString());
                writer.newLine();
            }
        }
        return outputFile;
    }

    public static boolean isBinary(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmedLine = line.trim();
                if (trimmedLine.isEmpty()) continue; // Ignorar líneas vacías
                if (!trimmedLine.matches("[01\\s]+")) {
                    System.err.println("Línea no válida: '" + trimmedLine + "'");
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
        return "3";
    }

}