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
    JButton addButton = new JButton("Add");

    public AddPersonContent(BiFunction<String,String,Void> addBook) {
        super("Imię", "Nazwisko");

        addButton.addActionListener(e -> {addBook.apply(nameField.getText(), authorField.getText()); nameField.setText(""); authorField.setText("");});
        add(addButton);
    }

    private class FetchOwners implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
