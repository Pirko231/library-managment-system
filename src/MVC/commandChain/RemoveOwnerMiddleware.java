package MVC.commandChain;

import MVC.objects.Book;
import MVC.objects.Bookshelf;

public class RemoveOwnerMiddleware extends Middleware {

    private Bookshelf bookshelf;

    public RemoveOwnerMiddleware(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }

    @Override
    public boolean check(String[] args) {
        if (args.length > 2 && args[0].equals("remove") && args[1].equals("owner")) {
            String title = args[2];
            Book book = bookshelf.findBook(title);
            if (book != null) {
                book.removeOwner();
                System.out.println("Usunieto wlasciciela");
                return true;
            }
        }

        return checkNext(args);
    }
}
