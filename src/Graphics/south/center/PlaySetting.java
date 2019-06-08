package Graphics.south.center;

import javax.swing.*;
import java.awt.*;

public class PlaySetting extends JPanel {

    JLabel emptySpace = new JLabel();
    JLabel speaker = new JLabel();
    RunningTime volume = new RunningTime(0,0);

    public PlaySetting(){
        super();
        this.setLayout(new BorderLayout());

        setLableProperties(emptySpace);
        setLableProperties(speaker);
        setLableIcon(speaker);

        this.add(emptySpace,BorderLayout.WEST);
        this.add(speaker,BorderLayout.CENTER);
        this.add(volume,BorderLayout.EAST);

        this.setVisible(true);


    }

   // 😍 😃

    public void setLableProperties(JLabel label){
        label.setOpaque(true);
        label.setBackground(new Color(3, 11, 21  ));
        label.setForeground(Color.WHITE);
        label.setPreferredSize(new Dimension(100,30));
    }

    public void setLableIcon(JLabel label){
        ImageIcon icon = new ImageIcon("C:\\Users\\hashemi\\Desktop\\Jpotify\\src\\Graphics\\icons\\wicon\\33.png");
        Image newimg = icon.getImage().getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;
        label.setIcon(new ImageIcon( newimg ));
    }

}
