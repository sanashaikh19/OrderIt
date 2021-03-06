import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.management.Descriptor;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;

public class Management_Categoty_Add extends JFrame 
{
	 InputStream is = null;
	public void Management_Categoty_Add()
	{
		final JFrame frame=new JFrame("Category List");
		
		final JLabel l=new JLabel();
		l.setPreferredSize(new Dimension(200,120));
		l.setBorder(new TitledBorder(""));
		
		
		JPanel Jpanel_MasterPage_ManagementMenu_Category_Add_Mainpanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		Jpanel_MasterPage_ManagementMenu_Category_Add_Mainpanel.setBackground(Color.GRAY);
		
		JLabel JLabel_MasterPage_ManagementMenu_Category_Add_Mainpanel_NameLabel=new JLabel("Name");
		JLabel_MasterPage_ManagementMenu_Category_Add_Mainpanel_NameLabel.setPreferredSize(new Dimension(80,50));
		
		final JTextField JTextField_MasterPage_ManagementMenu_Category_Add_Mainpanel_NameTextF=new JTextField();
		JTextField_MasterPage_ManagementMenu_Category_Add_Mainpanel_NameTextF.setPreferredSize(new Dimension(200,35));
		
		JLabel JLabel_MasterPage_ManagementMenu_Category_Add_Mainpanel_ImageLabel=new JLabel("Image");
		JLabel_MasterPage_ManagementMenu_Category_Add_Mainpanel_ImageLabel.setPreferredSize(new Dimension(80,50));
		
		
		
		final JTextField JTextField_MasterPage_ManagementMenu_Category_Add_Mainpanel_ImageTextF=new JTextField();
		JTextField_MasterPage_ManagementMenu_Category_Add_Mainpanel_ImageTextF.setPreferredSize(new Dimension(105,30));

		JButton JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_BrowseButton=new JButton("Browse");
		JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_BrowseButton.setBackground(Color.LIGHT_GRAY);
		JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_BrowseButton.setPreferredSize(new Dimension(90,30));
		
		JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_BrowseButton.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				JFileChooser fileChooser = new JFileChooser();				 
			    fileChooser.setFileSelectionMode(JFileChooser.CUSTOM_DIALOG);			 
			    fileChooser.setAcceptAllFileFilterUsed(true);			 
			    int rVal = fileChooser.showOpenDialog(null);
			    if (rVal == JFileChooser.APPROVE_OPTION) 
			    {
			      	String s=fileChooser.getSelectedFile().toString();
			       	JTextField_MasterPage_ManagementMenu_Category_Add_Mainpanel_ImageTextF.setText(s);
			       	ImageIcon image_takeout_sale = new ImageIcon(s);
			       	l.setIcon(image_takeout_sale);	
			     	try {
						is = new FileInputStream(s);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    }
	         }
		});
		JButton JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_SaveButton=new JButton("Save");
		JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_SaveButton.setBackground(Color.LIGHT_GRAY);
		JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_SaveButton.setPreferredSize(new Dimension(150,50));
	
		JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_SaveButton.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				if (JTextField_MasterPage_ManagementMenu_Category_Add_Mainpanel_NameTextF.getText().equals("") )
                {
					JOptionPane.showMessageDialog(null,"Enter Address.");
                }
				else
                {               
                	try
                	{   
                		Class.forName("com.mysql.jdbc.Driver");  
                		
                		Connection con=DriverManager.getConnection("jdbc:mysql://192.168.1.102:3306/rachana?","root","root");
                		
                		String sql="insert into category(Category_Name,Category_Image) VALUES(?,?)";
                		
                		PreparedStatement pstmt = con.prepareStatement(sql);
                		
                		pstmt.setString(1, JTextField_MasterPage_ManagementMenu_Category_Add_Mainpanel_NameTextF.getText());
                		pstmt.setBinaryStream(2, is,is.available());
                		
                    	pstmt.executeUpdate();
                    	
                    	JOptionPane.showMessageDialog(null, "Added Successfully","Added",JOptionPane.PLAIN_MESSAGE); 
                    	JTextField_MasterPage_ManagementMenu_Category_Add_Mainpanel_NameTextF.setText("");
                	}

	                catch(Exception ex)
	                {
	                    System.out.println(ex);
	                    JOptionPane.showMessageDialog(null,"Error In Insertion","Error",JOptionPane.ERROR_MESSAGE);
	                }
                }
	        }
	    });
		
		JButton JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_CancelButton=new JButton("Cancel");
		JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_CancelButton.setBackground(Color.LIGHT_GRAY);
		JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_CancelButton.setPreferredSize(new Dimension(150,50));
		
		JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_CancelButton.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				frame.dispose();
	        }
	    });
		
		Jpanel_MasterPage_ManagementMenu_Category_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Category_Add_Mainpanel_NameLabel);
		Jpanel_MasterPage_ManagementMenu_Category_Add_Mainpanel.add(JTextField_MasterPage_ManagementMenu_Category_Add_Mainpanel_NameTextF);
		Jpanel_MasterPage_ManagementMenu_Category_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Category_Add_Mainpanel_ImageLabel);
		Jpanel_MasterPage_ManagementMenu_Category_Add_Mainpanel.add(l);
		
		Jpanel_MasterPage_ManagementMenu_Category_Add_Mainpanel.add(JTextField_MasterPage_ManagementMenu_Category_Add_Mainpanel_ImageTextF);
		Jpanel_MasterPage_ManagementMenu_Category_Add_Mainpanel.add(JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_BrowseButton);
		Jpanel_MasterPage_ManagementMenu_Category_Add_Mainpanel.add(JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_SaveButton);
		Jpanel_MasterPage_ManagementMenu_Category_Add_Mainpanel.add(JButton_MasterPage_ManagementMenu_Category_Add_Mainpanel_CancelButton);
		
		frame.add(Jpanel_MasterPage_ManagementMenu_Category_Add_Mainpanel);
		frame.setVisible(true);
		frame.setSize(340,320);
		frame.setResizable(false);
		frame.setLocation(450,210);
	}
}