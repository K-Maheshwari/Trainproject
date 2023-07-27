package rrs;

import java.awt.*;
import javax.swing.*;

public class About extends JFrame {    
    JPanel p1=new JPanel();
    JLabel img = new JLabel();
    JLabel tit=new JLabel();
    JLabel q1=new JLabel();
    JLabel q2=new JLabel();
    JLabel q3=new JLabel();
    JLabel q4=new JLabel();
//    public About(){
//        
//    }
    public void run() {
        setVisible(true);
        setLayout(null);
        setSize(1360, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        p1.setLayout(null);
        p1.setBackground(new Color(51,85,102));//102,128,153
        add(p1);
        p1.setBounds(0,0,1360,700);
        
        tit.setFont(new Font("MONOSPACED",1,48));
        tit.setForeground(Color.CYAN);
        tit.setText("HAPPY JOURNEY");
        p1.add(tit);
        tit.setBounds(500,20,450,50);
        
        q1.setFont(new Font("Segoe Script",1,30));
        q1.setForeground(Color.white);
        q1.setText("''The best part of a train journey");
        p1.add(q1);
        q1.setBounds(760,250,550,30);
        
        q2.setFont(new Font("Segoe Script",1,30));
        q2.setForeground(Color.white);
        q2.setText("is not the destination,");
        p1.add(q2);
        q2.setBounds(850,300,500,30);
        
        q3.setFont(new Font("Segoe Script",1,30));
        q3.setForeground(Color.white);
        q3.setText("the memories you create along");
        p1.add(q3);
        q3.setBounds(780,350,500,30);
        
        q4.setFont(new Font("Segoe Script",1,30));
        q4.setForeground(Color.white);
        q4.setText("the way''");
        p1.add(q4);
        q4.setBounds(930,400,500,30);
        
        img.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Desktop\\JAVA programs\\rrs\\images\\ts.gif"));
        p1.add(img);
        img.setBounds(20, 0, 700, 700);
    }
}
