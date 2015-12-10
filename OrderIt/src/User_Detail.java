import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class User_Detail implements ActionListener 
{
	static String role[] = { "Admin", " ", " " };
	JFrame MainFrame = new JFrame("User");
	JButton button_cancel,button_save,button_brows;
	JTextField text_user_name,text_password,text_email,text_phone,text_brows;
	JTextArea textarea_address;
	JComboBox combobox_role;
	JLabel l=new JLabel();
	 InputStream is = null;

	public User_Detail() {

		l.setPreferredSize(new Dimension(130,140));
		l.setBorder(new TitledBorder(""));
		
		JPanel panel_main = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel_main.setBackground(Color.GRAY);
		panel_main.setPreferredSize(new Dimension(560, 360));

		JPanel panel_detail = new JPanel();
		panel_detail.setBackground(Color.GRAY);
		panel_detail.setPreferredSize(new Dimension(400, 300));
		panel_detail.setLayout(new GridLayout(7, 2, 10, 10));

		JPanel panel_photo = new JPanel();
		panel_photo.setBackground(Color.GRAY);
		panel_photo.setPreferredSize(new Dimension(130, 300));

		JLabel label_user_name = new JLabel("User Name");
		JLabel label_password = new JLabel("Password");
		JLabel label_email = new JLabel("Email");
		JLabel label_phone = new JLabel("Phone");
		JLabel label_address = new JLabel("Address");
		JLabel label_role = new JLabel("Role");

		text_user_name = new JTextField();
		text_user_name.setBackground(Color.LIGHT_GRAY);

		text_password = new JTextField();
		text_password.setBackground(Color.LIGHT_GRAY);

		text_email = new JTextField();
		text_email.setBackground(Color.LIGHT_GRAY);

		text_phone = new JTextField();
		text_phone.setBackground(Color.LIGHT_GRAY);

		textarea_address = new JTextArea(4, 1);
		textarea_address.setBackground(Color.LIGHT_GRAY);

		text_brows = new JTextField(6);
		text_brows.setBackground(Color.LIGHT_GRAY);
		text_brows.setPreferredSize(new Dimension(50, 30));

		button_save = new JButton("Save");
		button_save.setPreferredSize(new Dimension(100, 50));
		button_save.addActionListener(this);

		button_cancel = new JButton("Cancel");
		button_cancel.setPreferredSize(new Dimension(100, 50));
		button_cancel.addActionListener((ActionListener) this);

		button_brows = new JButton("Brows");
		button_brows.setPreferredSize(new Dimension(50, 30));
		button_brows.addActionListener(this);

		combobox_role = new JComboBox(role);
		combobox_role.setPreferredSize(new Dimension(200, 25));

		panel_detail.add(label_user_name);
		panel_detail.add(text_user_name);
		panel_detail.add(label_password);
		panel_detail.add(text_password);
		panel_detail.add(label_email);
		panel_detail.add(text_email);
		panel_detail.add(label_phone);
		panel_detail.add(text_phone);
		panel_detail.add(label_address);
		panel_detail.add(textarea_address);
		panel_detail.add(label_role);
		panel_detail.add(combobox_role);

		panel_photo.add(l);
		panel_photo.add(text_brows);
		panel_photo.add(button_brows);

		panel_main.add(panel_detail);
		panel_main.add(panel_photo);
		panel_main.add(button_save);
		panel_main.add(button_cancel);
		MainFrame.add(panel_main);
		MainFrame.setVisible(true);
		MainFrame.setSize(700, 650);
		MainFrame.pack();
		MainFrame.setLocation(350, 100);

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==button_cancel)
			MainFrame.dispose();
		
		else if(ae.getSource()==button_brows)
		{
			JFileChooser fileChooser = new JFileChooser();				 
		    fileChooser.setFileSelectionMode(JFileChooser.CUSTOM_DIALOG);			 
		    fileChooser.setAcceptAllFileFilterUsed(true);			 
		    int rVal = fileChooser.showOpenDialog(null);
		    if (rVal == JFileChooser.APPROVE_OPTION) 
		    {
		      	String s=fileChooser.getSelectedFile().toString();
		      	text_brows.setText(s);
		       ImageIcon image_takeout_sale = new ImageIcon();
		       	l.setIcon(image_takeout_sale);	
		       	try {
					is = new FileInputStream(s);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }

		}
		if(ae.getSource()==button_save)
		{
			if (text_user_name.getText().equals("") )
			{
				JOptionPane.showMessageDialog(null,"Enter user name");
			}
			else
			{  
				try
				{
					Class.forName("com.mysql.jdbc.Driver");   
					Connection con=DriverManager.getConnection("jdbc:mysql://192.168.1.102:3306/rachana","root","root");
					String sql="insert into users(Users_Username,Users_Phone,Users_Email,Users_Address,Users_Role,Users_Image,User_Password) values(?,?,?,?,?,?,?)";
					PreparedStatement pstmt = con.prepareStatement(sql);

					pstmt.setString(1,text_user_name.getText());
					pstmt.setString(2, text_password.getText());
					pstmt.setString(3, text_email.getText());
					pstmt.setInt(4,Integer.parseInt(text_phone.getText()));
					pstmt.setString(5, textarea_address.getText());
					pstmt.setString(6, combobox_role.getSelectedItem().toString());
					pstmt.setBinaryStream(7, is,is.available());
					//pstmt.setString(8, text_brows.getText());
					
					pstmt.execute();
					JOptionPane.showMessageDialog(null, "Customer Complaint Added Successfully","Added",JOptionPane.PLAIN_MESSAGE);

					text_user_name.setText("");
					text_password.setText("");
					text_email.setText("");
					text_phone.setText("");
					text_user_name.setText("");
					text_password.setText("");
					text_brows.setText("");
				}

				catch(Exception ex)
				{
					System.out.println(ex);
					JOptionPane.showMessageDialog(null,"Error In Updation","Error",JOptionPane.ERROR_MESSAGE);
				}
			}

		}

	}
}
