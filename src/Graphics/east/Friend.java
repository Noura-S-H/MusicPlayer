package Graphics.east;
import Graphics.AddProperties;

import javax.swing.*;
import java.awt.*;

public class Friend extends JPanel {
    private AddProperties pro = new AddProperties();
    private JLabel friendInfo;
    private String username;
    private String info;
    //private Song song;

    public Friend(String username){
        super();
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.username = username;
        friendInfo = new JLabel();
        pro.setLabelProperties(friendInfo,100,50,"",12,SwingConstants.LEFT);
        this.add(friendInfo);
    }

}
