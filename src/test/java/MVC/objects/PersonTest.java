package MVC.objects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testAddBook() {
        Person person = new Person("name", "surname");
        person.addBook(new Book());
        assertEquals(person.getBooks().size(), 1);
    }
    
    @Test
    public void testRemoveBook() {
        Person person = new Person("name","surname");
        Book book = new Book();
        book.setOwner(person);
        assertEquals(person.getBooks().get(0), book);
        person.removeBook(book);
        assertEquals(person.getBooks().size(), 0);
    }

    @Test
    public void testRemoveAll() {
        Person person = new Person("name","surname");
        person.removeAll(); // runtime error

        Book b1 = new Book();
        b1.setOwner(person);
        Book b2 = new Book();
        b2.setOwner(person);
        person.removeAll();
        assertEquals(person.getBooks().size(), 0);
    }
}
