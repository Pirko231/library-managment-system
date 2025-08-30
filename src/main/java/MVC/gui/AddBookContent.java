package MVC.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import MVC.objects.Author;
import MVC.objects.Person;

public class AddBookContent extends Content {
    private static List<Person> people;
    private static List<Author> authors;

    private Person owner = null;
    private Author author = null;
    private JButton addButton = new JButton("Dodaj");
    private JComboBox<ComboBoxOwner> ownerList = new JComboBox<>();
    private JComboBox<ComboBoxAuthor> authorList = new JComboBox<>();

    public static void setPeople(List<Person> p, List<Author> a) {
        people = p;
        authors = a;
    }

    public AddBookContent(TriFunction<String,Author,Person,Void> addBook) {
        super("Książka", "Autor");

        add(new JLabel("Książka"));
        add(nameField);
        add(new JLabel("Autor"));

        authorList.setAlignmentX(LEFT_ALIGNMENT);
        authorList.addActionListener(new SelectAuthorAction());
        fetchAuthors();
        add(authorList);

        add(new JLabel("Właściciel"));
        ownerList.setAlignmentX(LEFT_ALIGNMENT);
        ownerList.addActionListener(new SelectOwnerAction());
        fetchPeople();
        add(ownerList);

        addButton.addActionListener(e -> {addBook.apply(nameField.getText(), author, owner); nameField.setText(""); ownerList.setSelectedIndex(0);});
        add(addButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void fetchPeople() {
        ownerList.removeAllItems(); 
        ownerList.addItem(new ComboBoxOwner("Brak", null));

        for (var p : people) {
            if (p != null) {
                ownerList.addItem(new ComboBoxOwner(p.getName() + " " + p.getSurname(), p));
            }
        }
        revalidate();
        repaint();
    }

    public void fetchAuthors() {
        authorList.addItem(new ComboBoxAuthor("Brak", null));
        if (author != null) {
            var current = new ComboBoxAuthor(author.getName() + " " + author.getSurname(), author);
            authorList.addItem(current);
            authorList.setSelectedItem(current);
        }
        

        for (var a : authors) {
            if (a != null) {
                if (author != null && (a.getName() + " " + a.getSurname()).equals(author.getName() + " " + author.getSurname())) {

                } else {
                    authorList.addItem(new ComboBoxAuthor(a.getName() + " " + a.getSurname(), a));
                }
                
            }
        }
    }

    private class SelectOwnerAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ComboBoxOwner o = (ComboBoxOwner)ownerList.getSelectedItem();
            if (o != null) {
                owner = o.person;
            } else {
                owner = null;
            }
            
        }
    }

    private class SelectAuthorAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ComboBoxAuthor o = (ComboBoxAuthor)authorList.getSelectedItem();
            author = o.author;
        }
    }
}
