package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User extends JFrame {

    private AddProperties pro = new AddProperties();
    private JTextArea username;
    private JPasswordField password;
    private JLabel name ;
    private JLabel pass;
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

        name = new JLabel("USERNAME :");
        name.setFont(new Font("Calibri" , Font.BOLD , 20));
        name.setBounds(110 , 131 , 120 , 30);
        username = new JTextArea();
        username.setFont(new Font("Serif" , Font.CENTER_BASELINE , 16));
        username.setBounds(241,131,150,20);

        pass = new JLabel("PASSWORD :");
        pass.setFont(new Font("Calibri" , Font.BOLD , 20));
        pass.setBounds(110 , 175, 120 , 30);
        password = new JPasswordField();
        password.setBounds(241,175,150,20);

        JLabel lab = new JLabel(pro.getImageSong(new ImageIcon("src\\Graphics\\icons\\artwork\\kkkk.jpg"),700,500));
        login = new JButton("LOGIN");
        pro.setButtonProperties(login,700,30,JButton.CENTER,JButton.CENTER,SwingConstants.CENTER);


        lab.add(name);
        lab.add(pass);

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
                //new Graphics(ss , k);
                dispose();
            }
        });
    }


}
