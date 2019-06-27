package Graphics.west;
import Graphics.AddProperties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class PlayList extends JPanel {

    private AddProperties pro = new AddProperties();
    DefaultListModel<File> playlist = new DefaultListModel<File>();
    JList<File> list;
    private static final String LABEL_TEXT = "  \uD83C\uDFA7  Your Playlist ";
    private static final String PLAYLISTS_PATH = System.getProperty("user.dir") + "/src/Files/playlists.json";

    public PlayList() {
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        JLabel label = new JLabel(LABEL_TEXT);
        pro.setLabelProperties(label,150,30,"",12,SwingConstants.LEFT);
        this.add(label, BorderLayout.NORTH);

        list = new JList<File>(playlist);
        this.add(list, BorderLayout.CENTER);
        JScrollPane scroll = new JScrollPane(list);
        // this.add(scroll);
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
    public static boolean insertPlaylist(String name, ArrayList<String> array)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readPlaylistJson();
        JSONObject aux = new JSONObject();
        FileWriter writeFile;
        int i = 0;
        if (!jarr.isEmpty()) {
            for (i = 0; i < jarr.size(); i++) {
                JSONObject jobj = (JSONObject) jarr.get(i);
                if (jobj.containsKey(name)) {
                    JOptionPane.showMessageDialog(null, "A playlist " + name
                            + " Already in library", "Error", INFORMATION_MESSAGE);
                    return false;
                }
            }
        }
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

    public void addSongToPlaylist(File file) {
        playlist.addElement(file);
    }
}