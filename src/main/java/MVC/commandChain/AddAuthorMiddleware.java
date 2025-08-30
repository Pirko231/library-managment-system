package MVC.commandChain;

import MVC.objects.Author;
import MVC.objects.Person;
import MVC.objects.PersonManager;

public class AddAuthorMiddleware extends Middleware {
    private PersonManager personManager;

    public AddAuthorMiddleware(PersonManager pManager) {
        personManager = pManager;
    }

    @Override
    public boolean check(String[] args) {
        if (args.length > 2 && args[0].equals("add") && (args[1].equals("author") || args[1].equals("Author"))) {
            String data = args[2];
            if (data.contains(":")) {
                String name = new String(data.substring(0, data.indexOf(':')));
                String surname = new String(data.substring(data.indexOf(':') + 1, data.length()));
                personManager.addAuthor(new Author(name, surname));
                System.out.println("Author was added");
                return true;
            }
        }
        return checkNext(args);
    }
    
}
