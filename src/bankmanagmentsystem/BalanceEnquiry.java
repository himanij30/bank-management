package bankmanagmentsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener {
  JButton back;
  String pin;
 
  BalanceEnquiry(String pin){
   this.pin=pin;
   setLayout(null);
  
   
  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
  Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
  ImageIcon i3 = new ImageIcon(i2);
  JLabel image = new JLabel(i3);
  image.setBounds(0, 0, 900, 900);
  add(image);
  
  back = new JButton("Back");
  back.setFont(new Font("Raleway", Font.BOLD, 14));
  back.setBounds(355,520,150,30);
  back.addActionListener(this);
  image.add(back);
  
  Conn conn= new Conn();
  int balance=0;
  try {
       String q="select * from bank where pin='"+pin+"'";
      ResultSet rs = conn.s.executeQuery(q);
      //System.out.println(rs);
      
      while(rs.next()) {
          if(rs.getString("type").equals("Deposit")) {
              balance += Integer.parseInt(rs.getString("amount"));
          }else {
              balance -= Integer.parseInt(rs.getString("amount"));
          }
        }  
          
      }catch(Exception e) {
       System.out.println(e);
      }
  
  JLabel text = new JLabel("Your Current Account Balance is Rs " + balance);
  text.setFont(new Font("Raleway", Font.BOLD, 22));
  text.setBounds(179,300,400,30);
  text.setForeground(Color.WHITE);
  text.setFont(new Font("System", Font.BOLD, 16));
  image.add(text);
  
  
  getContentPane().setBackground(Color.WHITE);
  setSize(900,900);
  setLocation(300,0);
  setUndecorated(true);
  setVisible(true);
 }
  
  public void actionPerformed(ActionEvent ae){
   setVisible(false);
   new Transactions(pin).setVisible(true);
  }

 public static void main(String[] args) {
  // TODO Auto-generated method stub
   new BalanceEnquiry("");
 }

}
