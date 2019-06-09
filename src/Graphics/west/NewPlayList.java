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

    public void setButtonsProperties(JButton button){
        button.setVerticalTextPosition(JButton.TOP);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setPreferredSize(new Dimension(150,30));
        button.setForeground(Color.white);
        button.setBackground(new Color(3, 11, 21 ));
    }
}
