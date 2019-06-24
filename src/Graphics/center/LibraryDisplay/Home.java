package Graphics.center.LibraryDisplay;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {

    JLabel message = new JLabel();

    public Home(){
        super();

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3,11,21));
        this.setVisible(true);

        message.setText("<html><h1>&emsp;Wellcom</h1></html>");
        message.setVerticalTextPosition(JLabel.TOP);
        message.setFont(new Font("Trebuchet MS",Font.PLAIN,14));
        message.setForeground(Color.GRAY);

        this.add(message,BorderLayout.NORTH);
    }


    public JPanel getPanel(){
        return this;
    }


}