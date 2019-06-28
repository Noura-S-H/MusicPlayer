package NetWork;

import Graphics.Playlist;
import Graphics.Song;
import Graphics.north.Profile;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {

    private String friendUsername;
    private ArrayList<Playlist> sharedPlaylists;

    public Data(String friendUsername,ArrayList<Playlist> sharedPlaylists){
        this.friendUsername = friendUsername;
        this.sharedPlaylists = sharedPlaylists;
        //this.lastPlayed = lastPlayed;

//        public String toString(){
//            return friendUsername + lastPlayed +sharedPlaylists ;
//
//        }
    }

    public ArrayList<Playlist> getSharedPlaylists() {
        return sharedPlaylists;
    }

    public String getFriendUsername() {
        return friendUsername;
    }
}
