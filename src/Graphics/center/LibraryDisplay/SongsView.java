package Graphics.center.LibraryDisplay;


import Graphics.Song;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class SongsView extends JPanel {

    private ArrayList<Song> songslist = new ArrayList<Song>();
    private JTable table;

    private JPanel list = new JPanel();

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

        setTableProperties(table);
        list.add(new JScrollPane(table),BorderLayout.CENTER);

    }


    public void setTableProperties(JTable tb){

        JTableHeader header = tb.getTableHeader();
        header.setBackground(new Color(3,11,21));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Sherif", Font.BOLD, 12));
        header.setPreferredSize(new Dimension(100,35));
        UIManager.getDefaults().put("TableHeader.cellBorder" , BorderFactory.createEmptyBorder(0,0,0,0));
        tb.setShowGrid(false);
        tb.setRowHeight(35);
        tb.setPreferredSize(new Dimension(100,800));
        tb.setForeground(Color.white);
        tb.setBackground(new Color(3,11,21));
        tb.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        ((DefaultTableCellRenderer)tb.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.LEFT);
        //tb.setEnabled(false);
        for(int i = 0; i < 7; i++ ){
            TableColumn column = tb.getColumnModel().getColumn(i);
            if(i == 0)
                column.setPreferredWidth(25);
            else if(i == 1)
                column.setPreferredWidth(30);
            else if (i == 2)
                column.setPreferredWidth(250);//sport column is bigger
            else if(i == 3 || i == 4 )
                column.setPreferredWidth(150);
            else
                column.setPreferredWidth(50);

        }
    }

    public void addToSongsListFromFile(String pt){

        try (BufferedReader br = new BufferedReader(new FileReader(new File(pt)))) {
            String line;
            while ((line = br.readLine()) != null) {
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

class ImageRenderer extends DefaultTableCellRenderer {
    JLabel lbl = new JLabel();
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        ImageIcon icon = (ImageIcon)value;
        lbl.setIcon(new ImageIcon(icon.getImage()
                .getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH)));

        return lbl;
    }
}
