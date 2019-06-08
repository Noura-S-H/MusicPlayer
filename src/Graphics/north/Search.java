package Graphics.north;

import javax.swing.*;
import java.awt.*;

public class Search extends JPanel {

    private JLabel emptySpace = new JLabel();
    private final JLabel searchIcon;
    private JTextArea searchBar;

    public Search() {
        super();
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);
        searchBar = new JTextArea(1,17);
        searchIcon = new JLabel();


        setJTaxtFieldProperties(searchBar);
        setLableProperties(searchIcon);
        setLableProperties(emptySpace);
        this.add(emptySpace);
        this.add(searchIcon);
        this.add(searchBar);

    }

    public void setLableProperties(JLabel label){
        label.setOpaque(true);
        label.setBackground(new Color(3, 11, 21  ));
        label.setForeground(Color.WHITE);
    }

    public void setIconLabel(JLabel label){
        ImageIcon icon = new ImageIcon("C:\\Users\\hashemi\\Desktop\\Jpotify\\src\\Graphics\\icons\\wicon\\search.png");
        Image newimg = icon.getImage().getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;
        label.setIcon(new ImageIcon( newimg ));
    }

    public void setJTaxtFieldProperties(JTextArea textField){
        textField.setEditable(true);
        textField.setLineWrap(true);
        textField.setVisible(true);
        textField.setSize(new Dimension(20,1));
    }


}
