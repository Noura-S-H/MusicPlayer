package Graphics.center.LibraryDisplay;

import Graphics.center.LibraryDisplay.Albums.AlbumsDisplay;

import javax.swing.*;
import java.awt.*;

public class Center extends JPanel {

    //DisplayAlbumContent displayAlbumContent = new DisplayAlbumContent();
    Home home;
    SongsView songsView ;
    AlbumsDisplay albumsDisplay;
    String path = "src\\Files\\Songs.txt";

    CardLayout cardLayout = new CardLayout();
   // JPanel cardPanel = new JPanel(cardLayout);

    public Center(){
        super();

        this.setLayout(cardLayout);
        this.setBackground(new Color(3, 11, 21));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        songsView = new SongsView(path);
        albumsDisplay = new AlbumsDisplay();
        home = new Home();

        this.add(home.getPanel(),"HOME");
        this.add(new JScrollPane(albumsDisplay.getPanel()),"ALBUMSVIEW");
        this.add(songsView.getPanel(),"SONGSVIEW");

        //this.add(displayAlbumContent,BorderLayout.CENTER);

        this.setVisible(true);
    }

    public JPanel getPanel(){
        return this;
    }
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public SongsView getSongsView() {
        return songsView;
    }

    public AlbumsDisplay getAlbumsDisplay() {
        return albumsDisplay;
    }

    public Home getHome() {
        return home;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
