package MVC.commandChain;
import MVC.objects.Book;
import MVC.objects.Bookshelf;

public class AddBookMiddleware extends Middleware
{
    private final Bookshelf bookshelf;

    public AddBookMiddleware(Bookshelf bookshelf)
    {
        this.bookshelf = bookshelf;
    }

    @Override
    public boolean check(String[] args)
    {
        if(args.length > 1 && args[0].equals("add")) // dwa elementy
        {
            Book book = new Book();
            String title = args[1].substring(0, args[1].indexOf(','));
            String author = args[1].substring(args[1].indexOf(',') + 1);
            book.setAuthor(author); book.setTitle(title);
            bookshelf.addBook(book);
            System.out.println("Dodano ksiazke");
            return true;
        }
        System.out.println("Nie dodano ksiazki");
        return checkNext(args);
    }
}