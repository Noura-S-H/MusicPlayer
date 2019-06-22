package Graphics.south.center;
import Graphics.AddProperties;
import javax.swing.*;
import java.awt.*;

public class Nothing extends JPanel {
    private AddProperties pro = new AddProperties();
    JLabel artwork;

    public Nothing(){
        super();
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        artwork = new JLabel("artwork");
        pro.setLabelProperties(artwork,200,100,"",12,SwingConstants.LEFT);
        this.add(artwork,BorderLayout.SOUTH);
    }


}
