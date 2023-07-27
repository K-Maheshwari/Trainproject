package rrs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame {

    JLabel title = new JLabel();
    JLabel home = new JLabel();
    JLabel admin = new JLabel();
    JLabel user = new JLabel();
    JLabel about = new JLabel();
    JLabel label = new JLabel();

    public void run() {
        setVisible(true);
        setSize(1360, 780);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new Font("Times New Roman", 3, 48));
        title.setForeground(Color.WHITE);
        title.setText("RAILWAY RESERVATION SYSTEM");
        getContentPane().add(title);
        title.setBounds(250, 10, 780, 80);

//        home.setFont(new Font("Times New Roman", 1, 24)); 
//        home.setForeground(Color.WHITE);
//        home.setText("HOME");
//        home.addMouseListener( new MouseAdapter() {
//            public void mouseClicked(MouseEvent evt) {
//               
//            }
//        });
//        getContentPane().add(home);
//        home.setBounds(90, 120, 140, 50);
        admin.setFont(new Font("Times New Roman", 1, 24));
        admin.setForeground(Color.WHITE);
        admin.setText("ADMIN");
        admin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        admin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Admin a = new Admin();
                a.run();
            }
        });
        getContentPane().add(admin);
        admin.setBounds(90, 190, 140, 50);

        user.setFont(new Font("Times New Roman", 1, 24));
        user.setForeground(Color.WHITE);
        user.setText("USER");
        user.setCursor(new Cursor(Cursor.HAND_CURSOR));
        user.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                UserSignin u = new UserSignin();
                u.run();
            }
        });
        getContentPane().add(user);
        user.setBounds(90, 260, 100, 50);

        about.setFont(new Font("Times New Roman", 1, 24));
        about.setForeground(Color.WHITE);
        about.setText("ABOUT");
        about.setCursor(new Cursor(Cursor.HAND_CURSOR));
        about.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                About a = new About();
                a.run();
            }
        });
        getContentPane().add(about);
        about.setBounds(90, 330, 150, 50);

        label.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Desktop\\JAVA programs\\RRS\\images\\1.jpg"));
        label.setText("Label");
        getContentPane().add(label);
        label.setBounds(-10, -80, 1380, 800);
    }

    protected void paintComponent(Graphics g) {
        int i = 0;
        g.setColor(Color.red);
        g.drawString("WELCOME", 40, 50);
        for (int j = 1; j <= 20; j++) {
            i++;
            repaint();
            if (i > 1300) {
                i = 0;
            }
        }
    }
}
