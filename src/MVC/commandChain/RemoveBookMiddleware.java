package MVC.commandChain;

import MVC.objects.*;

public class RemoveBookMiddleware extends Middleware {
    private Bookshelf bookshelf;

    public RemoveBookMiddleware(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }

    public boolean check(String[] args) {
        if(args.length > 2 && args[0].equals("remove") && args[1].equals("book")) {
            boolean succes = bookshelf.removeBook(bookshelf.findBook(args[2]));
            if(succes) {
                System.out.println("Usunieto ksiazke");
                return true;
            }
        }
        System.out.println("Nie usunieto ksiazki");
        return checkNext(args);
    }
}
