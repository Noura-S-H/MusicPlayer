package Graphics.south;

import Graphics.SongsManeger;
import Graphics.Song;
import Graphics.south.center.Center;
import Graphics.south.left.Artwork;
import Graphics.south.left.Left;


import javax.swing.*;
import java.awt.*;

public class South extends JPanel {

   Left left = new Left();
   Center center = new Center();


    public South(){
        this.setLayout(new BorderLayout());
        this.add(left,BorderLayout.WEST);
        this.add(center,BorderLayout.CENTER);
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
