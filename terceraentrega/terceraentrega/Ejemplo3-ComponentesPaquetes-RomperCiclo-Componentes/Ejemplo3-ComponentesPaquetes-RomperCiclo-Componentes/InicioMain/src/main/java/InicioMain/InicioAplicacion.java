package InicioMain;


import Authorizer.Permissions;
import View.UseCases.CrearPersonaView;
import View.UseCases.ListarPersonaView;

public class InicioAplicacion {


    private static CrearPersonaView vista1;
    private static ListarPersonaView vista2;
    
    public static void main(String[] args) {
        Permissions permissions=Permissions.inicializarPermissions();
        permissions.permisosDisponibles();
        vista1=new CrearPersonaView();
        vista1.adicionarPersona();
        vista1.adicionarPersona();        
        vista2= new ListarPersonaView();        
    }    
}
