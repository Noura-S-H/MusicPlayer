package Graphics.south.center;
import Graphics.AddProperties;

import Graphics.ActionlistenerManeger;
import Graphics.center.LibraryDisplay.SongsView;
import Logic.PlayMusic;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static Logic.PlayMusic.deleteMusic;

public class Play extends JPanel {

    private AddProperties pro = new AddProperties();
    private ActionlistenerManeger alm = new ActionlistenerManeger();
    private JButton[] playButtons = new JButton[6];
    private String[] buttonIcons = {"7.png","20.png","21.png","18.png","29.png","34.png"};
    private RunningTime playerBar = new RunningTime(0,300);
    private PlaySetting playSetting = new PlaySetting();
    private JButton favorites;
    PlayMusic m = new PlayMusic();
    private JList<String> musicsList = new JList<>();
    private String nameOfSong;
    public Play(){
        super();
        this.nameOfSong = nameOfSong;
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        for(int i = 0; i < playButtons.length ; i++){
            playButtons[i] = new JButton(pro.getImageArtwork("src\\Graphics\\icons\\wicon\\"+buttonIcons[i],25,25));
            pro.setButtonProperties(playButtons[i],30,30,JButton.CENTER,JButton.CENTER,SwingConstants.CENTER);
            this.add(playButtons[i]);
        }

        playButtons[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        playButtons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        playButtons[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        playButtons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnPlayActionPerformed(evt);

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
                System.out.println(alm.getSongName());
                m.playMusic((String) alm.getSongName());
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
            m.playMusic((String) alm.getNextSongName());
            playButtons[0].setEnabled(true);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void btnPreviousActionPerformed(ActionEvent evt){
        System.out.println("next");
        //int index = musicsList.getSelectedIndex();
        try {
            m.stopMusic();
            // musicsList.setSelectedIndex(index - 1);
            m.playMusic((String) alm.getPreviousSongName());
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
    /**
     * Deletes from the system the selected music
     *
     * @param evt
     */
    private void deleteBtnActionPerformed(ActionEvent evt) {

        try {
            deleteMusic("Ahmad-Solo-Mimiram-@Otaghe8Bot.mp3");

        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


