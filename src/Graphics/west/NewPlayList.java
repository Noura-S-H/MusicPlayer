package Graphics.west;
import Graphics.AddProperties;
import javax.swing.*;
import java.awt.*;

public class NewPlayList extends JPanel {

    private AddProperties pro = new AddProperties();
    JButton button;

    public NewPlayList() {
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        button = new JButton("➕ New playList ");
        pro.setButtonProperties(button,150,30,JButton.TOP,JButton.CENTER,SwingConstants.CENTER);
        this.add(button, BorderLayout.CENTER);
    }
}
