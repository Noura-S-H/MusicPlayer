package Graphics.north;

import javax.swing.*;
import java.awt.*;

public class North extends JPanel {


    Search search = new Search();
    Profile profile = new Profile();
    public North(){
        super();
        this.setLayout(new BorderLayout());
        this.add(search, BorderLayout.WEST);
        this.add(profile,BorderLayout.EAST);
        this.setVisible(true);
    }



}
