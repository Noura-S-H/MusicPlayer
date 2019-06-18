package Graphics.south.left;

import javax.swing.*;
import java.awt.*;


public class SongInfo extends JPanel {

    private JLabel artworkLable,songInformation;
    private  boolean favorites = false;
    private String songName ="songName",singerName ="singerName",artwork = "iii.jpg";


    public SongInfo(){
        super();
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        artworkLable = new JLabel(getImageAlbum(artwork));
        setLableProperties(artworkLable,150,100);
        this.add(artworkLable,BorderLayout.CENTER);
        songInformation = new JLabel(labelSongInfo(songName,singerName),SwingConstants.LEFT);
        setLableProperties(songInformation,150,50);
        this.add(songInformation,BorderLayout.SOUTH);
    }

    public  void setLableProperties(JLabel label,int width,int heiqth){
        label.setOpaque(true);
        label.setBackground(new Color(3, 11, 21 ));
        label.setPreferredSize(new Dimension(width,heiqth));
        // label.setBackground(new Color(26, 89, 79 ));
        label.setFont(new Font("Brush Script MT", Font.PLAIN, 14));
        label.setForeground(Color.WHITE);
    }

    public ImageIcon getImageAlbum(String albumPicture){
        ImageIcon imIcon = new ImageIcon("C:\\Users\\hashemi\\Desktop\\"+ albumPicture);
        Image newimg = imIcon.getImage().getScaledInstance( 130, 100,  java.awt.Image.SCALE_SMOOTH ) ;
        imIcon = new ImageIcon( newimg );
        return imIcon;
    }

    public String labelSongInfo(String songName,String singerName){
        String sn = "&emsp;";
        String info = "<html>"+ sn + songName +"<br>"+ sn + singerName +"<br></html>";
        return info;
    }








}