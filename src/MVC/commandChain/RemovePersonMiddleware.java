package MVC.commandChain;

import MVC.objects.*;

public class RemovePersonMiddleware extends Middleware {
    private PersonManager personManager;

    public RemovePersonMiddleware(PersonManager personManager) {
        this.personManager = personManager;
    }

    public boolean check(String[] args) {
        if(args.length > 2 && args[0].equals("remove") && args[1].equals("person")) {
            boolean succes = personManager.removePerson(personManager.findPerson(args[2]));
            if(succes) {
                System.out.println("Usunieto osobe");
                return true;
            }
        }
        System.out.println("Nie usunieto osoby");
        return checkNext(args);
    }
}
