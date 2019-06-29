package Graphics;


import Logic.Time;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Song {

    private Mp3File mp3File;
    private Warrning error;
    private static boolean favorite = false;
    private File song;
    private ImageIcon artwork;
    private String title;
    private String artists;
    private String album;
    private String year;
    private String lastTimePlayed = "00:00:00";
    private String jsonFileName;
    private boolean isplaying = false;

    Time time ;

    public Song(String path){

        try {

            mp3File = new Mp3File(path);
            if(mp3File.hasId3v1Tag()) {

                song = new File(path);
                jsonFileName = song.getName();
                FileInputStream file = new FileInputStream(song);
                setID3v1Info(last128(file));
                file.close();
                //find artwork
                ID3v2 id3 = mp3File.getId3v2Tag();
                byte[] ic = id3.getAlbumImage();
                artwork = new ImageIcon(ic);
                if(artwork.equals(null))
                    setDifultArtwork("src\\Graphics\\icons\\artwork\\12.jpg");
            }
            else if(mp3File.hasId3v2Tag()){
                jsonFileName = song.getName();
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
            error =  new Warrning("   DOSE NOT CONTAIN IDV3 INFORMATION!",false);
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


    public void setDifultArtwork(String path){
        artwork = new ImageIcon(path);
    }


    public Object[] getInfo(String str){

        String ti = " > " + findString(title);
        String ar = findString(artists);
        String al = findString(album);
        String ye = findString(year);

        Object [] ALinfo = {"✓", ti, ar, al, ye, lastTimePlayed,"\uD83D\uDDF4 "};
        Object [] SVinfo = {"✓",artwork,ti,ar,al,ye,lastTimePlayed,"\uD83D\uDDF4 "};

        if(str.equals("AL"))
            return ALinfo;
        else if(str.equals("SV"))
            return SVinfo;

        return SVinfo;
    }


    public String findString(String str){
        int i;
        String space = "&emsp;";
        char[] c = str.toCharArray();
        for(int k = 0 ;k <c.length; k++)
            if((int)c[k] == '\0' )
                c[k] = '*';
        for( i = c.length-1 ; i>=0 ;i--)
            if( (c[i] != '*') )
                break;

        str = str.substring(0,i+1);

        return str;
    }

    public void startTime() {
        time = new Time();
        time.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lastTimePlayed = time.getTime();
                }
            }
        }).start();


    }

    public boolean getFavorite(){
        return favorite;
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

    public String getLastTimePlayed(){
        return lastTimePlayed;
    }

    public String getSongPath(){
        return song.getPath();
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getJsonFileName() {
        return jsonFileName;
    }

    public void setisPlaying(boolean playingStatus) {
        this.isplaying = playingStatus;
    }

    public boolean isPlaying(){
        return isplaying;
    }

    public void setLastTimePlayed(String lastTimePlayed) {
        this.lastTimePlayed = lastTimePlayed;
    }

    public Time getTime() {
        return time;
    }
}