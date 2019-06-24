package Graphics;

import Graphics.center.LibraryDisplay.Center;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionlistenerManeger {

    public ActionlistenerManeger(){

    }


    public void libraryButtons(JButton bt, Center views,String card,String filePath){
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                views.setPath(filePath);
                views.getCardLayout().show(views.getPanel(),card);

            }
        });
    }
}
