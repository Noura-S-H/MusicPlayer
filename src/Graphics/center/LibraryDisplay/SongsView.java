package Graphics.center.LibraryDisplay;


import Graphics.Song;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

public class SongsView extends JPanel {

    private ArrayList<Song> songslist = new ArrayList<Song>();
    private JTable songsTable;

    private JPanel list = new JPanel();

    public SongsView(){
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3,11,21));
        this.setVisible(true);

        addsong("src\\Graphics\\icons\\songTest\\www.mp3");
        addsong("src\\Graphics\\icons\\songTest\\qqq.mp3");
        addsong("src\\Graphics\\icons\\songTest\\rrr.mp3");
        addsong("src\\Graphics\\icons\\songTest\\yyy.mp3");
        addsong("src\\Graphics\\icons\\songTest\\eee.mp3");
        addsong("src\\Graphics\\icons\\songTest\\ttt.mp3");

        createListPanel();
        this.add(list,BorderLayout.CENTER);
    }

    public void createListPanel(){

        list.setLayout(new BorderLayout());
        list.setBackground(new Color(10, 11, 21));
        list.setMaximumSize(new Dimension(800,800));
        list.setVisible(true);
        //header and data of songList.
        Object[][] data = new Object[songslist.size()][6];
        for(int i = 0; i < songslist.size() ; i++) {
            data[i] = songslist.get(i).getInfo();
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


    public void sortSongByTime(){
    }

}

