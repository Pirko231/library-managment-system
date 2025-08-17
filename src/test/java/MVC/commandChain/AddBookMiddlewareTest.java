package MVC.commandChain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import MVC.objects.*;

public class AddBookMiddlewareTest {
    @Test
    public void testCheck() {
        PersonManager pManager = new PersonManager("");
        Bookshelf bookshelf = new Bookshelf("", pManager);
        AddBookMiddleware bMiddleware = new AddBookMiddleware(bookshelf);

        // invalid syntax
        bMiddleware.check("add book bk:auth".split(" "));
        assertEquals(bookshelf.getSize(), 0);
        bMiddleware.check("add book bk :auth".split(" "));
        assertEquals(bookshelf.getSize(), 0);
        bMiddleware.check("add book bk: auth".split(" "));
        assertEquals(bookshelf.getSize(), 0);

        // ksiazka z pojedynczym imieniem
        bMiddleware.check("add book book : author".split(" "));
        assertEquals(bookshelf.findBook("book"), new Book("book", "author"));
    
        // ksiazka z imieniem i autorem skladajacym sie z kilku wyrazow
        bMiddleware.check("add book Pan Tadeusz : Adam Mickiewicz".split(" "));
        assertEquals(bookshelf.findBook("Pan Tadeusz"), new Book("Pan Tadeusz", "Adam Mickiewicz"));
    }
}
