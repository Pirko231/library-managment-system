package MVC.gui;

import javax.swing.JPanel;

public class ContentRef extends JPanel {
    private Content content;

    public ContentRef() {
        
    }

    public void setContent(Content content) {
        this.content = content;
        removeAll();
        if (content != null) {
            add(this.content);
        }
        revalidate();
        repaint();
    }

    public Content getContent() {
        return content;
    }
}
