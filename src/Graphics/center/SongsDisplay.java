package Graphics.center;

import Graphics.Song;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

public class SongsDisplay extends JPanel {
        private ArrayList<Song> songslist = new ArrayList<Song>();

        private JTable songsTable;

        JPanel list = new JPanel();
        JPanel liveSong = new JPanel();

        public SongsDisplay(){
            super();
            this.setLayout(new BorderLayout());
            this.setBackground(new Color(3,11,21));
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

            list.setLayout(new BorderLayout());
            list.setBackground(new Color(3, 11, 21));
            list.setMaximumSize(new Dimension(800,800));
            list.setVisible(true);

            String[][] data = new String[songslist.size()][5];
            for(int i = 0; i < songslist.size() ; i++)
                    data[i] = songslist.get(i).getInfo();

            String[] headLine = {"   \uD83D\uDD24 TITLE",
                    "  \uD83C\uDFA4 ️ARTISTS"," \uD83D\uDCBF ALBUM"," \uD83D\uDCC6 YEAR"," \uD83D\uDD52"};

            songsTable = new JTable(data,headLine);
            setTableProperties(songsTable);
            list.add(new JScrollPane(songsTable),BorderLayout.CENTER);

        }

        public void createPlayingSongPanel(Song s){
            liveSong.setLayout(new BorderLayout());
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

            liveSong.add(artworkSong,BorderLayout.WEST);
            liveSong.add(playBt,BorderLayout.EAST);
        }

        public void sortSongByTime(){
        }

        public void setButtonsProperties(JButton button,int w,int h){

            button.setBorder(BorderFactory.createEmptyBorder());
            button.setBackground(new Color(3, 11, 21));
            button.setOpaque(true);
            button.setPreferredSize(new Dimension(w,h));
     //     button.setFont(new Font("Brush Script MT", Font.PLAIN, 15));
            button.setHorizontalAlignment(SwingConstants.LEFT);
            button.setForeground(Color.white);
        }

        public  void setLableProperties(JLabel label){
            label.setOpaque(true);
            label.setBackground(new Color(3, 11, 21 ));
            label.setPreferredSize(new Dimension(600,110));
            label.setFont(new Font("Brush Script MT", Font.PLAIN, 14));
            label.setForeground(Color.WHITE);
        }

        public void setTableProperties(JTable tb){

            JTableHeader header = tb.getTableHeader();
            header.setBackground(new Color(3,11,21));
            header.setForeground(Color.WHITE);
            header.setFont(new Font("Sherif", Font.BOLD, 12));
            UIManager.getDefaults().put("TableHeader.cellBorder" , BorderFactory.createEmptyBorder(0,0,0,0));

            tb.setShowGrid(false);
            ((DefaultTableCellRenderer)tb.getTableHeader().getDefaultRenderer())
                    .setHorizontalAlignment(JLabel.LEFT);
            tb.setRowHeight(25);
            tb.setForeground(Color.white);
            tb.setBackground(new Color(3,11,21));
            tb.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
            songsTable.setPreferredSize(new Dimension(100,200));

            TableColumn column = null;
            for(int i = 0; i < 5; i++ ){
                column = tb.getColumnModel().getColumn(i);
                if (i == 0)
                    column.setPreferredWidth(250); //sport column is bigger
                else if(i == 1 || i ==2 )
                    column.setPreferredWidth(150);
                else
                    column.setPreferredWidth(50);
            }
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




}
