package Graphics.south;


import Graphics.south.center.Center;
import Graphics.south.left.Left;
import Graphics.south.right.Right;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class South extends JPanel {

   Left left = new Left();
   Center center = new Center();
   Right rigth = new Right();

    public South(){
        this.setLayout(new BorderLayout());
        this.add(left,BorderLayout.WEST);
        this.add(rigth,BorderLayout.EAST);
        this.add(center,BorderLayout.CENTER);
        this.setBackground(new Color(3, 11, 21));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.setVisible(true);
    }


}
