package Graphics;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AlbumsManeger{

    ArrayList<String> albumsName = new ArrayList<String>();
    ArrayList<Album> albums = new ArrayList<Album>();
    ArrayList<Song> allSongs = new ArrayList<Song>();
    String readThisFile = "src\\Files\\Songs.txt";


    public AlbumsManeger(){
        addToSongsFormSongsFile();
        findAlbumsName();
        createAlbums();
        setSongsToAlbums();
        createBackupAlbumsFile();
    }


    public void addToSongsFormSongsFile(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(readThisFile));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                allSongs.add(new Song(line));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
                if (albums.get(i).getAlbumName().equals(allSongs.get(j).getAlbum())) {
                    albums.get(i).addSong(allSongs.get(j));
                }
            }
        }

    }

    public void createBackupAlbumsFile(){
        for (int i = 0; i<albums.size(); i++){
            boolean empty = false;
            String name = albums.get(i).getAlbumName().replaceAll("[ : , \t, \0 ]" , "_");
            String path = "src\\Files\\Albums\\" + name + ".txt";

            File f = new File(path);
            ArrayList<Song> s = albums.get(i).getSongs();
            if(f.length() == 0)
                empty = true;
            try {
                if (!f.exists())
                    f.createNewFile();

                PrintWriter file = new PrintWriter(new FileWriter(f));
                if(empty == false)
                    file.println();

                for(int j = 0; j < s.size() ;j++) {
                    if(i == s.size()-1)
                        file.print(s.get(j).getSongPath());
                    else
                        file.println(s.get(j).getSongPath());

                }
                file.close();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }


    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    /*public static void main(String[] args){
        AlbumsManeger am = new AlbumsManeger();
    }*/



}