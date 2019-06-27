package Graphics.west;
import Graphics.AddProperties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
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
    JButton[] btList = new JButton[10];


    public PlaylistDisplay() {
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        JLabel label = new JLabel(LABEL_TEXT);
        pro.setLabelProperties(label,150,30,"",12,SwingConstants.LEFT);
        this.add(label, BorderLayout.NORTH);

    }

    public void setMusicsNameToButtons(JButton[] buttons){
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton(playListsName.get(i));
            pro.setButtonProperties(buttons[i],300,40,JButton.CENTER,JButton.CENTER,SwingConstants.LEFT);
        }
    }


    public void addSongToPlaylist(File file) {
        //playlist.addElement(file);
    }

}