
package InteractorsUseCases;

import DTO.PersonaDTO;
import DataBase.PersonaDAO;
import Entities.Persona;
import java.util.List;


public class ListarPersonasUseCase {
    private Persona persona;
    private PersonaDAO personaDAO;

    public ListarPersonasUseCase() {
        
        persona= new Persona();
        personaDAO=PersonaDAO.inicializarPersonaDAO();    
    }
    
    public List<PersonaDTO> listadoPersonas(){
    
        return personaDAO.listadoPersonas();
    }
    
}
