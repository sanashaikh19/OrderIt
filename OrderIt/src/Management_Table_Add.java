import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;

public class Management_Table_Add extends JFrame 
{
	public void Management_Table_Add() 
	{

		final JFrame frame=new JFrame("Table Details");	
		JPanel Jpanel_MasterPage_ManagementMenu_Table_Add_Mainpanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		Jpanel_MasterPage_ManagementMenu_Table_Add_Mainpanel.setBackground(Color.GRAY);

		JPanel Jpanel_MasterPage_ManagementMenu_Table_Add_Categorypanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		Jpanel_MasterPage_ManagementMenu_Table_Add_Categorypanel.setBackground(Color.GRAY);
		Jpanel_MasterPage_ManagementMenu_Table_Add_Categorypanel.setPreferredSize(new Dimension(280,100));

		JLabel JLabel_MasterPage_ManagementMenu_Table_Add_MainPanel_NameLabel=new JLabel("Name");
		JLabel_MasterPage_ManagementMenu_Table_Add_MainPanel_NameLabel.setPreferredSize(new Dimension(50,30));
		final JTextField JTextField_MasterPage_ManagementMenu_Table_Add_MainPanel_NameTextF=new JTextField();
		JTextField_MasterPage_ManagementMenu_Table_Add_MainPanel_NameTextF.setPreferredSize(new Dimension(200,30));

		JLabel JLabel_MasterPage_ManagementMenu_Table_Add_MainPanel_FloorLabel=new JLabel("Floor");
		JLabel_MasterPage_ManagementMenu_Table_Add_MainPanel_FloorLabel.setPreferredSize(new Dimension(50,30));

		String Department_Combo[]=new String[]{"Inside","Outside","AC Rooms","MyFloor","3rd Floor"};
		final JComboBox JCombobox_MasterPage_ManagementMenu_Table_Add_MainPanel_FloorCombo=new JComboBox(Department_Combo);
		JCombobox_MasterPage_ManagementMenu_Table_Add_MainPanel_FloorCombo.setPreferredSize(new Dimension(200,30));
		JCombobox_MasterPage_ManagementMenu_Table_Add_MainPanel_FloorCombo.setBackground(Color.LIGHT_GRAY);

		JLabel JLabel_MasterPage_ManagementMenu_Table_Add_MainPanel_EmptyLabel=new JLabel("");
		JLabel_MasterPage_ManagementMenu_Table_Add_MainPanel_EmptyLabel.setPreferredSize(new Dimension(10,45));

		JButton JButton_MasterPage_ManagementMenu_Table_Add_MainPanel_SaveButton=new JButton("Save");
		JButton_MasterPage_ManagementMenu_Table_Add_MainPanel_SaveButton.setPreferredSize(new Dimension(100,45));
		JButton_MasterPage_ManagementMenu_Table_Add_MainPanel_SaveButton.setBackground(Color.LIGHT_GRAY);
		JButton_MasterPage_ManagementMenu_Table_Add_MainPanel_SaveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (JTextField_MasterPage_ManagementMenu_Table_Add_MainPanel_NameTextF.getText().equals("") )
				{
					JOptionPane.showMessageDialog(null,"Enter name");
				}
				else
				{  
					try
					{
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection("jdbc:mysql://192.168.1.102:3306/rachana?","root","root");
						String sql="insert into tables(Table_Name) values(?)";
						PreparedStatement pstmt = con.prepareStatement(sql);

						pstmt.setString(1,JTextField_MasterPage_ManagementMenu_Table_Add_MainPanel_NameTextF.getText());
						//pstmt.setString(2, JCombobox_MasterPage_ManagementMenu_Table_Add_MainPanel_FloorCombo.getSelectedItem().toString());

						pstmt.executeUpdate();   
						JOptionPane.showMessageDialog(null, "Customer Complaint Added Successfully","Added",JOptionPane.PLAIN_MESSAGE);

						JTextField_MasterPage_ManagementMenu_Table_Add_MainPanel_NameTextF.setText("");
					}

					catch(Exception ex)
					{
						System.out.println(ex);
						JOptionPane.showMessageDialog(null,"Error In Updation","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			});


		JLabel JLabel_MasterPage_ManagementMenu_Table_Add_MainPanel_EmptyL=new JLabel("");
		JLabel_MasterPage_ManagementMenu_Table_Add_MainPanel_EmptyL.setPreferredSize(new Dimension(30,45));

		JButton JButton_MasterPage_ManagementMenu_Table_Add_MainPanel_CancelButton=new JButton("Cancel");
		JButton_MasterPage_ManagementMenu_Table_Add_MainPanel_CancelButton.setPreferredSize(new Dimension(100,45));
		JButton_MasterPage_ManagementMenu_Table_Add_MainPanel_CancelButton.setBackground(Color.LIGHT_GRAY);

		JButton_MasterPage_ManagementMenu_Table_Add_MainPanel_CancelButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
			}
		});

		Jpanel_MasterPage_ManagementMenu_Table_Add_Categorypanel.add(JLabel_MasterPage_ManagementMenu_Table_Add_MainPanel_NameLabel);
		Jpanel_MasterPage_ManagementMenu_Table_Add_Categorypanel.add(JTextField_MasterPage_ManagementMenu_Table_Add_MainPanel_NameTextF);
		Jpanel_MasterPage_ManagementMenu_Table_Add_Categorypanel.add(JLabel_MasterPage_ManagementMenu_Table_Add_MainPanel_FloorLabel);
		Jpanel_MasterPage_ManagementMenu_Table_Add_Categorypanel.add(JCombobox_MasterPage_ManagementMenu_Table_Add_MainPanel_FloorCombo);

		Jpanel_MasterPage_ManagementMenu_Table_Add_Mainpanel.add(Jpanel_MasterPage_ManagementMenu_Table_Add_Categorypanel);
		Jpanel_MasterPage_ManagementMenu_Table_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Table_Add_MainPanel_EmptyLabel);
		Jpanel_MasterPage_ManagementMenu_Table_Add_Mainpanel.add(JButton_MasterPage_ManagementMenu_Table_Add_MainPanel_SaveButton);
		Jpanel_MasterPage_ManagementMenu_Table_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Table_Add_MainPanel_EmptyL);
		Jpanel_MasterPage_ManagementMenu_Table_Add_Mainpanel.add(JButton_MasterPage_ManagementMenu_Table_Add_MainPanel_CancelButton);


		frame.add(Jpanel_MasterPage_ManagementMenu_Table_Add_Mainpanel);
		frame.setVisible(true);
		frame.setSize(300,220);
		frame.setLocation(490,290);
		//		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
	}
