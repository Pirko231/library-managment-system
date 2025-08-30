package MVC.objects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonManagerTest {
    
    @Test
    public void testAddPerson() {
        PersonManager pManager = new PersonManager();
        pManager.addPerson(new Person("",""));
        assertEquals(1, pManager.getPeopleSize());
    }

    @Test
    public void testFindPerson() {
        PersonManager pManager = new PersonManager();
        Person p = new Person("", "");
        pManager.addPerson(p);
        assertEquals(p, pManager.findPerson(p.getHash()));
    }
}
