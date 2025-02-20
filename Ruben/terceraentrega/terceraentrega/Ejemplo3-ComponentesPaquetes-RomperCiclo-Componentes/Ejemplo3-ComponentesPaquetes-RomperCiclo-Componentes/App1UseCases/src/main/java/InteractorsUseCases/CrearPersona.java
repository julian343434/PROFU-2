package InteractorsUseCases;

import DTO.PersonaDTO;
import Entities.Persona;


public class CrearPersona {
    private Persona persona;

    public CrearPersona() {  
        persona= new Persona();
    }
    
    public boolean inicializarPersona(PersonaDTO personaDTO) {
        return persona.guardarPersona(personaDTO);
    }
    
}
