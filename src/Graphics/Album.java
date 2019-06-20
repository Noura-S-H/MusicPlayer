package Graphics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Album extends Song{


    private HashMap<String, List<String> > nameAlbum;
    private List<String> songsPath;

    public Album(){
        super();
        nameAlbum = new HashMap<>();
         songsPath = new ArrayList<>();
    }



    public void addSong(Song s){

       for(String i : nameAlbum.keySet() ) {
           if (i != null) {
               if (s.getAlbum().equals(i)) {
                   songsPath.add(s.getSongPath());
                   nameAlbum.put(i, songsPath);
               }

           } else {
                   songsPath.add(s.getSongPath());
                   nameAlbum.put(i, songsPath);
               }
           }

    }

    public void removeSong(Song s){
       for(List<String> i : nameAlbum.values()){
           if(i != null){
               if(i.equals(s.getSongPath())){
                   i.remove(s.getSongPath());
               }
           }
       }
    }


}
