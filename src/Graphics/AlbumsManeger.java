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

        boolean check = false;
        for(int i = 0; i < allSongs.size(); i++){
            Song temp = allSongs.get(i);
            for (int j = 0; j < albumsName.size(); j++){
                if(temp.getAlbum().equals(temp))
                    check = true;
            }
            if(check == false) {
                albumsName.add(allSongs.get(i).getAlbum());
            }
        }
    }


    public void createAlbums(){
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
            String name =albums.get(i).getAlbumName().replaceAll("[ : , \t,\0 ]" , "_");
            String nameFile = "C:\\Users\\hashemi\\Desktop\\Jpotify\\src\\Files\\"+name+".txt";
            System.out.println(nameFile);
            File f = new File(nameFile);
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
                    if(i == s.size()-1) {
                        file.print(s.get(j).getSongPath());
                    }
                    else {
                        System.out.println(s.get(j).getSongPath());
                        file.println(s.get(j).getSongPath());
                    }
                }
                file.close();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }


    }

    public static void main(String[] args){
        AlbumsManeger am = new AlbumsManeger();
    }



}