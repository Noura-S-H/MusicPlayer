package Graphics.south.center;
import Graphics.AddProperties;
import javax.swing.*;
import java.awt.*;

public class Play extends JPanel {

    private AddProperties pro = new AddProperties();
    private JButton[] playButtons = new JButton[5];
    private String[] buttonIcons = {"23.png","7.png","21.png","18.png","29.png"};
    //private String[] ic = {"list.png","backk.png","play.png","nextt.png","search.png"};
    private RunningTime playerBar = new RunningTime(0,300);
    private PlaySetting playSetting = new PlaySetting();
    private JButton favorites;


    public Play(){
        super();
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        for(int i = 0; i < playButtons.length ; i++){
            playButtons[i] = new JButton(pro.getImageArtwork("src\\Graphics\\icons\\wicon\\"+buttonIcons[i],25,25));
            pro.setButtonProperties(playButtons[i],30,30,JButton.CENTER,JButton.CENTER,SwingConstants.CENTER);
            this.add(playButtons[i]);
        }
        //playerBar.setPreferredSize(new Dimension(300,20));
        this.add(playerBar);

        favorites = new JButton(pro.getImageArtwork("src\\Graphics\\icons\\wicon\\3.png",25,25));
        pro.setButtonProperties(favorites,30,50,JButton.CENTER,JButton.CENTER,SwingConstants.CENTER);
        this.add(favorites);

        this.add(playSetting);

    }


}
