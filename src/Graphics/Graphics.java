package Graphics;

import Graphics.center.LibraryDisplay.Center;
import Graphics.east.East;
import Graphics.north.North;
import Graphics.south.South;
import Graphics.west.West;

import javax.swing.*;
import java.awt.*;

;

public class Graphics extends JFrame {


    private final String WINDOWS_TITLE = "Jpotify";
    private final int WIDTH = 1100, HEIGHT = 600;
    private final int X = 70, Y = 70;
    private final String WINDOWS_ICON = "src\\Graphics\\icons\\hhh.png";

    East east;
    West west;
    North north;
    South south;
    Center center;
    ActionlistenerManeger alm = new ActionlistenerManeger();


    public Graphics(String username,String password) {

        super();
        this.setTitle(WINDOWS_TITLE);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(X, Y);

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(WINDOWS_ICON)) ;

         east = new East();
         north = new North(username,password);
         south = new South();
         center = new Center();
         west = new West(center);
        this.add(new JScrollPane(west),BorderLayout.WEST);
        this.add(new JScrollPane(south),BorderLayout.SOUTH);
        this.add(new JScrollPane(north),BorderLayout.NORTH);
        this.add(new JScrollPane(east),BorderLayout.EAST);
        this.add(center, BorderLayout.CENTER);
        this.setVisible(true);



    }

    public East getEast(){
        return east;
    }

    public West getWest(){
        return west;
    }

    public North getNorth(){
        return north;
    }

    public South getSouth(){
        return south;
    }

    public Center getCenter(){
        return center;
    }
}
