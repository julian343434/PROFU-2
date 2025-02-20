
package Controllers;

import DTO.PersonaDTO;
import InteractorsUseCases.*;
import java.util.List;

public class ControllerUseCase1 {
    
    private CrearPersonaUseCase crearPersona;
    private ListarPersonasUseCase listarPersonas ;
    
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
