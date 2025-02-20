package View.UseCases;

import Controllers.ControllerUseCase1;
import DTO.PersonaDTO;
import Factories.UseCaseFactory;

public class ListarPersonaView {
    private ControllerUseCase1 controllerUseCase1;

    public ListarPersonaView() {
        // Inyección de dependencias usando Factory Method
        this.controllerUseCase1 = new ControllerUseCase1(
            UseCaseFactory.createCrearPersonaUseCase(),
            UseCaseFactory.createListarPersonasUseCase()
        );
        mostrarInformacion();
    }

    private void mostrarInformacion() {
        System.out.println("---------------------------------------------------------.");
        System.out.println("Imprimiendo la información de las personas registradas.");
        System.out.println("---------------------------------------------------------.");
        for (PersonaDTO personaDTO : controllerUseCase1.listadoPersonas()) {
            System.out.println("-->" + personaDTO.toString());
        }
        System.out.println("---------------------------------------------------------.");
    }
}
