package MVC.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CategoryAddObject extends JButton {
    public CategoryAddObject(ActionListener onClicked) {
        super("add");
        addActionListener(onClicked);
    }
}
