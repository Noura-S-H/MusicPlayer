package Graphics.south.center;

import javax.swing.*;
import java.awt.*;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.jar.JarEntry;

public class RunningTime extends JPanel {

    private final int STARTSECOND = 0, ENDSECOND = 100;
    JSlider runningTime;

    public RunningTime(){
        super();
        this.setLayout(new BorderLayout());
        runningTime = new JSlider(STARTSECOND,ENDSECOND,0);
        this.setVisible(true);
        runningTime.setPaintTicks(false);
        runningTime.setPaintLabels(true);
        runningTime.setBackground(new Color(3, 11, 21));

       // runningTime.putClientProperty( "runningTime.paintThumbArrowShape", Boolean.TRUE );


        this.add(runningTime);

    }

}
