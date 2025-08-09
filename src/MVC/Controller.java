package MVC;

public class Controller
{
    private View view;
    private Model model;
    private boolean isActive = true;

    public Controller(View view, Model model)
    {
        this.view = view; this.model = model;
    }

    public boolean running() {return isActive;}

    public void update()
    {
        var command = view.getCommand();
        if(command.isPresent())
        {
            model.sendCommand(command.get());
            
        }
    }
}