package Graphics.south.left;
import Graphics.SongsManeger;
import Graphics.Song;


import javax.swing.*;
import java.awt.*;

public class Left extends JPanel {

    Artwork artwork = new Artwork("SONG NAME","ARTISTS",
            new ImageIcon("src\\Graphics\\icons\\artwork\\7.jpg"));
    Song song;

    CardLayout cardArtworkLayout = new CardLayout();
    SongsManeger sm = new SongsManeger("src\\Files\\musics.json");



    public Left(){
        super();
        this.setLayout(cardArtworkLayout);
        this.setBackground(new Color(3, 11, 21));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.setVisible(true);
        this.add(artwork.getPanel(),"ARTWORK");
    }


    public void changeArtwork(Song s){
        artwork = new Artwork(s.getTitle(),s.getArtists(),s.getArtwork());
        this.add(artwork.getPanel(),"ARTWORK");
    }


    public JPanel getPanel(){
        return this;
    }

    public CardLayout getCardArtworkLayout() {
        return cardArtworkLayout;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}