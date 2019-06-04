package Graphics.south.center;


import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class Center extends JPanel {

    Play play = new Play();
    Nothing nothing = new Nothing();

    public Center(){
        this.setLayout(new BorderLayout());
        //this.setSize(300,600);
        this.add(play,BorderLayout.CENTER);
        this.add(nothing,BorderLayout.NORTH);
        this.setVisible(true);
    }
}