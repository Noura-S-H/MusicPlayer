package Graphics.center.LibraryDisplay;

import Graphics.center.LibraryDisplay.Albums.AlbumsDisplay;
import Graphics.center.LibraryDisplay.Albums.DisplayAlbumContent;
import Graphics.south.South;

import javax.swing.*;
import java.awt.*;

public class Center extends JPanel {

    DisplayAlbumContent displayAlbumContent;
    Home home;
    SongsView songsView ;
    AlbumsDisplay albumsDisplay;
    String path = "src\\Files\\musics.json";
    South south;

    CardLayout cardLayout = new CardLayout();
   // JPanel cardPanel = new JPanel(cardLayout);

    public Center(South south){
        super();

        this.south = south;
        this.setLayout(cardLayout);
        this.setBackground(new Color(3, 11, 21));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        home = new Home();
        albumsDisplay = new AlbumsDisplay(this);

        this.add(home.getPanel(),"HOME");
        this.add(new JScrollPane(albumsDisplay.getPanel()),"ALBUMSVIEW");

        this.setVisible(true);
    }

    public void changePath(String path) {
        this.path = path;
        songsView = new SongsView(path,south);
//        displayAlbumContent = new DisplayAlbumContent(path);

        this.add(songsView.getPanel(),"SONGSVIEW");
   //     this.add(displayAlbumContent.getPanel(),"ALBUMCONTENT");
    }

    public String getPath() {
        return path;
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


}
