
package InteractorsUseCases;

import DTO.PersonaDTO;
import DataBase.PersonaDAO;
import Entities.Persona;
import java.util.List;


public class ListarPersonas {
    private Persona persona;
    private PersonaDAO personaDAO;

    public ListarPersonas() {
        
        persona=new Persona();
        personaDAO= PersonaDAO.inicializarPersonaDAO();    
    }
    
    public List<PersonaDTO> listadoPersonas(){
    
        return personaDAO.listadoPersonas();
    }
    
}
