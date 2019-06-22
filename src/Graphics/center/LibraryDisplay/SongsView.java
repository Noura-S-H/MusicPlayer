package Graphics.center.LibraryDisplay;


import Graphics.AddProperties;
import Graphics.Song;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class SongsView extends JPanel {
    private AddProperties pro = new AddProperties();
    private ArrayList<Song> songslist = new ArrayList<Song>();
    private JPanel list = new JPanel();
    private JTable table;

    public SongsView(String pathsFile){
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3,11,21));
        this.setVisible(true);

        addToSongsListFromFile(pathsFile);

        createListPanel();
        this.add(list,BorderLayout.CENTER);
    }

    public void createListPanel(){

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
                "  \uD83C\uDFA4 ️ARTISTS"," \uD83D\uDCBF ALBUM"," \uD83D\uDCC6 YEAR"," \uD83D\uDD52"};

        //make table not editable.
        DefaultTableModel tableModel = new DefaultTableModel(data, headLine){
            @Override
            public boolean isCellEditable(int row, int column) {
                // make read and editable cell fields except column 1,2,3,4
                return column == 1 || column == 2 || column == 3 || column == 4 || column == 5 ? false : true;
            }
        };
        table = new JTable(tableModel);

        table.getColumnModel().getColumn(0).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(0).setCellEditor(
                new ButtonEditor(new JCheckBox()));
        table.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());

        pro.setTableProperties(table,100,35,100,800,35,7);
        list.add(new JScrollPane(table),BorderLayout.CENTER);

    }


    public void addToSongsListFromFile(String pt){

        try (BufferedReader br = new BufferedReader(new FileReader(new File(pt)))) {
            String line;
            while ((line = br.readLine()) != null) {
                songslist.add(new Song(line));
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sortSongByTime(){
    }


}

