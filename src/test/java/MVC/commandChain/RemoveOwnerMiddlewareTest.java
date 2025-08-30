package MVC.commandChain;

import org.junit.jupiter.api.Test;

import MVC.objects.Bookshelf;
import MVC.objects.PersonManager;
import MVC.objects.*;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveOwnerMiddlewareTest {

    @Test
    public void testCheck() {
        PersonManager pManager = new PersonManager();
        Bookshelf bookshelf = new Bookshelf(pManager);
        RemoveOwnerMiddleware oMiddleware = new RemoveOwnerMiddleware(bookshelf);

        // jednowyrazowe
        Book b = new Book();
        bookshelf.addBook(b);
        Person p = new Person("name","surname");
        b.setOwner(p);
        pManager.addPerson(p);
        oMiddleware.check(("remove owner " + b.getTitle() + " : " + p.getHash()).split(" "));
        assertEquals(null, b.getOwner());
        assertEquals(0, p.getBooks().size());

        // wielowyrazowe
        b.setTitle("Pan Tadeusz");
        b.setAuthor(new Author("Adam","Mickiewicz"));
        b.setOwner(p);
        oMiddleware.check(("remove owner " + b.getTitle() + " : " + p.getHash()).split(" "));
        assertEquals(null, b.getOwner());
        assertEquals(0, p.getBooks().size());
    }
}
