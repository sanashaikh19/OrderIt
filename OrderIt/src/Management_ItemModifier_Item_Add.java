import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;

public class Management_ItemModifier_Item_Add extends JFrame 
{
	public void Management_ItemModifier_Item_Add() 
	{
		final JFrame frame=new JFrame("");	
		JPanel Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Mainpanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Mainpanel.setBackground(Color.GRAY);
		
		JPanel Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Categorypanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Categorypanel.setBackground(Color.GRAY);
		Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Categorypanel.setPreferredSize(new Dimension(280,100));
		
		JLabel JLabel_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_LanguageLabel=new JLabel("Language");
		JLabel_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_LanguageLabel.setPreferredSize(new Dimension(70,30));
		
		String Language_Combo[]=new String[]{"English","Arabic","Burmese","Thai"};
		JComboBox JCombobox_MasterPage_ManagementMenu_ItemModifier_Item_Add_Categorypanel_LanguageCombo=new JComboBox(Language_Combo);
		JCombobox_MasterPage_ManagementMenu_ItemModifier_Item_Add_Categorypanel_LanguageCombo.setPreferredSize(new Dimension(180,30));
		
		JLabel JLabel_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_NameLabel=new JLabel("Name");
		JLabel_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_NameLabel.setPreferredSize(new Dimension(70,30));
		final JTextField JTextField_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_NameTextF=new JTextField();
		JTextField_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_NameTextF.setBackground(Color.LIGHT_GRAY);
		JTextField_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_NameTextF.setPreferredSize(new Dimension(180,30));
		
		JLabel JLabel_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_EmptyLabel=new JLabel("");
		JLabel_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_EmptyLabel.setPreferredSize(new Dimension(10,45));
		
		JButton JButton_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_SaveButton=new JButton("Save");
		JButton_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_SaveButton.setPreferredSize(new Dimension(100,45));
		JButton_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_SaveButton.setBackground(Color.LIGHT_GRAY);
		
		JButton_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_SaveButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	if(JTextField_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_NameTextF.equals(""))
            	{
            		JOptionPane.showMessageDialog(null,"Please Enter Name.");
            	}
            	else
            	{
            		try
            		{
            		Class.forName("com.mysql.jdbc.Driver");  
            		
            		Connection con=DriverManager.getConnection("jdbc:mysql://192.168.1.102:3306/rachana?","root","root");
            		
            		String sql="insert into customer(Customer_Name,Customer_Phone,Customer_PostalCode,Customer_EmailID,Customer_Address) VALUES(?,?,?,?,?)";
            		
            		PreparedStatement pstmt = con.prepareStatement(sql);
            		
            		pstmt.setString(1, JTextField_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_NameTextF.getText());
            		pstmt.executeUpdate();
                	
                	JOptionPane.showMessageDialog(null, "Added Successfully","Added",JOptionPane.PLAIN_MESSAGE);     
                	
            	} catch(Exception ex)
  	                {
  	                    System.out.println(ex);
  	                    JOptionPane.showMessageDialog(null,"Error In Insertion","Error",JOptionPane.ERROR_MESSAGE);
  	                }
            	}
            }
        });
		
		JLabel JLabel_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_EmptyL=new JLabel("");
		JLabel_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_EmptyL.setPreferredSize(new Dimension(30,45));
		
		JButton JButton_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_CancelButton=new JButton("Cancel");
		JButton_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_CancelButton.setPreferredSize(new Dimension(100,45));
		JButton_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_CancelButton.setBackground(Color.LIGHT_GRAY);
		
		JButton_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_CancelButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	frame.dispose();
            }
        });
		
		Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Categorypanel.add(JLabel_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_LanguageLabel);
		Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Categorypanel.add(JCombobox_MasterPage_ManagementMenu_ItemModifier_Item_Add_Categorypanel_LanguageCombo);
		Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Categorypanel.add(JLabel_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_NameLabel);
		Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Categorypanel.add(JTextField_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_NameTextF);
		
		
		Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Mainpanel.add(Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Categorypanel);
		Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_EmptyLabel);
		Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Mainpanel.add(JButton_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_SaveButton);
		Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_EmptyL);
		Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Mainpanel.add(JButton_MasterPage_ManagementMenu_ItemModifier_Item_Add_MainPanel_CancelButton);
		
		
		frame.add(Jpanel_MasterPage_ManagementMenu_ItemModifier_Item_Add_Mainpanel);
		frame.setVisible(true);
		frame.setSize(300,220);
		frame.setLocation(520,280);
		frame.setResizable(false);	
	}
}
