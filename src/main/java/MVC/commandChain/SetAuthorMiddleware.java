package MVC.commandChain;

import java.io.IOException;

import MVC.objects.Author;
import MVC.objects.Book;
import MVC.objects.Bookshelf;
import MVC.objects.PersonManager;

public class SetAuthorMiddleware extends Middleware {
    private Bookshelf bookshelf;
    private PersonManager personManager;

    public SetAuthorMiddleware(Bookshelf bookshelf, PersonManager pManager) {
        this.bookshelf = bookshelf;
        personManager = pManager;
    }

    public boolean check(String[] args) {
        if (args.length > 3 && args[0].equals("set") && (args[1].equals("author") || args[1].equals("Author"))) {
            try {
                if (handleInput(args)) {
                    return true;
                }
            }
            catch(IOException e) {

            }
        }
        return checkNext(args);
    }
    
    private boolean handleInput(String[] args) throws IOException {
        String title = "";
        int i = 2;
        for(;i < args.length; i++) {
            if (args[i].equals(":")) {
                for (int j = 2; j < i; j++) {
                    title += args[j] + " ";
                }
                title = title.substring(0, title.length() - 1);
                break;
            }
        }
        if (i == args.length - 1) {
            throw new IOException("Invalid input");
        }

        Book book = bookshelf.findBook(title);
        if (book != null) {
            String hash = args[i + 1];
            Author author = personManager.findAuthor(hash);
            if (author != null) {
                book.setAuthor(author);
                System.out.println("Author was set");
                return true;
            }
        }
        return false;
    }
}
