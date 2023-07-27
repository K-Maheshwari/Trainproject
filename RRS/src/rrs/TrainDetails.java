package rrs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TrainDetails extends JFrame {

    JLabel title = new JLabel();
    JLabel bg = new JLabel();
    JLabel lid = new JLabel();
    JLabel ln = new JLabel();
    JLabel lsp = new JLabel();
    JLabel ldp = new JLabel();
    JLabel lrs = new JLabel();
    JTextField tid = new JTextField();
    JTextField tname = new JTextField();
    JTextField tsp = new JTextField();
    JTextField tdp = new JTextField();
    JTextField trs = new JTextField();
    JTable table1 = new JTable();
    JScrollPane scroll = new JScrollPane();
    JButton add = new JButton();
    JButton update = new JButton();
    JButton delete = new JButton();
    JButton reset = new JButton();
    JButton clear=new JButton();
    JButton back = new JButton();

    public TrainDetails() {
        run();
        Connect();
        train_detail();
    }
    Connection con;
    PreparedStatement st;
    ResultSet rs;

    public void Connect() {
        String url, uname, pwd;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://localhost:3306/rrs";
            uname = "Mahesh";
            pwd = "mahesh";
            con = DriverManager.getConnection(url, uname, pwd);
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        }
    }

    public void train_detail() {
        try {
            st = con.prepareStatement("select * from train");
            rs = st.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            int c;
            c = rsd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel) table1.getModel();
            d.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 0; i <= c; i++) {
                    v.add(rs.getString("trainid"));
                    v.add(rs.getString("trainName"));
                    v.add(rs.getString("startPlace"));
                    v.add(rs.getString("destinationPlace"));
                    v.add(rs.getString("Price"));
                }
                d.addRow(v);
            }
        } catch (SQLException ex) {
            System.out.println("Train : "+ex);
        }
    }

    public void run() {
        setVisible(true);
        setSize(1380, 760);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new Font("MONOSPACED", Font.BOLD, 48));
        title.setForeground(new Color(255, 218, 185));
        title.setText("TRAIN DETAILS");
        add(title);
        title.setBounds(510, -15, 500, 100);

        lid.setFont(new Font("TIMES NEW ROMAN", 1, 25));
        lid.setForeground(new Color(255, 255, 255));
        lid.setText("ID");
        add(lid);
        lid.setBounds(210, 200, 140, 20);

        ln.setFont(new Font("TIMES NEW ROMAN", 1, 25));
        ln.setForeground(new Color(255, 255, 255));
        ln.setText("Train Name");
        add(ln);
        ln.setBounds(210, 250, 140, 20);

        lsp.setFont(new Font("TIMES NEW ROMAN", 1, 25));
        lsp.setForeground(new Color(255, 255, 255));
        lsp.setText("Starting Place");
        add(lsp);
        lsp.setBounds(210, 300, 180, 20);

        ldp.setFont(new Font("TIMES NEW ROMAN", 1, 25));
        ldp.setForeground(new Color(255, 255, 255));
        ldp.setText("Destination Place");
        add(ldp);
        ldp.setBounds(210, 350, 210, 20);

        lrs.setFont(new Font("TIMES NEW ROMAN", 1, 25));
        lrs.setForeground(new Color(255, 255, 255));
        lrs.setText("Price");
        add(lrs);
        lrs.setBounds(210, 400, 140, 20);
        
        tid.setFont(new Font("Times New Roman",1,18));
        add(tid);
        tid.setBounds(480, 200, 170, 30);
        tname.setFont(new Font("Times New Roman",1,18));
        add(tname);
        tname.setBounds(480, 250, 170, 30);
        tsp.setFont(new Font("Times New Roman",1,18));
        add(tsp);
        tsp.setBounds(480, 300, 170, 30);
        tdp.setFont(new Font("Times New Roman",1,18));
        add(tdp);
        tdp.setBounds(480, 350, 170, 30);
        trs.setFont(new Font("Times New Roman",1,18));
        add(trs);
        trs.setBounds(480, 400, 170, 30);
        
        table1.setModel(new DefaultTableModel(
                new Object [][]{
                
                },
                new String[]{
                    "ID", "Train Name", "Start Place", "Destination Place", "Price"}
        ));
        table1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                DefaultTableModel d = (DefaultTableModel) table1.getModel();
                int selectIndex = table1.getSelectedRow();
                tid.setText(d.getValueAt(selectIndex, 0).toString());
                tname.setText(d.getValueAt(selectIndex, 1).toString());
                tsp.setText(d.getValueAt(selectIndex, 2).toString());
                tdp.setText(d.getValueAt(selectIndex, 3).toString());
                trs.setText(d.getValueAt(selectIndex, 4).toString());
                add.setEnabled(false);
            }
        });
        scroll.setViewportView(table1);
        add(scroll);
        scroll.setBounds(730, 350, 600, 300);

        add.setBackground(new Color(255, 255, 255));
        add.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add.setFont(new Font("Comic Sans MS", 1, 20));
        add.setText("ADD");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String ID = tid.getText();
                String TrainName = tname.getText();
                String StartPlace = tsp.getText();
                String DestinationPlace = tdp.getText();
                String Price = trs.getText();
                try {
                    st = con.prepareStatement("insert into train(trainid,trainName,startPlace,destinationPlace,Price)values(?,?,?,?,?);");
                    st.setString(1, ID);
                    st.setString(2, TrainName);
                    st.setString(3, StartPlace);
                    st.setString(4, DestinationPlace);
                    st.setString(5, Price);
                    int k = st.executeUpdate();
                    if (k == 1) {
                        JOptionPane.showMessageDialog(null, "Record Added Successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Record Added Failed");
                    }
                } catch (SQLException ex) {
                    System.out.println("Add : "+ex);
                }
            }
        });
        add(add);
        add.setBounds(170, 540, 110, 50);

        update.setBackground(new Color(255, 255, 255));
        update.setCursor(new Cursor(Cursor.HAND_CURSOR));
        update.setFont(new Font("Comic Sans MS", 1, 20));
        update.setText("UPDATE");
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String ID = tid.getText();
                String TrainName = tname.getText();
                String StartPlace = tsp.getText();
                String DestinationPlace = tdp.getText();
                String Price = trs.getText();
                try {
                    st = con.prepareStatement("update train set trainName=?,startPlace=?,destinationPlace=?,Price=? where trainid=?;");
                    st.setString(1, TrainName);
                    st.setString(2, StartPlace);
                    st.setString(3, DestinationPlace);
                    st.setString(4, Price);
                    st.setString(5, ID);
                    int k = st.executeUpdate();
                    if (k == 1) {
                        JOptionPane.showMessageDialog(null, "Record Updated Successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Record Updated Failed");
                    }
                    tid.setText(" ");
                    tname.setText(" ");
                    tsp.setText(" ");
                    tdp.setText(" ");
                    trs.setText(" ");
                    tid.requestFocus();
                    train_detail();
                    add.setEnabled(true);
                } catch (SQLException ex) {
                    System.out.println("Update : "+ex);
                }
            }
        });
        add(update);
        update.setBounds(300, 540, 120, 50);

        delete.setBackground(new Color(255, 255, 255));
        delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        delete.setFont(new Font("Comic Sans MS", 1, 20));
        delete.setText("DELETE");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String ID = tid.getText();
                try {
                    st = con.prepareStatement("delete from train where trainid=?;");
                    st.setString(1, ID);
                    int k = st.executeUpdate();
                    if (k == 1) {
                        JOptionPane.showMessageDialog(null, "Record Deleted Successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Record Deleted Failed");
                    }
                    tid.setText(" ");
                    tname.setText(" ");
                    tsp.setText(" ");
                    tdp.setText(" ");
                    trs.setText(" ");
                    tid.requestFocus();
                    train_detail();
                    add.setEnabled(true);
                } catch (SQLException ex) {
                    System.out.println("Delete : "+ex);
                }
            }
        });
        add(delete);
        delete.setBounds(440, 540, 110, 50);

        reset.setBackground(new Color(255, 255, 255));
        reset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reset.setFont(new Font("Comic Sans MS", 1, 20));
        reset.setText("RESET");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                train_detail();
                add.setEnabled(true);
            }
        });
        add(reset);
        reset.setBounds(570, 540, 110, 50);
        
        clear.setBackground(new Color(255,255,255));
        clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clear.setFont(new Font("Comic Sans MS", 1, 20));
        clear.setText("CLEAR");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                tid.setText(" ");
                tname.setText(" ");
                tsp.setText(" ");
                tdp.setText(" ");
                trs.setText(" ");
            }
        });
        add(clear);
        clear.setBounds(380,610,110,50);
        
        back.setBackground(new Color(255,218,185));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setText("Back");
        back.setFont(new Font("Comic Sans MS",3,20));
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                setVisible(false);
            }
        });
        add(back);
        back.setBounds(10,10,80,30);

        bg.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Desktop\\JAVA programs\\RRS\\images\\10.jpg"));
        add(bg);
        bg.setBounds(-700, -600, 2300, 1400);
    }
}
