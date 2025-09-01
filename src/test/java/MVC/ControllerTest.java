package MVC;

import org.junit.jupiter.api.Test;

import MVC.objects.Author;
import MVC.objects.Book;
import MVC.objects.Person;
import MVC.objects.PersonManager;

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

        Book b1 = new Book("Tytuł", null);
        model.getBooks().add(b1);
        controller.removeBook(b1.getTitle(), b1.getAuthor());
        assertEquals(0, model.getBooks().size());

        Author a1 = new Author("name", "surname");
        model.getAuthors().add(a1);
        b1.setAuthor(a1);
        model.getBooks().add(b1);
        controller.removeBook(b1.getTitle(), a1);
        assertEquals(0, model.getBooks().size());

        Person p1 = new Person("name", "surname");
        model.getPeople().add(p1);
        b1.setOwner(p1);
        model.getBooks().add(b1);
        controller.removeBook(b1.getTitle(), null);
        assertEquals(1, model.getBooks().size());
        controller.removeBook(b1.getTitle(), a1);
        assertEquals(0, model.getBooks().size());
    }

    @Test
    public void testAddAuthor() {
        AtomicBoolean running = new AtomicBoolean(true);
        Model model = new DefaultModel(running);
        Controller controller = new Controller(model,running);

        controller.addAuthor("name","surname");
        assertEquals(1, model.getAuthors().size());
        assertEquals(new Author("name", "surname"), model.getAuthors().get(0));
    
        controller.addAuthor("name","");
        assertEquals(2, model.getAuthors().size());
        assertEquals(new Author("name", ""), model.getAuthors().get(1));

        controller.addAuthor("","surname");
        assertEquals(3, model.getAuthors().size());
        assertEquals(new Author("", "surname"), model.getAuthors().get(2));
    }

    @Test
    public void testRemoveAuthor() {
        AtomicBoolean running = new AtomicBoolean(true);
        Model model = new DefaultModel(running);
        Controller controller = new Controller(model,running);

        PersonManager pManager = new PersonManager();
        Author a1 = new Author("name", "surname");
        pManager.addAuthor(a1);

        model.getAuthors().add(a1);

        controller.removeAuthor(a1.getHash());
        assertEquals(0, model.getAuthors().size());
    }

    @Test
    public void testAddPerson() {
        AtomicBoolean running = new AtomicBoolean(true);
        Model model = new DefaultModel(running);
        Controller controller = new Controller(model,running);

        controller.addPerson("name", "surname");
        assertEquals(1, model.getPeople().size());
        assertEquals(new Person("name", "surname"), model.getPeople().get(0));

        controller.addPerson("name", "");
        assertEquals(2, model.getPeople().size());
        assertEquals(new Person("name", ""), model.getPeople().get(1));

        controller.addPerson("", "surname");
        assertEquals(3, model.getPeople().size());
        assertEquals(new Person("", "surname"), model.getPeople().get(2));
    }

    @Test
    public void testRemovePerson() {
        AtomicBoolean running = new AtomicBoolean(true);
        Model model = new DefaultModel(running);
        Controller controller = new Controller(model,running);

        PersonManager pManager = new PersonManager();
        Person p1 = new Person("name", "surname");
        pManager.addPerson(p1);

        model.getPeople().add(p1);

        controller.removePerson(p1.getHash());
        assertEquals(0, model.getPeople().size());
    }
}
