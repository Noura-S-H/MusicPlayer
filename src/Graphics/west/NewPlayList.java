package Graphics.west;
import Graphics.AddProperties;
import Graphics.Warrning;
import Graphics.Album;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class NewPlayList extends JPanel {

    private ArrayList<Album> playlists = new ArrayList<Album>();
    private AddProperties pro = new AddProperties();
    JButton buttonNewPlaylist;

    private Warrning warrning;
    private final String WINDOWS_TITLE = "NEW PLAYLIST ";
    private final int WIDTH = 500, HEIGHT = 150;
    private final int X = 200, Y = 300;
    private final String WINDOWS_ICON = "src\\Graphics\\icons\\wicon\\plus.png";

    public NewPlayList() {
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(3, 11, 21));
        this.setVisible(true);

        buttonNewPlaylist = new JButton("➕ New playList ");
        pro.setButtonProperties(buttonNewPlaylist,150,30,JButton.TOP,JButton.CENTER,SwingConstants.CENTER);
        this.add(buttonNewPlaylist, BorderLayout.CENTER);
        buttonNewPlaylist.addActionListener(new ActionListener() {
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

                JLabel lab1 = new JLabel("<html>&emsp;\uD83C\uDFBA PLAYLIST NAME : </html>");
                pro.setLabelProperties(lab1,400,150,"Trebuchet MS",14,SwingConstants.LEFT);
                JTextArea name = new JTextArea();
                lab1.add(name);
                name.setBounds(150,33,200,20);
                JButton add = new JButton(" ➕ ADD SONGS");
                JButton con  = new JButton(" ✔️ CONFIRM ");

                pro.setButtonProperties(add,100,30,JButton.CENTER,JButton.CENTER,SwingConstants.CENTER);
                pro.setButtonProperties(con,500,30,JButton.CENTER,JButton.CENTER,SwingConstants.CENTER);
                add.setBackground(new Color(23, 32, 42));
                con.setBackground(new Color(21, 141, 32));

                playlistNameFrame.add(lab1,BorderLayout.CENTER);
                playlistNameFrame.add(add,BorderLayout.EAST);
                playlistNameFrame.add(con,BorderLayout.SOUTH);
                ArrayList<String> paths = new ArrayList<String>();

                add.addActionListener(new ActionListener() {

                    //actionlistener for add songs to playlist
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JFileChooser fc = new JFileChooser();
                        fc.setMultiSelectionEnabled(true);
                        int i = fc.showOpenDialog(playlistNameFrame);
                        try {
                            if (i == JFileChooser.APPROVE_OPTION) {
                                File[] files = fc.getSelectedFiles();
                                for (int j = 0; j < files.length; j++) {
                                    paths.add(files[j].getAbsolutePath());

                                }
                            }
                            playlistNameFrame.dispose();
                        }catch(Exception ex) {
                            System.out.println(ex.toString());

                        }
                    }
                });
                //actionlistener for created file from new playlist and make album from that
                con.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(name.getText() != null){

                            String plname = "src\\Files\\playlists\\" + name.getText() +".txt";
                            plname = plname.replaceAll("[ : , \t, \0 ]" , "_");
                            File f = new File(plname);
                            PrintWriter file = null;

                            try {
                                if (!f.exists())
                                    f.createNewFile();

                                file = new PrintWriter(new FileWriter(f));

                                for(int i = 0; i < paths.size() ;i++) {
                                    if(i == paths.size()-1)
                                        file.print(paths.get(i));
                                    else
                                        file.println(paths.get(i));
                                }
                                file.close();
                                playlists.add(new Album(plname));
                                warrning = new Warrning("   PLAYLIST CREATED!",true);

                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                        }
                        else {
                            warrning = new Warrning("   PLAYLIST WAS NOT CREATED!",false);
                        }

                    }
                });


            }
        });




    }
}
//myJFrame.addWindowListener(new MyWindowListener());