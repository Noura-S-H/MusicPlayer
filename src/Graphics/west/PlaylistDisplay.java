package Graphics.west;
import Graphics.AddProperties;
import Graphics.center.LibraryDisplay.Center;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;


import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import Graphics.PlayListManager;
import Graphics.SongsManeger;
import Graphics.ActionlistenerManeger;
import Graphics.Playlist;
public class PlaylistDisplay extends JPanel {

    private ActionlistenerManeger alm = new ActionlistenerManeger();
    private PlayListManager pm = new PlayListManager();
    private static final String LABEL_TEXT = "  \uD83C\uDFA7  Your Playlist ";
    private AddProperties pro = new AddProperties();
    ArrayList<String> playListsName = new ArrayList<>();
    JList list = new JList();


    public PlaylistDisplay(Center view) {
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        JLabel label = new JLabel(LABEL_TEXT);
        pro.setLabelProperties(label,150,30,"",12,SwingConstants.LEFT);

        setPlayListsName();
        list = new JList (playListsName.toArray());
        list.setBackground(new Color(3,11,21));
        list.setForeground(Color.white);
        list.setFont(new Font("Trebuchet MS", Font.BOLD, 12));


        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setPreferredSize(new Dimension(150,50));
        listPanel.add(new JScrollPane(list),BorderLayout.CENTER);
        this.add(listPanel,BorderLayout.CENTER);
        this.add(label, BorderLayout.NORTH);

        alm.changeViewInPlayListDisplay(list,view,"PLAYLIST",pm.getPlaylists());
//
//        list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                System.out.println("fddf");
//            }
//        });

    }

    public void setPlayListsName() {
        ArrayList<Playlist> pl = pm.getPlaylists();
        for (int i = 0; i<pl.size();i++){
            playListsName.add("<html>&emsp; > "+pl.get(i).getName()+"</html>");
        }

    }

    public void updateList(ArrayList<String> s){

    }



}