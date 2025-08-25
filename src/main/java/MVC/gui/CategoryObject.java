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
import MVC.objects.Person;

public class CategoryObject extends JButton {
    static ContentRef currentContent;

    //private JButton button;
    private Content onClicked;

    public CategoryObject(String name, Content onClicked) {
        super(name);
        addActionListener(new ClickListener());
        this.onClicked = onClicked;
    }

    public static void setCurrentContent(ContentRef content) {
        currentContent = content;
    }

    public static List<CategoryObject> toCategoryObject(List<? extends Categorizable> objects) {
        var stream = objects.stream();
        List<CategoryObject> list = stream.map(Categorizable::asCategoryObject)
            .collect(Collectors.toList());
        return list;
    }

    private class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentContent.setContent(onClicked);
        }
    }
}
