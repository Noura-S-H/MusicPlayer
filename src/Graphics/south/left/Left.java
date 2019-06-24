package Graphics.south.left;
import Graphics.Song;
import javax.swing.*;
import java.awt.*;

public class Left extends JPanel {

    Song song = new Song("src\\Files\\songTest\\eee.mp3");

    Artwork artwork ;//= new Artwork(null);

    public Left(){
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.setVisible(true);

    }

    public void changeSongArtwork(Song song){
        this.song = song;
        this.add(artwork, BorderLayout.CENTER);
    }

}