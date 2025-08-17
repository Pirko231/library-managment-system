package MVC.commandChain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import MVC.objects.*;

public class AddPersonMiddlewareTest {
    
    @Test
    public void testCheck() {
        PersonManager personManager = new PersonManager("");
        AddPersonMiddleware pMiddleware = new AddPersonMiddleware(personManager);
        pMiddleware.check("add person Name:Surname".split(" "));
        assertEquals(personManager.findPerson("{Name,Surname}_1"), new Person("Name", "Surname"));
    }
}
