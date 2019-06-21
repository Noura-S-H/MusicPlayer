package Graphics.center.LibraryDisplay;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;


/* class ButtonReaderer for add Button to JTable
   class ButtonEditor for action listener and changes after clicking
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        setBackground(new Color(3,11,21));
        setBorder(BorderFactory.createEmptyBorder());
        setForeground(Color.white);
        setEnabled(true);
        if (isSelected)
            setBackground(new Color(21, 141, 32));

        setText((value == null) ? "" : value.toString());
        return this;
    }
}
