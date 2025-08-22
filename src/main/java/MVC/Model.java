package MVC;

import java.util.List;

import MVC.objects.Book;
import MVC.objects.Person;

public abstract class Model extends Observable {

    public abstract void writeToFiles();

    public abstract boolean sendCommand(String[] args);

    public abstract List<Book> getBooks(); 

    public abstract List<Person> getPeople();
}
