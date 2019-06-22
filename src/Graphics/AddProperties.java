package Graphics;

import javax.swing.*;
import java.awt.*;

public class AddProperties{
    Color color = new Color(3,11,21);
    public AddProperties(){}


    public JLabel setLabelProperties(JLabel lab,int width, int height,String font,int sizeFont,int alignment){
        lab.setOpaque(true);
        lab.setForeground(Color.WHITE);
        lab.setPreferredSize(new Dimension(width,height));
        lab.setBackground(color);
        lab.setFont(new Font(font, Font.BOLD, sizeFont));
        lab.setHorizontalAlignment(alignment);
        lab.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        return lab;
    }

    public JButton setButtonProperties(JButton butt,int width,int height,int verTexPos,int horTexPos,int horAlignment){
        butt.setForeground(Color.white);
        butt.setBackground(color);
        butt.setVerticalTextPosition(verTexPos);
        butt.setHorizontalTextPosition(horTexPos);
        butt.setHorizontalAlignment(horAlignment);
        butt.setBorder(BorderFactory.createEmptyBorder());
        butt.setPreferredSize(new Dimension(width,height));
        //butt.setIcon(getImageArtwork("src\\Graphics\\icons\\artwork\\18.jpg"));
        return butt;
    }

    public ImageIcon getImageArtwork(String path,int widthIcon,int heightIcon){
        ImageIcon icon = new ImageIcon(path);
        Image newimg = icon.getImage().getScaledInstance( widthIcon, heightIcon,java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon( newimg );
        return icon;
    }

    public ImageIcon getImageSong(ImageIcon icon) {
        ImageIcon imIcon = new ImageIcon(icon.getImage()
                .getScaledInstance(130, 100, java.awt.Image.SCALE_SMOOTH));
        return imIcon;
    }

    public void setImageIcon(JLabel lab,String path,int widthPic, int heightPic){
        ImageIcon icon = new ImageIcon(path);
        Image newimage = icon.getImage().getScaledInstance( widthPic, heightPic,  java.awt.Image.SCALE_SMOOTH ) ;
        lab.setIcon(new ImageIcon( newimage ));
    }

    public void getImage(){

    }

}