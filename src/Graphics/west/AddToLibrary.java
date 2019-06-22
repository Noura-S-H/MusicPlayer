package Graphics.west;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class AddToLibrary extends Component implements ActionListener {

    private ActionEvent e;
    private JButton  button;
    ArrayList<String> filePath;

    public AddToLibrary(JButton button) {
        this.button = button;
        filePath = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.e = e;
        if(e.getSource()==button) {
            JFileChooser fc = new JFileChooser();
            fc.setMultiSelectionEnabled(true);
            int i = fc.showOpenDialog(this);
            try {
                if (i == JFileChooser.APPROVE_OPTION) {
                    File[] files = fc.getSelectedFiles();
                    for (int j = 0; j < files.length; j++) {
                        filePath.add(files[j].getAbsolutePath());
                        System.out.println(filePath.get(j));
                    }
                }
            }catch(Exception ex) {
                System.out.println(ex.toString());

            }
            addSongstoLibrary("src\\Files\\output.txt");
        }
    }


    public void addSongstoLibrary(String pt){

        File f = new File(pt);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            PrintWriter file = null;

            file = new PrintWriter(new FileWriter(f));
            for(int i = 0; i < filePath.size() ;i++) {
                if(i == filePath.size()-1)
                    file.print(filePath.get(i));
                else
                    file.println(filePath.get(i));
            }
            file.close();


        } catch (IOException e1) {
            e1.printStackTrace();
        }



    }



}

