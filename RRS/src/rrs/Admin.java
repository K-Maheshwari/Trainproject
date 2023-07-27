package rrs;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Admin extends JFrame {

    JPanel adm = new JPanel();
    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel();
    JTextField name = new JTextField();
    JPasswordField pass = new JPasswordField();
    JButton submit = new JButton();
    JButton cancel = new JButton();

    public void run() {
        setVisible(true);
        getContentPane().setLayout(null);
        setSize(1380,760);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        l2.setFont(new Font("Comic Sans MS", 3, 48));
        l2.setForeground(new Color(255, 255, 51));
        l2.setText("ADMIN LOGIN");
        add(l2);
        l2.setBounds(455, 30, 500, 85);

        l3.setFont(new Font("Times New Roman", 1, 25));
        l3.setForeground(new Color(255, 255, 255));
        l3.setText("User Name");
        getContentPane().add(l3);
        l3.setBounds(440, 220, 130, 40);

        l4.setFont(new Font("Times New Roman", 1, 25));
        l4.setForeground(new Color(255, 255, 255));
        l4.setText("Password");
        getContentPane().add(l4);
        l4.setBounds(440, 310, 130, 50);

        name.setFont(new Font("Times New Roman", 1, 18));
        getContentPane().add(name);
        name.setBounds(630, 225, 210, 30);
        pass.setFont(new Font("Times New Roman", 1, 18));
        getContentPane().add(pass);
        pass.setBounds(630, 320, 210, 30);

        submit.setFont(new Font("Comic Sans MS", 1, 25));
        submit.setText("SUBMIT");
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText().trim().isEmpty() && pass.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Blank not Allowed!!!!");
                } else if (name.getText().equals("Admin") && pass.getText().equals("1234")) {
                    JOptionPane.showMessageDialog( null,"Login Successfully");
                    AdminsPanel ap = new AdminsPanel();
                    ap.run();
                } else {
                    JOptionPane.showMessageDialog(null,"Invalid Credantials");

                }
            }
        });
        getContentPane().add(submit);
        submit.setBounds(420, 450, 200, 50);
        
//        adminbtn abtn=new adminbtn();
//        abtn.setFont(new Font("Comic Sans MS", 1, 25));
//        abtn.setText("SUBMIT");
//        abtn.setVisible(true);
//        add(abtn);
//        abtn.setBounds(420, 450, 200, 50);

        cancel.setFont(new Font("Comic Sans MS", 1, 25));
        cancel.setText("CANCEL");
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name.setText(" ");
                pass.setText(" ");
                setVisible(false);
            }
        });
        getContentPane().add(cancel);
        cancel.setBounds(660, 450, 200, 50);

        l1.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Desktop\\JAVA programs\\RRS\\images\\7.jpg"));
        getContentPane().add(l1);
        l1.setBounds(-550, 0, 1920, 710);

    }
}
