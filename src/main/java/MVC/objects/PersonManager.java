package MVC.objects;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonManager implements Serializable {

    private ArrayList<Person> people = new ArrayList<>();
    private int code = 0;

    public PersonManager(String filename) {
        //code = loadPeople(filename);
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

    // zwraca najwyzszy wczytany kod
    private int loadPeople(String filename) {
        int maxCode = 0;
        try {
            java.io.File file = new java.io.File(filename);
            java.util.Scanner scanner = new java.util.Scanner(file);
            file.setReadable(true);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String name = line.substring(1, line.indexOf(','));
                String surname = line.substring(line.indexOf(',') + 1, line.indexOf('}'));
                int code = Integer.valueOf(line.substring(line.indexOf('_') + 1, line.length()));
                if (code > maxCode) {
                    maxCode = code;
                }
                Person person = new Person(name, surname);
                person.setCode(code);
                people.add(person);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("File didn't open: " + filename);
        }
        System.out.print("People: ");
        System.out.println(people);
        return maxCode;
    }

    public void savePeople(String filename) {
        
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(filename));
            for (Person person : people) {
                stream.writeObject(person);
            }
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
