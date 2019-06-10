package Graphics.west;

import javax.swing.*;
import java.awt.*;

public class Library extends JPanel {


    private final String[] name = {" Add To Library","Songs","Albums","Favorites ","Shared Playlist"};
    private JButton buttons[] = new JButton[5];

    public Library() {
        super();
        this.setLayout(new GridLayout(6, 1));
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);


        JLabel label = new JLabel("  \uD83C\uDFA7  Libray");
        setLableProperties(label);
        this.add(label);


        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("       \uD83C\uDFB5 " + name[i]);
            setButtonsProperties(buttons[i]);
            add(buttons[i]);
        }
    }


    public void setButtonsProperties(JButton button){
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(new Color(3, 11, 21));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        //button.setFont(new Font("Open Sans", Font.BOLD, 12));
        button.setForeground(Color.white);
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(150, 30));
    }

    public  void setLableProperties(JLabel label){
        label.setOpaque(true);
        label.setSize(new Dimension(150,30));
        label.setBackground(new Color(3, 11, 21 ));
        label.setForeground(Color.WHITE);
    }



}
