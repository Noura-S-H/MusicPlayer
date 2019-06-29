package Graphics.east;
import Graphics.AddProperties;
import NetWork.Client;
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
    JPanel panel;
    Server server = new Server(2000);

    public FriendActivity(){
        super();
        server.start();

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3,11,21));
        this.setVisible(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean check = true;
                while (check) {
                    friends = server.getFriends();
                    if(friends!= null)
                        check = false;
                }
                panel = new JPanel();
                panel.setBackground(new Color(3,11,21));
                panel.setLayout(new GridLayout(friends.size(),1));
                setJPanel();
            }
        }).start();
        setFriendsInfoToButtons();

        JLabel friendActivity = new JLabel(LABEL_TEXT);
        pro.setLabelProperties(friendActivity,150,30,"",12,SwingConstants.LEFT);
        this.add(friendActivity, BorderLayout.NORTH);


    }

    public void setFriendsInfoToButtons(){
       for(int i = 0; i < friends.size(); i++){
           String ic = "uD83D\uDD0A";
           if(friends.get(i).getStatus() == "play")
               ic = "uD83D\uDD0A";
           else
               ic = friends.get(i).getStatus();

           String btInfo ="<html>&emsp;" + friends.get(i).getUsername() +"&emsp;&emsp;" + ic
                    +"<br>&emsp;\\uD83C\\uDFB6\\"+ friends.get(i).getLastPlayedSongName()+"</html>";

           friendList.get(i).add(new JButton(btInfo));
       }
    }

    public void setJPanel(){
        this.add(new JScrollPane(panel), BorderLayout.CENTER);
    }

    public void addNewFriend(Friend f){
        friends.add(f);
    }

    public void removeFriend(Friend f){
        friendList.remove(f);
    }




}