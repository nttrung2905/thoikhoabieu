package com.example.demo;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;


public class simpleTable extends JFrame {
    private JPanel tkb;
    private JTable table;
    private JScrollPane scrollPane;


    simpleTable() {
        setTitle("Thời khóa biểu");
        setSize(300, 200);
        north();

        center();
        south();

    }

    public void north() {
        JPanel buttons = new JPanel();
        add(buttons, BorderLayout.SOUTH);
        JButton clear = new JButton("Clear");
        JButton print = new JButton("Print");
        buttons.add(print);
        buttons.add(clear);
        clear.setBackground(Color.red);
        clear.setForeground(Color.white);
        print.setBackground(Color.blue);
        print.setForeground(Color.white);
    }

    public void center() {

        tkb = new JPanel();
        tkb.setLayout(new BorderLayout());

        getContentPane().add(tkb);
        String[] columnNames = {"Time/day", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ nhật", ""};
        Object[][] data = {
                {"Tiet 1", "lap trinh mang", "", "", "", "", "", "", "Tiết 1"},
                {"Tiet 2", "lap trinh mang", "", "", "", "", "", "", "Tiết 2"},
                {"Tiet 3", "", "", "", "", "", "", "", "Tiết 3"},
                {"Tiet 4", "", "", "", "", "", "", "", "Tiết 4"},
                {"Tiet 5", "", "", "", "", "", "", "", "Tiết 5"},
                {"Tiet 6", "", "", "", "", "", "", "", "Tiết 6"},
                {"Tiet 7", "", "", "", "", "", "", "", "Tiết 7"},
                {"Tiet 8", "", "", "", "", "", "", "", "Tiết 8"},
                {"Tiet 9", "", "", "", "", "", "", "", "Tiết 9"},
                {"Tiet 10", "", "", "", "", "", "", "", "Tiết 10"},
                {"Tiet 11", "", "", "", "", "", "", "", "Tiết 11"},
                {"Tiet 12", "", "", "", "", "", "", "", "Tiết 12"},
                {"Tiet 13", "", "", "", "", "", "", "", "Tiết 13"},
                {"Tiet 14", "", "", "", "", "", "", "", "Tiết 14"}
        };


        table = new JTable(data, columnNames);
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(8).setPreferredWidth(5);


        JTableHeader anHeader = table.getTableHeader();
        anHeader.setForeground(new Color(0).white);
        anHeader.setBackground(new Color(0).blue);

        scrollPane = new JScrollPane(table);
        tkb.add(scrollPane, BorderLayout.CENTER);

    }

    public void south() {
        JPanel labels = new JPanel();
        add(labels, BorderLayout.NORTH);
        JLabel id = new JLabel("Mã số: ");
        JTextField idTextField = new JTextField("3117410278");
        JLabel name = new JLabel("Tên: ");
        JTextField nameTextField = new JTextField("Nguyen Thanh Trung");
        JLabel className = new JLabel("Lớp: ");
        JTextField classTextField = new JTextField("DCT1176");
        labels.add(id);
        labels.add(idTextField);
        labels.add(name);
        labels.add(nameTextField);
        labels.add(className);
        labels.add(classTextField);
    }


    public static void main(String... arg) {
        simpleTable mainFrame = new simpleTable();
        mainFrame.setVisible(true);
        mainFrame.setSize(1200, 800);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
