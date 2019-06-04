package Graphics.south.center;

import javax.swing.*;
import java.awt.*;

public class Nothing extends JPanel {

    JLabel artwork;

    public Nothing(){
        super();
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        artwork = new JLabel("artwork");
        setLableProperties(artwork,200,100);
        this.add(artwork,BorderLayout.SOUTH);
    }

    public  void setLableProperties(JLabel label,int width,int heiqth){
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setPreferredSize(new Dimension(width,heiqth));
        label.setForeground(Color.WHITE);
    }



}
