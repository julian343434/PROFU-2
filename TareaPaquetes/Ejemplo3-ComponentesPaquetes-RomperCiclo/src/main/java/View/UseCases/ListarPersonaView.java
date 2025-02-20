package View.UseCases;

import Controllers.IControllerUseCase;
import DTO.PersonaDTO;


public class ListarPersonaView extends View{
     private IControllerUseCase controllerUseCase1;

    public ListarPersonaView(IControllerUseCase controllerUseCase) {
        controllerUseCase1 = controllerUseCase;
    }
    
    private void mostrarInformacion(){
        System.out.println("---------------------------------------------------------.");
        System.out.println("Imprimiendo la información de las personas registradas.");
        System.out.println("---------------------------------------------------------.");
        for (PersonaDTO personaDTO : controllerUseCase1.listadoPersonas()) {
            System.out.println("-->"+personaDTO.toString());
          }        
        System.out.println("---------------------------------------------------------.");
    }

    @Override
    public void show() {
        mostrarInformacion();
    }
}
