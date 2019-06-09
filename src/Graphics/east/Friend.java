package Graphics.east;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Friend extends JPanel {

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
        setLableProperties(friendInfo);
        this.add(friendInfo);
    }

    public  void setLableProperties(JLabel label){
        label.setOpaque(true);
        label.setBackground(new Color(3, 11, 21 ));
        label.setPreferredSize(new Dimension(100,50));
        label.setForeground(Color.WHITE);
    }




}
