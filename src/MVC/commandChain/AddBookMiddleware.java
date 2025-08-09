package MVC.commandChain;
import MVC.objects.Bookshelf;

public class AddBookMiddleware extends Middleware
{
    private Bookshelf bookshelf;

    public AddBookMiddleware(Bookshelf bookshelf)
    {
        this.bookshelf = bookshelf;
    }

    @Override
    public boolean check(String[] args)
    {
        return false;
    }
}