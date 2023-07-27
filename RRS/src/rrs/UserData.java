package rrs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class UserData extends JFrame {

    JLabel tit = new JLabel();
    JLabel bg_img = new JLabel();
    JTable Utable = new JTable();
    JScrollPane sp = new JScrollPane();
    JLabel back=new JLabel();

    public UserData() {
        run();
        Connect();
        user();
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

    public void user() {
        try {
            st = con.prepareStatement("Select * from reservation;");
            rs = st.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            int c;
            c = rsd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel) Utable.getModel();
            d.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 0; i <= c; i++) {
                    v.add(rs.getString("id"));
                    v.add(rs.getString("startPlace"));
                    v.add(rs.getString("destinationPlace"));
                    v.add(rs.getString("trainid"));
                    v.add(rs.getString("trainName"));
                    v.add(rs.getString("Price"));
                    v.add(rs.getString("Date"));
                    v.add(rs.getString("Ticket"));
                    v.add(rs.getString("Total"));
                }
                d.addRow(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void run() {
        setVisible(true);
        setLayout(null);
        setSize(1360, 780);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        tit.setFont(new Font("MONOSPACED", 1, 48));
        tit.setForeground(new Color(255, 234, 0));//0,255,255
        tit.setText("USERS DATA");
        add(tit);
        tit.setBounds(550, 20, 300, 60);
        
        back.setFont(new Font("Comic Sans MS",3,25));
        back.setForeground(new Color(255,255,255));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setText("Back");
        back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                setVisible(false);
            }
        });
        add(back);
        back.setBounds(70,520,100,30);

        Utable.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"Passenger ID", "Start Place", "Destination Place", "Train ID", "Train Name", "Price", "Date", "Ticket", "Amount"}
        ));
        sp.setViewportView(Utable);
        add(sp);
        sp.setBounds(70, 100, 1200, 400);

        bg_img.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Desktop\\JAVA programs\\rrs\\images\\9.jpg"));
        bg_img.setText("BgImage");
        add(bg_img);
        bg_img.setBounds(0, 0, 1440, 720);
    }
}
