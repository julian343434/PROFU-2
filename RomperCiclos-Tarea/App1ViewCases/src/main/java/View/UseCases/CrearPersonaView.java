package View.UseCases;

import Authorizer.Permissions;
import Controllers.ControllerUseCase1;
import DTO.PersonaDTO;


public class CrearPersonaView {
    private ControllerUseCase1 controllerUseCase1;

    public CrearPersonaView() {
        controllerUseCase1=new ControllerUseCase1(Permissions.inicializarPermissions());
        // creandoPersona();
    }
    public void adicionarPersona(){
        creandoPersona();
    }
    private void creandoPersona(){


        controllerUseCase1.crearPersona(definiendoPersona());

    }
    private PersonaDTO definiendoPersona(){
        PersonaDTO personaDTO =new PersonaDTO (100.0, "Juan","Calderón Moreno", 50);
        return personaDTO;
    }

}