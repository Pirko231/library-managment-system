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
            if (handleInput(args)) {
                return true;
            }
        }

        return checkNext(args);
    }

    private boolean handleInput(String[] args) {
        String title = new String();
        int i = 2;
        for(; i < args.length && !args[i].equals(":"); i++) {
            title += args[i] + " ";
        }
        title = title.substring(0, title.length() - 1);
        i++; // pomijamy znak :
        Book book = bookshelf.findBook(title);
        if (book != null) {
            book.getOwner().removeBook(book);
            book.removeOwner();
            System.out.println("Owner was deleted");
            return true;
        }
        return false;
    }
}
