package Graphics;

import javax.swing.*;
import java.awt.*;

public class Properties{
    public Properties(){

    }


    public JLabel setLabelProperties(JLabel lab,int width, int height,String font,int sizeFont,String alignment){
        lab.setOpaque(true);
        lab.setForeground(Color.WHITE);
        lab.setPreferredSize(new Dimension(width,height));
        lab.setBackground(new Color(3, 11, 21 ));
        lab.setFont(new Font(font, Font.PLAIN, sizeFont));
        lab.setHorizontalAlignment(Integer.parseInt(alignment));
        lab.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        return lab;

    }

    public void setButtonProperties(){

    }

    public void gitImageArtwork(){

    }

}