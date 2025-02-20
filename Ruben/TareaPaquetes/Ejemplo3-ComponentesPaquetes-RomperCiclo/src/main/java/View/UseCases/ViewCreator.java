package View.UseCases;

public abstract class ViewCreator {
    public abstract View createView();
    public void RenderView(){
        View view = createView();
        view.show();
    }
}
