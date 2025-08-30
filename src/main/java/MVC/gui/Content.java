package MVC.gui;

import java.awt.Graphics;
import java.util.function.BiFunction;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MVC.objects.Author;
import MVC.objects.Person;

import java.awt.Component;
import java.awt.Dimension;

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

class ComboBoxAuthor {
    public String name;
    public Author author;

    public ComboBoxAuthor(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        if (author != null) {
            return author.getName() + " " + author.getSurname();
        }
        else {
            return name;
        }
    }
}

// klasa ktora pozwala wyswietlac informacje o obecnym produkcie
public abstract class Content extends JPanel {

    protected JTextField nameField = new JTextField(20);
    protected JComboBox<ComboBoxAuthor> authorField = new JComboBox<>();

    protected Content(String box1, String box2) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        nameField.setAlignmentX(Component.LEFT_ALIGNMENT);
        authorField.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, nameField.getPreferredSize().height));
        authorField.setMaximumSize(new Dimension(Integer.MAX_VALUE, authorField.getPreferredSize().height));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
