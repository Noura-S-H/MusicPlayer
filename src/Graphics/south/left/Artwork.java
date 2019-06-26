package Graphics.south.left;

import Graphics.Song;
import Graphics.AddProperties;

import javax.swing.*;
import java.awt.*;

public class Artwork extends JPanel {

    private AddProperties pro = new AddProperties();
    private JLabel artworkLable,songInformation;
    private static String songName ,singersNames ;
    private static ImageIcon artwork ;


    public Artwork(String name , String artist , ImageIcon art) {
        super();
        this.setLayout(new BorderLayout());


        this.songName = name;
        this.singersNames = artist;
        this.artwork = art;


        artworkLable = new JLabel(pro.getImageSong(artwork, 130, 100));
        pro.setLabelProperties(artworkLable, 150, 100, "", 12, SwingConstants.CENTER);

        songInformation = new JLabel(labelSongInfo(songName, singersNames));
        pro.setLabelProperties(songInformation, 150, 50, "Trebuchet MS", 12, SwingConstants.LEFT);

        this.add(artworkLable, BorderLayout.CENTER);
        this.add(songInformation, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public String labelSongInfo(String songName,String singerName){
        return "<html>&emsp;"+ songName +"<br>&emsp;" + singerName +"<br></html>";
    }

    public JPanel getPanel(){
        return this;
    }

    public static void setSongName(String songName) {
        Artwork.songName = songName;
    }

    public static void setArtwork(ImageIcon artwork) {
        Artwork.artwork = artwork;
    }

    public static void setSingersNames(String singersNames) {
        Artwork.singersNames = singersNames;
    }
}