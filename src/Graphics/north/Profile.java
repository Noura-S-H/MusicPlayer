package Graphics.north;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class Profile extends JPanel {

    private JLabel emptySpace;
    private String[] profile = {"name","id"};
    private JComboBox<String> profileInfo;

    public Profile(){
        super();
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);
        profileInfo = new JComboBox<String>(profile);
        profileInfo.setBackground(new Color(3,11,21));
        profileInfo.setForeground(Color.white);
        profileInfo.setPreferredSize(new Dimension(150,20));
        //profileInfo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));

        for (int i = 0; i < profileInfo.getComponentCount(); i++) {
            if (profileInfo.getComponent(i) instanceof JComponent) {
                ((JComponent) profileInfo.getComponent(i)).setBorder(new EmptyBorder(0, -10, 0, 0));

            }
        }

        this.add(profileInfo);
    }

    


}

