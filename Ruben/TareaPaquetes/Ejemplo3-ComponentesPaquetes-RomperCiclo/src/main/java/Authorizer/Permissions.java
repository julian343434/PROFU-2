
package Authorizer;


import Entities.Permisos;
import InteractorsUseCases.*;

public class Permissions  implements Permisos {
    
    
    private static Permissions permissions;
    
    public void permisosDisponibles(){
        System.out.println("Permiso en crearPersonaUseCase");
        System.out.println("Permiso en listarPersonasUseCase");
    };
    
    private Permissions() { 
       
    }
    
    public static Permissions inicializarPermissions(){    
     if(permissions==null)
        {
            permissions=new Permissions();
        }
        return  permissions;
    }

    @Override
    public void validarPermisos() {
         permisosDisponibles();
    }
    
}
