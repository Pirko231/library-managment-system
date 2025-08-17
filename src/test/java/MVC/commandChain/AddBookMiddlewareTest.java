package MVC.commandChain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import MVC.commandChain.AddBookMiddleware;
import MVC.objects.*;

public class AddBookMiddlewareTest {
    @Test
    public void testCheck() {
        PersonManager pManager = new PersonManager("");
        Bookshelf bookshelf = new Bookshelf("", pManager);
        AddBookMiddleware bMiddleware = new AddBookMiddleware(bookshelf);


        bMiddleware.check("add book book : author".split(" "));
        bookshelf.display();
        assertEquals(bookshelf.findBook("book"), new Book("book", "author"));
    }
}
