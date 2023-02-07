package bankmanagmentsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener {
	JPasswordField pinn , repinn;
	JButton change,back;
	String pin;
	PinChange(String pin){
		this.pin=pin;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("Raleway", Font.BOLD, 22));
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setFont(new Font("Raleway", Font.BOLD, 22));
        pintext.setBounds(165,320,180,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);
        
        pinn = new JPasswordField();
        pinn.setFont(new Font("Raleway", Font.BOLD, 16));
        pinn.setBounds(330,320,180,25);
        image.add(pinn);
        
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setFont(new Font("Raleway", Font.BOLD, 22));
        repintext.setBounds(165,360,180,25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(repintext);
        
        repinn = new JPasswordField();
        repinn.setFont(new Font("Raleway", Font.BOLD, 16));
        repinn.setBounds(330,360,180,25);
        image.add(repinn);
        
        
        change = new JButton("CHANGE");
        //change.setFont(new Font("Arial", Font.BOLD, 14));
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        //change.setFont(new Font("Arial", Font.BOLD, 14));
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	 public void actionPerformed(ActionEvent ae){
		 
		 if(ae.getSource()==change) {
		 try {
			  String npin= pinn.getText();
			  String rpin = repinn.getText();
			  
			  if(!npin.equals(rpin)) {
				  JOptionPane.showMessageDialog(null,"Entered PIN does not match");
				  return;
			  }
			  if(npin.equals("")) {
				  JOptionPane.showMessageDialog(null,"Please Enter New PIN");
				  return;  
			  }
			  if(rpin.equals("")) {
				  JOptionPane.showMessageDialog(null,"Please re-Enter PIN");
				  return;  
			  }
			  Conn conn = new Conn();
			  String query1 ="update bank set pin ='"+rpin+"' where pin ='"+pin+"'";
			  String query2 ="update login set pin ='"+rpin+"' where pin ='"+pin+"'";
			  String query3 ="update Signupthree set pin ='"+rpin+"' where pin ='"+pin+"'";
			  
			  conn.s.executeUpdate(query1);
			  conn.s.executeUpdate(query2);
			  conn.s.executeUpdate(query3);
			  
			  JOptionPane.showMessageDialog(null,"PIN Change Successfully");
			  setVisible(false);
			  new Transactions(rpin).setVisible(true);
			  
		 
		 }catch(Exception e) {
			 System.out.println(e); 
		 }
		 }else {
			 setVisible(false);
			 new Transactions(pin).setVisible(true);
		 }
	 } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new PinChange("").setVisible(true);

	}

}
