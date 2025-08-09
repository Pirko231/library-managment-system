package MVC;
import MVC.commandChain.*;
import MVC.objects.*;

public class DefaultModel implements Model
{
    private Bookshelf bookshelf;
    private Middleware middleware;

    public DefaultModel(String fileName)
    {
        bookshelf = new Bookshelf(fileName);
        middleware = Middleware.link(
            new AddBookMiddleware(bookshelf),
            new AddPersonMiddleware()
        );
    }

    @Override
    public void addBook(Book book)
    {
        bookshelf.addBook(book);
    }
}