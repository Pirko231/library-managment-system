package MVC.commandChain;

public class HelpMiddleware extends Middleware {

    public HelpMiddleware() {

    }

    public boolean check(String[] args) {
        if (args.length > 0 && (args[0].equals("help") || args[0].equals("Help") || args[0].equals("h"))) {
            text();
            return true;
        }

        return checkNext(args);
    }

    private void text() {
        System.out.println("Commands: ");
        System.out.println("Get help: help | Help | h");
        System.out.println("Add book: add book title,author");
        System.out.println("Add person: add person name:surname");
        System.out.println("Add book owner: add owner title personHash");
        System.out.println("Get books (book name + owner): books");
        System.out.println("Get people (personHash): people");
        System.out.println("Quit: q | quit");
    }
}
