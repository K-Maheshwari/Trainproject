package rrs;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Reservation extends JFrame{
    JLabel img=new JLabel();
    JLabel title=new JLabel();
    JLabel lpid=new JLabel();
    JLabel lsp=new JLabel();
    JLabel ldp=new JLabel();
    JLabel lno=new JLabel();
    JLabel ltn=new JLabel();
    JLabel lp=new JLabel();
    JLabel dat=new JLabel();
    JLabel ltic=new JLabel();
    JLabel ltot=new JLabel();
    JTextField tpid=new JTextField();
    JTextField tno=new JTextField();
    JTextField ttn=new JTextField();
    JTextField tp=new JTextField();
    JTextField ttot=new JTextField();
    JTextField ticket=new JTextField();
    JComboBox sp=new JComboBox();
    JComboBox dp=new JComboBox();
    JDateChooser dt = new JDateChooser();
    JButton reserve =new JButton();
    JButton search=new JButton();
    JLabel back=new JLabel();
    public Reservation(){
        run();
        Connect();
        LoadStartPlace();
        LoadDestinationPlace();
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
    
    public void LoadStartPlace(){
        try{
            st=con.prepareStatement("select startPlace from train");
            rs=st.executeQuery();
            sp.removeAllItems();
            while(rs.next()){
                sp.addItem(rs.getString(1));
            }
           
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public void LoadDestinationPlace(){
        try{
            st=con.prepareStatement("select destinationPlace from train");
            rs=st.executeQuery();
            dp.removeAllItems();
            while(rs.next()){
                dp.addItem(rs.getString(1));
            }
           
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public void load(){
        String StartPlace=sp.getSelectedItem().toString();
        String DestinationPlace=dp.getSelectedItem().toString();
        try{
           st=con.prepareStatement("Select * from train where startPlace=? and destinationPlace=?;");
           st.setString(1,StartPlace);
           st.setString(2,DestinationPlace);
           rs=st.executeQuery();
           if(rs.next()==true){
               tno.setText(rs.getString(1));
               ttn.setText(rs.getString(2));
               tp.setText(rs.getString(5));
           }
           else{
               JOptionPane.showMessageDialog(null,"Record Not Found!!!");
           }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
    public void run(){
        setVisible(true);
        setLayout(null);
        setSize(1360,780);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        title.setFont(new Font("MONOSPACED", 1, 48));
        title.setForeground(Color.pink);
        title.setText("RESERVATION");
        add(title);
        title.setBounds(500, 20, 380, 60);
        
        lpid.setFont(new Font("TImes New Roman",1,25));
        lpid.setForeground(Color.white);
        lpid.setText("Passenger ID");
        add(lpid);
        lpid.setBounds(380,120,200,30);
        
        lsp.setFont(new Font("TImes New Roman",1,25));
        lsp.setForeground(Color.white);
        lsp.setText("Start Place");
        add(lsp);
        lsp.setBounds(380,180,200,30);
        
        ldp.setFont(new Font("TImes New Roman",1,25));
        ldp.setForeground(Color.white);
        ldp.setText("Destination Place");
        add(ldp);
        ldp.setBounds(380,240,200,30);
        
        lno.setFont(new Font("TImes New Roman",1,25));
        lno.setForeground(Color.white);
        lno.setText("Train No.");
        add(lno);
        lno.setBounds(380,300,200,30);
        
        ltn.setFont(new Font("TImes New Roman",1,25));
        ltn.setForeground(Color.white);
        ltn.setText("Train Name");
        add(ltn);
        ltn.setBounds(380,360,200,30);
        
        lp.setFont(new Font("TImes New Roman",1,25));
        lp.setForeground(Color.white);
        lp.setText("Price");
        add(lp);
        lp.setBounds(380,420,200,30);
        
        dat.setFont(new Font("TImes New Roman",1,25));
        dat.setForeground(Color.white);
        dat.setText("Date");
        add(dat);
        dat.setBounds(380,480,200,30);
        
        ltic.setFont(new Font("TImes New Roman",1,25));
        ltic.setForeground(Color.white);
        ltic.setText("Ticket");
        add(ltic);
        ltic.setBounds(380,540,200,30);
        
        ltot.setFont(new Font("TImes New Roman",1,25));
        ltot.setForeground(Color.white);
        ltot.setText("Total Price");
        add(ltot);
        ltot.setBounds(380,600,200,30);
        
        tpid.setFont(new Font("TImes New Roman",1,20));
        add(tpid);
        tpid.setBounds(650,120,250,30);
        
        sp.setFont(new Font("TImes New Roman",1,20));
        add(sp);
        sp.setBounds(650,180,250,30);
        
        dp.setFont(new Font("TImes New Roman",1,20));
        add(dp);
        dp.setBounds(650,240,250,30);
        
        tno.setFont(new Font("TImes New Roman",1,20));
        add(tno);
        tno.setBounds(650,300,250,30);
        
        ttn.setFont(new Font("TImes New Roman",1,20));
        add(ttn);
        ttn.setBounds(650,360,250,30);
        
        tp.setFont(new Font("TImes New Roman",1,20));
        add(tp);
        tp.setBounds(650,420,250,30);
        
        dt.setFont(new Font("Times New Roman",1,20));
        add(dt);
        dt.setBounds(650,480,250,30);
        
        ticket.setFont(new Font("Times New Roman",1,20));
//        ticket.addKeyListener(new KeyAdapter(){
//            @Override
//            public void keyPressed(KeyEvent evt){
//                int amt,tckt,tot;
//                if(evt.getKeyCode()==KeyEvent.VK_ENTER){
//                    amt=Integer.parseInt(tp.getText());
//                    tckt=Integer.parseInt(ticket.getText());
//                    tot=amt*tckt;
//                    ttot.setText(String.valueOf(tot));
//                }
//            }
//        });
        add(ticket);
        ticket.setBounds(650,540,250,30);
        
        ttot.setFont(new Font("TImes New Roman",1,20));
        ttot.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                int amt,tckt,tot;
                //if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    amt=Integer.parseInt(tp.getText());
                    tckt=Integer.parseInt(ticket.getText());
                    tot=amt*tckt;
                    ttot.setText(String.valueOf(tot));
               // }
            }
        });
        add(ttot);
        ttot.setBounds(650,600,250,30);
        
        search.setFont(new Font("Comic Sans MS",1,25));
        search.setBackground(Color.pink);
        search.setText("Search");
        search.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                load();
            }
        });
        add(search);
        search.setBounds(980,220,130,60);
        
        reserve.setFont(new Font("Comic Sans MS",1,20));
        reserve.setBackground(Color.pink);
        reserve.setText("Reserve");
        reserve.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                String Passenger=tpid.getText();
                String StartPlace=sp.getSelectedItem().toString();
                String DestinationPlace=dp.getSelectedItem().toString();
                String TrainId=tno.getText();
                String TrainName=ttn.getText();
                String Price=tp.getText();
                SimpleDateFormat date_form=new SimpleDateFormat("dd-MM--yyyy");
                String Date=date_form.format(dt.getDate());
                String Ticket=ticket.getText();
                String Total=ttot.getText();
                try{
                    st=con.prepareStatement("insert into reservation(id,startPlace,destinationPlace,trainid,trainName,price,date,ticket,total)values(?,?,?,?,?,?,?,?,?)");
                    st.setString(1,Passenger);
                    st.setString(2,StartPlace);
                    st.setString(3, DestinationPlace);
                    st.setString(4,TrainId);
                    st.setString(5,TrainName);
                    st.setString(6,Price);
                    st.setString(7,Date);
                    st.setString(8,Ticket);
                    st.setString(9,Total);
                    
                    int k=st.executeUpdate();
                    if(k==1){
                        JOptionPane.showMessageDialog(null, "Ticket Reserved Successfully");
                        Home hh=new Home();
                        hh.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Reservation Failed");
                    }
                }
                catch(SQLException ex){
                    System.out.println(ex);
                }
            }
        });
        add(reserve);
        reserve.setBounds(580,640,130,40);
        
        back.setFont(new Font("Comic Sans Ms", 1, 20));
        back.setForeground(Color.white);
        back.setText("Back");
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt){
                setVisible(false);
                Home home=new Home();
                home.run();
            }
        });
        add(back);
        back.setBounds(10,10,100,20);
       
        img.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Desktop\\JAVA programs\\rrs\\images\\17.jpg"));
        add(img);
        img.setBounds(-200,-100,1920,1080);
    }
}
