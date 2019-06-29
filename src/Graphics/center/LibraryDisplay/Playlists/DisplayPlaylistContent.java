package Graphics.center.LibraryDisplay.Playlists;

import Graphics.ActionlistenerManeger;
import Graphics.AddProperties;
import Graphics.Song;
import Graphics.center.LibraryDisplay.ButtonEditor;
import Graphics.center.LibraryDisplay.ButtonRenderer;
import Graphics.center.LibraryDisplay.ImageRenderer;
import Graphics.south.South;
import Graphics.Playlist;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

public class DisplayPlaylistContent extends JPanel {

    private ActionlistenerManeger am = new ActionlistenerManeger();
    private String path;

    private AddProperties pro = new AddProperties();
    private ArrayList<Song> songslist = new ArrayList<Song>();
    //private ArrayList<String> Allpaths = new ArrayList<String>();
    private JPanel list = new JPanel();
    private JTable table;
    JButton share = new JButton();



    public DisplayPlaylistContent(Playlist playlist, South south){
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3,11,21));
        this.setVisible(true);
        songslist = playlist.getSongs();

        createListPanel(south);
        this.add(list,BorderLayout.CENTER);
    }

    public void createListPanel(South south){

        list.setLayout(new BorderLayout());
        list.setBackground(new Color(10, 11, 21));
        list.setMaximumSize(new Dimension(800,800));
        list.setVisible(true);
        //header and data of songList.
        Object[][] data = new Object[songslist.size()][7];
        for(int i = 0; i < songslist.size() ; i++) {
            data[i] = songslist.get(i).getInfo("SV");
        }
        String[] headLine = {"   \uD83C\uDFBA ️" ,""," \uD83D\uDD24 TITLE",
                "  \uD83C\uDFA4 ️ARTISTS"," \uD83D\uDCBF ALBUM"," \uD83D\uDCC6 YEAR"," \uD83D\uDD52","\uD83D\uDDD1️"};

        //make table not editable.
        DefaultTableModel tableModel = new DefaultTableModel(data, headLine){
            @Override
            public boolean isCellEditable(int row, int column) {
                // make read and editable cell fields except column 1,2,3,4
                return column == 1 || column == 2 || column == 3 || column == 4 || column == 5 || column == 6? false : true;
            }


        };
        table = new JTable(tableModel);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    am.ChangeArtwork(songslist.get(row) , south);
                    am.SetSong(songslist,column,row);
                }
            }
        });

        table.getColumnModel().getColumn(0).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(0).setCellEditor(new ButtonEditor(new JCheckBox()));

        table.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));

        table.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());

        pro.setTableProperties(table,100,35,100,800,35,7);
        pro.setButtonProperties(share,800,30,JButton.CENTER,JButton.CENTER,SwingConstants.LEFT);
        pro.getImageArtwork("src\\Graphics\\icons\\wicon\\28.png",20,20);

        share.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        list.add(share,BorderLayout.NORTH);
        list.add(new JScrollPane(table),BorderLayout.CENTER);

    }


    public void sortSongByTime(){
    }

    public JPanel getPanel(){
        return this;
    }


}

