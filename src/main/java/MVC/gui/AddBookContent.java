package MVC.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.List;
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

import MVC.objects.Person;

public class AddBookContent extends Content {
    private static List<Person> people;

    private Person owner = null;
    private JButton addButton = new JButton("Add");
    private JComboBox<ComboBoxOwner> ownerList = new JComboBox<>();

    public static void setPeople(List<Person> p) {
        people = p;
    }

    public AddBookContent(TriFunction<String,String,Person,Void> addBook) {
        super("Książka", "Autor");

        ownerList.setAlignmentX(LEFT_ALIGNMENT);
        ownerList.addActionListener(new SelectOwnerAction());
        fetchPeople();
        add(ownerList);

        addButton.addActionListener(e -> {addBook.apply(nameField.getText(), authorField.getText(), owner); nameField.setText(""); authorField.setText("");ownerList.setSelectedIndex(0);});
        add(addButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void fetchPeople() {
        ownerList.removeAllItems(); 
        ownerList.addItem(new ComboBoxOwner("Brak", null));

        for (var p : people) {
            if (p != null) {
                ownerList.addItem(new ComboBoxOwner(p.getName() + " " + p.getSurname(), p));
            }
        }
        revalidate();
        repaint();
    }

    private class SelectOwnerAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ComboBoxOwner o = (ComboBoxOwner)ownerList.getSelectedItem();
            if (o != null) {
                owner = o.person;
            } else {
                owner = null;
            }
            
        }
    }
}
