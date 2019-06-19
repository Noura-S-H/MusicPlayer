package Graphics.center;

import Graphics.Song;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SongsDisplay extends JPanel {
        private ArrayList<Song> songslist = new ArrayList<Song>();
        private ArrayList<JButton> songsButtons = new ArrayList<JButton>();
        private JLabel headLine ;

        public SongsDisplay(){
            super();
            this.setLayout(new GridLayout(100,1));
            this.setBackground(new Color(3, 11, 21));
            this.setVisible(true);

            headLine = new JLabel(setHeadLinePart());
            headLine.setHorizontalTextPosition(SwingConstants.LEFT);
            this.add(headLine);

            addsong("C:\\Users\\hashemi\\Desktop\\rrr.mp3");
            addsong("C:\\Users\\hashemi\\Desktop\\uuu.mp3");
            addSongInfoToSongButton();
            for(int i = 0; i<songslist.size(); i++){
                setButtonsProperties(songsButtons.get(i));
                this.add(songsButtons.get(i));
            }


        }

        public void sortSongByTime(){

        }

    public void setButtonsProperties(JButton button){

        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(new Color(3, 11, 21));
        button.setOpaque(true);
        button.setMaximumSize(new Dimension(1000,40));
     //   button.setFont(new Font("Brush Script MT", Font.PLAIN, 15));
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
            Image newimg = songslist.get(i).getArtwork().getImage().getScaledInstance( 40, 40, java.awt.Image.SCALE_SMOOTH);
            songsButtons.get(i).setIcon(new ImageIcon(newimg));

            songsButtons.get(i).setVerticalTextPosition(SwingConstants.CENTER);
            //songsButtons.get(i).setHorizontalTextPosition(JButton.CENTER);

        }
    }

    public String setHeadLinePart(){
            String[] s = {" \uD83C\uDF41 Artwork","\uD83D\uDD24 Title","\uD83C\uDFA4 ️Artists","\uD83D\uDCBF Album","\uD83D\uDCC6 Year"};

            String bt = "&emsp;";
            for(int i = 0; i<8;i++)
                 bt = bt + "&emsp;";
            String ss = "<html>&emsp;&emsp;&emsp;&emsp;&emsp;"+s[1]+bt+bt+s[2]+"&emsp;&emsp;&emsp;"+bt+s[3]+"&emsp;"+bt+s[4]+"</html>";
            return ss;
    }


}
