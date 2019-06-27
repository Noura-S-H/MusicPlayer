package Logic;

import Graphics.Song;
import Graphics.south.left.Artwork;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Set;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;


public class PlayMusic {

    private static final String MUSICS_PATH = System.getProperty("user.dir") + "/src/Files/musics.json";

    private String aux;
    private AdvancedPlayer player;
    private FileInputStream stream;
    private boolean playing = false;
    private boolean paused = false;
    public long duration_song;
    public long pause_position;

    /**
     * Changes the value of paused variable
     *
     * @param b True if paused and False if not
     */
    public void setPausedStatus(boolean b) {
        this.paused = b;
    }

    /**
     * Identifies the current value of the paused variable
     *
     * @return True if it is paused or false if
     */
    public boolean getPaused() {
        return this.paused;
    }

    /**
     * Identifies whether a song is playing
     *
     * @return True if there is a song playing or False if no
     */
    public boolean getPlaying() {
        return this.playing;
    }


    /**
     * read the JSON file containing the songs (and their paths) added to the system
     *
     * @return JSONArray object of existing songs
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public static JSONArray readMusicJson()
            throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jarr = null;
        Object obj;
        try {
            obj = parser.parse(new FileReader(MUSICS_PATH));
            jarr = (JSONArray) obj;
        } catch (IOException | NullPointerException | ParseException e) {
            System.out.println(e);
        }
        return jarr;
    }

    /**
     * Insert a new song in the music archive
     *
     * @param music Name of the song
     * @param path Music path
     * @return True if successfully added or False if not
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static boolean insertMusic(String music, String path)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readMusicJson();
        JSONObject aux = new JSONObject();
        FileWriter writeFile;
        System.out.println(jarr.isEmpty());
        if (!jarr.isEmpty()) {
            for (int i = 0; i < jarr.size(); i++) {
                JSONObject jobj = (JSONObject) jarr.get(i);
                if (jobj.containsKey(music)) {
                    JOptionPane.showMessageDialog(null, "A music " + music
                            + " already in library", "Error", INFORMATION_MESSAGE);
                    return false;
                }
            }
        }
        aux.put(music, path);
        //System.out.println(aux);
        jarr.add(aux);
        //System.out.println(jarr);
        writeFile = new FileWriter(MUSICS_PATH);
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();
        return true;
    }

    /**
     * Delete a song from the system
     *
     * @param musicname Name of the song to be deleted
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void deleteMusic(String musicname)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jsonArray;
        jsonArray = readMusicJson();
        FileWriter writeFile;
        if (!jsonArray.isEmpty()) {
            for (int i = 0; i < jsonArray.size(); i++) {
                //copy jsonarray's JSONObject value
                JSONObject obj = (JSONObject) jsonArray.get(i);

                if (obj.containsKey(musicname)) {
                    //update the array of songs
                    try {
                        stopMusic();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    jsonArray.remove(i);
                    break;
                }
            }
            //update by writing to json
            writeFile = new FileWriter(MUSICS_PATH);
            JSONArray.writeJSONString(jsonArray, writeFile);
            writeFile.close();
        }
    }

    /**
     * Returns all the songs (without their respective paths) registered in the system
     *
     * @return ArrayList
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static ArrayList<String> getMusics()
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readMusicJson();
        JSONObject jobj;
        ArrayList<String> musicslist = new ArrayList<>();
        for (int i = 0; i < jarr.size(); i++) {
            jobj = (JSONObject) jarr.get(i);
            Set<String> s = jobj.keySet();
            musicslist.add(s.toString().substring(1, s.toString().length() - 1));
        }
        return musicslist;
    }

    /**
     * Starts executing a song
     *
     * @param music Name of the song to be played
     * @throws Exception
     */
    public void playMusic(String music) throws Exception {
        System.out.println(music+"yes");
        if (playing == false) {

            try {
                JSONArray jarr = readMusicJson();
                String way = null;
                for (int i = 0; i < jarr.size(); i++) {
                    JSONObject jobj = (JSONObject) jarr.get(i);
                    if (jobj.containsKey(music)) {
                        way = jobj.get(music).toString();
//                        Song s = new Song(way);
//                        new Artwork(s);
                        System.out.println("get");
                    }
                }
                System.out.println("Path Music " + way);
                aux = way;
                stream = new FileInputStream(way);
                player = new AdvancedPlayer(stream);
                // total duration of the music
                duration_song = stream.available();
            } catch (FileNotFoundException | JavaLayerException e) {
                System.out.println(e);
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        player.play();

                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            this.playing = true;
        }
    }

    /**
     * For the execution of a song
     *
     * @throws Exception
     */
    public void stopMusic() throws Exception {
        if (this.player != null && playing == true) {
            this.player.close();
            this.duration_song = 0;
            this.pause_position = 0;
            this.playing = false;
        }
    }

    /**
     * Play music from where it was paused
     *
     * @throws FileNotFoundException
     * @throws JavaLayerException
     * @throws IOException
     */
    public void resumeMusic() throws FileNotFoundException, JavaLayerException, IOException {
        if (this.player != null && paused == true) {
            stream = new FileInputStream(aux);
            stream.skip(duration_song - pause_position);
            player = new AdvancedPlayer(stream);
            new Thread() {
                @Override
                public void run() {
                    try {
                        player.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            this.playing = true;
        }
    }

    /**
     * Pause the music by playing
     *
     * @throws IOException
     */
    public void pauseMusic() throws IOException {
        if (this.player != null && playing == true) {
            pause_position = stream.available();
            this.player.close();
            this.setPausedStatus(true);
        }
    }
}
