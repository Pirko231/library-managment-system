package MVC.commandChain;

import org.junit.jupiter.api.Test;

import MVC.objects.Book;
import MVC.objects.Bookshelf;
import MVC.objects.Person;
import MVC.objects.PersonManager;

import static org.junit.jupiter.api.Assertions.*;


public class AddOwnerMiddlewareTest {
    
    @Test
    public void testCheck() {
        PersonManager pManager = new PersonManager("");
        Bookshelf bookshelf = new Bookshelf("", pManager);
        AddOwnerMiddleware oMiddleware = new AddOwnerMiddleware(bookshelf, pManager);
        oMiddleware.check("add owner some book : person".split(" ")); // na razie check jakiegos wyjatku

        // dodawanie nowego wlasciciela
        Person person1 = new Person("Name","surname");
        pManager.addPerson(person1);
        Book book1 = new Book("Title", "Author");
        bookshelf.addBook(book1);
        oMiddleware.check(("add owner " + book1.getTitle() + " : " + person1.getHash()).split(" "));
        assertEquals(book1.getOwner(), person1);
        Book result = new Book();
        for(Book book : person1.getBooks()) {
            if (book.equals(book1)) {
                result = book;
                break;
            }
        }
        assertEquals(result, book1);

        // wymienianie wlasciciela
        Person person2 = new Person("Name2", "Surname2");
        pManager.addPerson(person2);
        oMiddleware.check(("add owner " + book1.getTitle() + " : " + person2.getHash()).split(" "));
        assertEquals(book1.getOwner(), person2);
        for(Book book : person2.getBooks()) {
            if (book.equals(book1)) {
                result = book;
                break;
            }
        }
        assertEquals(result, book1);
        assertEquals(person1.getBooks().size(), 0);

    }
}
