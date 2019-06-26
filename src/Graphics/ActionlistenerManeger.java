package Graphics;

import Graphics.center.LibraryDisplay.Center;
import Graphics.south.South;
import org.json.simple.parser.ParseException;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



public class ActionlistenerManeger {
    private static String name;
    private static String path;
    private static String nextName;
    private static String previousName;
    private static Song song ;

    public ActionlistenerManeger(){

    }

    public void changeViewInAlbumDisplay(JButton list, Center views,String card,Album album){
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(album!=null)
                    views.changeCentralAlbumListView(album);
                views.getCardLayout().show(views.getPanel(),card);

            }
        });
    }

    public void changeView(JButton list, Center views,String card,String filePath){
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(filePath!=null)
                    views.changePath(filePath);
//                if(album!=null)
//                    views.changeAlbum(album);
                views.changeCentralView();
                views.getCardLayout().show(views.getPanel(),card);

            }
        });
    }


    public void SetSong(Song song,Song nextSong,Song previousSong,int row) {
     if(row!=7) {
         name = song.getJsonFileName();
         path = song.getSongPath();
         nextName = nextSong.getJsonFileName();
         previousName = previousSong.getJsonFileName();
     }else{
//         try {
//             //deleteMusic(song.getJsonFileName());
//         } catch (IOException e) {
//             e.printStackTrace();
//         } catch (ParseException e) {
//             e.printStackTrace();
//         }
     }
    }

    public void ChangeArtwork(Song s , South south){
        south.getLeft().changeArtwork(s);
        System.out.println(s.getTitle());
        south.getLeft().getCardArtworkLayout().show(south.getLeft().getPanel(),"ARTWORK");
    }

    public void changeMusic(Song song){
        System.out.println(song.getTitle());

    }

    public String getSongName(){
        return  name;
    }

    public String getNextSongName(){
        return nextName;
    }

    public  String getPreviousSongName(){
        return previousName;
    }

    public String getSongPath(){
        return path;
    }

    }




