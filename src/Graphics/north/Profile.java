package Graphics.north;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class Profile extends JPanel {

    private JLabel proIcon = new JLabel();
    private JLabel emptySpace = new JLabel();
    private String[] profile = {"Username","id"};
    private JComboBox<String> profileInfo  = new JComboBox<String>(profile);

    public Profile(){
        super();
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        setIconLabel(proIcon);
        setLableProperties(emptySpace);
        setJComboBoxProperties(profileInfo);
        this.add(proIcon);
        this.add(profileInfo);
        this.add(emptySpace);
    }

    public void setJComboBoxProperties(JComboBox Combo){
        profileInfo.setBackground(new Color(3,11,21));
        profileInfo.setForeground(Color.white);
        profileInfo.setPreferredSize(new Dimension(150,20));
        for (int i = 0; i < profileInfo.getComponentCount(); i++) {
            if (profileInfo.getComponent(i) instanceof JComponent) {
                ((JComponent) profileInfo.getComponent(i)).setBorder(new EmptyBorder(0, -10, 0, 0));

            }
        }
        //profileInfo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
    }

    public void setLableProperties(JLabel label){
        label.setOpaque(true);
        label.setPreferredSize(new Dimension(140,20));
        label.setBackground(new Color(3, 11, 21 ));
        label.setForeground(Color.WHITE);
    }

    public void setIconLabel(JLabel label){
        ImageIcon icon = new ImageIcon("C:\\Users\\hashemi\\Desktop\\Jpotify\\src\\Graphics\\icons\\wicon\\32.png");
        Image newimg = icon.getImage().getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;
        label.setIcon(new ImageIcon( newimg ));
    }


}

