package MVC;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.util.Optional;

import MVC.gui.*;

public class GUIView implements View {
    // MVC
    private Controller controller;
    private Model model;

    // swing
    JFrame frame = new JFrame("Tytul");
    private JPanel categoryObjectPanel;
    private CategoryGroup categoryGroup;
    private CategoryObjectGroup books;
    private CategoryObjectGroup people;

    public GUIView(Controller controller, Model model) {
        this.controller = controller;
        this.model = model;
        model.addObserver((Observer)this);

        //frame = ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new CloseEventListener());
        frame.setVisible(true);

        CardLayout cl = new CardLayout();
        categoryObjectPanel = new JPanel(cl);


        ContentRef content = new ContentRef();
        content.setContent(new AddBookContent((s1, s2) -> {controller.addBook(s1, s2); return null;}));
        CategoryObject.setCurrentContent(content);
        CategoryAddObject.setCurrentContent(content);

        categoryGroup = new CategoryGroup(
            new Category("Books", c -> cl.show(categoryObjectPanel, "BOOKS")),
            new Category("People", c -> cl.show(categoryObjectPanel, "PEOPLE"))
        );

        books = new CategoryObjectGroup("BOOKS",
            new CategoryAddObject(new AddBookContent((s1,s2) -> {controller.addBook(s1, s2); return null;}))
        );

        people = new CategoryObjectGroup("PEOPLE",
            new CategoryAddObject(new AddPersonContent((s1,s2) -> {controller.addPerson(s1, s2); return null;}))
        );

        categoryObjectPanel.add(books, books.getCode());
        categoryObjectPanel.add(people, people.getCode());

        JSplitPane splitCategories = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(categoryGroup), categoryObjectPanel);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitCategories, (JPanel)content);
        
        frame.getContentPane().add(BorderLayout.CENTER, splitPane); // west
        frame.setSize(600,600);
    }

    public void update(Model model) {
        books.setContent(CategoryObject.toCategoryObject(model.getBooks()));
        people.setContent(CategoryObject.toCategoryObject(model.getPeople()));
        frame.repaint();
    }

    private class CloseEventListener implements WindowListener {
        public void windowActivated(WindowEvent e) {
            
        }
        public void windowClosed(WindowEvent e) {
            
        }
        public void windowClosing(WindowEvent e) {
            controller.writeToFiles();
        }
        public void windowDeactivated(WindowEvent e) {

        }
        public void windowDeiconified(WindowEvent e) {

        }
        public void windowIconified(WindowEvent e) {

        }
        public void windowOpened(WindowEvent e) {

        }
    }
}
