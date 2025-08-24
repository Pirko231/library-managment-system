package MVC;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.util.Optional;

import MVC.gui.*;

public class GUIView implements View {
    public GUIView() {
        JFrame frame = new JFrame("Tytul");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        CardLayout cl = new CardLayout();
        JPanel categoryObjectPanel = new JPanel(cl);


        Content content = null;
        CategoryObject.setCurrentContent(content);

        CategoryGroup categoryGroup = new CategoryGroup(
            new Category("Books", c -> cl.show(categoryObjectPanel, "BOOKS")),
            new Category("People", c -> cl.show(categoryObjectPanel, "PEOPLE"))
        );

        CategoryObjectGroup books = new CategoryObjectGroup("BOOKS",
            new CategoryObject("Alwernia", new BookContent()),
            new CategoryObject("Krzeszowice", new BookContent())
        );

        CategoryObjectGroup people = new CategoryObjectGroup("PEOPLE",
            new CategoryObject("Data1", new BookContent()),
            new CategoryObject("data2", new BookContent()),
            new CategoryObject("data3", new BookContent())
        );

        categoryObjectPanel.add(books, books.getCode());
        categoryObjectPanel.add(people, people.getCode());

        JSplitPane splitCategories = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(categoryGroup), categoryObjectPanel);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitCategories, (JPanel)content);
        
        frame.getContentPane().add(BorderLayout.WEST, splitPane);
    }

    public Optional<String[]> getCommand() {
        return Optional.empty();
    }

    public void update(Model model) {
        
    }
}
