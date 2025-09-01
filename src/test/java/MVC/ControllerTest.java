package MVC;

import org.junit.jupiter.api.Test;

import MVC.objects.Author;
import MVC.objects.Book;
import MVC.objects.Person;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicBoolean;

public class ControllerTest {
    
    @Test
    public void testAddBook() {
        AtomicBoolean running = new AtomicBoolean(true);
        Model model = new DefaultModel(running);
        Controller controller = new Controller(model,running);

        // wariant funkcji pierwszy (String)
        controller.addBook("title");
        assertEquals(1, model.getBooks().size());
        assertEquals(new Book("title", null), model.getBooks().get(0));
    
        // wariant funkcji drugi (String, Author, Person)
        Author a1 = new Author("Adam", "Mickiewicz");
        model.getAuthors().add(a1);
        controller.addBook("Pan Tadeusz", a1, null);
        assertEquals(new Book("Pan Tadeusz", a1), model.getBooks().get(1));
        assertEquals(null, model.getBooks().get(1).getOwner());

        Person p1 = new Person("Alwernia", "Obywatel");
        model.getPeople().add(p1);
        controller.addBook("Sonety Krymskie", a1, p1);
        assertEquals(new Book("Sonety Krymskie", a1), model.getBooks().get(2));
        assertEquals(p1, model.getBooks().get(2).getOwner());
    }

    @Test
    public void testRemoveBook() {
        AtomicBoolean running = new AtomicBoolean(true);
        Model model = new DefaultModel(running);
        Controller controller = new Controller(model,running);

        
    }
}
