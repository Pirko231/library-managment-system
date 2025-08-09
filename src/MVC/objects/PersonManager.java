package MVC.objects;

import java.util.ArrayList;

public class PersonManager {

    private ArrayList<Person> people = new ArrayList<>();

    public PersonManager() {

    }

    public void addPerson(Person person) {
        people.add(person);
    }
}
