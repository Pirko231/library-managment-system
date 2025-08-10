package MVC;

import MVC.commandChain.*;
import MVC.objects.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class DefaultModel implements Model {

    private final Bookshelf bookshelf;
    private final PersonManager personManager;
    private final Middleware middleware;

    public DefaultModel(AtomicBoolean running) {
        bookshelf = new Bookshelf("books.txt");
        personManager = new PersonManager();
        middleware = Middleware.link(
                new AddBookMiddleware(bookshelf),
                new AddPersonMiddleware(personManager),
                new QuitMiddleware(running),
                new DisplayMiddleware(bookshelf, personManager),
                new AddOwnerMiddleware(bookshelf, personManager),
                new HelpMiddleware()
        );
    }

    @Override
    public boolean sendCommand(String[] args) {
        return middleware.check(args);
    }
}
