package Graphics.center.LibraryDisplay.Albums;

import Graphics.AddProperties;
import Graphics.Song;
import Graphics.center.LibraryDisplay.ButtonEditor;
import Graphics.center.LibraryDisplay.ButtonRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

public class DisplayAlbumContent extends JPanel {

        private AddProperties pro = new AddProperties();
        private ArrayList<Song> songslist = new ArrayList<Song>();
        private JTable songsTable;

        private JPanel list = new JPanel();
        private JPanel liveSong = new JPanel();

        public DisplayAlbumContent(){
            super();
            this.setLayout(new BorderLayout());
            this.setBackground(new Color(3,11,21));
            this.setVisible(true);

            addsong("src\\Graphics\\center\\LibraryDisplay\\songTest\\www.mp3");
            addsong("src\\Graphics\\center\\LibraryDisplay\\songTest\\qqq.mp3");
            addsong("src\\Graphics\\center\\LibraryDisplay\\songTest\\rrr.mp3");
            addsong("src\\Graphics\\center\\LibraryDisplay\\songTest\\yyy.mp3");
            addsong("src\\Graphics\\center\\LibraryDisplay\\songTest\\eee.mp3");
            addsong("src\\Graphics\\center\\LibraryDisplay\\songTest\\ttt.mp3");

            createListPanel();
            createLiveSongPanel(songslist.get(0));
            this.add(list,BorderLayout.CENTER);
            this.add(liveSong,BorderLayout.NORTH);
        }

        public void createListPanel(){

            list.setLayout(new BorderLayout());
            list.setBackground(new Color(10, 11, 21));
            list.setMaximumSize(new Dimension(800,800));
            list.setVisible(true);
            //header and data of songList.
            Object[][] data = new Object[songslist.size()][6];
            for(int i = 0; i < songslist.size() ; i++) {
                data[i] = songslist.get(i).getInfo("AL");
            }
            String[] headLine = {"   \uD83C\uDFBA ️" ," \uD83D\uDD24 TITLE",
                    "  \uD83C\uDFA4 ️ARTISTS"," \uD83D\uDCBF ALBUM"," \uD83D\uDCC6 YEAR"," \uD83D\uDD52"};
            //make table not editable.
            DefaultTableModel tableModel = new DefaultTableModel(data, headLine){
                @Override
                public boolean isCellEditable(int row, int column) {
                    // make read and editable cell fields except column 1,2,3,4
                    return column == 1 || column == 2 || column == 3 || column == 4 ? false : true;
                }
            };
            songsTable = new JTable(tableModel);

            songsTable.getColumnModel().getColumn(0).setCellRenderer(new ButtonRenderer());
            songsTable.getColumnModel().getColumn(0).setCellEditor(
                    new ButtonEditor(new JCheckBox()));

            setTableProperties(songsTable);
            list.add(new JScrollPane(songsTable),BorderLayout.CENTER);

        }

        public void createLiveSongPanel(Song s){
            liveSong.setLayout(new BorderLayout());
            liveSong.setBackground(new Color(3,11,21));
            liveSong.setVisible(true);

            JLabel artworkSong = new JLabel();
            JButton playBt = new JButton("PLAY");
            pro.setLabelProperties(artworkSong,600,110,"Brush Script MT",14,SwingConstants.LEFT);
            pro.setButtonProperties(playBt,100,100,JButton.CENTER,JButton.CENTER,SwingConstants.LEFT);
            playBt.setIcon(pro.getImageArtwork("C:\\Users\\hashemi\\Desktop\\Jpotify\\src\\Graphics\\icons\\MusicIcons\\ppp.png",50,50));

            Image newimg = s.getArtwork().getImage().getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;
            artworkSong.setIcon(new ImageIcon(newimg));
            artworkSong.setText("<html><p>&emsp;<font size = \"20\">"+s.getTitle()+
                    "</font><p>&emsp;"+s.getArtists()+"<br>&emsp;"+s.getLastTimePlayed()+"</html>");

            liveSong.add(artworkSong,BorderLayout.WEST);
            liveSong.add(playBt,BorderLayout.EAST);
        }


        public void setTableProperties(JTable tb){

            JTableHeader header = tb.getTableHeader();
            header.setBackground(new Color(3,11,21));
            header.setForeground(Color.WHITE);
            header.setFont(new Font("Sherif", Font.BOLD, 12));
            header.setPreferredSize(new Dimension(100,25));
            UIManager.getDefaults().put("TableHeader.cellBorder" , BorderFactory.createEmptyBorder(0,0,0,0));
            tb.setShowGrid(false);
            ((DefaultTableCellRenderer)tb.getTableHeader().getDefaultRenderer())
                    .setHorizontalAlignment(JLabel.LEFT);
            tb.setRowHeight(25);
            tb.setPreferredSize(new Dimension(100,800));
            tb.setForeground(Color.white);
            tb.setBackground(new Color(3,11,21));
            tb.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
            //tb.setEnabled(false);
            for(int i = 0; i < 5; i++ ){
                TableColumn column = tb.getColumnModel().getColumn(i);

                if(i == 0)
                    column.setPreferredWidth(25);
                else if (i == 1)
                    column.setPreferredWidth(250);//sport column is bigger
                else if(i == 2 || i == 3 )
                    column.setPreferredWidth(150);
                else
                    column.setPreferredWidth(50);
            }
        }

        public void addsong(String path){
                Song s = new Song(path);
                songslist.add(s);
        }


        public void sortSongByTime(){
        }

}

