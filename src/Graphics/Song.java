package Graphics;


import com.mpatric.mp3agic.Mp3File;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Song {

    private Mp3File mp3File;

    private File song;
    private String title;
    private String artists;
    private String album;
    private String year;
    private int seconds;

    public Song(String path){
        try {

            mp3File = new Mp3File(path);
            //if(mp3File.hasId3v1Tag()) {
                song = new File(path);
                FileInputStream file = new FileInputStream(song);
                setID3v1Info(last128(file));
                file.close();
            //}
            //else if(mp3File.hasId3v2Tag()){
                setID3v2Info();
            //}
        } catch (Exception e) {
            System.out.println("Error - " + e.toString());
        }
        /*Mp3File mp3file = new Mp3File("SomeMp3File.mp3");
        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            byte[] imageData = id3v2Tag.getAlbumImage();
            if (imageData != null) {
                String mimeType = id3v2Tag.getAlbumImageMimeType();
                // Write image to file - can determine appropriate file extension from the mime type
                RandomAccessFile file = new RandomAccessFile("album-artwork", "rw");
                file.write(data);
                file.close();
            }
        }*/

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

    public void setID3v2Info(){


    }

    public void print(){
        System.out.println(title);
        System.out.println(artists);
        System.out.println(album);
        System.out.println(year);
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

    public static void main(String[] args){
        Song s = new Song("C:\\Users\\hashemi\\Desktop\\rrr.mp3");
        s.print();
    }
}


