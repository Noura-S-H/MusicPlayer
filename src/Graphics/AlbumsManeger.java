package Graphics;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AlbumsManeger{

    SongsManeger sm;

    ArrayList<String> albumsName = new ArrayList<String>();
    ArrayList<Album> albums = new ArrayList<Album>();

    private static final String ALBUMS_PATH = System.getProperty("user.dir") + "/src/Files/albums.json";

    public AlbumsManeger(){
        try {
             sm = new SongsManeger(System.getProperty("user.dir") + "/src/Files/musics.json");
            findAlbumsName();
            createAlbums();
            JSONArray jarr = new JSONArray();
            for(int i = 0; i < albums.size(); i++)
                insertAlbums(albums.get(i).getAlbumName(),albums.get(i).getPaths(),jarr);

        } catch (IOException | ParseException e) {
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
     * write in jsonfile per album with its musics
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */

    public static boolean insertAlbums(String albName, ArrayList<String> pathsOfalbumSongs,JSONArray jarr)
            throws IOException, FileNotFoundException, ParseException {

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