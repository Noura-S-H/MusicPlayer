package Graphics;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Album {

    String albumName;
    private ArrayList<Song> songs;
    public Album(String albumName){
        this.albumName = albumName;
    }

    public void addSong(Song s){
        if(s.getAlbum().equals(albumName))
            songs.add(s);
    }

    public void removeSong(Song s){
        songs.remove(s);
    }


}
