package InicioMain;

import Authorizer.Permissions;

import View.UseCases.*;


public class InicioAplicacion {
    
    public static void main(String[] args) {
        Permissions permissions=Permissions.inicializarPermissions();
        permissions.permisosDisponibles();
        //FACTORY METHOD
        ViewCreator creadorCrearPersonaView = new CrearPersonaViewCreator();
        creadorCrearPersonaView.RenderView();

        ViewCreator creadorListarPersona = new ListarPersonaViewCreator();
        creadorListarPersona.RenderView();

    }    
}
