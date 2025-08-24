package MVC.gui;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class CategoryObjectGroup extends JPanel {
    private String code;

    public CategoryObjectGroup(String code, CategoryObject... objects) {
        this.code = code;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentY(LEFT_ALIGNMENT);
        for (var object : objects) {
            add(object);
        }

        
    }

    public String getCode() {
        return code;
    }

    public void setContent(List<? extends CategoryObject> content) {
        removeAll();
        for (var o : content) {
            add(o);
        }
    }
}
