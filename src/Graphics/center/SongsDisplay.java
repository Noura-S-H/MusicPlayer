package Graphics.center;

import Graphics.Song;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SongsDisplay extends JPanel {
        private ArrayList<Song> songslist = new ArrayList<Song>();
        private ArrayList<JButton> songsButtons = new ArrayList<JButton>();

        JPanel list = new JPanel();
        JPanel liveSong = new JPanel();

        public SongsDisplay(){
            super();
            this.setLayout(new BorderLayout());
            this.setVisible(true);

            addsong("C:\\Users\\hashemi\\Desktop\\www.mp3");
            addsong("C:\\Users\\hashemi\\Desktop\\qqq.mp3");
            addsong("C:\\Users\\hashemi\\Desktop\\rrr.mp3");
            addsong("C:\\Users\\hashemi\\Desktop\\yyy.mp3");
            addsong("C:\\Users\\hashemi\\Desktop\\eee.mp3");
            addsong("C:\\Users\\hashemi\\Desktop\\ttt.mp3");

            createListPanel();
            createPlayingSongPanel(songslist.get(0));
            this.add(list,BorderLayout.CENTER);
            this.add(liveSong,BorderLayout.NORTH);

        }

        public void createListPanel(){

            list.setLayout(new GridLayout(100,1));
            list.setBackground(new Color(3, 11, 21));
            list.setVisible(true);

            JLabel headLine = new JLabel(setHeadLinePart());
            headLine.setForeground(Color.white);
            headLine.setHorizontalTextPosition(SwingConstants.LEFT);
            list.add(headLine);

            addSongInfoToSongButton();
            for(int i = 0; i<songslist.size(); i++){
                setButtonsProperties(songsButtons.get(i),700,40);
                list.add(songsButtons.get(i));
            }

        }

        public void createPlayingSongPanel(Song s){
            liveSong.setLayout(new FlowLayout());
            liveSong.setVisible(true);
            liveSong.setBackground(new Color(3,11,21));
            JLabel artworkSong = new JLabel();
            JButton playBt = new JButton("PLAY");
            setLableProperties(artworkSong);
            setButtonsProperties(playBt,100,100);
            playBt.setIcon(getImage("C:\\Users\\hashemi\\Desktop\\Jpotify\\src\\Graphics\\icons\\MusicIcons\\ppp.png",50,50));

            Image newimg = s.getArtwork().getImage().getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;
            artworkSong.setIcon(new ImageIcon(newimg));
            artworkSong.setText("<html><p>&emsp;<font size = \"20\">"+s.getTitle()+
                    "</font><p>&emsp;"+s.getArtists()+"<br>&emsp;"+s.getLastTimePlayed()+"</html>");

            liveSong.add(artworkSong);
            liveSong.add(playBt);
        }

        public void sortSongByTime(){

        }

    public void setButtonsProperties(JButton button,int w,int h){

        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(new Color(3, 11, 21));
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(w,h));
     //   button.setFont(new Font("Brush Script MT", Font.PLAIN, 15));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setForeground(Color.white);
    }

    public  void setLableProperties(JLabel label){
        label.setOpaque(true);
        label.setBackground(new Color(3, 11, 21 ));
        label.setPreferredSize(new Dimension(900,110));
        label.setFont(new Font("Brush Script MT", Font.PLAIN, 14));
        label.setForeground(Color.WHITE);
    }
    
    public ImageIcon getImage(String path,int w, int h){
        ImageIcon imIcon = new ImageIcon(path);
        Image newimg = imIcon.getImage().getScaledInstance( w, h,  java.awt.Image.SCALE_SMOOTH ) ;
        imIcon = new ImageIcon( newimg );
        return imIcon;
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

    public String setHeadLinePart(){
            String[] s = {" \uD83C\uDF41 ARTWOKE","\uD83D\uDD24 TITLE",
                    "\uD83C\uDFA4 ️ARTISTS","\uD83D\uDCBF ALBUM","\uD83D\uDCC6 YEAR","\uD83D\uDD52"};
            String bt = "&emsp;";
            for(int i = 0; i<8;i++)
                 bt = bt + "&emsp;";
            String ss = "<html>&emsp;&emsp;"+s[1]+bt+bt+s[2]
                    +"&emsp;&emsp;&emsp;"+bt+s[3]+"&emsp;&emsp;"+bt+s[4]+bt+s[5]+"</html>";
            return ss;
    }


}
