package MVC;

import MVC.commandChain.*;
import MVC.objects.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class DefaultModel implements Model {

    private final Bookshelf bookshelf;
    private final Middleware middleware;

    public DefaultModel(AtomicBoolean running) {
        bookshelf = new Bookshelf("books.txt");
        middleware = Middleware.link(
                new AddBookMiddleware(bookshelf),
                new AddPersonMiddleware(),
                new QuitMiddleware(running)
        );
    }

    @Override
    public boolean sendCommand(String[] args) {
        return middleware.check(args);
    }
}
