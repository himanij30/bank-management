package bankmanagmentsystem;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{
	JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
	String pin;
	
	FastCash(String pin){
		this.pin=pin;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setFont(new Font("Raleway", Font.BOLD, 22));
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setFont(new Font("Raleway", Font.BOLD, 14));
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setFont(new Font("Raleway", Font.BOLD, 14));
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Rs 2000");
        ministatement.setFont(new Font("Raleway", Font.BOLD, 14));
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setFont(new Font("Raleway", Font.BOLD, 14));
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setFont(new Font("Raleway", Font.BOLD, 14));
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        
        exit = new JButton("Back");
        exit.setFont(new Font("Raleway", Font.BOLD, 14));
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
		getContentPane().setBackground(Color.WHITE);
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==exit){
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}else{
			String amount=  ((JButton)ae.getSource()).getText().substring(3);
			Conn conn= new Conn();
			try {
				 String q="select * from bank where pin ='"+pin+"'";
				ResultSet rs = conn.s.executeQuery(q);
				System.out.println(rs);
				int balance=0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
					
				}
				 if(ae.getSource()!= exit && balance< Integer.parseInt(amount)) {
					 JOptionPane.showMessageDialog(null,"Insufficient Balance");
					 return;
				 }else {
				Date date = new Date();
				String query="insert into bank values('"+pin+"','"+date+"','withdrawl','"+amount+"')";
				conn.s.executeUpdate(query);
				//System.out.println(query);
				JOptionPane.showMessageDialog(null,"Rs."+amount+ "Debited Sucessfully");
				
				
				 setVisible(false);
                 new Transactions(pin).setVisible(true);
				 }
				
			}catch(Exception e) {
				System.out.println(e);
			}
		
		
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FastCash("");
			
		

	}

}