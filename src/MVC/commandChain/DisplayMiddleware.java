package MVC.commandChain;

import MVC.objects.*;

public class DisplayMiddleware extends Middleware {

    private Bookshelf bookshelf;
    private PersonManager personManager;

    public DisplayMiddleware(Bookshelf bookshelf, PersonManager personManager) {
        this.bookshelf = bookshelf;
        this.personManager = personManager;
    }

    @Override
    public boolean check(String[] args) {
        if (args.length <= 0) {
            return checkNext(args);
        }
        // sprawdzamy czy to odpowiednie argumenty
        if (args[0].equals("books")) {
            bookshelf.display();
            return true;
        } else if (args[0].equals("people")) {
            personManager.display();
            return true;
        }

        return checkNext(args);
    }
}
