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
        if (args.length > 1 && args[0].equals("add")) // dwa elementy
        {
            String data = args[1];
            if (data.contains(",")) {
                String title = data.substring(0, args[1].indexOf(','));
                String author = data.substring(args[1].indexOf(',') + 1);
                bookshelf.addBook(new Book(title, author));
                System.out.println("Dodano ksiazke");
                return true;

            }
        }
        System.out.println("Nie dodano ksiazki");
        return checkNext(args);
    }
}
