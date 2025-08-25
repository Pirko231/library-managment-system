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
    private String bookName;
    private String authorName; // zamiast mozna trzymac po prostu autora?
    
    // komponenty dla swing
    JTextField nameField = new JTextField(20);
    JTextField authorField = new JTextField(20);
    JComboBox<String> ownerList = new JComboBox<>();
    JButton addButton = new JButton("Add");

    public AddPersonContent(BiFunction<String,String,Void> addBook) {
        bookName = "Empty name";
        authorName = "Empty name";
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        nameField.setAlignmentX(Component.LEFT_ALIGNMENT);
        authorField.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, nameField.getPreferredSize().height));
        authorField.setMaximumSize(new Dimension(Integer.MAX_VALUE, authorField.getPreferredSize().height));

        addButton.addActionListener(e -> {bookName = nameField.getText(); authorName = authorField.getText(); nameField.setText(""); authorField.setText(""); addBook.apply(bookName, authorName);});

        add(new JLabel("Imię:"));
        add(nameField);
        add(Box.createVerticalStrut(8));
        add(new JLabel("Nazwisko:"));
        add(authorField);
        //add(ownerList);
        add(addButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void update(String bookName, String authorName) {
        this.bookName = bookName;
        this.authorName = authorName;

        //bookText.setText(bookName);
        //authorText.setText(authorName);
    }

    private class FetchOwners implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
