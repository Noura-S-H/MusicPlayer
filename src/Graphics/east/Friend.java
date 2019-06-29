package Graphics.east;
import Graphics.AddProperties;
import Graphics.Song;
import Graphics.Playlist;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Friend {

    private String username;
  //  private String lastPlayedSongName;


    //private Song song;

    public Friend(String username,String lastPlayed){
        this.username = username;
       // this.lastPlayedSongName = lastPlayed;

    }



    public String getUsername() {
        return username;
    }

}
