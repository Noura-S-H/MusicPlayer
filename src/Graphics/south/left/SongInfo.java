package Graphics.south.left;

import Graphics.Song;

import javax.swing.*;
import java.awt.*;

public class SongInfo extends JPanel {

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

        artworkLable = new JLabel(getImageAlbum(music.getArtwork()));
        setLableProperties(artworkLable,150,100);

        songInformation = new JLabel(labelSongInfo(songName,singersNames),SwingConstants.LEFT);
        setLableProperties(songInformation,150,50);

        this.add(artworkLable,BorderLayout.CENTER);
        this.add(songInformation,BorderLayout.SOUTH);
    }

    public  void setLableProperties(JLabel label,int width,int heiqth){
        label.setOpaque(true);
        label.setBackground(new Color(3, 11, 21 ));
        label.setPreferredSize(new Dimension(width,heiqth));
        label.setFont(new Font("Brush Script MT", Font.PLAIN, 14));
        label.setForeground(Color.WHITE);
    }

    public ImageIcon getImageAlbum(ImageIcon icon) {
        ImageIcon imIcon = new ImageIcon(icon.getImage()
                .getScaledInstance(130, 100, java.awt.Image.SCALE_SMOOTH));
        return imIcon;
    }

    public String labelSongInfo(String songName,String singerName){
        return "<html>&emsp;"+ songName +"<br>&emsp;" + singerName +"<br></html>";
    }








}