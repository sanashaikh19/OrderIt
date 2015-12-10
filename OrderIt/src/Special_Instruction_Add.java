import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Special_Instruction_Add 
{
	public Special_Instruction_Add()
	{
		final JFrame frame=new JFrame("Special Instruction");
		
		JPanel Jpanel_Mainpanel=new JPanel();
		Jpanel_Mainpanel.setBackground(Color.GRAY);
		Jpanel_Mainpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JLabel JLabel_MenuName=new JLabel("Menu Name");
		JLabel_MenuName.setBackground(Color.GRAY);
		JLabel_MenuName.setPreferredSize(new Dimension(100,30));
		
		JTextField JTextField_MenuName=new JTextField();
		JTextField_MenuName.setPreferredSize(new Dimension(350,30));
		
		JLabel JLabel_InstructionValue=new JLabel("Instruction Value");
		JLabel_InstructionValue.setBackground(Color.GRAY);
		JLabel_InstructionValue.setPreferredSize(new Dimension(100,30));
		
		JTextArea JTextArea_InstructionValue=new JTextArea();
		JTextArea_InstructionValue.setPreferredSize(new Dimension(350,150));
		
		JButton JButton_save=new JButton("Save");
		JButton_save.setBackground(Color.LIGHT_GRAY);
		JButton_save.setPreferredSize(new Dimension(100,50));
		
		JLabel empty=new JLabel("");
		empty.setBackground(Color.GRAY);
		empty.setPreferredSize(new Dimension(141,50));
		
		JButton JButton_cancel=new JButton("Cancel");
		JButton_cancel.setBackground(Color.LIGHT_GRAY);
		JButton_cancel.setPreferredSize(new Dimension(100,50));
		JButton_cancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
            	frame.dispose();                
            }
        });
		Jpanel_Mainpanel.add(JLabel_MenuName);
		Jpanel_Mainpanel.add(JTextField_MenuName);
		Jpanel_Mainpanel.add(JLabel_InstructionValue);
		Jpanel_Mainpanel.add(JTextArea_InstructionValue);
		Jpanel_Mainpanel.add(JButton_save);
		Jpanel_Mainpanel.add(empty);
		Jpanel_Mainpanel.add(JButton_cancel);
		
		frame.add(Jpanel_Mainpanel);
		frame.setVisible(true);
        frame.setSize(500,300);
        frame.setResizable(false);
        frame.setLocation(500,250);
	}
}
