package Graphics.center.LibraryDisplay.Albums;

import Graphics.ActionlistenerManeger;
import Graphics.AddProperties;
import Graphics.Album;
import Graphics.AlbumsManeger;
import Graphics.center.LibraryDisplay.Center;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class AlbumsDisplay extends JPanel{

    private ActionlistenerManeger alm = new ActionlistenerManeger();
    private AlbumsManeger am = new AlbumsManeger();
    private AddProperties pro = new AddProperties();
    private ArrayList<Album> albums = new ArrayList<Album>();
    private ArrayList<JButton> buttons = new ArrayList<JButton>();

    private Album thisAlbumChoosed;

    public AlbumsDisplay(JPanel center){
        super();
        albums = am.getAlbums();
        this.setLayout(new GridLayout(2,albums.size()));
        this.setBackground(new Color(3, 11, 21));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        setAlbumsToButtons();
        for (int i = 0; i < albums.size(); i++){
            this.add(buttons.get(i));
        }
        setButtonsActionListener(center);
        this.setVisible(true);
    }


    public void setAlbumsToButtons(){

        for(int i = 0; i < albums.size(); i++ ){
            Album temp = albums.get(i);

            String name = temp.getAlbumName();
            String artists = temp.getSongs().get(0).getArtists();
            ImageIcon artwork = pro.getImageSong(temp.getSongs().get(0).getArtwork(),120,120);

            buttons.add(new JButton("<html>&emsp;"+name+"<br>&emsp;"+artists+"</html>"));
            pro.setButtonProperties(buttons.get(i),100,100,JButton.BOTTOM,JButton.CENTER,SwingConstants.CENTER);
            buttons.get(i).setFont(new Font("Trebuchet MS", Font.BOLD, 10));
            buttons.get(i).setIcon(artwork);
        }


    }

    public void setButtonsActionListener(JPanel view) {
        for(int i = 0 ; i < buttons.size(); i++){
            alm.changeViewInAlbumDisplay(buttons.get(i),(Center) view,"ALBUMCONTENT",albums.get(i));
        }
    }

    public Album getThisAlbumChoosed() {
        return thisAlbumChoosed;
    }

    public ArrayList<Album> getAlbums(){
        return albums;
    }

    public JPanel getPanel() {
        return this;
    }
}