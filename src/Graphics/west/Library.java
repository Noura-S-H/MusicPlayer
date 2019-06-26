package Graphics.west;

import Graphics.AddProperties;

import Graphics.ActionlistenerManeger;
import Graphics.center.LibraryDisplay.Center;
import Logic.PlayMusic;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static Logic.PlayMusic.insertMusic;


public class Library extends JPanel {

    ActionlistenerManeger alm = new ActionlistenerManeger();
    private final String SONGSPATH = "src\\Files\\Songs.txt";
    private final String FAVORITES = "src\\Files\\Favorites.txt";
    JButton buttons[] = new JButton[6];
    String path = "DIFALT";

    PlayMusic m = new PlayMusic();
    private DefaultListModel dlm1;
    private JList<String> musicsList = new JList<>();

    private AddProperties pro = new AddProperties();
    private final String[] name = {" Home"," Add To Library","Songs","Albums","Favorites ","Shared Playlist"};

    public Library(Center view) {
        super();
        this.setLayout(new GridLayout(7, 1));
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        buttons = new JButton[6];

        JLabel label = new JLabel("  \uD83C\uDFA7  Libray");
        pro.setLabelProperties(label,150,30,"",12,SwingConstants.LEFT);
        this.add(label);

        for (int i = 0; i < buttons.length; i++) {
            if(i == 0)
                buttons[i] = new JButton("       \uD83C\uDFE0 " + name[i]);
            else
                buttons[i] = new JButton("       \uD83C\uDFB5 " + name[i]);
            pro.setButtonProperties(buttons[i],150,30,JButton.CENTER,JButton.CENTER,SwingConstants.LEFT);
            add(buttons[i]);
        }

        buttons[1].addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDirecBtnActionPerformed(evt);
                alm.changeView(buttons[3],view,"ALBUMSVIEW",null);
            }
        });



        alm.changeView(buttons[0],view,"HOME",null);
        alm.changeView(buttons[2],view,"SONGSVIEW","src\\Files\\musics.json");
        alm.changeView(buttons[3],view,"ALBUMSVIEW",null);
        alm.changeView(buttons[4],view,"SONGSVIEW","src\\Files\\Favorites.json");

    }

    private void addDirecBtnActionPerformed(ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.showOpenDialog(this);

        try {
            File[] files = chooser.getSelectedFiles();
            for (File file : files) {
                if (insertMusic(file.getName(), file.getAbsolutePath())) {
                    System.out.println(file.getName());
                    System.out.println(file.getAbsolutePath());
                }
            }
        } catch (IOException | ParseException ex) {
            System.out.println(ex);
        }

    }



    public JButton[] getButtons(){
        return buttons;
    }

    public String getPath() {
        return path;
    }
}
