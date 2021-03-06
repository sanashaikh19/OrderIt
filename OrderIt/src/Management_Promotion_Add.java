import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class Management_Promotion_Add extends JFrame 
{
	FileInputStream is;
	public void Management_Promotion_Add() 
	{
		final JFrame frame=new JFrame("Promotion Details");	
		
		final JLabel l=new JLabel();
		l.setPreferredSize(new Dimension(230,150));
		l.setBorder(new TitledBorder(""));
		
		JPanel Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.setBackground(Color.GRAY);
		
		JLabel JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_ItemLabel=new JLabel("Item");
		JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_ItemLabel.setPreferredSize(new Dimension(120,30));
		
		String Department_Combo[]=new String[]{"Falafel"};
		final JComboBox JCombobox_MasterPage_ManagementMenu_Promotion_Add_MainPanel_ItemCombo=new JComboBox(Department_Combo);
		JCombobox_MasterPage_ManagementMenu_Promotion_Add_MainPanel_ItemCombo.setPreferredSize(new Dimension(230,30));
		JCombobox_MasterPage_ManagementMenu_Promotion_Add_MainPanel_ItemCombo.setBackground(Color.LIGHT_GRAY);
		
		JLabel JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_OldPriceLabel=new JLabel("Old Price");
		JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_OldPriceLabel.setPreferredSize(new Dimension(120,30));
		final JTextField JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_OldPriceTextF=new JTextField();
		JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_OldPriceTextF.setPreferredSize(new Dimension(230,30));
		
		JLabel JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromotePriceLabel=new JLabel("Promote Price");
		JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromotePriceLabel.setPreferredSize(new Dimension(120,30));
		final JTextField JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromotePriceTextF=new JTextField();
		JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromotePriceTextF.setPreferredSize(new Dimension(230,30));
		
		JLabel JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromoteTextLabel=new JLabel("Promote Text");
		JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromoteTextLabel.setPreferredSize(new Dimension(120,30));
		final JTextArea JTextArea_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromoteTextTextA=new JTextArea();
		JTextArea_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromoteTextTextA.setPreferredSize(new Dimension(230,70));
		
		JLabel JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromoteColorLabel=new JLabel("Promote Color");
		JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromoteColorLabel.setPreferredSize(new Dimension(120,30));
		
		JColorChooser JColorChooser_MasterPage_ManagementMenu_Promotion_Add_MainPanel_Color=new JColorChooser();
		JColorChooser_MasterPage_ManagementMenu_Promotion_Add_MainPanel_Color.setPreferredSize(new Dimension(230,30));

		JLabel JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_CouponCodeLabel=new JLabel("Coupon Code");
		JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_CouponCodeLabel.setPreferredSize(new Dimension(120,30));
		final JTextField JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_CouponCodeTextF=new JTextField();
		JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_CouponCodeTextF.setPreferredSize(new Dimension(230,30));
		
		JLabel JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PictureLabel=new JLabel("Picture");
		JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PictureLabel.setPreferredSize(new Dimension(120,30));
		
		JLabel JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_EmptyLabel=new JLabel("");
		JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_EmptyLabel.setPreferredSize(new Dimension(120,30));
		final JTextField JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PictureTextF=new JTextField();
		JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PictureTextF.setPreferredSize(new Dimension(130,30));
		
		JButton JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_BrowseButton=new JButton("Browse");
		JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_BrowseButton.setPreferredSize(new Dimension(100,30));
		JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_BrowseButton.setBackground(Color.LIGHT_GRAY);
		
		JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_BrowseButton.addActionListener(new ActionListener() 
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
			      	JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PictureTextF.setText(s);
			       	ImageIcon image_takeout_sale = new ImageIcon(s);
			       	l.setIcon(image_takeout_sale);	  
			       	try {
						is=new FileInputStream(s);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    }
	         }
		});
		
		JButton JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_SaveButton=new JButton("Save");
		JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_SaveButton.setPreferredSize(new Dimension(120,55));
		JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_SaveButton.setBackground(Color.LIGHT_GRAY);
		
		JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_SaveButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {

				if (JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_OldPriceTextF.getText().equals("") )
                {
					JOptionPane.showMessageDialog(null,"Enter Old Price.");
                }
				else
                {               
                	try
                	{   
                		Class.forName("com.mysql.jdbc.Driver");  
                		
                		Connection con=DriverManager.getConnection("jdbc:mysql://192.168.1.102:3306/rachana?","root","root");
                		
                		String sql="insert into promotion() VALUES(?,?,?,?,?,?)";
                		
                		PreparedStatement pstmt = con.prepareStatement(sql);
                		
                		pstmt.setString(1, JCombobox_MasterPage_ManagementMenu_Promotion_Add_MainPanel_ItemCombo.getSelectedItem().toString());
                		pstmt.setString(2, JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_OldPriceTextF.getText());
                		pstmt.setString(3, JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromotePriceTextF.getText());
                		pstmt.setString(4, JTextArea_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromoteTextTextA.getText());
                		pstmt.setString(5, JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_CouponCodeTextF.getText());
                		pstmt.setBinaryStream(6, is,is.available());
                		
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
		
		JLabel JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_EmptyL=new JLabel("");
		JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_EmptyL.setPreferredSize(new Dimension(110,55));
		
		JButton JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_CancelButton=new JButton("Cancel");
		JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_CancelButton.setPreferredSize(new Dimension(120,55));
		JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_CancelButton.setBackground(Color.LIGHT_GRAY);
		
		JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_CancelButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	frame.dispose();
            }
        });
		
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_ItemLabel);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JCombobox_MasterPage_ManagementMenu_Promotion_Add_MainPanel_ItemCombo);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_OldPriceLabel);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_OldPriceTextF);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromotePriceLabel);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromotePriceTextF);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromoteTextLabel);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JTextArea_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromoteTextTextA);
		//Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PromoteColorLabel);
		//Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JColorChooser_MasterPage_ManagementMenu_Promotion_Add_MainPanel_Color);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_CouponCodeLabel);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_CouponCodeTextF);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PictureLabel);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(l);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_EmptyLabel);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JTextField_MasterPage_ManagementMenu_Promotion_Add_MainPanel_PictureTextF);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_BrowseButton);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_SaveButton);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JLabel_MasterPage_ManagementMenu_Promotion_Add_MainPanel_EmptyL);
		Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel.add(JButton_MasterPage_ManagementMenu_Promotion_Add_MainPanel_CancelButton);
		
		
		frame.add(Jpanel_MasterPage_ManagementMenu_Promotion_Add_Mainpanel);
		frame.setVisible(true);
		frame.setSize(380,550);
		frame.setLocation(450,80);
		frame.setResizable(false);
	}
}
