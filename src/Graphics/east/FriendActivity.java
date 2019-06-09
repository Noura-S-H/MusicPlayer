package Graphics.east;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FriendActivity extends JPanel {

    DefaultListModel<File> playlist = new DefaultListModel<File>();
    //⛓️ \uD83D\uDC64 \uD83D\uDC65
    JList<File> list;
    private static final String LABEL_TEXT = "  \uD83D\uDC6C Friend Activity ";

    public FriendActivity(){
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3,11,21));
        this.setVisible(true);

        JLabel friendActivity = new JLabel(LABEL_TEXT);
        setLableProperties(friendActivity);
        this.add(friendActivity, BorderLayout.NORTH);
        list = new JList<File>(playlist);
        this.add(list, BorderLayout.CENTER);
        JScrollPane scroll = new JScrollPane(list);

    }

    public void setLableProperties(JLabel label){
        label.setPreferredSize(new Dimension(150, 30));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setForeground(Color.white);
        label.setOpaque(true);
        label.setBackground(new Color(3, 11, 21));

        /*ImageIcon imIcon = new ImageIcon("C:\\Users\\hashemi\\Desktop\\Jpotify\\src\\Graphics\\icons\\friend\\5 (2).png");
        Image newimg = imIcon.getImage().getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;

        label.setIcon(new ImageIcon( newimg ));*/
    }





}