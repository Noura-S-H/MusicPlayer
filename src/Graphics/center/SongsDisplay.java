package Graphics.center;

import Graphics.Song;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SongsDisplay extends JPanel {
        private ArrayList<Song> songlist;
        JPanel left = new JPanel();
        JPanel right = new JPanel();

        public SongsDisplay(){
            super();
            this.setLayout(new BorderLayout());
            this.setBackground(new Color(3, 11, 21));

            this.add(left,BorderLayout.EAST);
            this.add(right,BorderLayout.WEST);

            this.setVisible(true);

        }

        public void leftPanelDesigne(){

        }


        public void rightPanelDesigne(){

        }

}
