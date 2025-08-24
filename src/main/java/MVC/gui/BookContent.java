package MVC.gui;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BookContent extends JPanel implements Content {

    private String bookName;
    private String authorName; // zamiast mozna trzymac po prostu autora?
    
    // komponenty dla swing
    JLabel bookText = new JLabel();
    JLabel authorText = new JLabel();

    public BookContent() {
        bookName = "Empty name";
        authorName = "Empty name";

        Font titleFont = new Font("serif", Font.BOLD, 28);
        bookText.setFont(titleFont);
        authorText.setFont(titleFont);

        add(bookText);
        add(authorText);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void update(String bookName, String authorName) {
        this.bookName = bookName;
        this.authorName = authorName;

        bookText.setText(bookName);
        authorText.setText(authorName);
    }

    public void setBookName(String name) {
        bookName = name;
    }

    public void setAuthorName(String name) {
        authorName = name;
    }
}
