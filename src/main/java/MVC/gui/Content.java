package MVC.gui;

import java.awt.Graphics;

// klasa ktora pozwala wyswietlac informacje o obecnym produkcie
public interface Content {
    public void paintComponent(Graphics g);

    public void update(String bookName, String authorName);
}
