package Graphics.east;
import Graphics.AddProperties;
import Graphics.Song;
import Graphics.Playlist;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Friend {

    private String username;
    private Song lastPlayed;
    ArrayList<Playlist> sharedPlaylists;

    //private Song song;

    public Friend(String username,Song lastPlayed,ArrayList<Playlist> sharedPlaylists){
        this.username = username;
        this.sharedPlaylists = sharedPlaylists;
        this.lastPlayed = lastPlayed;

//        public String toString(){
//            return friendUsername + lastPlayed +sharedPlaylists ;
//
//        }
    }

    public Song getLastPlayed() {
        return lastPlayed;
    }

    public ArrayList<Playlist> getSharedPlaylists() {
        return sharedPlaylists;
    }

    public String username() {
        return username;
    }

}
