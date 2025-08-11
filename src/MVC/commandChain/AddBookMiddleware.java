package MVC.commandChain;

import MVC.objects.Book;
import MVC.objects.Bookshelf;

public class AddBookMiddleware extends Middleware {

    private final Bookshelf bookshelf;

    public AddBookMiddleware(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }

    @Override
    public boolean check(String[] args) {
        if (args.length > 2 && args[0].equals("add") && (args[1].equals("book") || args[1].equals("Book"))) // dwa elementy
        {
            String data = args[2];
            if (data.contains(",")) {
                String title = data.substring(0, data.indexOf(','));
                String author = data.substring(data.indexOf(',') + 1);
                bookshelf.addBook(new Book(title, author));
                System.out.println("Book was added");
                return true;

            }
        }
        return checkNext(args);
    }
}
