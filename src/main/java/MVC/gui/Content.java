package MVC.gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.Component;

// klasa ktora pozwala wyswietlac informacje o obecnym produkcie
public abstract class Content extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public abstract void update(String bookName, String authorName);
}
