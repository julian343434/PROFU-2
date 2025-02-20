import Authorizer.Permissions;

import View.UseCases.CrearPersonaView;
import View.UseCases.ListarPersonaView;


public class App1 {

    private static CrearPersonaView vista1;
    private static ListarPersonaView vista2;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Nelson Arango - 160004402");
        System.out.println("Maykol Gomez - 160004336");

        Permissions permissions=Permissions.inicializarPermissions();
        permissions.permisosDisponibles();

        vista1=new CrearPersonaView();
        vista1.adicionarPersona();
        vista1.adicionarPersona();
        vista2= new ListarPersonaView();
    }
}