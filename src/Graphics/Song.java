package Graphics;

import javax.swing.*;
import java.awt.*;
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

}


