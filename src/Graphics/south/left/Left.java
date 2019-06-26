package Graphics.south.left;

import Graphics.Song;


import javax.swing.*;
import java.awt.*;

public class Left extends JPanel {

    //Song song = new Song("src\\Files\\songTest\\eee.mp3");

    Artwork artwork ;//= new Artwork(null);

    public Left(){
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.setVisible(true);

    }

    public void changeSongArtwork(Song song){
        //this.song = song;
        artwork = new Artwork(song.getTitle() , song.getArtists() , song.getArtwork());
        this.add(artwork.getPanel(), BorderLayout.CENTER);
    }

}