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
import java.util.Set;

public class AlbumsManeger{

    ArrayList<String> albumsName = new ArrayList<String>();
    ArrayList<Album> albums = new ArrayList<Album>();
    ArrayList<Song> allSongs = new ArrayList<Song>();
    ArrayList<String> allSongsPath = new ArrayList<String>();
    private static final String ALBUMS_PATH = System.getProperty("user.dir") + "/src/Files/albums.json";

    public AlbumsManeger(){
        try {
            setPathsToAllSongsPaths();
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

    //read music for create list of all music exists in library
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
            allSongsPath.add(ss.toString().substring(1, ss.toString().length() - 1));

        }
        for(int i = 0; i < allSongsPath.size(); i++) {
            allSongs.add(new Song(allSongsPath.get(i)));

        }

    }

    public void findAlbumsName(){

        boolean exists = false;
        for(int i = 0; i < allSongs.size(); i++){
            String temp = allSongs.get(i).getAlbum();
            for (int j = 0; j < albumsName.size(); j++){
                if(temp.replaceAll("[ : , \t, \0 ]" , "_")
                         .equals(albumsName.get(j).replaceAll("[ : , \t, \0 ]" , "_")))
                    exists = true;
            }
            if(exists == false) {
                albumsName.add(allSongs.get(i).getAlbum());
            }
            exists = false;
        }
    }


    public void createAlbums(){
        for(int i = 0; i<albumsName.size(); i++){
            albums.add(new Album(albumsName.get(i)));
        }
        for(int i = 0; i < albumsName.size(); i++){
            for (int j = 0; j < allSongs.size(); j++) {
                String albumName = albums.get(i).getAlbumName().replaceAll("[ : , \t, \0 ]" , "_");
                String songAlbumName = allSongs.get(j).getAlbum().replaceAll("[ : , \t, \0 ]" , "_");

                if (albumName.equals(songAlbumName)) {
                    albums.get(i).addSong(allSongs.get(j));
                    albums.get(i).addPath(allSongs.get(j).getSongPath());
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

    public static void main(String[] args){
        AlbumsManeger am = new AlbumsManeger();

    }



}