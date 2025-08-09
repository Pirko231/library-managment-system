package MVC;
import MVC.commandChain.*;
import MVC.objects.*;

public class DefaultModel implements Model
{
    private final Bookshelf bookshelf;
    private final Middleware middleware;

    public DefaultModel(String fileName)
    {
        bookshelf = new Bookshelf(fileName);
        middleware = Middleware.link(
            new AddBookMiddleware(bookshelf),
            new AddPersonMiddleware()
        );
    }

    @Override
    public boolean sendCommand(String[] args)
    {
        return middleware.check(args);
    }
}