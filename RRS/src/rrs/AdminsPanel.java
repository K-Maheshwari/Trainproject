package rrs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminsPanel extends JFrame{
        JPanel admp=new JPanel();
        JLabel lb1=new JLabel();
        JLabel lb2=new JLabel();
        JButton btn1=new JButton();
        JButton btn2=new JButton();     
        JLabel back=new JLabel();
    public void run(){
        setVisible(true);
        setLayout(null);
        setSize(1380,760);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        admp.setBackground(new Color(21,137,255));
        admp.setBounds(395, 30, 500, 85);
        add(admp);
        
        lb2.setFont(new Font("MONOSPACED", 3, 48));
        lb2.setForeground(new Color(255, 255, 255));
        lb2.setText("ADMINS PANEL");
        admp.add(lb2);
        
        btn1.setBackground(new Color(244,164,96));
        btn1.setFont(new Font("Comic Sans Ms",1,24));
        btn1.setText("User Reservation");
        btn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                UserData ud=new UserData();
                ud.setVisible(true);
            }
        });
        add(btn1);
        btn1.setBounds(270,250,300,150);
        
        btn2.setBackground(new Color(244,164,96));
        btn2.setFont(new Font("Comic Sans Ms",1,24));
        btn2.setText("Train Data's");
        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                TrainDetails td=new TrainDetails();
                td.setVisible(true);
            }
        });
        add(btn2);
        btn2.setBounds(770,250,300,150);
        
        back.setForeground(Color.white);
        back.setFont(new Font("Comic Sans Ms",1,18));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setText("Back");
        back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                setVisible(false);
                Home h=new Home();
                h.run();
            }
        });
        add(back);
        back.setBounds(10,10,100,20);
        
        lb1.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Desktop\\JAVA programs\\RRS\\images\\2.jpg"));
        add(lb1);
        lb1.setBounds(-550,0,1920,720);
    }
}
