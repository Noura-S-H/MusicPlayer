package Graphics.center.LibraryDisplay.Albums;
import Graphics.AddProperties;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;




public class AlbumsDisplay extends JPanel{

        private AddProperties pro = new AddProperties();
      //  private ArrayList<Album> albums= new ArrayList<Album>();
        private ArrayList<JButton>  albutton = new ArrayList<JButton>();

        JPanel right = new JPanel(new FlowLayout());
        JPanel left = new JPanel(new FlowLayout());
        JPanel center = new JPanel(new FlowLayout());

        public AlbumsDisplay(){
            super();

            this.setLayout(new GridLayout(2,4));

            albutton.add(new JButton());
            albutton.add(new JButton());
            albutton.add(new JButton());
            albutton.add(new JButton());

            for( int i = 0; i<albutton.size(); i++) {
                pro.setButtonProperties(albutton.get(i),50,50,JButton.CENTER,JButton.CENTER,SwingConstants.CENTER);
                albutton.get(i).setFont(new Font("Brush Script MT", Font.PLAIN, 25));
                this.add(albutton.get(i));
            }
            this.setVisible(true);

        }

    private void Create(JButton name, JPanel panel) {
        pro.setButtonProperties(name,50,50,JButton.CENTER,JButton.CENTER,SwingConstants.CENTER);
        name.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
        panel.setLayout(new GridLayout(2 ,1));
        panel.setBackground(new Color(3, 11, 21));
        panel.setPreferredSize(new Dimension(350  ,790));
        panel.add(name);
        panel.setVisible(true);
    }


}
