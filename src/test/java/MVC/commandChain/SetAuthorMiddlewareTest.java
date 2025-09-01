package MVC.commandChain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import MVC.objects.Author;
import MVC.objects.Book;
import MVC.objects.Bookshelf;
import MVC.objects.Person;
import MVC.objects.PersonManager;

public class SetAuthorMiddlewareTest {
    
    @Test
    public void testCheck() {
        PersonManager pManager = new PersonManager();
        Bookshelf bookshelf = new Bookshelf(pManager);
        SetAuthorMiddleware aMiddleware = new SetAuthorMiddleware(bookshelf, pManager);
        aMiddleware.check("set author some book : person".split(" ")); // na razie check jakiegos wyjatku
    
        Author a1 = new Author("name","surname");
        pManager.addAuthor(a1);
        aMiddleware.check(("set author some book : " + a1.getHash()).split(" "));
        assertEquals(0, pManager.getAuthors().get(0).getBooks().size());

        Book b1 = new Book();
        bookshelf.addBook(b1);
        aMiddleware.check(("set author " + b1.getTitle() + " : " + a1.getHash()).split(" "));
        assertEquals(a1, b1.getAuthor());
    }
}
