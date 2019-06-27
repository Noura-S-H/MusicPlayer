package Graphics;

import Graphics.Song;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Playlist {

    private String name;
    private ArrayList<Song> songs = new ArrayList<Song>();
    private ArrayList<String> paths;


    public Playlist(String name,ArrayList<String> paths) {
        this.name = name;
        this.paths = paths;
        createSongs();
    }

    public void addPathAndSong(String p){
        paths.add(p);
        songs.add(new Song(p));
    }

    public void createSongs(){
        for(String p : paths){
            songs.add(new Song(p));
        }
    }

    public void removePathAndSong(String p) {
        paths.remove(p);
        for (Song s : songs){
            if (s.getSongPath().equals(p)) {
                songs.remove(s);
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPaths() {
        return paths;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}