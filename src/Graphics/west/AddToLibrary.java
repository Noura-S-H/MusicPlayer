package Graphics.west;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
            }
        }
    }

