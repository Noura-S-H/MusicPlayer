package Graphics.west;
import Graphics.AddProperties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;


import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import Graphics.PlayListManager;
import Graphics.SongsManeger;
public class PlaylistDisplay extends JPanel {

    private SongsManeger sm = new SongsManeger("src\\Files\\musics.json");
    private static final String LABEL_TEXT = "  \uD83C\uDFA7  Your Playlist ";
    private AddProperties pro = new AddProperties();
    ArrayList<String> playListsName = new ArrayList<>();
    JList list = new JList();


    public PlaylistDisplay() {
        super();
        ArrayList<String> s = new ArrayList<>();
        for (int i =0; i<10;i++)
                s.add("ddd");
        playListsName = s;
        list = new JList ();
        this.add(new JScrollPane(list),BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        JLabel label = new JLabel(LABEL_TEXT);
        pro.setLabelProperties(label,150,30,"",12,SwingConstants.LEFT);
        this.add(label, BorderLayout.NORTH);

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

            }
        });

    }


    public void setPlayListsName(ArrayList<String> playListsName) {
        this.playListsName = playListsName;
    }

    public void updateList(ArrayList<String> s){

    }



}