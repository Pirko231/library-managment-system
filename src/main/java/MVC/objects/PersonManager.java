package MVC.objects;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonManager implements Serializable {

    private ArrayList<Person> people = new ArrayList<>();
    private ArrayList<Author> authors = new ArrayList<>();
    private int code = 0;

    public PersonManager() {
        
    }

    // kopiuje osoby
    public void copy(PersonManager pManager) {
        people.clear();
        for (Person person : pManager.getPeople()) {
            people.add(person);
        }
    }

    public void addPerson(Person person) {
        code++;
        person.setCode(code);
        people.add(person);
    }

    public void addAuthor(Author author) {
        code++;
        author.setCode(code);
        authors.add(author);
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

    public int getPeopleSize() {
        return people.size();
    }

    public List<Person> getPeople() {
        return people;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public int getAuthorSize() {
        return authors.size();
    }

    public Author findAuthor(String hasCode) {
        for (Author author : authors) {
            if (author.getHash().equals(hasCode)) {
                return author;
            }
        }
        return null;
    }
}
