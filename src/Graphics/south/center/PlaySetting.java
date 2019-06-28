package Graphics.south.center;
import Graphics.AddProperties;
import javax.swing.*;
import java.awt.*;

public class PlaySetting extends JPanel {

    private AddProperties pro = new AddProperties();
    JLabel emptySpace = new JLabel();
    JLabel speaker = new JLabel();
    RunningTime volume = new RunningTime(0,100);

    public PlaySetting(){
        super();
        this.setLayout(new BorderLayout());

        pro.setLabelProperties(emptySpace,30,20,"",12,SwingConstants.LEFT);
        pro.setLabelProperties(speaker,30,20,"",12,SwingConstants.LEFT);
        pro.setImageIcon(speaker,"src\\Graphics\\icons\\wicon\\33.png",20,20);

        this.add(emptySpace,BorderLayout.WEST);
        this.add(speaker,BorderLayout.CENTER);
        this.add(volume,BorderLayout.EAST);

        this.setVisible(true);
    }

//    public void setLineGain(float gain)
//    {
//        if (source != null)
//        {
//            FloatControl volControl = (FloatControl) source.getControl(FloatControl.Type.MASTER_GAIN);
//            float newGain = Math.min(Math.max(gain, volControl.getMinimum()), volControl.getMaximum());
//
//            volControl.setValue(newGain);
//        }
//    }
//    if (audio instanceof JavaSoundAudioDevice)
//    {
//        JavaSoundAudioDevice jsAudio = (JavaSoundAudioDevice) audio;
//        jsAudio.setLineGain(yourGainGoesHere);
//    }

}
