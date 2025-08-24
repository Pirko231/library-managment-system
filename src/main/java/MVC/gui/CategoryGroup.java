package MVC.gui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class CategoryGroup extends JPanel {
    
    public CategoryGroup(Category... categories) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for(var category : categories) {
            add(category);
        }
    }
}
