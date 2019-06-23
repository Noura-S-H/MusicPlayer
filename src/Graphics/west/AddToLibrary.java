package Graphics.west;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddToLibrary extends Component implements ActionListener {

    private ActionEvent e;
    private JButton  button;
    ArrayList<String> filePath;
    private final String path = "src\\Files\\Songs.txt";

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
           // addSongstoLibrary(path);
        }
    }


    public void addSongstoLibrary(String pt){
        boolean empty = false;
        File f = new File(pt);
        PrintWriter file = null;
        Scanner scanner = null;

        /*try {
            scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                filePath.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        if(f.length() == 0)
            empty = true;
        try {
            if (!f.exists())
                f.createNewFile();

            file = new PrintWriter(new FileWriter(f));
            if(empty == false)
                file.println();

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

