package MVC;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.Optional;

import MVC.gui.*;

public class GUIView implements View {
    // MVC
    private Controller controller;
    private Model model;

    // swing
    JFrame frame = new JFrame("Biblioteka");
    JFileChooser fileChooser = new JFileChooser();
    private JPanel categoryObjectPanel;
    private CategoryGroup categoryGroup;
    private CategoryObjectGroup books;
    private CategoryObjectGroup people;

    public GUIView(Controller controller, Model model) {
        this.controller = controller;
        this.model = model;
        model.addObserver((Observer)this);

        BookContent.setData(model.getPeople(), controller);
        AddBookContent.setPeople(model.getPeople());
        PersonContent.setData(model.getBooks(), controller);

        //frame = ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new CloseEventListener());
        frame.setVisible(true);

        CardLayout cl = new CardLayout();
        categoryObjectPanel = new JPanel(cl);

        JMenuBar menu = new JMenuBar();
        JMenuItem menuFile = new JMenuItem("Kopia zapasowa");
        menuFile.addActionListener(new Backup());
        JMenuItem menuLoad = new JMenuItem("Załaduj dane");
        menuLoad.addActionListener(e -> fileChooser.showOpenDialog(menuLoad));
        menu.add(menuFile);
        menu.add(menuLoad);
        frame.setJMenuBar(menu);

        var filter = new FileNameExtensionFilter("SER files", "ser");
        fileChooser.setFileFilter(filter);
        File backupDir = new File(System.getProperty("user.dir"), "backups");
        if (!backupDir.exists()) {
            backupDir.mkdirs();
        }
        if (backupDir.isDirectory()) {
            fileChooser.setCurrentDirectory(backupDir);
        }
        fileChooser.addActionListener(new ChooseFile());

        ContentRef content = new ContentRef();
        content.setContent(new AddBookContent((s1, s2, p) -> {controller.addBook(s1, s2, p); return null;}));
        CategoryObject.setCurrentContent(content);
        CategoryAddObject.setCurrentContent(content);

        categoryGroup = new CategoryGroup(
            new Category("Books", c -> cl.show(categoryObjectPanel, "BOOKS")),
            new Category("People", c -> cl.show(categoryObjectPanel, "PEOPLE"))
        );

        books = new CategoryObjectGroup("BOOKS",
            new CategoryAddObject(new AddBookContent((s1,s2, p) -> {controller.addBook(s1, s2, p); return null;}))
        );

        people = new CategoryObjectGroup("PEOPLE",
            new CategoryAddObject(new AddPersonContent((s1,s2) -> {controller.addPerson(s1, s2); return null;}))
        );

        categoryObjectPanel.add(books, books.getCode());
        categoryObjectPanel.add(people, people.getCode());

        JSplitPane splitCategories = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(categoryGroup), categoryObjectPanel);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitCategories, (JPanel)content);
        
        update(model);
        frame.getContentPane().add(BorderLayout.CENTER, splitPane); // west
        frame.setSize(600,600);
    }

    public void update(Model model) {
        books.setContent(CategoryObject.toCategoryObject(model.getBooks()));
        people.setContent(CategoryObject.toCategoryObject(model.getPeople()));
        books.fetchPeople(model.getPeople());
        frame.repaint();
    }

    private void revalidateAll() {
        books.revalidate();
        books.repaint();
        people.revalidate();
        people.repaint();
        categoryObjectPanel.revalidate();
        categoryObjectPanel.repaint();
        frame.revalidate();
        frame.repaint();
    }

    private class Backup implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            File directory = new File("backups/");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            controller.writeToFiles(new File("backups/Backup " + LocalDate.now().toString() + " " + LocalTime.now().toString() + ".ser"));
        }
    }

    private class ChooseFile implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            File f = fileChooser.getSelectedFile();
            try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(f))) {
                controller.readFile(f);
                revalidateAll();
            } catch(Exception ex) {

            }
            
        }
    }

    private class CloseEventListener implements WindowListener {
        public void windowActivated(WindowEvent e) {
            
        }
        public void windowClosed(WindowEvent e) {

        }
        public void windowClosing(WindowEvent e) {
            controller.writeToFiles(new File("data.ser"));
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
