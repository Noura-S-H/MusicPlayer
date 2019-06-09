package Graphics.south.center;

import javax.swing.*;
import java.awt.*;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.jar.JarEntry;

public class RunningTime extends JPanel {

    JSlider runningTime;

    public RunningTime(int startsecond, int endsecond){
        super();
        this.setLayout(new BorderLayout());
        runningTime = new JSlider(startsecond,endsecond,0);
        this.setVisible(true);
        runningTime.setPaintTicks(false);
        runningTime.setPaintLabels(true);
        runningTime.setBackground(new Color(3, 11, 21));
        runningTime.setPreferredSize(new Dimension(endsecond,20));


        this.add(runningTime);

    }

}
