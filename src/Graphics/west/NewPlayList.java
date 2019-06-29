package Graphics.west;
import Graphics.AddProperties;
import Graphics.Warrning;
import Graphics.PlayListManager;
import Graphics.ActionlistenerManeger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class NewPlayList extends JPanel {

    ActionlistenerManeger am = new ActionlistenerManeger();
    private SongsManeger sm; //= new SongsManeger("src\\Files\\musics.json");
    ArrayList<String> paths = new ArrayList<String>();
    private AddProperties pro = new AddProperties();
    JButton buttonNewPlaylist;

    private final String WINDOWS_TITLE = "NEW PLAYLIST ";
    private final String WINDOWS_ICON = "src\\Graphics\\icons\\wicon\\plus.png";
    private static final String PLAYLISTS_PATH = System.getProperty("user.dir") + "/src/Files/playlists.json";

    public NewPlayList(PlaylistDisplay pld) {
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
                sm = new SongsManeger("src\\Files\\musics.json");
                JFrame playlistNameFrame = new JFrame();
                playlistNameFrame.setTitle(WINDOWS_TITLE);
                playlistNameFrame.setLayout(new BorderLayout());
                playlistNameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

                ArrayList<String> names = new ArrayList<>();
                for(int i = 0; i < sm.getMusics().size(); i++) {
                    names.add("      + "+sm.getMusics().get(i).getJsonFileName());
                }
                JList namelist = new JList(names.toArray());
                name.setBackground(new Color(255, 241, 118));
                namelist.setBackground(new Color(28, 40, 51));
                namelist.setForeground(Color.white);
                panel.add(lab1,BorderLayout.NORTH);
                panel.add(new JScrollPane(namelist),BorderLayout.CENTER);
                panel.add(con,BorderLayout.SOUTH);
                playlistNameFrame.add(panel,BorderLayout.CENTER);


                namelist.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        int n = name.getSelectionEnd();
                        paths.add(sm.getMusics().get(n).getSongPath());
                    }
                });

                con.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        playlistNameFrame.dispose();
//                        for(int i =0;i < paths.size();i++){
//                            System.out.println(paths.get(i));
//                        }
                        if(!name.getText().isEmpty()){
                            removeRepetitiousMusic(paths);
                                try {
                                    insertPlaylist(name.getText(),paths);
                                } catch (IOException | ParseException e1) {
                                    e1.printStackTrace();
                                }

                            new Warrning("   DONE!",true);
                                am.updatePlaylist(pld);
                        //    pm.addToPlaylists(list);
                        }else {
                            new Warrning("THE LIST WAS NOT CREATED! SOMETHINGS IS WRONG..!",false);
                        }
                    }
                });


            }
        });


    }



    /**
     * read the JSON file containing the playlists
     *
     * @return Existing playlist JSONArray object
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */

    public static JSONArray readPlaylistJson()
            throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jarr = null;
        Object obj;
        try {
            obj = parser.parse(new FileReader(PLAYLISTS_PATH));
            jarr = (JSONArray) obj;
        } catch (IOException | NullPointerException | ParseException e) {
            System.out.println(e);
        }
        return jarr;
    }


    /**
     * Returns required playlist
     *
     * @param name Name the playlist
     * @param array of paths the playlist
     * @return String ArrayList containing playlist songs
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static boolean insertPlaylist(String name, ArrayList<String> array)
            throws IOException, FileNotFoundException, ParseException {
        JSONArray jarr = readPlaylistJson();
        JSONObject aux = new JSONObject();
        FileWriter writeFile;
        int i = 0;
        if (!jarr.isEmpty()) {
            for (i = 0; i < jarr.size(); i++) {
                JSONObject jobj = (JSONObject) jarr.get(i);
                if (jobj.containsKey(name)) {
                    JOptionPane.showMessageDialog(null, "A playlist " + name
                            + " Already in library", "Error", INFORMATION_MESSAGE);
                    return false;
                }
            }
        }
        aux.put(name, array);
        jarr.add(aux);
        writeFile = new FileWriter(PLAYLISTS_PATH);
        JSONArray.writeJSONString(jarr, writeFile);
        writeFile.close();
        return true;
    }

    public void removeRepetitiousMusic(ArrayList<String> selectedPaths){
        for(int i = 0; i<selectedPaths.size(); i++){
            String temp = selectedPaths.get(i);
            for(int j = 1; j < selectedPaths.size(); j++){
                if(temp.equals(selectedPaths.get(j))){
                    selectedPaths.remove(temp);
                }
            }
        }
    }


    public ArrayList<String> getPaths() {
        return paths;
    }

}


