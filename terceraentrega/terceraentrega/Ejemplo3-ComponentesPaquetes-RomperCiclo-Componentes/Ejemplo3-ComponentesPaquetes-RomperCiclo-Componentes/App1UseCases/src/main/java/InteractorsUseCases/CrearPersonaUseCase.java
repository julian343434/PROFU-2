package InteractorsUseCases;

import DTO.PersonaDTO;
import Entities.Permisos;
import Entities.Persona;




public class CrearPersonaUseCase {
    private Persona persona;

    public CrearPersonaUseCase(Permisos permisos) {
        persona= new Persona();
        persona.setPermisos(permisos);
    }
    
    public boolean inicializarPersona(PersonaDTO personaDTO) {
        return persona.guardarPersona(personaDTO);
    }
    
}
