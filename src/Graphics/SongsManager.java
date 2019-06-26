package Graphics;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class SongsManager{

    HashMap<String,String> name_path_HM = new HashMap<String, String>();
    ArrayList<Song> musics = new ArrayList<Song>();

    String musicJsonFile;
    public SongsManager(String musicJsonFile){
        this.musicJsonFile = musicJsonFile;
        try {
            setSongsPathsToHM(musicJsonFile);
            createSongsFromMusicsPaths();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public static JSONArray readMusicJson(String path)
            throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jarr = null;
        Object obj;
        try {
            obj = parser.parse(new FileReader(path));
            jarr = (JSONArray) obj;
        } catch (IOException | NullPointerException | ParseException e) {
            // System.out.println(e);
        }
        return jarr;
    }

    public void setSongsPathsToHM(String filePath)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readMusicJson(filePath);
        JSONObject jobj;
        for (int i = 0; i < jarr.size(); i++) {
            jobj = (JSONObject) jarr.get(i);

            Set<String> s = jobj.keySet();
            String songName = s.toString().substring(1, s.toString().length() - 1);

            String ss = String.valueOf(jobj.values());
            String songPath = ss.toString().substring(1, ss.toString().length() - 1);

            name_path_HM.put(songName,songPath);
        }

    }

    public String filePathWithName(String musicName){
        String path = name_path_HM.get(musicName);
        return path;
    }

    public void createSongsFromMusicsPaths(){
        for(String name : name_path_HM.keySet()) {
            musics.add(new Song(name_path_HM.get(name)));
        }
    }

    public String getMusicJsonFile() {
        return musicJsonFile;
    }

    public HashMap<String, String> getName_path_HM() {
        return name_path_HM;
    }

    public ArrayList<Song> getMusics() {
        return musics;
    }

    public static void  main(String args[]){
        SongsManager song = new SongsManager("/src/Files/musics.json");
        System.out.println(song.getName_path_HM());
    }
}