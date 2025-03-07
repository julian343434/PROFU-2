package InicioMain;

import fabrica.FabricaAbstracta;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        FilterSequenceProcessor processor = new FilterSequenceProcessor(FabricaAbstracta.getFabrica());

        try {
            InputData inputData = inputHandler.getInput(args);
            processor.executeSequence(inputData);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error durante el procesamiento: " + e.getMessage());
            e.printStackTrace();
        }
    }
}