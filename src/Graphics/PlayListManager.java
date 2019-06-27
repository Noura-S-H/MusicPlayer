package Graphics;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;




public class PlayListManager {

    private static final String PLAYLISTS_PATH = System.getProperty("user.dir") + "/src/Files/playlists.json";
    ArrayList<Playlist> playlists = new ArrayList<Playlist>();



    public PlayListManager(){

        JSONArray jarr = new JSONArray();
        for(int i = 0; i < playlists.size(); i++ ){
            try {
                insertPlaylist(playlists.get(i).getName(),playlists.get(i).getPaths(),jarr);
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
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
     * Insert a new playlist into the playlists file
     *
     * @param name Name of Playlist to be created
     * @param array Array of songs from Playlist
     * @return True if successfully added or False if not
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static boolean insertPlaylist(String name, ArrayList<String> array,JSONArray jarr)
            throws IOException, FileNotFoundException, ParseException {

        JSONObject aux = new JSONObject();
        FileWriter writeFile;
        int i = 0;
        aux.put(name, array);
        jarr.add(aux);
        writeFile = new FileWriter(PLAYLISTS_PATH);
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();
        return true;
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

    public void addToPlaylists(Playlist p){
        playlists.add(p);
    }



}
