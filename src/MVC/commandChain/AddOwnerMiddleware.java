package MVC.commandChain;

import java.io.IOException;

import MVC.objects.Book;
import MVC.objects.Bookshelf;
import MVC.objects.Person;
import MVC.objects.PersonManager;

public class AddOwnerMiddleware extends Middleware {

    private Bookshelf bookshelf;
    private PersonManager personManager;

    public AddOwnerMiddleware(Bookshelf bookshelf, PersonManager personManager) {
        this.bookshelf = bookshelf;
        this.personManager = personManager;
    }

    @Override
    public boolean check(String[] args) {
        if (args.length > 3 && args[0].equals("add") && (args[1].equals("owner") || args[1].equals("Owner"))) {
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
            Person owner = personManager.findPerson(hash);
            if (owner != null) {
                book.setOwner(owner);
                owner.addBook(book);
                System.out.println("Owner was added");
                return true;
            }
        }
        return false;
    }
}
