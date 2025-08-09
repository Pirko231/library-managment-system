package MVC;
import MVC.objects.Book;
import java.util.Optional;


public interface View
{
    public void draw();

    public Optional<Book> addBook();
}