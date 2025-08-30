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
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import MVC.Controller;
import MVC.objects.Book;
import MVC.objects.Person;

public class PersonContent extends Content {
    private Person person;
    private static Controller controller;
    private static List<Book> books;

    public static void setData(List<Book> b, Controller c) {
        books = b;
        controller = c;
    }

    private JList<String> bookList = new JList<>();
    private JPanel buttons = new JPanel();

    public PersonContent(Person person) {
        super("Imię", "Nazwisko");
        this.person = person;
        nameField.setText(person.getName());
        authorField.setText(person.getSurname());

        bookList.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        fetchBooks();

        buttons.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        JButton modifyButton = new JButton("Modyfikuj");
        modifyButton.addActionListener(new ModifyAction());
        JButton deleteButton = new JButton("Usuń");
        deleteButton.addActionListener(new DeleteAction());
        buttons.add(modifyButton);
        buttons.add(deleteButton);
        add(buttons);
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

    private class DeleteAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            controller.removePerson(person.getHash());
        }
    }
}
