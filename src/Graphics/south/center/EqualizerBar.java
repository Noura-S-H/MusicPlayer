package Graphics.south.center;
import Graphics.AddProperties;
import davaguine.jeq.spi.EqualizerInputStream;
import javazoom.jl.decoder.Equalizer;
import Graphics.ActionlistenerManeger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.TargetDataLine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class EqualizerBar extends JPanel {

    private ActionlistenerManeger alm = new ActionlistenerManeger();
    AddProperties pro = new AddProperties();
    JButton lyric;
    JLabel artwork;

    public EqualizerBar(){
        super();
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        lyric =  new JButton("LYRIC");
        pro.setButtonProperties(lyric,150,100,JButton.CENTER,JButton.LEFT,SwingConstants.CENTER);
        lyric.setIcon(pro.getImageArtwork(
                "src\\Graphics\\icons\\MusicIcons\\ppp.png",50,50));
        lyric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        alm.setLyric();
                    }
                }).start();
            }
        });
        this.add(lyric);



        this.add(lyric);
//        try {
//            EqualizerInputStream eq = new EqualizerInputStream(
////                    new AudioInputStream((TargetDataLine) new FileInputStream(
//////                            new File("src\\Files\\songTest\\sss.mp3")) ),3);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        artwork = new JLabel();
        pro.setColor(Color.white);
        pro.setLabelProperties(artwork,200,100,"",12,SwingConstants.LEFT);
       // this.add(artwork,BorderLayout.SOUTH);
        this.add(lyric,BorderLayout.EAST);
        //this.add(eq,BorderLayout.CENTER);
    }


}
