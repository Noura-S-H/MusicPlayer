package Graphics.south.center;

import javax.swing.*;
import java.awt.*;

public class Play extends JPanel {

    private JButton[] playButtons = new JButton[5];
    private String[] buttonIcons = {"23.png","7.png","21.png","18.png","29.png"};
    //private String[] ic = {"list.png","backk.png","play.png","nextt.png","search.png"};
    private RunningTime playerBar = new RunningTime();
    private JButton favorites;


    public Play(){
        super();
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        for(int i = 0; i < playButtons.length ; i++){
            playButtons[i] = new JButton(getButtonsIcon (buttonIcons[i]));
            setButtonsProperties(playButtons[i]);
            this.add(playButtons[i]);
        }
        playerBar.setPreferredSize(new Dimension(300,20));
        this.add(playerBar);

        favorites = new JButton(getButtonsIcon("3.png"));
        setButtonsProperties(favorites);
        this.add(favorites);


    }


    public void setButtonsProperties(JButton button){
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(new Color(3, 11, 21  ));
        button.setForeground(Color.white);
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(30, 50));
    }

    public ImageIcon getButtonsIcon(String ic){
        ImageIcon icon = new ImageIcon("C:\\Users\\hashemi\\Desktop\\Jpotify\\src\\Graphics\\icons\\wicon\\"+ ic);
        Image newimg = icon.getImage().getScaledInstance( 25, 25,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon( newimg );
        return icon;
    }

    public JLabel setLableProperties(JLabel label){
        label.setOpaque(true);
        label.setBackground(new Color(3, 11, 21  ));
        label.setForeground(Color.WHITE);
        return label;
    }

}
