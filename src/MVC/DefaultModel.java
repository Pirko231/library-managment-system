package MVC;

import java.util.concurrent.atomic.AtomicBoolean;

import MVC.commandChain.AddBookMiddleware;
import MVC.commandChain.AddOwnerMiddleware;
import MVC.commandChain.AddPersonMiddleware;
import MVC.commandChain.DisplayMiddleware;
import MVC.commandChain.HelpMiddleware;
import MVC.commandChain.Middleware;
import MVC.commandChain.QuitMiddleware;
import MVC.commandChain.RemoveBookMiddleware;
import MVC.commandChain.RemoveOwnerMiddleware;
import MVC.commandChain.RemovePersonMiddleware;
import MVC.objects.Bookshelf;
import MVC.objects.PersonManager;

public class DefaultModel implements Model {

    private final Bookshelf bookshelf;
    private final PersonManager personManager;
    private final Middleware middleware;

    public DefaultModel(AtomicBoolean running) {
        personManager = new PersonManager("people.txt");
        bookshelf = new Bookshelf("books.txt", personManager);
        middleware = Middleware.link(
                new AddBookMiddleware(bookshelf),
                new AddPersonMiddleware(personManager),
                new QuitMiddleware(running),
                new DisplayMiddleware(bookshelf, personManager),
                new AddOwnerMiddleware(bookshelf, personManager),
                new RemoveBookMiddleware(bookshelf),
                new RemovePersonMiddleware(personManager),
                new RemoveOwnerMiddleware(bookshelf),
                new HelpMiddleware()
        );
    }

    @Override
    public boolean sendCommand(String[] args) {
        return middleware.check(args);
    }

    @Override
    public void writeToFiles() {
        bookshelf.saveBooks("books.txt");
        personManager.savePeople("people.txt");
    }
}
