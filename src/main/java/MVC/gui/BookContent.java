package MVC.gui;

import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MVC.objects.Book;
import MVC.objects.Person;
import MVC.objects.PersonManager;

class ComboBoxOwner {
    public String name;
    public Person person;

    public ComboBoxOwner(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    @Override
    public String toString() {
        if (person != null) {
            return person.getName() + " " + person.getSurname();
        }
        else {
            return name;
        }
    }
}

public class BookContent extends Content {
    private static List<Person> people;
    private Book book;
    

    private JButton modifyButton = new JButton("modyfikuj");
    private JComboBox<ComboBoxOwner> ownerList = new JComboBox<>();

    public static void setPeople(List<Person> p) {
        people = p;
    }

    public BookContent(Book book) {
        super("Książka", "Autor");
        this.book = book;
        nameField.setText(book.getTitle());
        authorField.setText(book.getAuthor());

        JLabel ownerLabel = new JLabel("Właściciel");
        add(ownerLabel);

        ownerList.setAlignmentX(LEFT_ALIGNMENT);
        ownerList.addActionListener(new SelectOwnerAction());
        fetchPeople();
        add(ownerList);
        modifyButton.addActionListener(new ModifyAction());
        add(modifyButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void setBookName(String name) {
        nameField.setText(name);
    }

    public void setAuthorName(String name) {
        authorField.setText(name);
    }

    private void fetchPeople() {
        Person person = book.getOwner();
        ownerList.addItem(new ComboBoxOwner("Brak", null));
        if (person != null) {
            var current = new ComboBoxOwner(person.getName() + " " + person.getSurname(), person);
            ownerList.addItem(current);
            ownerList.setSelectedItem(current);
        }
        

        for (var p : people) {
            if (p != null) {
                if (person != null && (p.getName() + " " + p.getSurname()).equals(person.getName() + " " + person.getSurname())) {

                } else {
                    ownerList.addItem(new ComboBoxOwner(p.getName() + " " + p.getSurname(), p));
                }
                
            }
        }
    }

    private class ModifyAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            book.setTitle(nameField.getText());
            book.setAuthor(authorField.getText());
        }
    }

    private class SelectOwnerAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ComboBoxOwner o = (ComboBoxOwner)ownerList.getSelectedItem();
            book.setOwner(o.person);
        }
    }
}
