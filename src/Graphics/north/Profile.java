package Graphics.north;

import javax.swing.*;
import java.awt.*;

public class Profile extends JPanel {

    private String username;
    private JLabel profile;

    public Profile(String username){
        super();
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        this.username = username;
        profile = new JLabel(username);
        this.add(profile);
    }


}

