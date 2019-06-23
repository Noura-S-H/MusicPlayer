package Graphics.north;

import javax.swing.*;
import java.awt.*;

public class North extends JPanel {


    Search search = new Search();
    Profile profile ;
    public North(String username,String password){
        super();


        profile = new Profile(username,password);
        this.setLayout(new BorderLayout());
        this.add(search, BorderLayout.WEST);
        this.add(profile,BorderLayout.EAST);
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);
    }



}
