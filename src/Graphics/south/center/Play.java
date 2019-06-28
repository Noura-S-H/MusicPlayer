package Graphics.south.center;
import Graphics.AddProperties;

import Graphics.ActionlistenerManeger;
import Graphics.center.LibraryDisplay.SongsView;
import Graphics.south.South;
import Logic.PlayMusic;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import Graphics.Song;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class Play extends JPanel {


    private static final String FAVORITES_PATH = System.getProperty("user.dir") + "/src/Files/Favorite.json";
    private AddProperties pro = new AddProperties();
    private ActionlistenerManeger alm = new ActionlistenerManeger();
    private JButton[] playButtons = new JButton[6];
    private String[] buttonIcons = {"7.png","20.png","21.png","18.png","29.png","23.png"};

    private RunningTime playerBar = new RunningTime(0,300)
            ;
    private PlaySetting playSetting = new PlaySetting();
    private JButton favorites;
    PlayMusic m = new PlayMusic();
    private JList<String> musicsList = new JList<>();
    private String nameOfSong;

    public Play(South south){
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


        playButtons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPreviousActionPerformed(evt,south);
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
                btnNextActionPerformed(evt,south);
            }
        });

        this.add(playerBar);

        favorites = new JButton(pro.getImageArtwork("src\\Graphics\\icons\\wicon\\3.png",25,25));
        pro.setButtonProperties(favorites,30,50,JButton.CENTER,JButton.CENTER,SwingConstants.CENTER);
        this.add(favorites);

        favorites.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {

                    if(alm.getThisSong().getFavorite() == true) {
                        alm.getThisSong().setFavorite(false);
                        favorites.setIcon(pro.getImageArtwork("src\\Graphics\\icons\\wicon\\3.png",25,25));
                        try {
                            playMusic.stopMusic();
                            playMusic.deleteMusic(thisSong.getJsonFileName());
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        deleteFromFavorite(alm.getThisSong().getJsonFileName());
                    }
                    else {
                        alm.getThisSong().setFavorite(true);
                        favorites.setIcon(pro.getImageArtwork("src\\Graphics\\icons\\wicon\\111.png",25,25));
                        insertMusicToFavorites(evt);
                    }
                    insertMusicToFavorites(evt);


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

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
                //System.out.println(alm.getSongName());
                m.playMusic((String) alm.getThisSong().getJsonFileName());
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


    private void btnNextActionPerformed(ActionEvent evt,South south) {
        System.out.println("next");

        try {
            m.stopMusic();
            int newRow = alm.getSongRow() + 1;
            if(newRow <= alm.getThisList().size()) {
                alm.SetSong(alm.getThisList(), 0, newRow);
            }
            m.playMusic(alm.getThisSong().getJsonFileName());
            playButtons[0].setEnabled(true);
            alm.ChangeArtwork(alm.getThisSong(),south);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void btnPreviousActionPerformed(ActionEvent evt,South south){
        System.out.println("previous");
        //int index = musicsList.getSelectedIndex();
        try {
            m.stopMusic();
            int newRow = alm.getSongRow() - 1;
            if(newRow >= 0) {
                alm.SetSong(alm.getThisList(),0,newRow);
            }
            // musicsList.setSelectedIndex(index - 1);
            m.playMusic((String) alm.getThisSong().getJsonFileName());
            playButtons[0].setEnabled(true);
            alm.ChangeArtwork(alm.getThisSong(),south);

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



    public static JSONArray readFavoritesJson()
            throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jarr = null;
        Object obj;
        try {
            obj = parser.parse(new FileReader(FAVORITES_PATH));
            jarr = (JSONArray) obj;
        } catch (IOException | NullPointerException | ParseException e) {
            System.out.println(e);
        }
        return jarr;
    }

    public boolean insertMusicToFavorites(ActionEvent evt)
            throws IOException, FileNotFoundException, ParseException {
        String music = alm.getThisSong().getJsonFileName();
        String  path = alm.getThisSong().getSongPath();
        JSONArray jarr = readFavoritesJson();
        JSONObject aux = new JSONObject();
        FileWriter writeFile;

        if (!jarr.isEmpty()) {
            for (int i = 0; i < jarr.size(); i++) {
                JSONObject jobj = (JSONObject) jarr.get(i);
                if (jobj.containsKey(music)) {
                    deleteFromFavorite(music);
                    return false;
                }
            }
        }
        aux.put(music, path);
        jarr.add(aux);
        writeFile = new FileWriter(FAVORITES_PATH);
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();
        return true;
    }

    public static void deleteFromFavorite(String musicname)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jsonArray;
        jsonArray = readFavoritesJson();
        FileWriter writeFile;
        if (!jsonArray.isEmpty()) {
            for (int i = 0; i < jsonArray.size(); i++) {
                //copy jsonarray's JSONObject value
                JSONObject obj = (JSONObject) jsonArray.get(i);

                if (obj.containsKey(musicname)) {
                    //update the array of songs
                    jsonArray.remove(i);
                    break;
                }
            }
            //update by writing to json
            writeFile = new FileWriter(FAVORITES_PATH);
            JSONArray.writeJSONString(jsonArray, writeFile);
            writeFile.close();
        }
    }
}

