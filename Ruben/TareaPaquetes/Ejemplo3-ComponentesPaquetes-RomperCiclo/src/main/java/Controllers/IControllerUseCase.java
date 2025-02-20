package Controllers;

import DTO.PersonaDTO;

import java.util.List;

public interface IControllerUseCase {
    public boolean crearPersona(PersonaDTO personaDTO);
    public List<PersonaDTO> listadoPersonas();
}
