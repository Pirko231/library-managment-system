package MVC.objects;

import java.util.ArrayList;

public class PersonManager {

    private ArrayList<Person> people = new ArrayList<>();

    public PersonManager() {

    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void display() {
        for (Person p : people) {
            System.out.println(p.getHash());
        }
    }

    // kiedy znajdzie osobe zwroci ja. W przeciwnym razie zwraca null
    public Person findPerson(String hasCode) {
        for (Person person : people) {
            if (person.getHash().equals(hasCode)) {
                return person;
            }
        }
        return null;
    }
}
