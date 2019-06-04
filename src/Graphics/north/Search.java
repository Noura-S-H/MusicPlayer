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
}
