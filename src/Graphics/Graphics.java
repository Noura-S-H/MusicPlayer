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
         west = new West();
         center = new Center();

        this.add(new JScrollPane(west),BorderLayout.WEST);
        this.add(new JScrollPane(south),BorderLayout.SOUTH);
        this.add(new JScrollPane(north),BorderLayout.NORTH);
        this.add(new JScrollPane(east),BorderLayout.EAST);
        this.add(center, BorderLayout.CENTER);
        this.setVisible(true);

        JButton[] libraryButtons = west.getLibrary().getButtons();
        alm.changeView(libraryButtons[0],center,"HOME",null);
        alm.changeView(libraryButtons[2],center,"SONGSVIEW","src\\Files\\Songs.txt");
        alm.changeView(libraryButtons[3],center,"ALBUMSVIEW",null);
        alm.changeView(libraryButtons[4],center,"SONGSVIEW","src\\Files\\Favorites.txt");
        /*west.getLibrary().getButtons()[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                center.getCardLayout().show(center.getPanel(),"HOME");
            }
        });

        west.getLibrary().getButtons()[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                center.getCardLayout().show(center.getPanel(),"SONGSVIEW");
            }
        });

        west.getLibrary().getButtons()[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                center.getCardLayout().show(center.getPanel(),"SONGSVIEW");
            }
        });*/

//


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
