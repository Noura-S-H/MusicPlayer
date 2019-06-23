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


    public Graphics(String username,String id) {

        super();
        this.setTitle(WINDOWS_TITLE);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(X, Y);
        this.setVisible(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(WINDOWS_ICON)) ;
       // this.getContentPane().setBackground( new Color(3,11,21) );

       // View view = new View();
        //Search search = new Search();
        //PlayList playList = new PlayList();
        //Artwork artwork = new Artwork();
        //FriendActivity friendActivity  = new FriendActivity();
         east = new East();
         north = new North(username,id);
         south = new South();
         west = new West();
         center = new Center();
        //this.add(new JScrollPane(library), BorderLayout.WEST);
        this.add(new JScrollPane(west),BorderLayout.WEST);
        this.add(new JScrollPane(south),BorderLayout.SOUTH);
        this.add(new JScrollPane(north),BorderLayout.NORTH);
        this.add(new JScrollPane(east),BorderLayout.EAST);
        this.add(center,BorderLayout.CENTER);
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
