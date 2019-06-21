package Logic;

import Graphics.Song;
import javazoom.jl.player.Player;

import java.io.FileInputStream;

public class PlayMusic extends Thread{

    private Song music;
    private boolean replay = false;

    public PlayMusic(Song music){
        this.music = music;
    }
    public void run(){

        try {
            FileInputStream file = new FileInputStream(music.getSongPath());
            Player playMP3 = new Player(file);
            playMP3.play();
        }
        catch (Exception e) {
        }
    }


    public boolean isReplay() {
        return replay;
    }

    public void setReplay(boolean replay) {
        this.replay = replay;
    }
}
