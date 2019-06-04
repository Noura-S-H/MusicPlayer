package Graphics.west;

import javax.swing.*;
import java.awt.*;

public class Library extends JPanel {

    private JButton buttons[] = new JButton[5];

    public Library() {
        super();
        this.setLayout(new GridLayout(6, 1));
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);


        JLabel label = new JLabel("  \uD83C\uDFA7  Libray");
        setLableProperties(label);
        this.add(label);


        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("       \uD83C\uDFB5 " + name[i]);
            setButtonsProperties(buttons[i]);
            add(buttons[i]);
        }
    }


    



}
