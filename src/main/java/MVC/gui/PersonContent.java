package MVC.gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;

import MVC.objects.Book;
import MVC.objects.Person;

public class PersonContent extends Content {
    private Person person;
    private static List<Book> books;

    public static void setBooks(List<Book> b) {
        books = b;
    }

    private JList<String> bookList = new JList<>();
    private JButton modifyButton = new JButton("modyfikuj");

    public PersonContent(Person person) {
        super("Imię", "Nazwisko");
        this.person = person;
        nameField.setText(person.getName());
        authorField.setText(person.getSurname());

        bookList.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        fetchBooks();

        modifyButton.addActionListener(new ModifyAction());
        add(modifyButton);
        add(new JScrollPane(bookList));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void fetchBooks() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for(var val : books) {
            if (val.getOwner() == person) {
                model.addElement("Tytuł: " + val.getTitle() + "  Autor: " + val.getAuthor());
            }
            
        }
                
       
        bookList.setModel(model);
    }

    private class ModifyAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            person.setName(nameField.getText());
            person.setSurname(authorField.getText());
        }
    }
}
