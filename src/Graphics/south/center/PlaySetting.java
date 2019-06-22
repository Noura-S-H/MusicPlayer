package Graphics.south.center;
import Graphics.AddProperties;
import javax.swing.*;
import java.awt.*;

public class PlaySetting extends JPanel {

    private AddProperties pro = new AddProperties();
    JLabel emptySpace = new JLabel();
    JLabel speaker = new JLabel();
    RunningTime volume = new RunningTime(0,100);

    public PlaySetting(){
        super();
        this.setLayout(new BorderLayout());

        pro.setLabelProperties(emptySpace,30,20,"",12,SwingConstants.LEFT);
        pro.setLabelProperties(speaker,30,20,"",12,SwingConstants.LEFT);
        setLableIcon(speaker);

        this.add(emptySpace,BorderLayout.WEST);
        this.add(speaker,BorderLayout.CENTER);
        this.add(volume,BorderLayout.EAST);

        this.setVisible(true);
    }


    public void setLableIcon(JLabel label){
        ImageIcon icon = new ImageIcon("C:\\Users\\hashemi\\Desktop\\Jpotify\\src\\Graphics\\icons\\wicon\\33.png");
        Image newimg = icon.getImage().getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;
        label.setIcon(new ImageIcon( newimg ));
    }

}
