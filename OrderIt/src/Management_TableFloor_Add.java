import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;

public class Management_TableFloor_Add extends JFrame 
{
	public void Management_TableFloor_Add() 
	{
		final JFrame frame=new JFrame("");	
		JPanel Jpanel_MasterPage_ManagementMenu_TableFloor_Add_Mainpanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		Jpanel_MasterPage_ManagementMenu_TableFloor_Add_Mainpanel.setBackground(Color.GRAY);	
		
		JLabel JLabel_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_NameLabel=new JLabel("Floor Name");
		JLabel_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_NameLabel.setPreferredSize(new Dimension(100,30));
		final JTextField JTextField_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_NameTextF=new JTextField();
		JTextField_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_NameTextF.setPreferredSize(new Dimension(200,30));
		
		JLabel JLabel_EmptyLabel1=new JLabel("");
		JLabel_EmptyLabel1.setPreferredSize(new Dimension(30,45));
		
		JButton JButton_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_SaveButton=new JButton("Save");
		JButton_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_SaveButton.setPreferredSize(new Dimension(100,45));
		JButton_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_SaveButton.setBackground(Color.LIGHT_GRAY);
		
		JButton_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_SaveButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	if (JTextField_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_NameTextF.getText().equals("") )
				{
					JOptionPane.showMessageDialog(null,"Enter Floor Name");
				}
				else
				{  
					try
					{
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection("jdbc:mysql://192.168.1.102:3306/rachana?","root","root");
						String sql="insert into floors(Floor_Name) values(?)";
						PreparedStatement pstmt = con.prepareStatement(sql);

						pstmt.setString(1,JTextField_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_NameTextF.getText());

						pstmt.executeUpdate();   
						JOptionPane.showMessageDialog(null, "Customer Complaint Added Successfully","Added",JOptionPane.PLAIN_MESSAGE);

						JTextField_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_NameTextF.setText("");
					}

					catch(Exception ex)
					{
						System.out.println(ex);
						JOptionPane.showMessageDialog(null,"Error In Updation","Error",JOptionPane.ERROR_MESSAGE);
					}
            }
            }
        });
		
		JLabel JLabel_EmptyLabel2=new JLabel("");
		JLabel_EmptyLabel2.setPreferredSize(new Dimension(60,45));
		
		JButton JButton_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_CancelButton=new JButton("Cancel");
		JButton_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_CancelButton.setPreferredSize(new Dimension(100,45));
		JButton_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_CancelButton.setBackground(Color.LIGHT_GRAY);
		
		JButton_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_CancelButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	frame.dispose();
            }
        });
		
		Jpanel_MasterPage_ManagementMenu_TableFloor_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_NameLabel);
		Jpanel_MasterPage_ManagementMenu_TableFloor_Add_Mainpanel.add(JTextField_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_NameTextF);
		Jpanel_MasterPage_ManagementMenu_TableFloor_Add_Mainpanel.add(JLabel_EmptyLabel1);
		Jpanel_MasterPage_ManagementMenu_TableFloor_Add_Mainpanel.add(JButton_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_SaveButton);
		Jpanel_MasterPage_ManagementMenu_TableFloor_Add_Mainpanel.add(JLabel_EmptyLabel2);
		Jpanel_MasterPage_ManagementMenu_TableFloor_Add_Mainpanel.add(JButton_MasterPage_ManagementMenu_TableFloor_Add_MainPanel_CancelButton);
		
		frame.add(Jpanel_MasterPage_ManagementMenu_TableFloor_Add_Mainpanel);
		frame.setVisible(true);
		frame.setSize(350,150);
		frame.setLocation(480,300);
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}