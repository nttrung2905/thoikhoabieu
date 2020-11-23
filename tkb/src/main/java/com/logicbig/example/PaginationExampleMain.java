package com.logicbig.example;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PaginationExampleMain {
    public static void main(String[] args) {
        JFrame frame = createFrame();
        JTable table = new JTable(createObjectDataModel());
        table.setAutoCreateRowSorter(true);
        table.getColumnModel().getColumn(0).setWidth(5);
        table.setRowHeight(50);


        JTableHeader anHeader = table.getTableHeader();
        anHeader.setForeground(new Color(0).white);
        anHeader.setBackground(new Color(0).blue);

        PaginationDataProvider<Tkb> dataProvider = createDataProvider();
        PaginatedTableDecorator<Tkb> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{7, 14, 170}, 7);
        frame.add(paginatedDecorator.getContentPanel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }



    private static TableModel createObjectDataModel() {
        return new ObjectTableModel<Tkb>() {
            @Override
            public Object getValueAt(Tkb tkb, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return tkb.getTiet();
                    case 1:
                        return tkb.getMon1();
                    case 2:
                        return tkb.getMon2();
                    case 3:
                        return tkb.getMon3();
                    case 5:
                        return tkb.getMon5();
                    case 6:
                        return tkb.getMon6();



                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 8;
            }
            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return "Tiết";
                    case 1:
                        return "Thứ 2";
                    case 2:
                        return "Thứ 3";
                    case 3:
                        return "Thứ 4";
                    case 4:
                        return "Thứ 5";
                    case 5:
                        return "Thứ 6";
                    case 6:
                        return "Thứ 7";
                    case 7:
                        return "Chủ nhật";
                }
                return null;
            }
        };
    }

    private static PaginationDataProvider<Tkb> createDataProvider() {


        LinkedList<LinkedList<Tkb>> listTkbs = new LinkedList<>(); //170
        LinkedList<Tkb> listtkb = new LinkedList<>(); // 7

        for (int i = 1; i <= 170; i++) {
            for (int j = 1; j <= 7; j++) {
                Tkb e = new Tkb();
                e.setTiet("Tiet"+j);



                listtkb.add(e);
            }


            for (int j = 1; j <= 14; j++) {
                Tkb e = new Tkb();
                e.setTiet("Tiet"+j);


                listtkb.add(e);
            }



            listTkbs.add(listtkb);

        }


        return new PaginationDataProvider<Tkb>() {
            @Override
            public int getTotalRowCount() {
                return listTkbs.size();
            }

            @Override
            public List<Tkb> getRows(int startIndex, int endIndex) {
                return listtkb.subList(startIndex, endIndex);
            }
        };
    }



    private static JFrame createFrame() {
        JFrame frame = new JFrame("Thời khóa biểu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1200, 800));
        return frame;
    }
}