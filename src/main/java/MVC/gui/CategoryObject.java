package MVC.gui;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CategoryObject extends JButton {
    static Content currentContent;

    //private JButton button;
    private Content onClicked;

    public CategoryObject(String name, Content onClicked) {
        super(name);
        addActionListener(new ClickListener());
        this.onClicked = onClicked;
        //button = new JButton(name);
        //button.addActionListener(new ClickListener());

        //add(button);
    }

    public static void setCurrentContent(Content content) {
        currentContent = content;
    }

    private class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentContent = onClicked;
        }
    }
}
