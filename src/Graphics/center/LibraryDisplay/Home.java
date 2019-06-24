package Graphics.center.LibraryDisplay;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {

    JTextArea message = new JTextArea();

    public Home(){
        super();

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3,11,21));
        this.setVisible(true);

        message.setEditable(false);

        this.add(message,BorderLayout.CENTER);
    }



}