package Graphics.center.LibraryDisplay;
import Graphics.center.LibraryDisplay.Albums.AlbumsDisplay;
import Graphics.center.LibraryDisplay.Albums.DisplayAlbumContent;
import Graphics.south.South;
import Graphics.Album;
import javax.swing.*;
import java.awt.*;

public class Center extends JPanel {

    DisplayAlbumContent displayAlbumContent;
    Home home;
    SongsView songsView ;
    AlbumsDisplay albumsDisplay;
    String tempPath = "src\\Files\\musics.json";
    Album tempAlbum;

    South south;
    CardLayout cardLayout = new CardLayout();

    public Center(South south){
        super();

        this.south = south;
        this.setLayout(cardLayout);
        this.setBackground(new Color(3, 11, 21));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        home = new Home();
        albumsDisplay = new AlbumsDisplay(this);

        this.add(home.getPanel(),"HOME");
        this.setVisible(true);
    }

    public void changeCentralView(){
        songsView = new SongsView(tempPath,south);
        albumsDisplay = new AlbumsDisplay(this);

        this.add(new JScrollPane(albumsDisplay.getPanel()),"ALBUMSVIEW");
        this.add(songsView.getPanel(),"SONGSVIEW");
    }

    public void changeCentralAlbumListView(Album album){
        this.tempAlbum = album;
        displayAlbumContent = new DisplayAlbumContent(album,south);
        this.add(displayAlbumContent.getPanel(),"ALBUMCONTENT");
    }


    public void changePath(String path) {
        this.tempPath = path;
    }

    public JPanel getPanel(){
        return this;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }


}
