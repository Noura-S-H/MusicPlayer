package Graphics.south;

import Graphics.SongsManeger;
import Graphics.Song;
import Graphics.south.center.Center;
import Graphics.south.left.Artwork;
import Graphics.south.left.Left;
import Graphics.south.right.Right;


import javax.swing.*;
import java.awt.*;

public class South extends JPanel {

   Left left;
   Center center;
   //Right right;

    public South(){
        left = new Left();
        center = new Center(this);
        //right = new Right();
        this.setLayout(new BorderLayout());
        this.add(left,BorderLayout.WEST);
        this.add(center,BorderLayout.CENTER);
       // this.add(right,BorderLayout.EAST);
        this.setBackground(new Color(3, 11, 21));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.setVisible(true);

    }

    public Left getLeft() {
        return left;
    }

    public Center getCenter() {
        return center;
    }


}
