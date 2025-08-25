package MVC.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CategoryAddObject extends JButton {
    static ContentRef currentContent;
    Content content;

    public static void setCurrentContent(ContentRef content) {
        currentContent = content;
    }

    public CategoryAddObject(ActionListener onClicked) {
        super("add");
        //content = new AddBookContent(onClicked);

        addActionListener(new ChangeCurrentContent());
    }

    private class ChangeCurrentContent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentContent.content = content;
        }
    }
}
