package Graphics.west;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;

public class PlayList extends JPanel {

    DefaultListModel<File> playlist = new DefaultListModel<File>();
    JList<File> list;
    private static final String LABEL_TEXT = "  \uD83C\uDFA7  Your Playlist ";

    public PlayList() {
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        JLabel label = new JLabel(LABEL_TEXT);
        setLableProperties(label);
        this.add(label, BorderLayout.NORTH);


        list = new JList<File>(playlist);
        this.add(list, BorderLayout.CENTER);
        JScrollPane scroll = new JScrollPane(list);
        // this.add(scroll);
    }

    public void setListProperties(JButton button) {

    }

    public void setLableProperties(JLabel label) {
        label.setOpaque(true);
        label.setBackground(new Color(3, 11, 21));
        label.setForeground(Color.WHITE);
        label.setPreferredSize(new Dimension(150, 30));
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }


    public void addSongToPlaylist(File file) {
        playlist.addElement(file);
    }
}