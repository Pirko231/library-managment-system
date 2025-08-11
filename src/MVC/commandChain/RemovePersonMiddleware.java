package MVC.commandChain;

import MVC.objects.Person;
import MVC.objects.PersonManager;

public class RemovePersonMiddleware extends Middleware {

    private PersonManager personManager;

    public RemovePersonMiddleware(PersonManager personManager) {
        this.personManager = personManager;
    }

    public boolean check(String[] args) {
        if (args.length > 2 && args[0].equals("remove") && args[1].equals("person")) {
            Person person = personManager.findPerson(args[2]);
            boolean succes = personManager.removePerson(person);
            if (succes) {
                person.removeAll();
                System.out.println("Person was deleted");
                return true;
            }
        }
        return checkNext(args);
    }
}
