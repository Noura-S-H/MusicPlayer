package Graphics.south.right;

import javax.swing.*;
import java.awt.*;

public class Setting extends JPanel {

    JLabel l = new JLabel();
    public Setting(){
        super();
        this.setLayout(new BorderLayout());

        setLableProperties(l);
        this.add(l,BorderLayout.CENTER);
        this.setVisible(true);
    }

   // 😍 😃

    public JLabel setLableProperties(JLabel label){
        label.setOpaque(true);
        label.setBackground(new Color(3, 11, 21  ));
        label.setForeground(Color.WHITE);
        label.setPreferredSize(new Dimension(100,30));
        ImageIcon icon = new ImageIcon("C:\\Users\\hashemi\\Desktop\\Jpotify\\src\\Graphics\\icons\\wicon\\33.png");
        Image newimg = icon.getImage().getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;
        label.setIcon(new ImageIcon( newimg ));
        return label;
    }

}
