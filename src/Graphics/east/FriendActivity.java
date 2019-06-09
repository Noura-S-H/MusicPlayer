package Graphics.east;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FriendActivity extends JPanel {

    DefaultListModel<Friend> friends = new DefaultListModel<Friend>();
    JList<Friend> friendList;
    private static final String LABEL_TEXT = "  \uD83D\uDC6C Friend Activity ";

    public FriendActivity(){
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3,11,21));
        this.setVisible(true);

        JLabel friendActivity = new JLabel(LABEL_TEXT);
        setLableProperties(friendActivity);
        this.add(friendActivity, BorderLayout.NORTH);
        friendList = new JList<Friend>(friends);
        this.add(friendList, BorderLayout.CENTER);
        JScrollPane scroll = new JScrollPane(friendList);

    }

    public void setLableProperties(JLabel label){
        label.setPreferredSize(new Dimension(150, 30));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setForeground(Color.white);
        label.setOpaque(true);
        label.setBackground(new Color(3, 11, 21));
    }

    public void addNewFriend(Friend f){
        friendList.add(f);
    }

    public void removeFriend(Friend f){
        friendList.remove(f);
    }




}