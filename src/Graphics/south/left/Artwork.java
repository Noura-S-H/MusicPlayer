package Graphics.south.left;

import Graphics.Song;
import Graphics.AddProperties;

import javax.swing.*;
import java.awt.*;

public class Artwork extends JPanel {

    private AddProperties pro = new AddProperties();
    private JLabel artworkLable,songInformation;
    private String songName = "SONG NAME",singersNames = "ARTISTS";
    private Song music;
    private ImageIcon artwork = new ImageIcon("src\\Graphics\\icons\\artwork\\12.jpg");


    public Artwork(Song music){
        super();
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        this.music = music;
        this.songName = music.getTitle();
        this.singersNames = music.getArtists();
        this.artwork = music.getArtwork();


        artworkLable = new JLabel(pro.getImageSong(artwork,130,100));
        pro.setLabelProperties(artworkLable,150,100,"",12,SwingConstants.CENTER);

        songInformation = new JLabel(labelSongInfo(songName,singersNames));
        pro.setLabelProperties(songInformation,150,50,"Trebuchet MS",12,SwingConstants.LEFT);

        this.add(artworkLable,BorderLayout.CENTER);
        this.add(songInformation,BorderLayout.SOUTH);
    }

    public String labelSongInfo(String songName,String singerName){
        return "<html>&emsp;"+ songName +"<br>&emsp;" + singerName +"<br></html>";
    }

    public JPanel getPanel(){
        return this;
    }


}