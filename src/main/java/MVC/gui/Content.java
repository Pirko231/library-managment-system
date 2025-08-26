package MVC.gui;

import java.awt.Graphics;
import java.util.function.BiFunction;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.Dimension;

// klasa ktora pozwala wyswietlac informacje o obecnym produkcie
public abstract class Content extends JPanel {

    protected JTextField nameField = new JTextField(20);
    protected JTextField authorField = new JTextField(20);
    private JComboBox<String> ownerList = new JComboBox<>();

    protected Content(String box1, String box2) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        nameField.setAlignmentX(Component.LEFT_ALIGNMENT);
        authorField.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, nameField.getPreferredSize().height));
        authorField.setMaximumSize(new Dimension(Integer.MAX_VALUE, authorField.getPreferredSize().height));

        

        add(new JLabel(box1));
        add(nameField);
        add(Box.createVerticalStrut(8));
        add(new JLabel(box2));
        add(authorField);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
