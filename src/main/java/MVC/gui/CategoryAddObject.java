package MVC.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BiFunction;

import javax.swing.JButton;

public class CategoryAddObject extends JButton {
    static ContentRef currentContent;
    Content content;

    public static void setCurrentContent(ContentRef content) {
        currentContent = content;
    }

    public CategoryAddObject(Content type) {
        super("add");
        content = type;

        addActionListener(new ChangeCurrentContent());
    }

    private class ChangeCurrentContent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentContent.setContent(content);
        }
    }
}
