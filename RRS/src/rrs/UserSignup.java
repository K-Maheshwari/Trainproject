package rrs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UserSignup extends JFrame{
    JLabel img=new JLabel();
    JLabel title=new JLabel();
    JLabel lname=new JLabel();
    JLabel luname=new JLabel();
    JLabel lemail=new JLabel();
    JLabel lpho=new JLabel();
    JLabel lpass=new JLabel();
    JLabel au=new JLabel();
    JTextField name=new JTextField();
    JTextField uname=new JTextField();
    JTextField email=new JTextField();
    JTextField phone=new JTextField();
    JTextField pass=new JTextField();
    JButton btn=new JButton();
    
    public UserSignup(){
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
    public void run(){
        setVisible(true);
        setLayout(null);
        setSize(1360,780);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        title.setFont(new Font("MONOSPACED", 1, 48));
        title.setForeground(Color.cyan);
        title.setText("USERS SIGNUP");
        add(title);
        title.setBounds(500, 20, 380, 60);
        
        lname.setFont(new Font("TIMES NEW ROMAN",1,25));
        lname.setForeground(Color.white);
        lname.setText("Name");
        add(lname);
        lname.setBounds(480,170,70,30);
        
        luname.setFont(new Font("TIMES NEW ROMAN",1,25));
        luname.setForeground(Color.white);
        luname.setText("UserName");
        add(luname);
        luname.setBounds(480,230,120,30);
        
        lemail.setFont(new Font("TIMES NEW ROMAN",1,25));
        lemail.setForeground(Color.white);
        lemail.setText("Phone No");
        add(lemail);
        lemail.setBounds(480,280,120,40);
        
        lpho.setFont(new Font("TIMES NEW ROMAN",1,25));
        lpho.setForeground(Color.white);
        lpho.setText("Email");
        add(lpho);
        lpho.setBounds(480,330,80,40);
        
        lpass.setFont(new Font("TIMES NEW ROMAN",1,25));
        lpass.setForeground(Color.white);
        lpass.setText("Password");
        add(lpass);
        lpass.setBounds(480,380,120,40);
        
        add(name);
        name.setBounds(700,170,170,30);
        add(uname);
        uname.setBounds(700,230,170,30);
        add(phone);
        phone.setBounds(700,280,170,30);
        add(email);
        email.setBounds(700,330,170,30);
        add(pass);
        pass.setBounds(700,380,170,30);
        
        btn.setBackground(Color.PINK);
        btn.setFont(new Font("Comic Sans MS",1,25));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setText("Sign In");
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                String Name=name.getText();
                String Username=uname.getText();
                String Email=email.getText();
                String Phone=phone.getText();
                String Password=pass.getText();
                try{
                    st=con.prepareStatement("insert into registration(name,username,email,phone,password)values(?,?,?,?,?)");
                    st.setString(1, Name);
                    st.setString(2, Username);
                    st.setString(3, Email);
                    st.setString(4, Phone);
                    st.setString(5, Password);
//                    st.execute();
//                    JOptionPane.showMessageDialog(null, "Account Successfully Created");
//                    String ID = null;
//                    st=con.prepareStatement("Select id from registration;");
//                    st.setString(1,ID);
//                    rs=st.executeQuery();
//                    rs.getString(1);
//                    JOptionPane.showMessageDialog(null,"Your Passenger ID is : "+rs);
                    
                   int k=st.executeUpdate();
                    if(k==1){
                        JOptionPane.showMessageDialog(null, "Account Successfully Created");
                        UserSignin us=new UserSignin();
                        us.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Failed");
                    }
                    con.close();
                }
                catch(SQLException ex){
                    System.out.println(ex);
                }
                
            }
        });
        add(btn);
        btn.setBounds(590,460,180,60);
        
        au.setFont(new Font("Serif",1,35));
        au.setForeground(Color.cyan);
        au.setCursor(new Cursor(Cursor.HAND_CURSOR));
        au.setText("Already a User? Click Here");
        au.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                UserSignin uu=new UserSignin();
                uu.setVisible(true);
            }
        });
        add(au);
        au.setBounds(460,560,470,40);
        
        img.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Desktop\\JAVA programs\\rrs\\images\\18.jpg"));
        add(img);
        img.setBounds(-150,-250,1900,1080);
    }
    
}
