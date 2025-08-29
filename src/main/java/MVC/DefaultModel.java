package MVC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    private Bookshelf bookshelf;
    private PersonManager personManager;
    private final Middleware middleware;
    

    public DefaultModel(AtomicBoolean running) {
        personManager = new PersonManager();
        bookshelf = new Bookshelf(personManager);
        readFile(new File("data.ser"));
        
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

    public void readFile(File file) {
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file));
            bookshelf.copy((Bookshelf)stream.readObject());
            personManager.copy((PersonManager)stream.readObject());
            stream.close();
            notifyObservers();
        }
        catch(Exception e) {

        }
    }

    @Override
    public void writeToFiles(File file) {
        System.out.println("Saving data");
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
            stream.writeObject(bookshelf);
            stream.writeObject(personManager);
            stream.close();
        }
        catch(Exception e) {

        }

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
