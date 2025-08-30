package MVC.commandChain;

import org.junit.jupiter.api.Test;

import MVC.objects.Author;
import MVC.objects.Book;
import MVC.objects.Bookshelf;
import MVC.objects.Person;
import MVC.objects.PersonManager;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveBookMiddlewareTest {
    
    @Test
    public void testCheck() {
        PersonManager pManager = new PersonManager();
        Bookshelf bookshelf = new Bookshelf(pManager);
        RemoveBookMiddleware bMiddleware = new RemoveBookMiddleware(bookshelf);
        
        // jednowyrazowy
        Author author = new Author("empty", "empty");
        pManager.addAuthor(author);
        Book b1 = new Book("empty", author);
        bookshelf.addBook(b1);
        bMiddleware.check(("remove book " + b1.getTitle() + " : " + b1.getAuthor()).split(" "));
        assertEquals(0, bookshelf.getSize());

        // kilkuwyrazowy
        b1.setAuthor(new Author("name","name2"));
        b1.setTitle("Title title2");
        bookshelf.addBook(b1);
        bMiddleware.check(("remove book " + b1.getTitle() + " : " +  b1.getAuthor()).split(" "));
        assertEquals(0, bookshelf.getSize());

        // check ownera
        Person person = new Person("name","surname");
        pManager.addPerson(person);
        b1.setOwner(person);
        bookshelf.addBook(b1);
        bMiddleware.check(("remove book " + b1.getTitle() + " : " +  b1.getAuthor()).split(" "));
        assertEquals(0, bookshelf.getSize());
        assertEquals(0, person.getBooks().size());
    }
}
