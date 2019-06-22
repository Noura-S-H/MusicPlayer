package Graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Album implements ActionListener {

    private String albumName;
    private ArrayList<Song> songs = new ArrayList<Song>();

    private ActionEvent e;
    private JButton button;

    public Album(String albumName) {
        this.albumName = albumName;
    }

    public void actionPerformed(ActionEvent e) {
        this.e = e;
        if (e.getSource() == button) {

        }

    }


    public String getAlbumName() {
        return albumName;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSong(Song s){
        songs.add(s);
    }


}
