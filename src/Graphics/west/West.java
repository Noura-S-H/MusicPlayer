package Graphics.west;

import Graphics.center.LibraryDisplay.Center;

import javax.swing.*;
import java.awt.*;

public class West extends JPanel {

    Library library ;
    PlaylistDisplay playList;
    NewPlayList newPlayList;

    public West(Center view){

        library = new Library(view);
        playList = new PlaylistDisplay();
        newPlayList = new NewPlayList();

        this.setLayout(new BorderLayout());
        this.add(library,BorderLayout.NORTH);
        this.add(playList,BorderLayout.CENTER);
        this.add(newPlayList,BorderLayout.SOUTH);
        this.setBackground(new Color(3, 11, 21));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.setVisible(true);
    }

    public Library getLibrary() {
        return library;
    }

    public NewPlayList getNewPlayList() {
        return newPlayList;
    }

    public PlaylistDisplay getPlayList() {
        return playList;
    }


}
