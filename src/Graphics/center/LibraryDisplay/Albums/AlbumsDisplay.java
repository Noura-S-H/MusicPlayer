package Graphics.center.LibraryDisplay.Albums;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;




public class AlbumsDisplay extends JPanel{


        private ArrayList<Album> albums= new ArrayList<Album>();
        private ArrayList<JButton>  albutton = new ArrayList<JButton>();

        JPanel right = new JPanel(new FlowLayout());
        JPanel left = new JPanel(new FlowLayout());
        JPanel center = new JPanel(new FlowLayout());

        public AlbumsDisplay(){
            super();

            this.setLayout(new GridLayout(2,4));

            albutton.add(new JButton());
            albutton.add(new JButton());

            albutton.add(new JButton());
            albutton.add(new JButton());


            for( int i = 0; i<albutton.size(); i++) {
                setButtonsProperties(albutton.get(i));
                this.add(albutton.get(i));
            }
            this.setVisible(true);

        }

    private void Create(JButton name, JPanel panel) {
        setButtonsProperties(name);
        panel.setLayout(new GridLayout(2 ,1));
        panel.setBackground(new Color(3, 11, 21));
        panel.setPreferredSize(new Dimension(350  ,790));
        panel.add(name);
        panel.setVisible(true);
    }


    public void setButtonsProperties(JButton button){
        button.setBackground(new Color(3, 11, 21));
        button.setIcon(getImageAlbum("src\\Graphics\\icons\\artwork\\18.jpg"));
        button.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
        button.setForeground(Color.white);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createEmptyBorder());
     //   button.setVerticalTextPosition(JButton.BOTTOM);
      //  button.setHorizontalTextPosition(JButton.CENTER);
        button.setPreferredSize(new Dimension(50,50));

    }

    public ImageIcon getImageAlbum(String albumPicture){
        ImageIcon imIcon = new ImageIcon(albumPicture);
        Image newimg = imIcon.getImage().getScaledInstance( 130, 100,  java.awt.Image.SCALE_SMOOTH ) ;
        imIcon = new ImageIcon( newimg );
        return imIcon;
    }

}
