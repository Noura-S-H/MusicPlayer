package Graphics.center.LibraryDisplay.Album;

import javax.swing.*;
import java.awt.*;



public class AlbumsDisplay extends JPanel{


        JPanel right = new JPanel(new FlowLayout());
        JPanel left = new JPanel(new FlowLayout());
        JPanel center = new JPanel(new FlowLayout());

        public AlbumsDisplay(){
            super();


            left.setLayout(new GridLayout(2,1));
            left.setBackground(new Color(3, 11, 21));

            center.setLayout(new GridLayout( 2,1));
            center.setBackground(new Color(3 ,11 ,21));

            right.setLayout(new GridLayout(2 ,3));
            right.setBackground(new Color(3 ,11 ,21));


            leftPanelDesign();
            centerPanelDesign();
            rightPanelDesign();


            this.add(left , BorderLayout.WEST);
            this.add(center , BorderLayout.CENTER);
            this.add(right , BorderLayout.EAST);
            this.setVisible(true);

        }

        public void leftPanelDesign(){

            JButton leftAlbumUP = new JButton("Left Button Up");
            JButton leftAlbumDown = new JButton("Left Button Down");
            Create(leftAlbumUP, left);
            Create(leftAlbumDown , left);

        }

        public void centerPanelDesign(){
            JButton centerAlbumUP = new JButton("Center Button Up");
            JButton centerAlbumDown = new JButton("Center Button Down");
            Create(centerAlbumUP, center);
            Create(centerAlbumDown , center);
        }

    public void rightPanelDesign(){
        JButton rightAlbumUP = new JButton("Right Button UP");
        JButton rightAlbumDown = new JButton("Right Button Down");
        Create(rightAlbumUP, right);
        Create(rightAlbumDown , right);
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
        Icon warnIcon = new ImageIcon("src\\Graphics\\icons\\artwork\\images.jpg");
        button.setIcon(warnIcon);
        button.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
        button.setForeground(Color.white);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setHorizontalTextPosition(JButton.CENTER);

    }

}
