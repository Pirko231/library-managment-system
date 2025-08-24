package MVC.gui;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JPanel;

import MVC.objects.Book;

public class CategoryObject extends JButton {
    static Content currentContent;

    //private JButton button;
    private Content onClicked;

    public CategoryObject(String name, Content onClicked) {
        super(name);
        addActionListener(new ClickListener());
        this.onClicked = onClicked;
    }

    public static void setCurrentContent(Content content) {
        currentContent = content;
    }

    public static List<CategoryObject> toCategoryObject(List<Book> books) {
        var stream = books.stream();
        List<CategoryObject> list = stream.map(b -> new CategoryObject(b.getTitle(), currentContent))
            .collect(Collectors.toList());
        return list;
    }

    private class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentContent = onClicked;
        }
    }
}
