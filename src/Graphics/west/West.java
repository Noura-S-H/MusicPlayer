package Graphics.west;

import javax.swing.*;
import java.awt.*;

public class West extends JPanel {

    Library library = new Library();
    PlayList playList = new PlayList();
    NewPlayList newPlayList = new NewPlayList();

    public West(){
        this.setLayout(new BorderLayout());
        this.add(library,BorderLayout.NORTH);
        this.add(playList,BorderLayout.CENTER);
        this.add(newPlayList,BorderLayout.SOUTH);
        this.setBackground(new Color(3, 11, 21));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.setVisible(true);
    }


}
