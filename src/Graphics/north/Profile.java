package Graphics.north;

import javax.swing.*;
import java.awt.*;

public class Profile extends JPanel {

    private String[] profile = {"name","id"};
    private JComboBox<String> profileInfo;

    public Profile(){
        super();
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);
        profileInfo = new JComboBox<String>(profile);
        profileInfo.setBackground(new Color(3,11,21));
        profileInfo.setForeground(Color.white);
        profileInfo.setPreferredSize(new Dimension(150,20));
        //profileInfo.setEditable(true);

        this.add(profileInfo);
    }


}

