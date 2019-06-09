package Graphics.east;

import javax.swing.*;
import java.awt.*;

public class East extends JPanel {

    private FriendActivity friendActivity = new FriendActivity();

    public East(){
        super();
        this.setLayout(new BorderLayout());
        this.add(friendActivity,BorderLayout.CENTER);
        this.setBackground(new Color(3, 11, 21));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.setVisible(true);
    }


}
