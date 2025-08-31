package MVC.commandChain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import MVC.objects.*;

public class AddBookMiddlewareTest {
    @Test
    public void testCheck() {
        PersonManager pManager = new PersonManager();
        Bookshelf bookshelf = new Bookshelf(pManager);
        AddBookMiddleware bMiddleware = new AddBookMiddleware(bookshelf);

        bMiddleware.check("add book bk:auth".split(" "));
        assertEquals(1, bookshelf.getSize());
        bMiddleware.check("add book bk :auth".split(" "));
        assertEquals(2, bookshelf.getSize());
        bMiddleware.check("add book bk: auth".split(" "));
        assertEquals(3, bookshelf.getSize());

        // ksiazka z pojedynczym imieniem
        bMiddleware.check("add book name of the book".split(" "));
        assertEquals(bookshelf.findBook("name of the book"), new Book("name of the book", null));
    
        // ksiazka z imieniem i autorem skladajacym sie z kilku wyrazow
        bMiddleware.check("add book Pan Tadeusz".split(" "));
        assertEquals(bookshelf.findBook("Pan Tadeusz"), new Book("Pan Tadeusz", null));
    }
}
