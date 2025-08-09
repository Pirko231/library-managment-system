package MVC;
import MVC.objects.*;
import java.util.Optional;
import java.util.Scanner;


public class TerminalView implements View
{
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void draw()
    {
        
    }
    @Override
    public Optional<Book> addBook()
    {
        
        if(scanner.hasNextLine())
        {
            Book book = new Book("","");
            String line = new String();
            line = scanner.nextLine();
            book.setTitle(line.substring(0, line.indexOf(',')));
            book.setAuthor(line.substring(line.indexOf(',') + 1, line.length()));
            return Optional.of(book);
        }
        
        return Optional.empty();
    }
}