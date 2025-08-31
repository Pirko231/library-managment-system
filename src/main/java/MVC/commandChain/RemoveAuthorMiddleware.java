package MVC.commandChain;

import MVC.objects.Author;
import MVC.objects.Person;
import MVC.objects.PersonManager;

public class RemoveAuthorMiddleware extends Middleware {
    private PersonManager personManager;

    public RemoveAuthorMiddleware(PersonManager personManager) {
        this.personManager = personManager;
    }

    public boolean check(String[] args) {
        if (args.length > 2 && args[0].equals("remove") && args[1].equals("author")) {
            Author author = personManager.findAuthor(args[2]);
            boolean succes = personManager.removeAuthor(author);
            if (succes) {
                author.removeAll();
                System.out.println("Author was deleted");
                return true;
            }
        }
        return checkNext(args);
    }
}
