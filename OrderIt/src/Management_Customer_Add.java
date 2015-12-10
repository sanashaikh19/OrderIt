import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.*;

public class Management_Customer_Add extends JFrame 
{	
	public void Management_Customer_Add() 
	{
		final JFrame frame=new JFrame("Customer");	
		JPanel Jpanel_MasterPage_ManagementMenu_Customer_Add_Mainpanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Mainpanel.setBackground(Color.GRAY);
		
		JPanel Jpanel_MasterPage_ManagementMenu_Customer_Add_Categorypanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Categorypanel.setBackground(Color.GRAY);
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Categorypanel.setPreferredSize(new Dimension(350,240));
		
		JLabel JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_NameLabel=new JLabel("Name");
		JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_NameLabel.setPreferredSize(new Dimension(90,30));
		final JTextField JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_NameTextF=new JTextField();
		JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_NameTextF.setPreferredSize(new Dimension(220,25));
		
		JLabel JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PhoneLabel=new JLabel("Phone");
		JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PhoneLabel.setPreferredSize(new Dimension(90,30));
		final JTextField JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PhoneTextF=new JTextField();
		JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PhoneTextF.setPreferredSize(new Dimension(220,25));
		
		JLabel JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PostalCodeLabel=new JLabel("Postal Code");
		JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PostalCodeLabel.setPreferredSize(new Dimension(90,30));
		final JTextField JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PostalCodeTextF=new JTextField();
		JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PostalCodeTextF.setPreferredSize(new Dimension(220,25));
		
		JLabel JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_EmailLabel=new JLabel("Email");
		JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_EmailLabel.setPreferredSize(new Dimension(90,30));
		final JTextField JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_EmailTextF=new JTextField();
		JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_EmailTextF.setPreferredSize(new Dimension(220,25));
		
		JLabel JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_AddressLabel=new JLabel("Address");
		JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_AddressLabel.setPreferredSize(new Dimension(90,30));
		final JTextArea JTextArea_MasterPage_ManagementMenu_Customer_Add_Categorypanel_AddressTextA=new JTextArea();
		JTextArea_MasterPage_ManagementMenu_Customer_Add_Categorypanel_AddressTextA.setPreferredSize(new Dimension(220,80));
		
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Categorypanel.add(JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_NameLabel);
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Categorypanel.add(JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_NameTextF);
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Categorypanel.add(JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PhoneLabel);
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Categorypanel.add(JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PhoneTextF);
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Categorypanel.add(JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PostalCodeLabel);
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Categorypanel.add(JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PostalCodeTextF);
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Categorypanel.add(JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_EmailLabel);
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Categorypanel.add(JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_EmailTextF);
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Categorypanel.add(JLabel_MasterPage_ManagementMenu_Customer_Add_Categorypanel_AddressLabel);
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Categorypanel.add(JTextArea_MasterPage_ManagementMenu_Customer_Add_Categorypanel_AddressTextA);
		
		JLabel JLabel_MasterPage_ManagementMenu_Customer_Add_MainPanel_EmptyLabel=new JLabel("");
		JLabel_MasterPage_ManagementMenu_Customer_Add_MainPanel_EmptyLabel.setPreferredSize(new Dimension(30,45));
		
		JButton JButton_MasterPage_ManagementMenu_Customer_Add_MainPanel_SaveButton=new JButton("Save");
		JButton_MasterPage_ManagementMenu_Customer_Add_MainPanel_SaveButton.setPreferredSize(new Dimension(100,45));
		JButton_MasterPage_ManagementMenu_Customer_Add_MainPanel_SaveButton.setBackground(Color.LIGHT_GRAY);
		
		JButton_MasterPage_ManagementMenu_Customer_Add_MainPanel_SaveButton.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				if (JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_NameTextF.getText().equals("") )
                {
					JOptionPane.showMessageDialog(null,"Enter Name.");
                }
				else if (JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PhoneTextF.getText().equals("") )
                {
					JOptionPane.showMessageDialog(null,"Enter Phone.");
                }
				else if (JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PostalCodeTextF.getText().equals("") )
                {
					JOptionPane.showMessageDialog(null,"Enter Postal Code.");
                }
				else if (JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_EmailTextF.getText().equals("") )
                {
					JOptionPane.showMessageDialog(null,"Enter Email ID.");
                }
				else if (JTextArea_MasterPage_ManagementMenu_Customer_Add_Categorypanel_AddressTextA.getText().equals("") )
                {
					JOptionPane.showMessageDialog(null,"Enter Address.");
                }
				else
                {               
                	try
                	{   
                		Class.forName("com.mysql.jdbc.Driver");                  		
                		Connection con=DriverManager.getConnection("jdbc:mysql://192.168.1.102:3306/rachana?","root","root");
                		String sql="insert into customer(Customer_Name,Customer_Phone,Customer_PostalCode,Customer_EmailID,Customer_Address) VALUES(?,?,?,?,?)";               		
                		PreparedStatement pstmt = con.prepareStatement(sql);
                		
                		pstmt.setString(1, JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_NameTextF.getText());                		
                    	pstmt.setString(2, JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PhoneTextF.getText());                    	
                    	pstmt.setString(3, JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_PostalCodeTextF.getText());                   	
                    	pstmt.setString(4, JTextField_MasterPage_ManagementMenu_Customer_Add_Categorypanel_EmailTextF.getText());                  	
                    	pstmt.setString(5, JTextArea_MasterPage_ManagementMenu_Customer_Add_Categorypanel_AddressTextA.getText());
                    	
                    	pstmt.executeUpdate();
                    	
                    	JOptionPane.showMessageDialog(null, "Added Successfully","Added",JOptionPane.PLAIN_MESSAGE);                	   
                	}
	                catch(Exception ex)
	                {
	                    System.out.println(ex);
	                    JOptionPane.showMessageDialog(null,"Error In Insertion","Error",JOptionPane.ERROR_MESSAGE);
	                }
                }	
	        }
	    });
		
		JLabel JLabel_MasterPage_ManagementMenu_Customer_Add_MainPanel_EmptyL=new JLabel("");
		JLabel_MasterPage_ManagementMenu_Customer_Add_MainPanel_EmptyL.setPreferredSize(new Dimension(50,45));
		
		JButton JButton_MasterPage_ManagementMenu_Customer_Add_MainPanel_CancelButton=new JButton("Cancel");
		JButton_MasterPage_ManagementMenu_Customer_Add_MainPanel_CancelButton.setPreferredSize(new Dimension(100,45));
		JButton_MasterPage_ManagementMenu_Customer_Add_MainPanel_CancelButton.setBackground(Color.LIGHT_GRAY);
		
		JButton_MasterPage_ManagementMenu_Customer_Add_MainPanel_CancelButton.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				frame.dispose();
	        }
	    });
		
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Mainpanel.add(Jpanel_MasterPage_ManagementMenu_Customer_Add_Categorypanel);
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Customer_Add_MainPanel_EmptyLabel);
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Mainpanel.add(JButton_MasterPage_ManagementMenu_Customer_Add_MainPanel_SaveButton);
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Customer_Add_MainPanel_EmptyL);
		Jpanel_MasterPage_ManagementMenu_Customer_Add_Mainpanel.add(JButton_MasterPage_ManagementMenu_Customer_Add_MainPanel_CancelButton);
		
		frame.add(Jpanel_MasterPage_ManagementMenu_Customer_Add_Mainpanel);
		frame.setVisible(true);
		frame.setSize(350,350);
		frame.setLocation(500,200);
	//	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
	}
}
