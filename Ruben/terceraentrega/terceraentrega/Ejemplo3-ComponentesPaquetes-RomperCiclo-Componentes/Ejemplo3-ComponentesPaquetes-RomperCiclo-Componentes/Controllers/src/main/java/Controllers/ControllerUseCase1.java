
package Controllers;

import DTO.PersonaDTO;
import Entities.Permisos;
import InteractorsUseCases.CrearPersonaUseCase;
import InteractorsUseCases.ListarPersonasUseCase;

import java.util.List;

public class ControllerUseCase1 {
    
    private CrearPersonaUseCase crearPersona;
    private ListarPersonasUseCase listarPersonas ;
    private Permisos _permisos;
    public ControllerUseCase1(Permisos permisos){
        _permisos = permisos;
    }
    public boolean crearPersona(PersonaDTO personaDTO)            
    {
        crearPersona= new CrearPersonaUseCase(_permisos);
        
        return crearPersona.inicializarPersona(personaDTO);
    }
    public List<PersonaDTO> listadoPersonas()
    {
        listarPersonas= new ListarPersonasUseCase();
        return listarPersonas.listadoPersonas();
    }
        
}
