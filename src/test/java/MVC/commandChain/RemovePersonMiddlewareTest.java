package MVC.commandChain;

import org.junit.jupiter.api.Test;

import MVC.objects.Bookshelf;
import MVC.objects.PersonManager;
import MVC.objects.*;

import static org.junit.jupiter.api.Assertions.*;

public class RemovePersonMiddlewareTest {
    
    @Test
    public void testCheck() {
        PersonManager pManager = new PersonManager("");
        Bookshelf bookshelf = new Bookshelf("", pManager);
        RemovePersonMiddleware pMiddleware = new RemovePersonMiddleware(pManager);

        // test zwyklego usuwania
        Person p = new Person("name", "surname");
        pManager.addPerson(p);
        pMiddleware.check(("remove person " + p.getHash()).split(" "));
        assertEquals(0, pManager.getSize());

        // test usuwania razem z ownerem
        Book b = new Book();
        bookshelf.addBook(b);
        b.setOwner(p);
        pManager.addPerson(p);
        pMiddleware.check(("remove person " + p.getHash()).split(" "));
        assertEquals(0, pManager.getSize());
        assertEquals(null, b.getOwner());
        assertEquals(0, p.getBooks().size());
    }
}
