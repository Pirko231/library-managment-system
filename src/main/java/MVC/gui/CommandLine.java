package MVC.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CommandLine extends JPanel {
    private Function<String,Void> actionOnSend;

    private JButton toggleButton = new JButton("▶");
    private JTextField inputText = new JTextField();

    public CommandLine(Function<String,Void> actionOnSend) {
        this.actionOnSend = actionOnSend;
        inputText.setPreferredSize(new Dimension(450, 23));

        inputText.addActionListener(new SendListener());
        toggleButton.addActionListener(new SendListener());

        JLabel label = new JLabel("Linia poleceń");
        Font font = new Font("serif", Font.BOLD, 10);
        label.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        label.setFont(font);
        add(label);
        add(inputText);
        add(toggleButton);
    }

    private class SendListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            actionOnSend.apply(inputText.getText());
            inputText.setText("");
        }

    }
}
