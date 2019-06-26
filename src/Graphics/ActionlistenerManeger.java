package Graphics;

import Graphics.center.LibraryDisplay.Center;
import Graphics.south.South;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionlistenerManeger {

    public ActionlistenerManeger(){

    }


    public void changeView(JButton list, Center views,String card,String filePath){
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(filePath!=null)
                    views.changePath(filePath);
                views.changeCentralView();
                views.getCardLayout().show(views.getPanel(),card);

            }
        });
    }

    public void changeArtwork(Song song, South south){
        south.getLeft().changeSongArtwork(song);
    //    south.getCenter();

    }

    public void changeMusic(Song song){
        System.out.println(song.getTitle());

    }



}
