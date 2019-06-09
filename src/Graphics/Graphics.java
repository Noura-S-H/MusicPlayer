package Graphics;
;
import Graphics.east.East;
import Graphics.north.North;
import Graphics.south.South;
import Graphics.west.West;

import javax.swing.*;
import java.awt.*;

public class Graphics extends JFrame {


    private final String WINDOWS_TITLE = "Jpotify";
    private final int WIDTH = 1000, HEIGHT = 600;
    private final int X = 70, Y = 70;
    private final String WINDOWS_ICON = "C:\\Users\\hashemi\\Desktop\\Jpotify\\src\\Graphics\\icons\\hhh.png";


    public Graphics() {

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
        East east = new East();
        North north = new North();
        South south = new South();
        West west = new West();
        //this.add(new JScrollPane(library), BorderLayout.WEST);
        this.add(new JScrollPane(west),BorderLayout.WEST);
        this.add(new JScrollPane(south),BorderLayout.SOUTH);
        this.add(new JScrollPane(north),BorderLayout.NORTH);
        this.add(new JScrollPane(east),BorderLayout.EAST);

    }

}
