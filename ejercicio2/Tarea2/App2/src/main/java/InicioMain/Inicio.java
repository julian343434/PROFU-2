package InicioMain;

import Interfaces.Documento;
import factory.FabricaDocumento;
import HTML.DocumentoHtmlImp;
import PDFAdaptado.DocumentoPdfImp;
import TextoPlano.DocumentoTexto;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
        // Registrar implementaciones disponibles
        Map<String, Documento> documentosDisponibles = new HashMap<>();
        documentosDisponibles.put("texto", new DocumentoTexto());
        documentosDisponibles.put("html", new DocumentoHtmlImp());
        documentosDisponibles.put("pdf", new DocumentoPdfImp());


        FabricaDocumento fabrica = new FabricaDocumento(documentosDisponibles);

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("=== Menú de creación de documentos ===");

        while (continuar) {
            System.out.println("\nSeleccione el tipo de documento que desea crear:");
            System.out.println("1. Documento de Texto");
            System.out.println("2. Documento HTML");
            System.out.println("3. Documento PDF");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    manejarDocumento(fabrica, "texto");
                    break;
                case "2":
                    manejarDocumento(fabrica, "html");
                    break;
                case "3":
                    manejarDocumento(fabrica, "pdf");
                    break;
                case "4":
                    continuar = false;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        }

        scanner.close();
    }

    private static void manejarDocumento(FabricaDocumento fabrica, String tipo) {
        try {
            Documento documento = fabrica.crearDocumento(tipo);
            System.out.println("Documento de tipo '" + tipo + "' creado exitosamente: " + documento.getClass().getSimpleName());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
