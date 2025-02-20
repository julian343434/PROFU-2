package View.UseCases;

import Controllers.ControllerUseCase1;
import DTO.PersonaDTO;
import Factories.UseCaseFactory;

public class CrearPersonaView {
    private ControllerUseCase1 controllerUseCase1;

    public CrearPersonaView() {
        // Inyección de dependencias usando Factory Method
        this.controllerUseCase1 = new ControllerUseCase1(
            UseCaseFactory.createCrearPersonaUseCase(),
            UseCaseFactory.createListarPersonasUseCase()
        );
    }
    
    public void adicionarPersona() {
        creandoPersona();
    }

    private void creandoPersona() {
        controllerUseCase1.crearPersona(definiendoPersona());
    }

    private PersonaDTO definiendoPersona() {
        PersonaDTO personaDTO = new PersonaDTO(100.0, "Juan", "Calderón Moreno", 50);
        return personaDTO;
    }
}
