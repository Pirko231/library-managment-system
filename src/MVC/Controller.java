package MVC;
import MVC.objects.*;

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
        var book = view.addBook();
        if(book.isPresent())
        {
            model.addBook(book.get());
            
        }
    }
}