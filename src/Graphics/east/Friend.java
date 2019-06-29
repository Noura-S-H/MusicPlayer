package Graphics.east;
import Graphics.AddProperties;
import Graphics.Song;
import Graphics.Playlist;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Friend {

    private String username;
    private String lastPlayedSongName;
    private String status;


    //private Song song;

    public Friend(String username,String lastPlayed,String status){
        this.username = username;
        this.lastPlayedSongName = lastPlayed;
        this.status = status;
    }



    public String getUsername() {
        return username;
    }

    public String getStatus() {
        return status;
    }

    public String getLastPlayedSongName() {
        return lastPlayedSongName;
    }
}
