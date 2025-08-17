package MVC.commandChain;

import MVC.objects.Book;
import MVC.objects.Bookshelf;

public class RemoveBookMiddleware extends Middleware {

    private Bookshelf bookshelf;

    public RemoveBookMiddleware(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }

    public boolean check(String[] args) {
        if (args.length > 2 && args[0].equals("remove") && args[1].equals("book")) {
            Book book = bookshelf.findBook(args[2]);
            boolean succes = bookshelf.removeBook(book);
            if (succes) {
                book.getOwner().removeBook(book);
                System.out.println("Book was deleted");
                return true;
            }
        }
        return checkNext(args);
    }
}
