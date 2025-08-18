package MVC.commandChain;

import MVC.objects.Book;
import MVC.objects.Bookshelf;

public class RemoveBookMiddleware extends Middleware {

    private Bookshelf bookshelf;

    public RemoveBookMiddleware(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }

    public boolean check(String[] args) {
        if (args.length > 4 && args[0].equals("remove") && args[1].equals("book")) {
            handleInput(args);
        }
        return checkNext(args);
    }

    private void handleInput(String[] args) {
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

        Book book = bookshelf.findBook(new Book(title, author));
        boolean succes = bookshelf.removeBook(book);
        if (succes) {
            if (book.getOwner() != null) {
                book.getOwner().removeBook(book);
            }
            System.out.println("Book was deleted");
        }
    }
}
