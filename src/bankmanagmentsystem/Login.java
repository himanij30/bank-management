package bankmanagmentsystem;

	import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

	public class Login extends JFrame implements ActionListener{
	    
		 JButton login,clear,SignUp;
	    JTextField cardTextField;
	    JPasswordField pinTextField;
	   
	  
	    Login(){
	        setTitle("AUTOMATED TELLER MACHINE");
	        setLayout(null);
	        
	        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
	        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel label = new JLabel(i3);
	        label.setBounds(70, 10, 100, 100);
	        add(label);
	        
	        JLabel text = new JLabel("WELCOME TO ATM");
	        text.setFont(new Font("Osward", Font.BOLD, 38));
	        text.setBounds(200,40,400,40);
	        add(text);
	        
	        JLabel cardno = new JLabel("Card No:");
	        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
	        cardno.setBounds(120,150,150,30);
	        add(cardno);
	        
	        cardTextField = new JTextField(15);
	        cardTextField.setBounds(300,150,250,30);
	        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
	        add(cardTextField);
	        
	        JLabel pin = new JLabel("PIN:");
	        pin.setFont(new Font("Raleway", Font.BOLD, 28));
	        pin.setBounds(120,220,250,30);
	        add(pin);
	        
	        pinTextField = new JPasswordField(15);
	        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
	        pinTextField.setBounds(300,220,250,30);
	        add( pinTextField);
	                
	        login = new JButton("SIGN IN");
	        login.setBackground(Color.BLACK);
	        login.setForeground(Color.WHITE);
	        login.setFont(new Font("Arial", Font.BOLD, 14));
	        login.setBounds(300,300,100,30);
	        login.addActionListener(this);
	        add(login);
	        
	        clear = new JButton("CLEAR");
	        clear.setBackground(Color.BLACK);
	        clear.setForeground(Color.WHITE);
	        clear.setFont(new Font("Arial", Font.BOLD, 14));
	        clear.setBounds(430,300,100,30);
	        clear.addActionListener(this);
	        add(clear);
	        
	        SignUp = new JButton("SIGN UP");
	        SignUp.setBackground(Color.BLACK);
	        SignUp.setForeground(Color.WHITE);
	        SignUp.setFont(new Font("Arial", Font.BOLD, 14));
	        SignUp.setBounds(300,350,230,30);
	        SignUp.addActionListener(this);
	        add(SignUp);
	        
	       
	 
	        
	        getContentPane().setBackground(Color.WHITE);
	        
	        setSize(800,480);
	        setLocation(350,200);
	        setVisible(true);
	        
	    }
	    public void actionPerformed(ActionEvent ae){
	    	try{        
	            if(ae.getSource()==login){
	                Conn conn = new Conn();
	                
	                String cardno  = cardTextField.getText();
	                String pin  = pinTextField.getText();
	               // System.out.println(cardno);
	                //System.out.println(pin);
	                String query  = "select * from login where cardno ='"+cardno+"' and pin ='"+pin+"'";
	                // System.out.println("query:"+query);
	               // System.out.println(rs.next());
	              
	                 ResultSet rs = conn.s.executeQuery(query);
	                 //  int size=0;
	                  if(rs.next()){
	                	  //rs.first();
	                	 // rs.beforeFirst();
	                	  //rs.last();
	                	 /// size=rs.getRow();
	                	// int size=rs.getRow();
	                	// System.out.println(rs.next());
	                	  
	             
	                       //rs.getInt(0);
	                       //rs.getFloat(1);
	                       //rs.getInt(2);
	                       //System.out.println(rs.getFloat(1));
	                       //System.out.println(rs.getInt(2));
	                    setVisible(false);
	                    new Transactions(pin).setVisible(true);
	                
	                 }else{ 
	                  JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
	                    }
	                
	                }else if(ae.getSource()==clear){
	                cardTextField.setText("");
	                pinTextField.setText("");
	                
	            }else if(ae.getSource()==SignUp){
	                setVisible(false);
	                new SignUpOne().setVisible(true);
	            }
	        }catch(Exception e){
	        	 System.out.println(e);
	        	
	        }
	    }
    			
    			
	    
	        
	    public static void main(String[] args){
	        new Login();
	    }

	    
	}


