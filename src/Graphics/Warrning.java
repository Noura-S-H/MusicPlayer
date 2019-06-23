package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Warrning extends JFrame{

    private String icon;
    private Color color;
    public Warrning(String warrning,boolean status) {
        super();
        if(status) {
            color = new Color(21, 141, 32);
            this.setTitle("DONE");
            icon =  "C:src\\Graphics\\icons\\warrning\\checked.png";
        }
        else {
            color = new Color(151, 8, 43);
            icon = "C:src\\Graphics\\icons\\warrning\\warrning.png";
            this.setTitle("ERROR");
        }
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 100);
        this.setLocation(210, 310);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(icon));
        this.add(new JLabel(warrning));
        this.setVisible(true);

        JButton close = new JButton("close");
        close.setBackground(color);
        close.setForeground(Color.white);
        close.setFocusPainted(false);
        close.setBorder(BorderFactory.createEmptyBorder());
        close.setPreferredSize(new Dimension(300,30));

        this.add(close,BorderLayout.SOUTH);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

}
