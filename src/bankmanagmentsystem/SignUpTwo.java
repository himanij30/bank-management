package bankmanagmentsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUpTwo extends JFrame implements ActionListener{
        long random;   
		JTextField pan,adharno;
		JButton next;
		JRadioButton syes,sno,eyes,eno;
	    JComboBox religion,category,income,education,occupation;
	   String formno;
	 
	    SignUpTwo(String formno){
	    	this.formno= formno;
	    	setLayout(null);
	    	
	    	setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 2");
	    	
	        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/210709_deutsche-bank_logo.png"));
	        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel label1 = new JLabel(i3);
	        label1.setBounds(20, 0, 100, 100);
	        add(label1);
	        
	 
	        
	        JLabel additionalDetails  = new JLabel("Page 2: Additional Details");
	        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
	        additionalDetails.setBounds(290,80,400,30);
	        add(additionalDetails);
	        
	        JLabel religions = new JLabel("Religions:");
	        religions.setFont(new Font("Raleway", Font.BOLD, 20));
	        religions.setBounds(100,140,100,30);
	        add(religions);
	        
	        String valReligion[]= {" Hindu" , "Muslim","Sikh" ," Chhristin","Others"};
	        religion = new JComboBox( valReligion);
	        religion.setBounds(300,140, 400, 30);
	        religion.setBackground(Color.WHITE);
	        add(religion);
	        
	        
	        JLabel cat = new JLabel("Category:");
	        cat.setFont(new Font("Raleway", Font.BOLD, 20));
	        cat.setBounds(100,190,200,30);
	        add(cat);
	        
	        String valcategory[]= {" General" , "OBC","SC" ,"NT","Others"};
	        category = new JComboBox( valcategory);
	        category.setBounds(300,190, 400, 30);
	        category.setBackground(Color.WHITE);
	        add(category);
	        
	  
	        
	        JLabel dob = new JLabel("Income:");
	        dob.setFont(new Font("Raleway", Font.BOLD, 20));
	        dob.setBounds(100,240,200,30);
	        add(dob);
	        
	        String valincome[]= {"NULL" , "<1,50,000","<2,50,000" ,"5,00,000","Others","Upto 10,00,000"};
	         income = new JComboBox( valincome);
	         income.setBounds(300,240, 400, 30);
	         income.setBackground(Color.WHITE);
	         add(income);
	
	       
	        JLabel gender = new JLabel("Educatoinal:");
	        gender.setFont(new Font("Raleway", Font.BOLD, 20));
	        gender.setBounds(100,290,200,30);
	        add(gender);
	        
	        JLabel email = new JLabel("Qualification:");
	        email.setFont(new Font("Raleway", Font.BOLD, 20));
	        email.setBounds(100,315,200,30);
	        add(email);

	        String educationValue[]= {"Non Graduation" , "Graduate","post Graduate","Others"};
	         education = new JComboBox(educationValue);
	         education.setBounds(300,315, 400, 30);
	         education.setBackground(Color.WHITE);
	          add(education);
	       
	        
	        JLabel marital = new JLabel("Occupation");
	        marital.setFont(new Font("Raleway", Font.BOLD, 20));
	        marital.setBounds(100,390,200,30);
	        add(marital);
	        

	        String occupationValue[]= {"Salaried","Self Employee","Business","Students","Retired","Others"};
	        occupation = new JComboBox(occupationValue);
	        occupation.setBounds(300,390, 400, 30);
	        occupation.setBackground(Color.WHITE);
	         add(occupation);
	       
	       	      
	        JLabel address = new JLabel("PAN No :");
	        address.setFont(new Font("Raleway", Font.BOLD, 20));
	        address.setBounds(100,440,200,30);
	        add(address);
	        
	        pan  = new JTextField();
	        pan.setFont(new Font("Raleway", Font.BOLD, 14));
	        pan.setBounds(300,440, 400, 30);
	        add(pan);
	        
	        JLabel city = new JLabel("AdharNo:");
	        city.setFont(new Font("Raleway", Font.BOLD, 20));
	        city.setBounds(100,490,200,30);
	        add(city);
	        
	        adharno  = new JTextField();
	        adharno.setFont(new Font("Raleway", Font.BOLD, 14));
	        adharno.setBounds(300,490, 400, 30);
	        add(adharno);

	        JLabel state = new JLabel("Senior Citizen :");
	        state.setFont(new Font("Raleway", Font.BOLD, 20));
	        state.setBounds(100,540,200,30);
	        add(state);
	        
	        syes = new JRadioButton("Yes");
	        syes.setBounds(300,540,100,30);
	        syes.setBackground(Color.WHITE);
	        add(syes);
	        
	        sno = new JRadioButton("No");
	        sno.setBounds(450,540,100,30);
	        sno.setBackground(Color.WHITE);
	        add(sno);
	        
	        ButtonGroup maritalgroup = new ButtonGroup();
	        maritalgroup.add(syes);
	        maritalgroup.add(sno);
	       

	        JLabel pincode = new JLabel("Existing Account :");
	        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
	        pincode.setBounds(100,590,200,30);
	        add(pincode);
	        
	        eyes = new JRadioButton("Yes");
	        eyes.setBounds(300,590,100,30);
	        eyes.setBackground(Color.WHITE);
	        add(eyes);
	        
	        eno = new JRadioButton("No");
	        eno.setBounds(450,590,100,30);
	        eno.setBackground(Color.WHITE);
	        add(eno);
	        
	        ButtonGroup magroup = new ButtonGroup();
	        magroup.add(eyes);
	        magroup.add(eno);
	        
	        
	        next = new JButton("Next");
	        next.setBackground(Color.BLACK);
	        next.setForeground(Color.WHITE);
	        next.setFont(new Font("Raleway", Font.BOLD, 14));
	        next.setBounds(620, 660, 80, 30);
	        next.addActionListener(this);
	        add(next);
	        
	        
	        getContentPane().setBackground(Color.WHITE);
	        
	        setSize(850,800);
	        setLocation(350,10);
	        setVisible(true);
	    }
	    
	    public void actionPerformed(ActionEvent ae){
	    	
	    	//String formno = ""+random; //setText
	    	String sreligion= (String)religion.getSelectedItem();
	    	String scategory= (String)category.getSelectedItem();
	    	String sincome= (String) income.getSelectedItem();
	    	String seducation= (String)education.getSelectedItem();
	    	String soccupation= (String)occupation.getSelectedItem();
	    	
	    	String seniorcitizen=null;
	    	
	    	if(syes.isSelected()){
	    		seniorcitizen="Yes";
	    		
	    	}else if(sno.isSelected()){
	    		seniorcitizen="No";
	    	}
	    
	    	
	    	String existingaccount=null;
	    	
	    	if(eyes.isSelected()){
	    		existingaccount="yes";
	    		
	    	}else if(eno.isSelected()){
	    		existingaccount="No";
	    		
	    	}
	    
	    	String span= pan.getText();
	    	String sadharno= adharno.getText();
	    	
	    
	    	try{
	    			Conn c = new Conn();
	    			String query="insert into Signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadharno+"','"+seniorcitizen+"','"+existingaccount+"')";
	    			c.s.executeUpdate(query);
	    			
	    			//Signup3 object
	    			
	    			setVisible(false);
	    			new SignupThree(formno).setVisible(true);
	    		
	    		}catch(Exception e){
	    		
	    		System.out.println(e);
	    	}
	    	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  new SignUpTwo("");

	}

}
