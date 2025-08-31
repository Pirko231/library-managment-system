package MVC.commandChain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import MVC.objects.*;

public class AddAuthorMiddlewareTest {
    
    @Test
    public void testCheck() {
        PersonManager pManager = new PersonManager();
        Bookshelf bookshelf = new Bookshelf(pManager);
        AddAuthorMiddleware bMiddleware = new AddAuthorMiddleware(pManager);

        bMiddleware.check(("add author author:author").split(" "));
        assertEquals(1, pManager.getAuthorSize());
        assertEquals("author", pManager.getAuthors().get(0).getName());

        
    }
}
