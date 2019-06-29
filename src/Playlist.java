package Graphics.west;
import Graphics.AddProperties;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Playlist extends JPanel {

    private AddProperties pro = new AddProperties();
    DefaultListModel<File> playlist = new DefaultListModel<File>();
    JList<File> list;
    private static final String LABEL_TEXT = "  \uD83C\uDFA7  Your Playlist ";

    public Playlist() {
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        JLabel label = new JLabel(LABEL_TEXT);
        pro.setLabelProperties(label,150,30,"",12,SwingConstants.LEFT);
        this.add(label, BorderLayout.NORTH);

        list = new JList<File>(playlist);
        this.add(list, BorderLayout.CENTER);
        JScrollPane scroll = new JScrollPane(list);
        // this.add(scroll);
    }


    public void addSongToPlaylist(File file) {
        playlist.addElement(file);
    }


}