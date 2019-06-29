package Graphics.west;
import Graphics.AddProperties;
import Graphics.center.LibraryDisplay.Center;
import Graphics.center.LibraryDisplay.Playlists.DisplayPlaylistContent;
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
    private PlayListManager pm ;
    private ArrayList<String> playListsName = new ArrayList<>();
    private JList list;
    private JPanel listPanel;
    private CardLayout cl = new CardLayout();

    public PlaylistDisplay(Center view) {
        super();
        this.setLayout(cl);
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);
        pm = new PlayListManager();

        setPlayListsName(pm.getPlaylists());
        list = new JList (playListsName.toArray());
        list.setBackground(new Color(3,11,21));
        list.setForeground(Color.white);
        list.setFont(new Font("Trebuchet MS", Font.BOLD, 12));


        listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.setPreferredSize(new Dimension(150,50));
        listPanel.add(new JScrollPane(list),BorderLayout.CENTER);
        this.add(listPanel,"LIST");
      //  this.add(label, BorderLayout.NORTH);

        alm.changeViewInPlayListDisplay(list,view,"PLAYLIST",pm.getPlaylists());
    }

    public void setPlayListsName(ArrayList<Playlist> pmm) {
        ArrayList<Playlist> pl = pmm;
        playListsName = new ArrayList<>();
        for (int i = 0; i<pl.size();i++){
            playListsName.add("<html>&emsp; > "+pl.get(i).getName()+"</html>");
        }

    }

    public void updateList(){
        pm = new PlayListManager();
        setPlayListsName(pm.getPlaylists());
        list = new JList(playListsName.toArray());
        list.setBackground(new Color(3,11,21));
        list.setForeground(Color.white);
        list.setFont(new Font("Trebuchet MS", Font.BOLD, 12));

        listPanel.add(new JScrollPane(list),BorderLayout.CENTER);
        this.add(listPanel,"LIST");
    }

    public JPanel getPanel() {
        return this;
    }

    public CardLayout getCl(){
        return cl;
    }
}