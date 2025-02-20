package InteractorsUseCases;

import DTO.PersonaDTO;
import Entities.Persona;




public class CrearPersonaUseCase {
    private Persona persona;

    public CrearPersonaUseCase() {
        persona= new Persona();
    }
    
    public boolean inicializarPersona(PersonaDTO personaDTO) {
        return persona.guardarPersona(personaDTO);
    }
    
}
