package MVC.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BiFunction;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddPersonContent extends Content {
    JButton addButton = new JButton("Dodaj");
    private JTextField authorField = new JTextField(20);

    public AddPersonContent(BiFunction<String,String,Void> addBook) {
        super("Imię", "Nazwisko");

        authorField.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(new JLabel("Imię"));
        add(nameField);
        add(Box.createVerticalStrut(8));
        add(new JLabel("Nazwisko"));
        add(authorField);

        addButton.addActionListener(e -> {addBook.apply(nameField.getText(), authorField.getText()); nameField.setText(""); authorField.setText("");});
        add(addButton);
    }

    private class FetchOwners implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
