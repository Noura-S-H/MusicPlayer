package Graphics.north;

import javax.swing.*;
import java.awt.*;

public class Search extends JPanel {

    private final JLabel searchIcon;

    public Search() {
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        searchIcon = new JLabel();
        setLableProperties(searchIcon);
        this.add(searchIcon, BorderLayout.WEST);

    }

    public JLabel setLableProperties(JLabel label){
        label.setOpaque(true);
        label.setBackground(new Color(3, 11, 21  ));
        label.setForeground(Color.WHITE);
        ImageIcon icon = new ImageIcon("C:\\Users\\hashemi\\Desktop\\Jpotify\\src\\Graphics\\icons\\wicon\\26.png");
        Image newimg = icon.getImage().getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;
        label.setIcon(new ImageIcon( newimg ));
        return label;
    }
}
