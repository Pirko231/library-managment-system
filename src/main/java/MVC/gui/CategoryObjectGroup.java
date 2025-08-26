package MVC.gui;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import MVC.objects.Person;
import MVC.objects.PersonManager;

public class CategoryObjectGroup extends JPanel {
    private String code;
    private CategoryAddObject addButton;

    public CategoryObjectGroup(String code, CategoryAddObject addButton, CategoryObject... objects) {
        this.code = code;
        this.addButton = addButton;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentY(LEFT_ALIGNMENT);
        add(addButton);
        for (var object : objects) {
            add(object);
        }

        
    }

    public String getCode() {
        return code;
    }

    public void setContent(List<? extends CategoryObject> content) {
        removeAll();
        add(addButton);
        for (var o : content) {
            add(o);
        }
        revalidate();
        repaint();
    }

    public void fetchPeople(List<Person> people) {
        
    }
}
