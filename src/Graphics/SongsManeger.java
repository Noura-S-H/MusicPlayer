package Graphics;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class SongsManeger{

    HashMap<String,String> name_path_HM = new HashMap<String, String>();

    String musicJsonFile;
    public SongsManeger(String musicJsonFile){
        this.musicJsonFile = musicJsonFile;
    }


    public static JSONArray readMusicJson()
            throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jarr = null;
        Object obj;
        try {
            obj = parser.parse(new FileReader(System.getProperty("user.dir") + "/src/Files/musics.json"));
            jarr = (JSONArray) obj;
        } catch (IOException | NullPointerException | ParseException e) {
            // System.out.println(e);
        }
        return jarr;
    }

    public void setPathsToAllSongsPaths()
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readMusicJson();
        JSONObject jobj;
        for (int i = 0; i < jarr.size(); i++) {
            jobj = (JSONObject) jarr.get(i);

            Set<String> s = jobj.keySet();
            String songName = s.toString().substring(1, s.toString().length() - 1);

            String ss = String.valueOf(jobj.values());
            String songPath = ss.toString().substring(1, ss.toString().length() - 1);

            name_path_HM.put(songName,songPath);
        }

        for (String name : name_path_HM.keySet()){
            System.out.println(name + " "+ name_path_HM.get(name));
        }
    }

    public String getMusicJsonFile() {
        return musicJsonFile;
    }

    public HashMap<String, String> getName_path_HM() {
        return name_path_HM;
    }

    public String filePathWithName(String musicName){
        String path = name_path_HM.get(musicName);
        return path;
    }

    /*public static  void main(String[] args){
        SongsManeger sm = new SongsManeger(System.getProperty("user.dir") + "/src/Files/musics.json");
        try {
            sm.setPathsToAllSongsPaths();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }*/

}