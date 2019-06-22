package Graphics.north;
import Graphics.AddProperties;
import javax.swing.*;
import java.awt.*;

public class Search extends JPanel {

    private AddProperties pro = new AddProperties();
    private JLabel emptySpace = new JLabel();
    private final JLabel searchIcon;
    private JTextArea searchBar;

    public Search() {
        super();
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);
        searchBar = new JTextArea(1,14);
        searchIcon = new JLabel();


        pro.setJTaxtFieldProperties(searchBar,true,true);
        pro.setImageIcon(searchIcon,"src\\Graphics\\icons\\wicon\\search.png",20,20);
        pro.setLabelProperties(searchIcon,20,20,"",12,SwingConstants.LEFT);
        pro.setLabelProperties(emptySpace,140,20,"",12,SwingConstants.LEFT);

        this.add(emptySpace);
        this.add(searchIcon);
        this.add(new JScrollPane(searchBar));

    }


}
