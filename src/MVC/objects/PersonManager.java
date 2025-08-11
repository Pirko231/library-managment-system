package MVC.objects;

import java.util.ArrayList;

public class PersonManager {

    private ArrayList<Person> people = new ArrayList<>();

    public PersonManager(String filename) {
        loadPeople(filename);
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

    public boolean removePerson(Person person) {
        return people.remove(person);
    }

    private void loadPeople(String filename) {
        try {
            java.io.File file = new java.io.File(filename);
            java.util.Scanner scanner = new java.util.Scanner(file);
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String name = line.substring(1, line.indexOf(','));
                String surname = line.substring(line.indexOf(',') + 1, line.indexOf('}'));
                int code = Integer.valueOf(line.substring(line.indexOf('_') + 1, line.length()));
                Person person = new Person(name, surname);
                person.setCode(code);
                people.add(person);
            }

        } catch (Exception e) {
            System.out.println("File didn't open: " + filename);
        }
    }

    public void savePeople(String filename) {
        try {
            java.io.Writer writer = new java.io.FileWriter(filename);
            for (Person person : people) {
                writer.write(person.getHash() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
