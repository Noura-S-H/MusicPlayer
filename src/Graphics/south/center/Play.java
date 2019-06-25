package Graphics.south.center;
import Graphics.AddProperties;
import Logic.PlayMusic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Play extends JPanel {

    private AddProperties pro = new AddProperties();
    private JButton[] playButtons = new JButton[5];
    private String[] buttonIcons = {"23.png","7.png","21.png","18.png","29.png"};
    //private String[] ic = {"list.png","backk.png","play.png","nextt.png","search.png"};
    private RunningTime playerBar = new RunningTime(0,300);
    private PlaySetting playSetting = new PlaySetting();
    private JButton favorites;

    PlayMusic m = new PlayMusic();
    private JList<String> musicsList = new JList<>();

    public Play(){
        super();
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        for(int i = 0; i < playButtons.length ; i++){
            playButtons[i] = new JButton(pro.getImageArtwork("src\\Graphics\\icons\\wicon\\"+buttonIcons[i],25,25));
            pro.setButtonProperties(playButtons[i],30,30,JButton.CENTER,JButton.CENTER,SwingConstants.CENTER);
            this.add(playButtons[i]);
        }
        //playerBar.setPreferredSize(new Dimension(300,20));
        this.add(playerBar);


        playButtons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnPlayActionPerformed(evt);

            }
        });

        playButtons[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        playButtons[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        this.add(playerBar);

        favorites = new JButton(pro.getImageArtwork("src\\Graphics\\icons\\wicon\\3.png",25,25));
        pro.setButtonProperties(favorites,30,50,JButton.CENTER,JButton.CENTER,SwingConstants.CENTER);
        this.add(favorites);

        this.add(playSetting);

    }


    /**
     * Starts executing the selected song
     *
     * @param evt
     */
    private void btnPlayActionPerformed(ActionEvent evt) {
        /// System.out.println("play");
        //new ChangeArtwork();

        try {
            if (m.getPaused() == false) {
                if (m.getPlaying() == true) {
                    m.stopMusic();
                }
                m.playMusic((String)"\uD83E\uDD40.mp3");
                playButtons[0].setEnabled(true);
                playButtons[3].setEnabled(true);

            } else {
                playButtons[2].setEnabled(true);
                playButtons[2].setEnabled(true);
                m.resumeMusic();
                m.setPausedStatus(false);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * To completely execute the selected song
     *
     * @param evt
     */


    private void btnNextActionPerformed(ActionEvent evt) {
        System.out.println("next");
        int index = musicsList.getSelectedIndex();
        try {
            m.stopMusic();
            musicsList.setSelectedIndex(index + 1);
            m.playMusic((String) musicsList.getSelectedValue());
            playButtons[0].setEnabled(true);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void btnPauseActionPerformed(ActionEvent evt) {
        System.out.println("pause");

        try {
            m.pauseMusic();
            m.setPausedStatus(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}
