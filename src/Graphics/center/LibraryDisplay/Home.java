package Graphics.center.LibraryDisplay;
import Graphics.AddProperties;
import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {

    AddProperties pro = new AddProperties();
    JLabel message1 = new JLabel();
    JLabel message2 = new JLabel();
    JLabel message3 = new JLabel();

    public Home(){
        super();

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3,11,21));
        this.setVisible(true);

        setTextMessage(message1,message2,message3);
      //  message1.setVerticalTextPosition(JLabel.TOP);

        this.add(message1,BorderLayout.NORTH);
        this.add(message2,BorderLayout.CENTER);
        this.add(message3,BorderLayout.SOUTH);
    }


    public JPanel getPanel(){
        return this;
    }

    public void setTextMessage(JLabel lab1,JLabel lab2,JLabel lab3){
        String wellcomMessage =
                "<html><h1 style=\"color:#FFD700\";>&emsp;Wellcome</h1>&emsp;Hello,<br>" +
                "&emsp;And wellcome to the Jpotify." +
                "Thanks for choosing Jpotify. Jpotify provides personalized services with social and interactive " +
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
                "<br>&emsp;Friend activity -> shows that your friends who have the Jpotify and you add them to your friend's list</html>";

        String enjoy = "<html>  ENJOY! :))</html>";
//\uD83C\uDF70
        String manufacturers =
                "<html><h4>&emsp;&emsp;  Manufacturers :" +
                "<br>&emsp;&emsp;  Arefeh K.S" +
                "<br>&emsp;&emsp;  Houra S.H</h4> </html>";

       // <h3 style="color:#FF0000";> Add to library -></h3>

        lab1.setText(wellcomMessage);
        lab2.setText(enjoy);
        lab3.setText(manufacturers);

        lab2.setIcon(pro.getImageArtwork("src\\Graphics\\icons\\cake.png",18,18));
        pro.setLabelProperties(lab1,800,275,"Trebuchet MS",12,SwingConstants.CENTER);
        pro.setLabelProperties(lab2,800,15,"Trebuchet MS",12,SwingConstants.CENTER);
        pro.setLabelProperties(lab3,800,70,"Trebuchet MS",10,SwingConstants.LEFT);

        message1.setForeground(new Color(255, 250, 205));
        message2.setForeground(new Color(255,250,205));
        message3.setForeground(new Color(143, 188, 139));
    }

}