package Graphics.center.LibraryDisplay;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {

    JLabel message = new JLabel();

    public Home(){
        super();

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3,11,21));
        this.setVisible(true);

        setTextMessage(message);
        message.setVerticalTextPosition(JLabel.TOP);


        this.add(message,BorderLayout.NORTH);
    }


    public JPanel getPanel(){
        return this;
    }

    public void setTextMessage(JLabel lab){
        String wellcomMessage =
                "<html><h1 style=\"color:#FFD700\";>&emsp;Wellcom</h1>&emsp;Hello,<br>" +
                "&emsp;And wellcome to the Jpotify." +
                "&emsp;Thanks for choosing Jpotify. Jpotify provides personalized services with social and interactive " +
                        "<p> &emsp;features for streaming" + " music and other content as well as other products and services" +
                        " that maybe developed from time to time.</p><br>" +
                "&emsp;By signing up or other wise using ny of these Jpotify services, including all" +
                        " associated features and functionalities.<br>"+
                "<br>&emsp;Help<br>" +
                "<br>&emsp;Click on Add to library -> You can choose a folder of your songs to add your songs" +
                "<br>&emsp;Click on Song -> You can see and play songs which you added"+
                "<br>&emsp;Click on Albums -> You can see and choose the albums that created by their names" +
                "<br>&emsp;Click on Favorites -> You can see all your favorites songs that you give a heart to them" +
                "<br>&emsp;Click on Shared playlist -> you can share the songs that you wants your friends seen" +
                "<br>&emsp;Click on New playlist -> You can create the playlist with your favorite name and songs" +
                "<br>&emsp;Friend activity -> shows that your friends who have the Jpotify and you add them to your friend's list"+
                "<br>&emsp;\uD83C\uDF70 ENJOY :))" +
                "<br><h4>&emsp;Manufacturers :<br>" +
                "<br>&emsp;Arefeh K.S" +
                "<br>&emsp;Houra S.H</h4> </html>";

       // <h3 style="color:#FF0000";> Add to library -></h3>
                lab.setText(wellcomMessage);
        lab.setFont(new Font("Trebuchet MS",Font.BOLD,12));
        message.setForeground(new Color(255, 250, 205));
    }

}