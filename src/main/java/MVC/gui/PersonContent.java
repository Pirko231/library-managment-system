package MVC.gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import MVC.objects.Person;

public class PersonContent extends Content {
    private Person person;

    private JButton modifyButton = new JButton("modyfikuj");

    public PersonContent(Person person) {
        super("Imię", "Nazwisko");
        this.person = person;
        nameField.setText(person.getName());
        authorField.setText(person.getSurname());
        bookName = "Empty name";
        authorName = "Empty name";

        modifyButton.addActionListener(new ModifyAction());
        add(modifyButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void update(String bookName, String authorName) {
        this.bookName = bookName;
        this.authorName = authorName;
    }

    public void setBookName(String name) {
        bookName = name;
    }

    public void setAuthorName(String name) {
        authorName = name;
    }

    private class ModifyAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            person.setName(nameField.getText());
            person.setSurname(authorField.getText());
        }
    }
}
