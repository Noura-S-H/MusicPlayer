package Graphics.center;

import Graphics.Song;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SongsDisplay extends JPanel {
        private ArrayList<Song> songslist = new ArrayList<Song>();
        JPanel left = new JPanel();
        JPanel right = new JPanel();

        public SongsDisplay(){
            super();
            this.setLayout(new BorderLayout());
            this.setBackground(new Color(3, 11, 21));

            addsong();
            //JButton lastPlayedSong = new JButton(songslist.get(0).getArtwork());

            //setButtonsProperties(lastPlayedSong);
            //this.add(lastPlayedSong,BorderLayout.WEST);
            leftPanelDesigne();
            //rightPanelDesigne();
            this.add(left,BorderLayout.WEST);
            //this.add(right,BorderLayout.);
            this.setVisible(true);

        }

        public void leftPanelDesigne(){

            JButton lastPlayedSong = new JButton();
            setButtonsProperties(lastPlayedSong);

            left.setLayout(new BorderLayout());
            left.setBackground(new Color(3, 11, 21));
            left.setPreferredSize(new Dimension(400,300));
            left.add(lastPlayedSong);
            left.setVisible(true);

        }

        public void rightPanelDesigne(){
            right.setLayout(new BorderLayout());
            right.setBackground(new Color(3, 11, 21));
            right.setVisible(true);
        }

        public void sortSongByTime(){

        }

    public void setButtonsProperties(JButton button){
        button.setBackground(new Color(3, 11, 21));
        //"Brush Script MT" Kunstler Script
        button.setFont(new Font("Brush Script MT", Font.PLAIN, 16));
        button.setForeground(Color.white);
        button.setOpaque(true);
        Image newimg = songslist.get(0).getArtwork().getImage().getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setIcon(new ImageIcon( newimg ));
        button.setText(songslist.get(0).getInfo());
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setHorizontalTextPosition(JButton.CENTER);

    }



    public void addsong(){
            Song s = new Song("C:\\Users\\hashemi\\Desktop\\rrr.mp3");
            songslist.add(s);
    }

}
