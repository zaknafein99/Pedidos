/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Docente
 */
public class DateCellRenderer extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        super.getTableCellRendererComponent( table, value, isSelected, hasFocus, row, column );
            if ( value instanceof Date ){
        // Use SimpleDateFormat class to get a formatted String from Date object.
                String strDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format((Date)value);
        // Sorting algorithm will work with model value. So you dont need to worry
        // about the renderer's display value.
                this.setText( strDate );
    }


return this;
}
}
