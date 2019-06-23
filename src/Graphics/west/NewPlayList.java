package Graphics.west;
import Graphics.AddProperties;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPlayList extends JPanel {

    private AddProperties pro = new AddProperties();
    JButton button;


    private final String WINDOWS_TITLE = "NEW PLAYLIST ";
    private final int WIDTH = 600, HEIGHT = 600;
    private final int X = 70, Y = 70;
    private final String WINDOWS_ICON = "src\\Graphics\\icons\\wicon\\plus.png";

    public NewPlayList() {
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        button = new JButton("➕ New playList ");
        pro.setButtonProperties(button,150,30,JButton.TOP,JButton.CENTER,SwingConstants.CENTER);
        this.add(button, BorderLayout.CENTER);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame playlistNameFrame = new JFrame();
                playlistNameFrame.setTitle(WINDOWS_TITLE);
                playlistNameFrame.setLayout(new BorderLayout());
                playlistNameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                playlistNameFrame.setSize(WIDTH, HEIGHT);
                playlistNameFrame.setLocation(X, Y);
                playlistNameFrame.setVisible(true);
                playlistNameFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(WINDOWS_ICON));
                playlistNameFrame.setBackground(new Color(3,11,21));

                JLabel label = new JLabel("<html>PLAYLIST NAME :<br> THIS SONGS :</html>");
                JTextArea name = new JTextArea();
                name.setBounds(100,100,100,20);
                JButton bt = new JButton("ADD");

            }
        });
    }
}
