package Graphics.south.left;

import Graphics.Song;
import Graphics.AddProperties;

import javax.swing.*;
import java.awt.*;

public class SongInfo extends JPanel {

    private AddProperties pro = new AddProperties();
    private JLabel artworkLable,songInformation;
    private  boolean favorites = false;
    private String songName ,singersNames,artwork = "iii.jpg";
    private Song music;


    public SongInfo(Song music){
        super();
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.music = music;
        this.songName = music.getTitle();
        this.singersNames = music.getArtists();

        artworkLable = new JLabel(pro.getImageSong(music.getArtwork()));
        pro.setLabelProperties(artworkLable,150,100,"",12,SwingConstants.LEFT);

        songInformation = new JLabel(labelSongInfo(songName,singersNames));
        pro.setLabelProperties(songInformation,150,50,"Brush Script MT",14,SwingConstants.LEFT);

        this.add(artworkLable,BorderLayout.CENTER);
        this.add(songInformation,BorderLayout.SOUTH);
    }

    public String labelSongInfo(String songName,String singerName){
        return "<html>&emsp;"+ songName +"<br>&emsp;" + singerName +"<br></html>";
    }


}