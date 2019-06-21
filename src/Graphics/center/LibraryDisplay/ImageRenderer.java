package Graphics.center.LibraryDisplay;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

class ImageRenderer extends DefaultTableCellRenderer {
    JLabel lbl = new JLabel();
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        ImageIcon icon = (ImageIcon)value;
        lbl.setIcon(new ImageIcon(icon.getImage()
                .getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH)));

        return lbl;
    }
}
