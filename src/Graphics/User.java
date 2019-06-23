package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User extends JFrame {

    private AddProperties pro = new AddProperties();
    private JTextArea username;
    private JTextArea password;
    private JButton login;

    private final String WINDOWS_TITLE = "Jpotify";
    private final int WIDTH = 600, HEIGHT = 500;
    private final int X = 400, Y = 80;
    private final String WINDOWS_ICON = "src\\Graphics\\icons\\WithePlayerIcons\\user.png";

    public User() {

        super();
        this.setTitle(WINDOWS_TITLE);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(X, Y);
        this.setVisible(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(WINDOWS_ICON)) ;

        username = new JTextArea();
        username.setBounds(200,130,200,20);
        password = new JTextArea();
        password.setBounds(200,155,200,20);

        JLabel lab = new JLabel(pro.getImageSong(new ImageIcon("src\\Graphics\\icons\\artwork\\TTTT.jpg"),700,500));
        login = new JButton("LOGIN");
        pro.setButtonProperties(login,700,30,JButton.CENTER,JButton.CENTER,SwingConstants.CENTER);


        lab.add(username);
        lab.add(password);
        this.add(lab,BorderLayout.CENTER);
        this.add(login,BorderLayout.SOUTH);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ss = username.getText();
                String k = password.getText();
                System.out.println(ss);
                System.out.println(k);

                Graphics s = new Graphics(username.getText(),password.getText());
                //System.exit(0);
            }
        });
    }

    //public static void main(String[] args){
    //    User u = new User();
   // }

}
