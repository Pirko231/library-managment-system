package MVC.commandChain;

import MVC.objects.Person;
import MVC.objects.PersonManager;

public class AddPersonMiddleware extends Middleware {

    private PersonManager personManager;

    public AddPersonMiddleware(PersonManager personManager) {
        this.personManager = personManager;
    }

    @Override
    public boolean check(String[] args) {
        if (args.length > 2 && args[0].equals("add") && (args[1].equals("person") || args[1].equals("Person"))) {
            String data = args[2];
            if (data.contains(":")) {
                String name = new String(data.substring(0, data.indexOf(':')));
                String surname = new String(data.substring(data.indexOf(':') + 1, data.length()));
                personManager.addPerson(new Person(name, surname));
                System.out.println("Dodano osobe");
                return true;
            }
        }
        System.out.println("Nie dodano osoby");
        return checkNext(args);
    }
}
