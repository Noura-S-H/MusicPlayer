package Graphics.south.left;
import Graphics.Song;
import javax.swing.*;
import java.awt.*;

public class Left extends JPanel {

    Song s = new Song("src\\Graphics\\center\\LibraryDisplay\\songTest\\ttt.mp3");
    SongInfo artwork = new SongInfo(s);
    public Left(){
        super();
        this.setLayout(new BorderLayout());
        this.add(artwork, BorderLayout.CENTER);
        this.setVisible(true);
    }

}