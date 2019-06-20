package Graphics.center.LibraryDisplay;

import Graphics.center.LibraryDisplay.Album.DisplayAlbumContent;

import javax.swing.*;
import java.awt.*;

public class Center extends JPanel {

    DisplayAlbumContent songsDisplay = new DisplayAlbumContent();


    public Center(){

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.add(songsDisplay,BorderLayout.CENTER);
        this.setVisible(true);
    }


}
