package Graphics;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;

public class AddProperties{
    Color color = new Color(3,11,21);
    public AddProperties(){}


    public JLabel setLabelProperties(JLabel lab,int width, int height,String font,int sizeFont,int alignment){
        lab.setOpaque(true);
        lab.setForeground(Color.WHITE);
        lab.setPreferredSize(new Dimension(width,height));
        lab.setBackground(color);
        lab.setFont(new Font(font, Font.BOLD, sizeFont));
        lab.setHorizontalAlignment(alignment);
        lab.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        return lab;
    }

    public JButton setButtonProperties(JButton butt,int width,int height,int verTexPos,int horTexPos,int horAlignment){
        butt.setForeground(Color.white);
        butt.setBackground(color);
        butt.setVerticalTextPosition(verTexPos);
        butt.setHorizontalTextPosition(horTexPos);
        butt.setHorizontalAlignment(horAlignment);
        butt.setBorder(BorderFactory.createEmptyBorder());
        butt.setPreferredSize(new Dimension(width,height));
        //butt.setIcon(getImageArtwork("src\\Graphics\\icons\\artwork\\18.jpg"));
        return butt;
    }

    public ImageIcon getImageArtwork(String path,int widthIcon,int heightIcon){
        ImageIcon icon = new ImageIcon(path);
        Image newimg = icon.getImage().getScaledInstance( widthIcon, heightIcon,java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon( newimg );
        return icon;
    }

    public ImageIcon getImageSong(ImageIcon icon,int width, int height) {
        ImageIcon imIcon = new ImageIcon(icon.getImage()
                .getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
        return imIcon;
    }

    public void setImageIcon(JLabel lab,String path,int widthPic, int heightPic){
        ImageIcon icon = new ImageIcon(path);
        Image newimage = icon.getImage().getScaledInstance( widthPic, heightPic,  java.awt.Image.SCALE_SMOOTH ) ;
        lab.setIcon(new ImageIcon( newimage ));
    }

    public void setTableProperties(JTable tb,int widthHeader,int heightHeader ,int widthCell,int heightCell,int rowHeight,int columnsNum){
        JTableHeader header = tb.getTableHeader();
        header.setBackground(color);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Sherif", Font.BOLD, 12));
        header.setPreferredSize(new Dimension(widthHeader,heightHeader));
        UIManager.getDefaults().put("TableHeader.cellBorder" , BorderFactory.createEmptyBorder(0,0,0,0));
        tb.setShowGrid(false);
        ((DefaultTableCellRenderer)tb.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.LEFT);
        tb.setRowHeight(rowHeight);
        tb.setPreferredSize(new Dimension(widthCell,heightCell));
        tb.setForeground(Color.white);
        tb.setBackground(color);
        tb.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        for(int i = 0; i < columnsNum; i++ ){
            TableColumn column = tb.getColumnModel().getColumn(i);
            if(columnsNum <= 5) {
                if (i == 0)
                    column.setPreferredWidth(25);
                else if (i == 1)
                    column.setPreferredWidth(250);//sport column is bigger
                else if (i == 2 || i == 3)
                    column.setPreferredWidth(150);
                else
                    column.setPreferredWidth(50);
            }else if( columnsNum > 5 && columnsNum <= 7){
                if(i == 0)
                    column.setPreferredWidth(25);
                else if(i == 1)
                    column.setPreferredWidth(30);
                else if (i == 2)
                    column.setPreferredWidth(250);//sport column is bigger
                else if(i == 3 || i == 4 )
                    column.setPreferredWidth(150);
                else
                    column.setPreferredWidth(50);
            }


        }
    }

    public void setJTaxtFieldProperties(JTextArea textField,boolean editable,boolean lineWrap){
        textField.setEditable(editable);
        textField.setLineWrap(lineWrap);
        textField.setBackground(Color.LIGHT_GRAY);
    }

    public void setJComboBoxProperties(JComboBox combo,int width,int height){
        combo.setBackground(color);
        combo.setForeground(Color.white);
        combo.setPreferredSize(new Dimension(width,height));
        for (int i = 0; i < combo.getComponentCount(); i++) {
            if (combo.getComponent(i) instanceof JComponent) {
                ((JComponent) combo.getComponent(i)).setBorder(new EmptyBorder(0, -10, 0, 0));

            }
        }
        //profileInfo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
    }



    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}