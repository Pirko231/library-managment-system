package MVC.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
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

public class AddBookContent extends Content {
    JButton addButton = new JButton("Add");

    public AddBookContent(BiFunction<String,String,Void> addBook) {
        super("Książka", "Autor");

        addButton.addActionListener(e -> {bookName = nameField.getText(); authorName = authorField.getText(); nameField.setText(""); authorField.setText(""); addBook.apply(bookName, authorName);});
        add(addButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void update(String bookName, String authorName) {
        this.bookName = bookName;
        this.authorName = authorName;
    }

    private class FetchOwners implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
