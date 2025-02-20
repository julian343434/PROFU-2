package Controllers;

import DTO.PersonaDTO;
import InteractorsUseCases.*;
import java.util.List;

public class ControllerUseCase1 {
    
    private CrearPersonaUseCase crearPersona;
    private ListarPersonasUseCase listarPersonas ;
    
    //Inyección de Dependencias
    public ControllerUseCase1(CrearPersonaUseCase crearPersona, ListarPersonasUseCase listarPersonas) {
        this.crearPersona = crearPersona;
        this.listarPersonas = listarPersonas;
    }

    public boolean crearPersona(PersonaDTO personaDTO) {
        return crearPersona.inicializarPersona(personaDTO);
    }
    
    public List<PersonaDTO> listadoPersonas() {
        return listarPersonas.listadoPersonas();
    }
}
