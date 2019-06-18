package Graphics.center;

import Graphics.Song;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SongsDisplay extends JPanel {
        private ArrayList<Song> songslist = new ArrayList<Song>();
        private ArrayList<JButton> songsButtons = new ArrayList<JButton>();

        public SongsDisplay(){
            super();
            this.setLayout(new GridLayout(0,3));
            this.setBackground(new Color(3, 11, 21));
            addsong("C:\\Users\\hashemi\\Desktop\\rrr.mp3");
            addsong("C:\\Users\\hashemi\\Desktop\\uuu.mp3");
            addSongInfoToSongButton();
            //JButton b = songslist.get(0).getInfo();
            setButtonsProperties(songsButtons.get(0));
            setButtonsProperties(songsButtons.get(1));
            this.add(songsButtons.get(0));
            this.add(songsButtons.get(1));
            //this.add(right,BorderLayout.);
            this.setVisible(true);

        }

        public void sortSongByTime(){

        }

    public void setButtonsProperties(JButton button){
        button.setBackground(new Color(3, 11, 21));
        //"Brush Script MT" Kunstler Script
        button.setFont(new Font("Brush Script MT", Font.PLAIN, 15));
        button.setForeground(Color.white);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setPreferredSize(new Dimension(600,50));
    }


    public void addsong(String path){
            Song s = new Song(path);
            songslist.add(s);
    }

    public void addSongInfoToSongButton(){
        for(int i = 0; i<songslist.size(); i++){
            songsButtons.add(songslist.get(i).getInfo()) ;
        }
    }

}
