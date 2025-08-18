package MVC.objects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    
    @Test
    public void testSetOwner(Person owner) {
        Book book = new Book();
        Person person = new Person("name","surname");
        book.setOwner(person);
        assertEquals(book.getOwner(), person);
        Person person2 = new Person("name2", "surname2");
        book.setOwner(person2);
        assertEquals(book.getOwner(), person2);
    }

    @Test public void testRemoveOwner() {
        Book book = new Book();
        Person person = new Person("name","surname");
        book.setOwner(person);
        book.removeOwner();
        assertEquals(book.getOwner(), null);
    }
}
