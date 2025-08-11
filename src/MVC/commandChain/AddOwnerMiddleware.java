package MVC.commandChain;

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
            String title = args[2];
            Book book = bookshelf.findBook(title);
            if (book != null) {
                String hash = args[3];
                Person owner = personManager.findPerson(hash);
                if (owner != null) {
                    book.setOwner(owner);
                    System.out.println("Owner was added");
                    return true;
                }
            }
        }
        return checkNext(args);
    }
}
