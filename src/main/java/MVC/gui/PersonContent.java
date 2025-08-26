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

        modifyButton.addActionListener(new ModifyAction());
        add(modifyButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private class ModifyAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            person.setName(nameField.getText());
            person.setSurname(authorField.getText());
        }
    }
}
