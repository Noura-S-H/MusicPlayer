package Graphics.east;
import Graphics.AddProperties;
import NetWork.Data;
import NetWork.Server;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FriendActivity extends JPanel {

    private AddProperties pro = new AddProperties();
    ArrayList<Friend> friends = new ArrayList<>();
    ArrayList<JButton> friendList = new ArrayList<>();
    private static final String LABEL_TEXT = "  \uD83D\uDC6C Friend Activity ";

   // Data data = new Data();
    Server server = new Server(2000);

    public FriendActivity(){
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3,11,21));
        this.setVisible(true);
        JLabel friendActivity = new JLabel(LABEL_TEXT);
        pro.setLabelProperties(friendActivity,150,30,"",12,SwingConstants.LEFT);
        this.add(friendActivity, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(3,11,21));
        panel.setLayout(new GridLayout(friends.size(),1));

        this.add(new JScrollPane(panel), BorderLayout.CENTER);

    }

    public void setFriendsInfoToButtons(){
       for(int i = 0; i < friends.size(); i++){
//           String ic = "uD83D\uDD0A";
//           if(friends.get(i).getLastPlayed().isPlaying() == true)
//               ic = "uD83D\uDD0A";
//           else
//               ic = friends.get(i).getLastPlayed().getLastTimePlayed();
//
//           String btInfo ="<html>&emsp;" + friends.get(i).username() +"&emsp;&emsp;" + ic
//                    +"<br>&emsp;\\uD83C\\uDFB6\\"+ friends.get(i).getLastPlayed().getTitle()+"</html>";

  //         friendList.get(i).add(new JButton(btInfo));
       }
    }


    public void addNewFriend(Friend f){
        friends.add(f);
    }

    public void removeFriend(Friend f){
        friendList.remove(f);
    }




}