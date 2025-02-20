package View.UseCases;

import Controllers.ControllerUseCase1;
import Controllers.IControllerUseCase;

public class ListarPersonaViewCreator extends ViewCreator {
    @Override
    public View createView() {
        IControllerUseCase controller = ControllerUseCase1.CreateController();
        return new ListarPersonaView(controller);
    }
}
