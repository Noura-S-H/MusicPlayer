package Graphics.south.right;


import Graphics.south.right.Setting;

import javax.swing.*;
import java.awt.*;

public class Right extends JPanel {

    Setting setting = new Setting();
    public Right(){
            super();
            this.setLayout(new BorderLayout());
            this.add(setting, BorderLayout.CENTER);
            this.setVisible(true);
    }
}