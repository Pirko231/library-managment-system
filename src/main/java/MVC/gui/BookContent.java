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

import MVC.Controller;
import MVC.objects.Author;
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
    private static Controller controller;
    private Book book;
    

    private JPanel buttons = new JPanel();
    private JComboBox<ComboBoxOwner> ownerList = new JComboBox<>();

    public static void setData(List<Person> p, Controller c) {
        people = p;
        controller = c;
    }

    public BookContent(Book book) {
        super("Książka", "Autor");
        this.book = book;
        nameField.setText(book.getTitle());
        authorField.setText(book.getAuthor().getName() + " " + book.getAuthor().getSurname());

        JLabel ownerLabel = new JLabel("Właściciel");
        add(ownerLabel);

        ownerList.setAlignmentX(LEFT_ALIGNMENT);
        ownerList.addActionListener(new SelectOwnerAction());
        fetchPeople();
        add(ownerList);
        
        buttons.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        JButton modifyButton = new JButton("Modyfikuj");
        modifyButton.addActionListener(new ModifyAction());
        JButton deleteButton = new JButton("Usuń");
        deleteButton.addActionListener(new DeleteAction());
        buttons.add(modifyButton);
        buttons.add(deleteButton);
        
        add(buttons);
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
            String authorText = authorField.getText();
            Author author = new Author(authorText, "");
            if (authorText.contains(" ")) {
                String authorName = authorText.substring(0, authorText.indexOf(" "));
                String authorSurname = authorText.substring(authorText.indexOf(" ") + 1, authorText.length());
                author = new Author(authorName, authorSurname);
            }
            book.setAuthor(author);
        }
    }

    private class DeleteAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            controller.removeBook(book.getTitle(), book.getAuthor());
        }
    }

    private class SelectOwnerAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ComboBoxOwner o = (ComboBoxOwner)ownerList.getSelectedItem();
            book.setOwner(o.person);
        }
    }
}
