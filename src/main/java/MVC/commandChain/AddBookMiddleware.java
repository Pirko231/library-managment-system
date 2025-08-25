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
        if (args.length > 4 && args[0].equals("add") && (args[1].equals("book") || args[1].equals("Book"))) // dwa elementy
        {
            Book book = handleInput(args);
            bookshelf.addBook(book);
            System.out.println("Book was added");
        }
        return checkNext(args);
    }

    private Book handleInput(String[] args) {
        String title = new String();
        int i = 2;
        for(; i < args.length && !args[i].equals(":"); i++) {
            title += args[i] + " ";
        }
        title = title.substring(0, title.length() - 1);
        i++; // pomijamy znak :
        String author = new String();
        for(; i < args.length; i++) {
            author += args[i] + " ";
        }
        author = author.substring(0, author.length() - 1);
        return new Book(title, author);
    }
}
