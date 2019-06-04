package Graphics.west;

import javax.swing.*;
import java.awt.*;

public class NewPlayList extends JPanel {

    JButton button;

    public NewPlayList() {
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        button = new JButton("➕ New playList ");
        setButtonsProperties(button);
        this.add(button, BorderLayout.CENTER);
    }
}
