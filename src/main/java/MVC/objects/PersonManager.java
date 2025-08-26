package MVC.objects;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonManager implements Serializable {

    private ArrayList<Person> people = new ArrayList<>();
    private int code = 0;

    public PersonManager() {
        
    }

    public void addPerson(Person person) {
        code++;
        person.setCode(code);
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

    public boolean removePerson(Person person) {
        return people.remove(person);
    }

    public int getSize() {
        return people.size();
    }

    public List<Person> getPeople() {
        return people;
    }
}
