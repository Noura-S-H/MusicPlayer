package Graphics;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AlbumsManeger{

    SongsManeger sm = new SongsManeger(System.getProperty("user.dir") + "/src/Files/musics.json");
    HashMap<String,String> HM = sm.getName_path_HM();

    ArrayList<String> albumsName = new ArrayList<String>();
    ArrayList<Album> albums = new ArrayList<Album>();


    //HashMap<String,String> name_path_HM = new HashMap<String, String>();

    private static final String ALBUMS_PATH = System.getProperty("user.dir") + "/src/Files/albums.json";

    public AlbumsManeger(){
        try {

            findAlbumsName();
            createAlbums();
            for(int i = 0; i < albums.size(); i++)
                insertAlbums(albums.get(i).getAlbumName(),albums.get(i).getPaths());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    public void findAlbumsName(){

        boolean exists = false;
        for(int i = 0; i < sm.getMusics().size(); i++){
            String temp = sm.getMusics().get(i).getAlbum();
            for (int j = 0; j < albumsName.size(); j++){
                if(temp.replaceAll("[ : , \t, \0 ]" , "_")
                         .equals(albumsName.get(j).replaceAll("[ : , \t, \0 ]" , "_")))
                    exists = true;
            }
            if(exists == false) {
                albumsName.add(sm.getMusics().get(i).getAlbum());
            }
            exists = false;
        }
    }


    public void createAlbums(){
        for(int i = 0; i<albumsName.size(); i++){
            albums.add(new Album(albumsName.get(i)));
        }
        for(int i = 0; i < albumsName.size(); i++){
            for (int j = 0; j < sm.getMusics().size(); j++) {
                String albumName = albums.get(i).getAlbumName().replaceAll("[ : , \t, \0 ]" , "_");
                String songAlbumName = sm.getMusics().get(j).getAlbum().replaceAll("[ : , \t, \0 ]" , "_");

                if (albumName.equals(songAlbumName)) {
                    albums.get(i).addSong(sm.getMusics().get(j));
                    albums.get(i).addPath(sm.getMusics().get(j).getSongPath());
                }
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
    public static JSONArray readAlbumsJson()
            throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jarr = null;
        Object obj;
        try {
            obj = parser.parse(new FileReader(ALBUMS_PATH));
            jarr = (JSONArray) obj;
        } catch (IOException | NullPointerException | ParseException e) {
            System.out.println(e);
        }
        return jarr;
    }


    public static boolean insertAlbums(String albName, ArrayList<String> pathsOfalbumSongs)
            throws IOException, FileNotFoundException, ParseException {

        JSONArray jarr = readAlbumsJson();
        JSONObject aux = new JSONObject();
        FileWriter writeFile;

        aux.put(albName, pathsOfalbumSongs);
        jarr.add(aux);
        writeFile = new FileWriter(ALBUMS_PATH);
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();
        return true;
    }


   /* public static ArrayList<String> getAlbums(String name)
            throws IOException, FileNotFoundException, ParseException {
        ArrayList<String> array;
        JSONArray jarr = readAlbumsJson();
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
    }*/


    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public static void main(String[] args) {
        AlbumsManeger am = new AlbumsManeger();

    }



}