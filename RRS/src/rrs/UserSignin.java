package rrs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UserSignin extends JFrame {

    JLabel pic = new JLabel();
    JLabel title = new JLabel();
    JLabel un = new JLabel();
    JLabel pwd = new JLabel();
    JLabel nuser = new JLabel();
    JLabel back = new JLabel();
    JTextField tun = new JTextField();
    JPasswordField tpwd = new JPasswordField();
    JButton sub = new JButton();

    public UserSignin() {
        run();
        Connect();
    }
    Connection con;
    PreparedStatement st;
    ResultSet rs;

    public void Connect() {
        String url, uname, pswd;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://localhost:3306/rrs";
            uname = "Mahesh";
            pswd = "mahesh";
            con = DriverManager.getConnection(url, uname, pswd);
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        }
    }

    public void run() {
        setVisible(true);
        setLayout(null);
        setSize(1360, 780);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new Font("MONOSPACED", 1, 48));
        title.setForeground(Color.black);
        title.setText("USERS LOGIN");
        add(title);
        title.setBounds(530, 20, 320, 60);

        un.setFont(new Font("TIMES NEW ROMAN", 1, 25));
        un.setForeground(Color.red);
        un.setText("User Name");
        add(un);
        un.setBounds(480, 180, 130, 40);

        pwd.setFont(new Font("TIMES NEW ROMAN", 1, 25));
        pwd.setForeground(Color.red);
        pwd.setText("Password");
        add(pwd);
        pwd.setBounds(480, 260, 130, 40);

        tun.setFont(new Font("TIMES NEW ROMAN", 1, 20));
        add(tun);
        tun.setBounds(750, 190, 180, 30);
        tpwd.setFont(new Font("TIMES NEW ROMAN", 1, 20));
        add(tpwd);
        tpwd.setBounds(750, 260, 180, 30);

        sub.setFont(new Font("Comic Sans Ms", 1, 25));
        sub.setBackground(Color.cyan);
        sub.setText("SUBMIT");
        sub.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    String Username = tun.getText();
                    String Password = tpwd.getText();
                    st = con.prepareStatement("Select * from registration where username=? and password=?");
//                  st = con.prepareStatement(sql);
                    st.setString(1, Username);
                    st.setString(2, Password);
                    rs = st.executeQuery();
                    if (rs.next()==true) {
                        JOptionPane.showMessageDialog(null, "SignIn Successfully");
                        Reservation r = new Reservation();
                        r.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "SignIn Failed");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        });
        add(sub);
        sub.setBounds(600, 350, 190, 60);

        nuser.setFont(new Font("MONOSPACED", 1, 35));
        nuser.setForeground(Color.white);
        nuser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nuser.setText("New User? Click Here...");
        nuser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                UserSignup us = new UserSignup();
                us.setVisible(true);
            }
        });
        add(nuser);
        nuser.setBounds(530, 450, 500, 40);

        back.setFont(new Font("Comic Sans Ms", 1, 20));
        back.setForeground(Color.black);
        back.setText("Back");
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                setVisible(false);
                Home h = new Home();
                h.setVisible(true);
            }
        });
        add(back);
        back.setBounds(0, 0, 100, 20);

        pic.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Desktop\\JAVA programs\\rrs\\images\\14.jpg"));
        add(pic);
        pic.setBounds(0, 0, 1920, 800);

    }
}
