
package Entities;

import Authorizer.Permissions;
import DTO.PersonaDTO;
import DataBase.PersonaDAO;

public class Persona {
    private Double identificacion;
    private String nombres;
    private String apellidos;
    private int edad;
    private String codigo;
    public Persona() { 
        this.identificacion = 0.0;
        this.nombres = "---";
        this.apellidos = "---";
        this.edad = 0;
        this.codigo="XYZ";
    
    }
    @Override
    public String toString() {
        return "Persona{" + "identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos=" + apellidos + ", edad=" + edad + '}';
    }
    public boolean guardarPersona(PersonaDTO persona) {
        
        //Se rompe el ciclo con la interfaz Permisos
        Permisos Permisos= Permissions.inicializarPermissions();
        Permisos.validarPermisos();
        
        
        this.identificacion = persona.getIdentificacion();
        this.nombres = persona.getNombres();
        this.apellidos = persona.getApellidos();
        this.edad = persona.getEdad();
        this.codigo="XYZ" + this.identificacion.toString();
        
        PersonaDAO personaDAO= PersonaDAO.inicializarPersonaDAO();
        personaDAO.guardar(this);
        return true;
    }

    public Double getIdentificacion() {
        return identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getCodigo() {
        return codigo;
    }
    
    
}
