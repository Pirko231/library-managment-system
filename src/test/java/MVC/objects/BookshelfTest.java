package MVC.objects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookshelfTest {
    
    @Test
    public void testAddBook() {
        Bookshelf bookshelf = new Bookshelf("", null);
        assertEquals(0, bookshelf.getSize());
        bookshelf.addBook(new Book());
        assertEquals(1, bookshelf.getSize());
    }

    @Test
    public void testRemoveBook() {
        Bookshelf bookshelf = new Bookshelf("", null);
        Book b = new Book();
        bookshelf.addBook(b);
        assertEquals(true, bookshelf.removeBook(b));
        assertEquals(0, bookshelf.getSize());
    }

    @Test
    public void testFindBook() {
        Bookshelf bookshelf = new Bookshelf("", null);
        Book b = new Book();
        bookshelf.addBook(b);
        assertEquals(b, bookshelf.findBook(b.getTitle()));
    }
}
