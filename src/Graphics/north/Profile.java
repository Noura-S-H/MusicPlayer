package Graphics.north;
import Graphics.AddProperties;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Profile extends JPanel {

    private AddProperties pro = new AddProperties();
    private JLabel proIcon = new JLabel();
    private JLabel emptySpace = new JLabel();
    private String[] profile = {"Username","id"};
    private JComboBox<String> profileInfo  = new JComboBox<String>(profile);

    public Profile(){
        super();
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        pro.setImageIcon(proIcon,"src\\Graphics\\icons\\wicon\\32.png",20,20);
        pro.setLabelProperties(emptySpace,140,20,"",12,SwingConstants.LEFT);
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


}

