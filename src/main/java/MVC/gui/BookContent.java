package MVC.gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MVC.objects.Book;

public class BookContent extends Content {
    private Book book;

    private JButton modifyButton = new JButton("modyfikuj");

    public BookContent(Book book) {
        super("Książka", "Autor");
        this.book = book;
        nameField.setText(book.getTitle());
        authorField.setText(book.getAuthor());

        modifyButton.addActionListener(new ModifyAction());
        add(modifyButton);
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

    private class ModifyAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            book.setTitle(nameField.getText());
            book.setAuthor(authorField.getText());
        }
    }
}
