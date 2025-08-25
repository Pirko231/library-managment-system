package MVC.gui;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import MVC.objects.Book;

public class BookContent extends Content {
    private Book book;

    public BookContent(Book book) {
        super("Książka", "Autor");
        this.book = book;
        nameField.setText(book.getTitle());
        authorField.setText(book.getAuthor());
        bookName = "Empty name";
        authorName = "Empty name";
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
}
