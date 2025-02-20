
package View.UseCases;

import Controllers.IControllerUseCase;
import DTO.PersonaDTO;



public class CrearPersonaView extends View{
    private IControllerUseCase controllerUseCase1;

    public CrearPersonaView(IControllerUseCase controllerUseCase) {
        controllerUseCase1 = controllerUseCase;
    }
    public void adicionarPersona(){
        creandoPersona();
    }
    private void creandoPersona(){
        
        
        controllerUseCase1.crearPersona(definiendoPersona());
    
    }
    private PersonaDTO definiendoPersona(){
        PersonaDTO personaDTO=new PersonaDTO (100.0, "Juan","Calderón Moreno", 50);
        return personaDTO;
    }

    @Override
    public void show() {
        adicionarPersona();
        adicionarPersona();
    }
}
