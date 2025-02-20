package DTO;


public class PersonaDTO {
    private Double identificacion;
    private String nombres;
    private String apellidos;
    private int edad;

    public PersonaDTO(Double identificacion, String nombres, String apellidos, int edad) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
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

    @Override
    public String toString() {
        return "PersonaDTO{" + "identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos=" + apellidos + ", edad=" + edad + '}';
    }
    
    
}
