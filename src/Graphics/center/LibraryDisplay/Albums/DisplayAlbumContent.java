package Graphics.center.LibraryDisplay.Albums;

import Graphics.ActionlistenerManeger;
import Graphics.AddProperties;
import Graphics.Song;
import Graphics.center.LibraryDisplay.ButtonEditor;
import Graphics.center.LibraryDisplay.ButtonRenderer;
import Graphics.Album;
import Graphics.south.South;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DisplayAlbumContent extends JPanel {

        private ActionlistenerManeger am = new ActionlistenerManeger();
        private AddProperties pro = new AddProperties();
        private ArrayList<Song> songslist = new ArrayList<Song>();
        private JTable songsTable;

        private JPanel list = new JPanel();
        private JPanel liveSong = new JPanel();

        public DisplayAlbumContent(Album thisAlbumChoosed, South south){
            super();
            this.setLayout(new BorderLayout());
            this.setBackground(new Color(3,11,21));
            this.setVisible(true);

            songslist = thisAlbumChoosed.getSongs();

            createListPanel(south);
            createLiveSongPanel(songslist.get(0));
            this.add(list,BorderLayout.CENTER);
            this.add(liveSong,BorderLayout.NORTH);
        }

        public void createListPanel(South south){

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
            songsTable.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        JTable target = (JTable)e.getSource();
                        int row = target.getSelectedRow();
                        int col = target.getSelectedColumn();
                        am.ChangeArtwork(songslist.get(row) , south);
                        am.SetSong(songslist,row,col);

                    }
                }
            });


            songsTable.getColumnModel().getColumn(0).setCellRenderer(new ButtonRenderer());
            songsTable.getColumnModel().getColumn(0).setCellEditor(
                    new ButtonEditor(new JCheckBox()));
            pro.setTableProperties(songsTable,100,25,100,800,25,5);
            list.add(new JScrollPane(songsTable),BorderLayout.CENTER);


        }

        public void createLiveSongPanel(Song s){
            liveSong.setLayout(new BorderLayout());
            liveSong.setBackground(new Color(3,11,21));
            liveSong.setVisible(true);

            JLabel artworkSong = new JLabel();
            pro.setLabelProperties(artworkSong,600,110,"Brush Script MT",15,SwingConstants.LEFT);


            Image newimg = s.getArtwork().getImage().getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;
            artworkSong.setIcon(new ImageIcon(newimg));
            artworkSong.setText("<html><p>&emsp;<font size = \"20\">"+s.getTitle()+
                    "</font><p>&emsp;"+s.getArtists()+"<br>&emsp;"+s.getLastTimePlayed()+"</html>");

            liveSong.add(artworkSong,BorderLayout.WEST);
        }


        public void addSong(){

        }



        public JPanel getPanel(){
            return this;
        }


        public void sortSongByTime(){
        }

}

