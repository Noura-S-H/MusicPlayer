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
    String readThisFile = "src\\Files\\Songs.txt";


    public AlbumsManeger(){
        try {
            getAllSongsPath();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // addToSongsListFormSongsFile();
       // insertAlbum(albumsName.get(0),);
        //findAlbumsName();
        //createAlbums();
        //setSongsToAlbums();
        //createBackupAlbumsFile();
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

    public void getAllSongsPath()
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readMusicJson();
        JSONObject jobj;
        ArrayList<String> musicslist = new ArrayList<>();
        for (int i = 0; i < jarr.size(); i++) {
            jobj = (JSONObject) jarr.get(i);
            Set<String> s = jobj.keySet();
            musicslist.add(s.toString().substring(1, s.toString().length() - 1));
        }
         allSongsPath = musicslist;
        for(int i = 0; i < allSongsPath.size(); i++)
            allSongs.add(new Song(allSongsPath.get(i)));

    }



    public void findAlbumsName(){

        boolean exists = false;
        for(int i = 0; i < allSongs.size(); i++){
            String temp = allSongs.get(i).getAlbum();

            for (int j = 0; j < albumsName.size(); j++){
                if(temp.replaceAll("[ : , \t, \0 ]" , "_")
                         .equals(albumsName.get(j).replaceAll("[ : , \t, \0 ]" , "_"))) {
                    exists = true;
                }
            }
            if(exists == false) {
                albumsName.add(allSongs.get(i).getAlbum());
            }
            exists = false;
        }
    }


    public void createAlbums(){
        System.out.println();
        for(int i = 0; i<albumsName.size(); i++){
            albums.add(new Album(albumsName.get(i)));
        }
    }

    public void setSongsToAlbums(){

        for(int i = 0; i < albumsName.size(); i++){
            for (int j = 0; j < allSongs.size(); j++) {
                String albumName = albums.get(i).getAlbumName().replaceAll("[ : , \t, \0 ]" , "_");
                String songAlbumName = allSongs.get(i).getAlbum().replaceAll("[ : , \t, \0 ]" , "_");
                if (albumName.equals(songAlbumName)) {
                    albums.get(i).addSong(allSongs.get(j));
                }
            }
        }

    }

    public static JSONArray readAlbumJson()
            throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();

        JSONArray jarr = null;
        Object obj;
        try {
            obj = parser.parse(new FileReader(System.getProperty("user.dir") + "/src/Files/albums.json"));
            jarr = (JSONArray) obj;
        } catch (IOException | NullPointerException | ParseException e) {
            // System.out.println(e);
        }
        return jarr;
    }

    public static boolean createAlbum(String alName, ArrayList<String> songslist)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readAlbumJson();
        JSONObject aux = new JSONObject();
        FileWriter writeFile;
        int i = 0;
        if (!jarr.isEmpty()) {
            for (i = 0; i < jarr.size(); i++) {
                JSONObject jobj = (JSONObject) jarr.get(i);
            }
        }
        aux.put(alName, songslist);
        jarr.add(aux);
        writeFile = new FileWriter(System.getProperty("user.dir") + "/src/Files/albums.json");
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();
        return true;
    }



    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public static void main(String[] args){
        AlbumsManeger am = new AlbumsManeger();

    }



}