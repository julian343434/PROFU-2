package View.UseCases;

import Controllers.ControllerUseCase1;
import Controllers.IControllerUseCase;

public class CrearPersonaViewCreator extends ViewCreator {
    @Override
    public View createView() {
        IControllerUseCase controller = ControllerUseCase1.CreateController();
        return new CrearPersonaView(controller);
    }
}
