package Graphics.west;
import Graphics.AddProperties;
import Graphics.Warrning;
import Graphics.PlayListManager;
import Graphics.ActionlistenerManeger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Graphics.SongsManeger;
import Graphics.Playlist;
import Graphics.south.center.Play;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NewPlayList extends JPanel {

    private PlayListManager pm ;
    private SongsManeger sm = new SongsManeger("src\\Files\\musics.json");
    private Playlist list ;
    ArrayList<String> paths = new ArrayList<String>();
    private AddProperties pro = new AddProperties();
    JButton buttonNewPlaylist;

    private final String WINDOWS_TITLE = "NEW PLAYLIST ";
    private final String WINDOWS_ICON = "src\\Graphics\\icons\\wicon\\plus.png";
    private static final String PLAYLISTS_PATH = System.getProperty("user.dir") + "/src/Files/Playlists/";

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
                playlistNameFrame.setSize(300, 300);
                playlistNameFrame.setLocation(200, 100);
                playlistNameFrame.setVisible(true);
                playlistNameFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(WINDOWS_ICON));

                JPanel panel = new JPanel(new BorderLayout());
                panel.setPreferredSize(new Dimension(300,500));

                JLabel lab1 = new JLabel("<html>&emsp;\uD83C\uDFBA PLAYLIST NAME : </html>");
                pro.setLabelProperties(lab1,100,50,"Trebuchet MS",12,SwingConstants.LEFT);
                JTextArea name = new JTextArea();
                lab1.add(name);
                name.setBounds(150,13,100,20);
                JButton con  = new JButton(" ✔️ CONFIRM ");
                pro.setButtonProperties(con,100,30,JButton.CENTER,JButton.CENTER,SwingConstants.CENTER);
                con.setBackground(new Color(21, 141, 32));

                JPanel butt = new JPanel(new GridLayout(sm.getMusics().size(),1));
                JButton[] bt = new JButton[sm.getMusics().size()];

                for(int i = 0; i < bt.length; i++) {
                    bt[i] =  new JButton(sm.getMusics().get(i).getJsonFileName());
                    bt[i].setBackground(new Color(28, 40, 51));
                    bt[i].setForeground(Color.white);
                    butt.add(bt[i]);
                }
                panel.add(lab1,BorderLayout.NORTH);
                panel.add(new JScrollPane(butt),BorderLayout.CENTER);
                panel.add(con,BorderLayout.SOUTH);
                playlistNameFrame.add(panel,BorderLayout.CENTER);


                for(int i = 0; i < bt.length; i++){
                    int finalI = i;
                    bt[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            paths.add(sm.getMusics().get(finalI).getSongPath());
                        }
                    });
                }
                con.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        playlistNameFrame.dispose();
                        if(!name.getText().isEmpty()){
                            list = new Playlist(name.getText(),paths);
                            new Warrning("   DONE!",true);
                            pm.addToPlaylists(list);
                        }else {
                            new Warrning("THE LIST WAS NOT CREATED! SOMETHINGS IS WRONG..!",false);
                        }
                    }
                });


            }
        });

        if(list!=null) {
            try {
                insertPlaylist(list.getName(),list.getPaths(),new JSONArray());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }




    }



    /**
     * read the JSON file containing the playlists
     *
     * @return Existing playlist JSONArray object
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public static JSONArray readPlaylistJson(String name)
            throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jarr = null;
        Object obj;
        try {
            obj = parser.parse(new FileReader(PLAYLISTS_PATH + name + "json"));
            jarr = (JSONArray) obj;
        } catch (IOException | NullPointerException | ParseException e) {
            System.out.println(e);
        }
        return jarr;
    }

    /**
     * Insert a new playlist into the playlists file
     *
     * @param name Name of Playlist to be created
     * @param array Array of songs from Playlist
     * @return True if successfully added or False if not
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static boolean insertPlaylist(String name, ArrayList<String> array,JSONArray jarr)
            throws IOException, FileNotFoundException, ParseException {

        JSONObject aux = new JSONObject();
        FileWriter writeFile;
        int i = 0;
        aux.put(name, array);
        jarr.add(aux);
        writeFile = new FileWriter(PLAYLISTS_PATH + name + "json");
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();
        return true;
    }

    /**
     * Returns required playlist
     *
     * @param name Name the playlist
     * @return String ArrayList containing playlist songs
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static ArrayList<String> getPlaylist(String name)
            throws IOException, FileNotFoundException, ParseException {
        ArrayList<String> array;
        JSONArray jarr = readPlaylistJson(name);
        JSONObject aux = new JSONObject();
        if (!jarr.isEmpty()) {
            for (int i = 0; i < jarr.size(); i++) {
                JSONObject jobj = (JSONObject) jarr.get(i);
                if (jobj.containsKey(name)) {
                    array = (ArrayList<String>) jobj.get(name);
                    return array;
                }
            }
        }
        return null;
    }

    public ArrayList<String> getPaths() {
        return paths;
    }

    public Playlist getList() {
        return list;
    }
}


