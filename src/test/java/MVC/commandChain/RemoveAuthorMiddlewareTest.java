package MVC.commandChain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import MVC.objects.*;

public class RemoveAuthorMiddlewareTest {
    
    @Test
    public void testCheck() {
        PersonManager pManager = new PersonManager();
        Bookshelf bookshelf = new Bookshelf(pManager);
        RemoveAuthorMiddleware bMiddleware = new RemoveAuthorMiddleware(pManager);

        Author author = new Author("name", "surname");
        pManager.addAuthor(author);

        bMiddleware.check(("remove author " + author.getHash()).split(" "));
        assertEquals(0, pManager.getAuthorSize());
    }
}
