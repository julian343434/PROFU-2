
package Controllers;

import DTO.PersonaDTO;
import InteractorsUseCases.*;
import java.util.List;

public class ControllerUseCase1 implements IControllerUseCase {
    
    private CrearPersonaUseCase crearPersona;
    private ListarPersonasUseCase listarPersonas ;
    private static ControllerUseCase1 controller;
    private ControllerUseCase1(){

    }
    public static ControllerUseCase1 CreateController(){
        if(controller == null){
            controller = new ControllerUseCase1();
        }
        return controller;
    }
    public boolean crearPersona(PersonaDTO personaDTO)            
    {
        crearPersona= new CrearPersonaUseCase();
        
        return crearPersona.inicializarPersona(personaDTO);
    }
    public List<PersonaDTO> listadoPersonas()
    {
        listarPersonas= new ListarPersonasUseCase();
        return listarPersonas.listadoPersonas();
    }
        
}
