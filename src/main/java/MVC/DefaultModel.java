package MVC;

import java.util.List;
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
import MVC.objects.Book;
import MVC.objects.Bookshelf;
import MVC.objects.Person;
import MVC.objects.PersonManager;

public class DefaultModel extends Model {

    private final Bookshelf bookshelf;
    private final PersonManager personManager;
    private final Middleware middleware;
    

    public DefaultModel(AtomicBoolean running) {
        personManager = new PersonManager("people.ser");
        bookshelf = new Bookshelf("books.ser", personManager);
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
        if (middleware.check(args))
            notifyObservers();
        return false;
    }

    @Override
    public void writeToFiles() {
        System.out.println("Saving data");
        bookshelf.saveBooks("books.ser");
        personManager.savePeople("people.ser");
    }

    @Override
    public List<Book> getBooks() {
        return bookshelf.getBooks();
    }

    @Override
    public List<Person> getPeople() {
        return personManager.getPeople();
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(this));
    }
}
