package Graphics;

import Graphics.center.LibraryDisplay.Center;
import Graphics.south.South;
import Graphics.south.center.RunningTime;
import Logic.PlayMusic;
import org.json.simple.parser.ParseException;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class ActionlistenerManeger {


    private static ArrayList<Song> thisList;
    private PlayMusic playMusic = new PlayMusic();
    private static int songRow = 0;
    private static Song thisSong;



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


    public void SetSong(ArrayList<Song> list,int col,int row) {
        thisList = list;
        if(col == 0) {
            this.thisSong = list.get(row);
            songRow = row;
        }
        if(col == 7){
            try {
                playMusic.stopMusic();
                playMusic.deleteMusic(thisSong.getJsonFileName());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    public void ChangeArtwork(Song s , South south){
        south.getLeft().changeArtwork(s);
        System.out.println(s.getTitle());
        south.getLeft().getCardArtworkLayout().show(south.getLeft().getPanel(),"ARTWORK");
    }


    public void changeViewInPlayListDisplay(JList list,Center view,String card,Playlist playlist){
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

            }
        });
    }

//
//    public void updateRunningTime (South south){
//        RunningTime rt = south.getCenter().getPlay().getPlayerBar();
//        rt = new RunningTime(thisSong.getSongPath());
//    }



    public ArrayList<Song> getThisList() {
        return thisList;
    }

    public Song getThisSong() {
        return thisSong;
    }

    public int getSongRow() {
        return songRow;
    }
}




