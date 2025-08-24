package MVC.gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Category extends JButton {
    //private JButton button;

    public Category(String name, ActionListener actionOnClick) {
        super(name);
        addActionListener(actionOnClick);
        //button = new JButton(name);
        //button.addActionListener(actionOnClick);
        //add(button);
    }
}
