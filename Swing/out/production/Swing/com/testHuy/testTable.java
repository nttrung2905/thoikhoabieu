/* (swing1.1beta3) jfc#96 */
package com.testHuy.testTable;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import tame.table.AttributiveCellTableModel;
import tame.table.CellSpan;
import tame.table.MultiSpanCellTable;

/**
 <pre>
 Exception in thread "main" java.lang.NullPointerException
 at javax.swing.table.DefaultTableModel.getColumnCount(DefaultTableModel.java:575)
 at javax.swing.table.DefaultTableModel.justifyRows(DefaultTableModel.java:242)
 at javax.swing.table.DefaultTableModel.setNumRows(DefaultTableModel.java:298)
 at tame.table.AttributiveCellTableModel.<init>(AttributiveCellTableModel.java:32)
 </pre>
 @author Nobuo Tamemasa
 @version 1.0 11/26/98
 */
public class MultiSpanCellTableExample extends JFrame {

    MultiSpanCellTableExample() {
        super( "Multi-Span Cell Example" );

        AttributiveCellTableModel ml = new AttributiveCellTableModel(10,6);
    /*
    AttributiveCellTableModel ml = new AttributiveCellTableModel(10,6) {
      public Object getValueAt(int row, int col) {
        return "" + row + ","+ col;
      }
    };
   */
        final CellSpan cellAtt =(CellSpan)ml.getCellAttribute();
        final MultiSpanCellTable table = new MultiSpanCellTable( ml );
        JScrollPane scroll = new JScrollPane( table );

        JButton b_one   = new JButton("Combine");
        b_one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] columns = table.getSelectedColumns();
                int[] rows    = table.getSelectedRows();
                cellAtt.combine(rows,columns);
                table.clearSelection();
                table.revalidate();
                table.repaint();
            }
        });
        JButton b_split = new JButton("Split");
        b_split.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int column = table.getSelectedColumn();
                int row    = table.getSelectedRow();
                cellAtt.split(row,column);
                table.clearSelection();
                table.revalidate();
                table.repaint();
            }
        });
        JPanel p_buttons = new JPanel();
        p_buttons.setLayout(new GridLayout(2,1));
        p_buttons.add(b_one);
        p_buttons.add(b_split);

        Box box = new Box(BoxLayout.X_AXIS);
        box.add(scroll);
        box.add(new JSeparator(SwingConstants.HORIZONTAL));
        box.add(p_buttons);
        getContentPane().add( box );
        setSize( 400, 200 );
        setVisible(true);
    }

    public static void main(String[] args) {
        MultiSpanCellTableExample frame = new MultiSpanCellTableExample();
        frame.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent e ) {
                System.exit(0);
            }
        });
    }
}