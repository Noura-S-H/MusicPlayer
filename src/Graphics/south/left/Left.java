package Graphics.south.left;

import javax.swing.*;
import java.awt.*;

public class Left extends JPanel {

    SongInfo artwork = new SongInfo();
    public Left(){
        super();
        this.setLayout(new BorderLayout());
        this.add(artwork, BorderLayout.CENTER);
        this.setVisible(true);
    }

}