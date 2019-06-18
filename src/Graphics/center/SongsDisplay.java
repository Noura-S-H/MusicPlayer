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

            this.setLayout(new GridLayout(100,1));
            this.setBackground(new Color(3, 11, 21));

            addsong("C:\\Users\\hashemi\\Desktop\\rrr.mp3");
            addsong("C:\\Users\\hashemi\\Desktop\\uuu.mp3");
            addSongInfoToSongButton();
            for(int i = 0; i<songslist.size(); i++){
                setButtonsProperties(songsButtons.get(i));
                this.add(songsButtons.get(i));
            }
            this.setVisible(true);

        }

        public void sortSongByTime(){

        }

    public void setButtonsProperties(JButton button){

        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(new Color(3, 11, 21));
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(600, 30));
        button.setFont(new Font("Brush Script MT", Font.PLAIN, 15));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setForeground(Color.white);
    }


    public void addsong(String path){
            Song s = new Song(path);
            songslist.add(s);
    }

    public void addSongInfoToSongButton(){
        for(int i = 0; i<songslist.size(); i++){
            songsButtons.add(new JButton());
            songsButtons.get(i).setText(songslist.get(i).getInfo());
        }
    }

}
