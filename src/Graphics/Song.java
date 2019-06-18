package Graphics;


import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Song {

    private Mp3File mp3File;


    private File song;
    private ImageIcon artwork;
    private String title;
    private String artists;
    private String album;
    private String year;
    private JButton info = new JButton();

    public Song(String path){
        setDifultArtwork("C:\\Users\\hashemi\\Desktop\\Jpotify\\src\\Graphics\\icons\\artwork\\12.jpg");

        try {

            mp3File = new Mp3File(path);
            if(mp3File.hasId3v1Tag()) {
                song = new File(path);
                FileInputStream file = new FileInputStream(song);
                setID3v1Info(last128(file));
                file.close();
            }
            else if(mp3File.hasId3v2Tag()){
                setID3v2Info(mp3File);
            }
        } catch (Exception e) {
            System.out.println("Error - " + e.toString());
        }

    }

    public byte[] last128(FileInputStream file){
        byte[] info = new byte[128];
        try {
            file.skip((int)song.length() - 128);
            file.read(info);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    public void setID3v1Info(byte[] info){
        String id3 = new String(info);
        String tag = id3.substring(0, 3);
        if (tag.equals("TAG")) {
            this.title = id3.substring(3, 33);
            this.artists = id3.substring(33, 63);
            this.album = id3.substring(63, 93);
            this.year = id3.substring(93, 97);
        } else{
            String WARRNING_WINDOWS_ICON = "C:\\Users\\hashemi\\Desktop\\Jpotify\\src\\Graphics\\icons\\warrning.png";
            JFrame error = new JFrame("ERROR");
            error.setLayout(new BorderLayout());
            error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            error.setSize(300, 100);
            error.setLocation(100, 100);
            error.setIconImage(Toolkit.getDefaultToolkit().getImage(WARRNING_WINDOWS_ICON));
            error.add(new JLabel("   DOSE NOT CONTAIN IDV3 INFORMATION!"));
            error.setVisible(true);
        }
    }

    public void setID3v2Info(Mp3File mp3) {
        ID3v2 id3v2Tag = mp3.getId3v2Tag();
        title = id3v2Tag.getTitle();
        artists = id3v2Tag.getArtist();
        album = id3v2Tag.getAlbum();
        year = id3v2Tag.getYear();
        byte[] ic = id3v2Tag.getAlbumImage();
        artwork = new ImageIcon(ic);
    }

    public void print(){
        System.out.println(title);
        System.out.println(artists);
        System.out.println(album);
        System.out.println(year);
        System.out.println(artwork);
    }

    public void setDifultArtwork(String path){
        artwork = new ImageIcon(path);
    }

    public String getInfo(){
        return ("<html>"+title +"<br>"+ artists + "</html>");
    }

    public ImageIcon getArtwork() {
        return artwork;
    }

    public File getSong() {
        return song;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtists() {
        return artists;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    /*public static void main(String[] args){
        Song s = new Song("C:\\Users\\hashemi\\Desktop\\rrr.mp3");
        s.print();
    }*/
}


