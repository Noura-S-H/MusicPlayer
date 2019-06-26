package Graphics.center.LibraryDisplay;

import Graphics.ActionlistenerManeger;
import Graphics.AddProperties;
import Graphics.Song;
import Graphics.south.South;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

public class SongsView extends JPanel {

    private ActionlistenerManeger am = new ActionlistenerManeger();
    private String path;

    private AddProperties pro = new AddProperties();
    private ArrayList<Song> songslist = new ArrayList<Song>();
    //private ArrayList<String> Allpaths = new ArrayList<String>();
    private JPanel list = new JPanel();
    private JTable table;
    private int row;


    public SongsView(String pathsFile, South south){
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3,11,21));
        this.setVisible(true);

        try {
            setPathsToAllSongsPaths(pathsFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
                return column == 1 || column == 2 || column == 3 || column == 4 || column == 5 ? false : true;
            }


        };
        table = new JTable(tableModel);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                     row = target.getSelectedRow();
                     am.ChangeArtwork(songslist.get(row) , south);
                    am.SetSong(songslist.get(row),songslist.get(row+1),songslist.get(row-1),row);

                }
            }
        });

        table.getColumnModel().getColumn(0).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(0).setCellEditor(new ButtonEditor(new JCheckBox()));

        table.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));

        table.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());

        pro.setTableProperties(table,100,35,100,800,35,7);
        list.add(new JScrollPane(table),BorderLayout.CENTER);

    }


    //read music for create list of all music exists in library
    public static JSONArray readMusicJson(String p)
            throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jarr = null;
        Object obj;
        try {
            obj = parser.parse(new FileReader(p));
            jarr = (JSONArray) obj;
        } catch (IOException | NullPointerException | ParseException e) {
            // System.out.println(e);
        }
        return jarr;
    }

    public void setPathsToAllSongsPaths(String jsonpath)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readMusicJson(jsonpath);
        JSONObject jobj;
        if(jarr != null) {
            for (int i = 0; i < jarr.size(); i++) {
                jobj = (JSONObject) jarr.get(i);
                String ss = String.valueOf(jobj.values());

                songslist.add(new Song(ss.toString().substring(1, ss.toString().length() - 1)));

            }
        }

    }

    public String getNameOfSong(){

        return songslist.get(row).getTitle();
    }



    public void sortSongByTime(){
    }

    public JPanel getPanel(){
        return this;
    }


}

