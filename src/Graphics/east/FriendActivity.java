package Graphics.east;
import Graphics.AddProperties;
import javax.swing.*;
import java.awt.*;

public class FriendActivity extends JPanel {

    private AddProperties pro = new AddProperties();
    DefaultListModel<Friend> friends = new DefaultListModel<Friend>();
    JList<Friend> friendList;
    private static final String LABEL_TEXT = "  \uD83D\uDC6C Friend Activity ";

    public FriendActivity(){
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3,11,21));
        this.setVisible(true);

        JLabel friendActivity = new JLabel(LABEL_TEXT);
        pro.setLabelProperties(friendActivity,150,30,"",12,SwingConstants.LEFT);
        this.add(friendActivity, BorderLayout.NORTH);
        friendList = new JList<Friend>(friends);
        this.add(friendList, BorderLayout.CENTER);
        JScrollPane scroll = new JScrollPane(friendList);

    }


    public void addNewFriend(Friend f){
        friendList.add(f);
    }

    public void removeFriend(Friend f){
        friendList.remove(f);
    }




}