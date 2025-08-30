package MVC.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BiFunction;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddAuthorContent extends Content {
    JButton addButton = new JButton("Dodaj");
    private JTextField authorField = new JTextField(20);

    public AddAuthorContent(BiFunction<String,String,Void> addAuthor) {
        super("Imię", "Nazwisko");

        authorField.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(new JLabel("Imię"));
        add(nameField);
        add(Box.createVerticalStrut(8));
        add(new JLabel("Nazwisko"));
        add(authorField);

        addButton.addActionListener(e -> {addAuthor.apply(nameField.getText(), authorField.getText()); nameField.setText(""); authorField.setText("");});
        add(addButton);
    }
}
