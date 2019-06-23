package Graphics.north;
import Graphics.AddProperties;

import javax.swing.*;
import java.awt.*;

public class Profile extends JPanel {

    private AddProperties pro = new AddProperties();
    private JLabel profileIcon = new JLabel();
    private JLabel emptySpace = new JLabel();
    private String[] profile;
    private JComboBox<String> profileInfo ;

    public Profile(String username, String id){
        super();
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        profile[0] = username;
        profile[1] = id;

        profileInfo = new JComboBox<>(profile);
        pro.setImageIcon(profileIcon,"src\\Graphics\\icons\\wicon\\32.png",20,20);
        pro.setLabelProperties(emptySpace,140,20,"",12,SwingConstants.LEFT);
        pro.setJComboBoxProperties(profileInfo,150,20);
        this.add(profileIcon);
        this.add(profileInfo);
        this.add(emptySpace);
    }


}

