package Graphics.center;

import Graphics.Song;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SongsDisplay extends JPanel {
        private ArrayList<Song> songslist = new ArrayList<Song>();
        private ArrayList<JButton> songsButtons = new ArrayList<JButton>();
        private JLabel headLine ;

        JPanel list = new JPanel();
        JPanel PlayingSong = new JPanel();

        public SongsDisplay(){
            super();
            this.setLayout(new BorderLayout());
            setVisible(true);
            createListPanel();
            this.add(list,BorderLayout.CENTER);


        }

        public void createListPanel(){

            list.setLayout(new GridLayout(100,1));
            list.setBackground(new Color(3, 11, 21));
            list.setVisible(true);

            headLine = new JLabel(setHeadLinePart());
            headLine.setForeground(Color.white);
            headLine.setHorizontalTextPosition(SwingConstants.LEFT);
            list.add(headLine);

            addsong("C:\\Users\\hashemi\\Desktop\\rrr.mp3");
            // addsong("C:\\Users\\hashemi\\Desktop\\uuu.mp3");
            addSongInfoToSongButton();
            for(int i = 0; i<songslist.size(); i++){
                setButtonsProperties(songsButtons.get(i));
                list.add(songsButtons.get(i));
            }

        }

        public void createPlayingSongPanel(){

        }

        public void sortSongByTime(){

        }

    public void setButtonsProperties(JButton button){

        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(new Color(3, 11, 21));
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(1000,30));
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
