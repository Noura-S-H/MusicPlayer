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
    String path = "src\\Files\\musics.json";
    South south;
    Album album;

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
        songsView = new SongsView(path,south);
        albumsDisplay = new AlbumsDisplay(this);



        this.add(new JScrollPane(albumsDisplay.getPanel()),"ALBUMSVIEW");
        this.add(songsView.getPanel(),"SONGSVIEW");

    }

    public void changeCentralAlbumListView(Album album){
        this.album = album;
        displayAlbumContent = new DisplayAlbumContent(album);
        this.add(displayAlbumContent.getPanel(),"ALBUMCONTENT");

    }


    public void changePath(String path) {
        this.path = path;
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
