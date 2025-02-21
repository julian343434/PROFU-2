package DataBase;

import DTO.PersonaDTO;
import Entities.Persona;

import java.util.ArrayList;
import java.util.List;

public  class PersonaDAO {
    ArrayList listado=new ArrayList<PersonaDTO>();
    private static PersonaDAO personaDAO;

    private PersonaDAO() { }

    public static PersonaDAO inicializarPersonaDAO(){
        if(personaDAO==null)
        {
            personaDAO=new PersonaDAO();
        }
        return  personaDAO;
    }


    public boolean guardar(Persona persona){
        listado.add(new PersonaDTO(persona.getIdentificacion(),persona.getNombres(),persona.getApellidos(),persona.getEdad()));
        return true;
    }

    public List<PersonaDTO> listadoPersonas(){
        listado.add(new PersonaDTO(100.0, "Roger","", 40));
        listado.add(new PersonaDTO(100.0, "Roger","Calderón", 41));
        listado.add(new PersonaDTO(100.0, "Roger","Calderón Moreno", 42));
        return listado;
    }
}
