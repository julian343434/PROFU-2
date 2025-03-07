package ID8;

import Tuberias.Filtro;

import java.io.*;

public class BuscarPalabraEnArchivoTexto implements Filtro {
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

            File outputFile = new BuscarPalabraEnArchivoTexto().processFile(inputFile);

            if (outputFile == null) {
                System.out.println("Terminado");
            }else{
                writer.println(outputFile.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File processFile(File inputFile) throws IOException {
        String palabra = "hola";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String linea;
            int numeroLinea = 1;
            boolean encontrada = false;

            while ((linea = br.readLine()) != null) {
                if (linea.contains(palabra)) {
                    System.out.println("Palabra encontrada en la línea " + numeroLinea + ": " + linea);
                    encontrada = true;
                }
                numeroLinea++;
            }

            if (!encontrada) {
                System.out.println("La palabra \"" + palabra + "\" no se encontró en el archivo.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getID() {
        return "";
    }
}