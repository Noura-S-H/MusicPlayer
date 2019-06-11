package Graphics;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Song {

    private File song ;
    private String title;
    private String artists;
    private String album;
    private String year;

    public Song(String path){
        try {
            song = new File(path);
            FileInputStream file = new FileInputStream(song);
            setSongInfo(last128(file));

            file.close();
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

    public void setSongInfo(byte[] info){
        String id3 = new String(info);
        String tag = id3.substring(0, 3);
        if (tag.equals("TAG")) {
            title = id3.substring(3, 33);
            artists = id3.substring(33, 63);
            album = id3.substring(63, 93);
            year = id3.substring(93, 97);
        } else{
            JFrame error = new JFrame("ERROR");
            
        }
            System.out.println(" does not contain IDv3 information.");
    }

}


