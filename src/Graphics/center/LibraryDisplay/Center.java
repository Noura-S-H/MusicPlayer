package Graphics.center.LibraryDisplay;

import Graphics.center.LibraryDisplay.Album.DisplayAlbumContent;
import Graphics.center.LibraryDisplay.Albums.AlbumsDisplay;

import javax.swing.*;
import java.awt.*;

public class Center extends JPanel {

    DisplayAlbumContent displayAlbumContent = new DisplayAlbumContent();
    AlbumsDisplay albumsDisplay = new AlbumsDisplay();


    public Center(){

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        //this.add(displayAlbumContent,BorderLayout.CENTER);
        this.add(albumsDisplay,BorderLayout.CENTER);
        this.setVisible(true);
    }


}
