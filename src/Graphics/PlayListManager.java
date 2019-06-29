package Graphics;

import Graphics.south.center.Play;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;




public class PlayListManager {

    private static final String PLAYLISTS_PATH = System.getProperty("user.dir") + "/src/Files/playlists.json";
    ArrayList<Playlist> playlists = new ArrayList<Playlist>();
    //save all name of play lists with their position that exists
    HashMap<Integer,String> allName_HM = new HashMap<Integer, String>();



    public PlayListManager(){

        try {
            getAllNamePlayList(PLAYLISTS_PATH);

            for(int i : allName_HM.keySet()){
                playlists.add(new Playlist(allName_HM.get(i)));
                ArrayList<String> paths = new ArrayList<>();
                JSONArray arr = (JSONArray) getPlaylist(allName_HM.get(i));
                for (int j = 0; j < arr.size(); j++) {
                    String p = (String) arr.get(j);
                    paths.add(p);
                }
                playlists.get(i).setPaths(paths);
            }

            for (int i = 0; i<playlists.size();i++){
                System.out.println(playlists.get(i).getName());
                for(int j = 0 ;j<playlists.get(i).getPaths().size(); j++){
                    System.out.println(playlists.get(i).getPaths().get(j));
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }


    /**
     * read the JSON file containing the playlists
     *
     * @return Existing playlist JSONArray object
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public static JSONArray readPlaylistJson()
            throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jarr = null;
        Object obj;
        try {
            obj = parser.parse(new FileReader(PLAYLISTS_PATH));
            jarr = (JSONArray) obj;
        } catch (IOException | NullPointerException | ParseException e) {
            System.out.println(e);
        }
        return jarr;
    }


    /**
     * Returns required playlist
     *
     * @param name Name the playlist
     * @return String ArrayList containing playlist songs
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static ArrayList<String> getPlaylist(String name)
            throws IOException, FileNotFoundException, ParseException {
        ArrayList<String> array;
        JSONArray jarr = readPlaylistJson();
        JSONObject aux = new JSONObject();
        if (!jarr.isEmpty()) {
            for (int i = 0; i < jarr.size(); i++) {
                JSONObject jobj = (JSONObject) jarr.get(i);
                if (jobj.containsKey(name)) {
                    array = (ArrayList<String>) jobj.get(name);
                    return array;
                }
            }
        }
        return null;
    }


    public HashMap<Integer,String> getAllNamePlayList(String filePath)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readPlaylistJson();
        JSONObject jobj;
        for (int i = 0; i < jarr.size(); i++) {
            jobj = (JSONObject) jarr.get(i);

            Set<String> s = jobj.keySet();
            String songName = s.toString().substring(1, s.toString().length() - 1);

            allName_HM.put(i,songName);

        }
        return allName_HM;
    }


    private ArrayList<String> updateMusicsList(String playlistName)
            throws IOException, FileNotFoundException, ParseException {
        ArrayList<String> musics = getPlaylist(playlistName);

        return musics;
    }

    public void addToPlaylists(Playlist p){
        playlists.add(p);
    }

    public static void main(String[] args){
        PlayListManager pm = new PlayListManager();
    }



}
