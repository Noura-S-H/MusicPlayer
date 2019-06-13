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
            JButton lastPlayedSong = new JButton(songslist.get(0).getArtwork());
            setButtonsProperties(lastPlayedSong);
            left.setLayout(new BorderLayout());
            left.setBackground(new Color(3, 11, 21));
            left.setPreferredSize(new Dimension(300,300));
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
        //button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(new Color(3, 11, 21));
        //button.setHorizontalAlignment(SwingConstants.LEFT);
        //button.setFont(new Font("Open Sans", Font.BOLD, 12));
        button.setForeground(Color.white);
        button.setOpaque(true);
        //button.setPreferredSize(new Dimension(100, 100));
    }



    public void addsong(){
            Song s = new Song("C:\\Users\\hashemi\\Desktop\\rrr.mp3");
            songslist.add(s);
    }

}
