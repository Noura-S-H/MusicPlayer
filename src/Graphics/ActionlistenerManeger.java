package Graphics;

import Graphics.center.LibraryDisplay.Center;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionlistenerManeger {

    public ActionlistenerManeger(){

    }


    public void changeView(JButton bt, Center views,String card,String filePath){
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(filePath!=null)
                    views.changePath(filePath);
                views.getCardLayout().show(views.getPanel(),card);

            }
        });
    }
}
