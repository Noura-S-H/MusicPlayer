package Graphics.west;

import Graphics.AddProperties;

import javax.swing.*;
import java.awt.*;

public class Library extends JPanel {

    private final String SONGSPATH = "src\\Files\\Songs.txt";
    private final String FAVORITES = "src\\Files\\Favorites.txt";
    JButton buttons[] = new JButton[6];
    String path = "kkkk";


    private AddProperties pro = new AddProperties();
    private final String[] name = {" Home"," Add To Library","Songs","Albums","Favorites ","Shared Playlist"};

    public Library() {
        super();
        this.setLayout(new GridLayout(7, 1));
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        buttons = new JButton[6];

        JLabel label = new JLabel("  \uD83C\uDFA7  Libray");
        pro.setLabelProperties(label,150,30,"",12,SwingConstants.LEFT);
        this.add(label);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("       \uD83C\uDFB5 " + name[i]);
            pro.setButtonProperties(buttons[i],150,30,JButton.CENTER,JButton.CENTER,SwingConstants.LEFT);
            add(buttons[i]);
        }

       // buttons[0].addActionListener(new Center());
        buttons[1].addActionListener(new AddToLibrary(buttons[1]));


    }

    public JButton[] getButtons(){
        return buttons;
    }

    public String getPath() {
        return path;
    }
}
