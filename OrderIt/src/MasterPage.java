import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Properties;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class MasterPage extends JFrame implements ActionListener
{
	static JPanel Jpanel_MasterPage_TabPanel=new JPanel();
	static String column[]=new String[]{" Order NO "," Name "," Number Of People "," DateTime "," Phone "," Total "," Status "};
	static String column1[]=new String[]{" Order NO "," Name "," Phone "," Address "," Date "," Postal Code "," Total ","Status"};
	static JTabbedPane tab=new JTabbedPane();
	static JPanel reservation=new JPanel();
	static JPanel take_out=new JPanel();
	static JPanel delivery=new JPanel();
	static JPanel dining=new JPanel();
	static JPanel receipt_on_hold=new JPanel();
	static JPanel Panel_kitchen_view=new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	public MasterPage()
	{
		 reservation();	
		 take_out();
		 delivery();
		 dining();
		 receipt_on_hold();
		 KitchenView();
	}
	public void KitchenView()
	{       
		String column[]=new String[]{" Order NO "," Name  "," Quantity "," Table "," Order Type "," Status "," Taken By User "};
		final JButton button_showbytable;
		Panel_kitchen_view.setBackground(Color.gray);
		DefaultTableModel model;
	   
		model=new DefaultTableModel(column,0);
		JTable table = new JTable(model );
		
		JScrollPane pane=new JScrollPane(table);
		pane.setPreferredSize(new Dimension(1240,340));

		Panel_kitchen_view.setPreferredSize(new Dimension(1330,550));
		
		JPanel panel_show=new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_show.setBackground(Color.GRAY);
		panel_show.setPreferredSize(new Dimension(1340,80));
		
		JPanel panel_change_status=new JPanel();
		panel_change_status.setBackground(Color.GRAY);
		panel_change_status.setBorder(new TitledBorder("Change Status"));
			
		JPanel panel_item_remark=new JPanel();
		panel_item_remark.setBackground(Color.GRAY);
		panel_item_remark.setBorder(new TitledBorder("Item Remarks"));
		
		JPanel panel_order_remark=new JPanel();
		panel_order_remark.setBackground(Color.GRAY);
		panel_order_remark.setBorder(new TitledBorder("Order Remark"));
		
		JPanel panel_kitchen_view_mode=new JPanel();
		panel_kitchen_view_mode.setBackground(Color.GRAY);
		
		JPanel panel_table=new JPanel();
		panel_table.setBackground(Color.GRAY);
		
		JPanel panel_up_down=new JPanel();
		panel_up_down.setBorder(new TitledBorder(""));
		panel_up_down.setBackground(Color.GRAY);
		panel_up_down.setPreferredSize(new Dimension(75,340));

		JButton button_showall=new JButton("Show All");
		button_showall.setPreferredSize(new Dimension(100,70));
		button_showall.setBackground(Color.LIGHT_GRAY);
		
		JButton button_showrecieved=new JButton("Show Recieved (F2)");
		button_showrecieved.setPreferredSize(new Dimension(130,70));
		button_showrecieved.setBackground(Color.LIGHT_GRAY);
		
		JButton button_showpreparing=new JButton("Show Prepairing (F3)");
		button_showpreparing.setPreferredSize(new Dimension(130,70));
		button_showpreparing.setBackground(Color.LIGHT_GRAY);
		
		JButton button_showprepared=new JButton("Show Prepared (F4)");
		button_showprepared.setPreferredSize(new Dimension(130,70));
		button_showprepared.setBackground(Color.LIGHT_GRAY);
		
		JButton button_showserved=new JButton("Show Served (F5)");
		button_showserved.setPreferredSize(new Dimension(120,70));
		button_showserved.setBackground(Color.LIGHT_GRAY);
		
		button_showbytable=new JButton("Show By Table (F6)");
		button_showbytable.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent ae)
				{
					if(ae.getSource()==button_showbytable)
					{
						Select_Table st=new Select_Table();
						st.Select_Table();
					}
				}
		});
		button_showbytable.setPreferredSize(new Dimension(140,70));
		button_showbytable.setBackground(Color.LIGHT_GRAY);
		
		JButton button_showbytakeaway=new JButton("Show By Takeaway (F7)");
		button_showbytakeaway.setBackground(Color.LIGHT_GRAY);
		
		button_showbytakeaway.setPreferredSize(new Dimension(140,70));
		button_showbytakeaway.setBackground(Color.LIGHT_GRAY);
		
		JButton button_showbydining=new JButton("Show By Dining (F8)");
		button_showbydining.setPreferredSize(new Dimension(140,70));
		button_showbydining.setBackground(Color.LIGHT_GRAY);
		JButton button_showbydelivery=new JButton("Show By Delivery (F9)");
		button_showbydelivery.setPreferredSize(new Dimension(140,70));
		button_showbydelivery.setBackground(Color.LIGHT_GRAY);
		JButton button_close=new JButton("Close(ESC)");
		button_close.setPreferredSize(new Dimension(100,70));
		button_close.setBackground(Color.LIGHT_GRAY);
		
		button_close.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	Panel_kitchen_view.setVisible(false);    
				Jpanel_MasterPage_TabPanel.setVisible(true);					

            }
        });	
		panel_show.add(button_showall);
		panel_show.add(button_showrecieved);
		panel_show.add(button_showpreparing);
		panel_show.add( button_showprepared);
		panel_show.add(button_showserved);
		panel_show.add(button_showbytable);
		panel_show.add(button_showbytakeaway);
		panel_show.add(button_showbydining);
		panel_show.add(button_showbydelivery);
		panel_show.add(button_close);
		
		//Change Status
		JButton button_preparing=new JButton("Button_preparing (F9)");
		button_preparing.setPreferredSize(new Dimension(140,70));
		button_preparing.setBackground(Color.LIGHT_GRAY);
		
		JButton button_prepared=new JButton("Button_prepared (F10)");
		button_prepared.setPreferredSize(new Dimension(140,70));
		button_prepared.setBackground(Color.LIGHT_GRAY);
		
		JButton button_served=new JButton("Button_served (F11)");
		button_served.setPreferredSize(new Dimension(140,70));
		button_served.setBackground(Color.LIGHT_GRAY);
		
		panel_change_status.add(button_preparing);
		panel_change_status.add(button_prepared);
		panel_change_status.add(button_served);

		//text_itemremark
		JTextField text_itemremark=new JTextField();
		text_itemremark.setPreferredSize(new Dimension(160,70));
		panel_item_remark.add(text_itemremark);
		
		//Text_orderremark
		JTextField text_orderremark=new JTextField();
		text_orderremark.setPreferredSize(new Dimension(160,70));
		panel_order_remark.add(text_orderremark);
		
		//Kitchen Mode
		JLabel label_kitchenmode=new JLabel("Kitchen View Mode");
		panel_kitchen_view_mode.add(label_kitchenmode);
		
		JButton button_up=new JButton("UP");
		button_up.setPreferredSize(new Dimension(70,70));
		button_up.setBackground(Color.LIGHT_GRAY);
		
		JButton button_down=new JButton("DOWN");
		button_down.setPreferredSize(new Dimension(70,70));
		button_down.setBackground(Color.LIGHT_GRAY);
		
		panel_table.add(pane);
		panel_up_down.add(button_up);
		panel_up_down.add(button_down);
		panel_table.add(panel_up_down);
		panel_table.add(panel_up_down,BorderLayout.EAST);
		
		Panel_kitchen_view.add(panel_show);
		Panel_kitchen_view.add(panel_change_status);
		Panel_kitchen_view.add(panel_item_remark);
		Panel_kitchen_view.add(panel_order_remark);
		Panel_kitchen_view.add(panel_kitchen_view_mode);
		Panel_kitchen_view.add(panel_table);
		Panel_kitchen_view.setVisible(false);
	}
	
	public static void main(String[] args) 
	{
		MasterPage mg=new MasterPage();
		
		final JFrame frame=new JFrame("OrderIt");
    	
        JMenuBar Jmenubar_EasyMenu_MasterPage_menuBar = new JMenuBar();
        Jmenubar_EasyMenu_MasterPage_menuBar.setBackground(Color.GRAY);
        
        JMenu Jmenubar_EasyMenu_MasterPage_menuBar_fileMenu = new JMenu("File");
        Jmenubar_EasyMenu_MasterPage_menuBar_fileMenu.setForeground(Color.white);
        Jmenubar_EasyMenu_MasterPage_menuBar_fileMenu.setMnemonic(KeyEvent.VK_F);
        
        JMenu Jmenubar_EasyMenu_MasterPage_menuBar_viewMenu = new JMenu("View");
        Jmenubar_EasyMenu_MasterPage_menuBar_viewMenu.setForeground(Color.white);
        Jmenubar_EasyMenu_MasterPage_menuBar_viewMenu.setMnemonic(KeyEvent.VK_V);
        
        Jmenubar_EasyMenu_MasterPage_menuBar_viewMenu.addMenuListener(new MenuListener()
        {   
			public void menuCanceled(MenuEvent arg0){}			
			public void menuDeselected(MenuEvent arg0){}			
			public void menuSelected(MenuEvent arg0) 
			{	
				ViewMenu view_menu=new ViewMenu();
				view_menu.ViewMenu();
			}
        });
        
        JMenu Jmenubar_EasyMenu_MasterPage_menuBar_settingMenu = new JMenu("Setting");
        Jmenubar_EasyMenu_MasterPage_menuBar_settingMenu.setForeground(Color.white);
        Jmenubar_EasyMenu_MasterPage_menuBar_settingMenu.setMnemonic(KeyEvent.VK_S);
        
        Jmenubar_EasyMenu_MasterPage_menuBar_settingMenu.addMenuListener(new MenuListener()
        {           
        	public void menuCanceled(MenuEvent arg0){}			
			public void menuDeselected(MenuEvent arg0){}			
			public void menuSelected(MenuEvent arg0) 
			{	
				Setting setting_menu=new Setting();
				setting_menu.Setting();
			}
        });
        
        JMenu Jmenubar_EasyMenu_MasterPage_menuBar_managmentMenu = new JMenu("Managment");
        Jmenubar_EasyMenu_MasterPage_menuBar_managmentMenu.setForeground(Color.white);
        Jmenubar_EasyMenu_MasterPage_menuBar_managmentMenu.setMnemonic(KeyEvent.VK_M);
        
        Jmenubar_EasyMenu_MasterPage_menuBar_managmentMenu.addMenuListener(new MenuListener()
        {           
        	public void menuCanceled(MenuEvent arg0){}			
			public void menuDeselected(MenuEvent arg0){}
			public void menuSelected(MenuEvent arg0) 
			{	
				ManagementMenu management_menu=new ManagementMenu();
				management_menu.ManagementMenu();
			}
        });
        
        JMenu Jmenubar_EasyMenu_MasterPage_menuBar_reportMenu = new JMenu("Report");
        Jmenubar_EasyMenu_MasterPage_menuBar_reportMenu.setForeground(Color.white);
        Jmenubar_EasyMenu_MasterPage_menuBar_reportMenu.setMnemonic(KeyEvent.VK_R);
        
        Jmenubar_EasyMenu_MasterPage_menuBar_reportMenu.addMenuListener(new MenuListener()
        {           
        	public void menuCanceled(MenuEvent arg0){}			
			public void menuDeselected(MenuEvent arg0){}
			public void menuSelected(MenuEvent arg0) 
			{	
				Report report_menu=new Report();
				report_menu.Report();
			}
        });
        
        JMenu Jmenubar_EasyMenu_MasterPage_menuBar_helpMenu = new JMenu("Help");
        Jmenubar_EasyMenu_MasterPage_menuBar_helpMenu.setForeground(Color.white);
        Jmenubar_EasyMenu_MasterPage_menuBar_helpMenu.setMnemonic(KeyEvent.VK_H);
        
        Jmenubar_EasyMenu_MasterPage_menuBar_helpMenu.addMenuListener(new MenuListener()
        {           
        	public void menuCanceled(MenuEvent arg0){}			
			public void menuDeselected(MenuEvent arg0){}
			public void menuSelected(MenuEvent arg0) 
			{	
				Help help_menu=new Help();
				help_menu.Help();
			}
        });
        
        Jmenubar_EasyMenu_MasterPage_menuBar.add(Jmenubar_EasyMenu_MasterPage_menuBar_fileMenu);
        Jmenubar_EasyMenu_MasterPage_menuBar.add(Jmenubar_EasyMenu_MasterPage_menuBar_viewMenu);
        Jmenubar_EasyMenu_MasterPage_menuBar.add(Jmenubar_EasyMenu_MasterPage_menuBar_settingMenu);
        Jmenubar_EasyMenu_MasterPage_menuBar.add(Jmenubar_EasyMenu_MasterPage_menuBar_managmentMenu);
        Jmenubar_EasyMenu_MasterPage_menuBar.add(Jmenubar_EasyMenu_MasterPage_menuBar_reportMenu);
        Jmenubar_EasyMenu_MasterPage_menuBar.add(Jmenubar_EasyMenu_MasterPage_menuBar_helpMenu);
        
        JMenuItem Jmenubar_EasyMenu_MasterPage_menuBar_fileMenu_exit = new JMenuItem("Exit");
        
        Jmenubar_EasyMenu_MasterPage_menuBar_fileMenu_exit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
            	frame.dispose();                
            }
        });
        
        Jmenubar_EasyMenu_MasterPage_menuBar_fileMenu.add(Jmenubar_EasyMenu_MasterPage_menuBar_fileMenu_exit);
        
        frame.setJMenuBar(Jmenubar_EasyMenu_MasterPage_menuBar);
        
        JPanel Jpanel_MasterPage_Mainpanel=new JPanel();
        Jpanel_MasterPage_Mainpanel.setBackground(Color.GRAY);
       
        
        Jpanel_MasterPage_TabPanel.setBackground(Color.gray);
        Jpanel_MasterPage_TabPanel.setPreferredSize(new Dimension(1340,560));
        Jpanel_MasterPage_TabPanel.setVisible(false);
        
        tab.setPreferredSize(new Dimension(1340,550));
        
        dining.setBackground(Color.gray);
        
        tab.add("Reservation",reservation);
        tab.add("TakeOut",take_out);
        tab.add("Delivery",delivery);
        tab.add("Dining",dining);
        tab.add("Receipt On Hold",receipt_on_hold);
        
        Jpanel_MasterPage_TabPanel.add(tab);
        
        JPanel Jpanel_MasterPage_Logopanel=new JPanel();
        Jpanel_MasterPage_Logopanel.setBackground(Color.GRAY);
        Jpanel_MasterPage_Logopanel.setBorder(new TitledBorder("  "));
        Jpanel_MasterPage_Logopanel.setPreferredSize(new Dimension(350,100));
           
        JPanel Jpanel_MasterPage_Viewpanel=new JPanel();
        Jpanel_MasterPage_Viewpanel.setBackground(Color.GRAY);
        Jpanel_MasterPage_Viewpanel.setBorder(new TitledBorder("View"));
        Jpanel_MasterPage_Viewpanel.setPreferredSize(new Dimension(300,100));
        
        final JButton Jbutton_MasterPage_Viewpanel_posButton=new JButton("POS");
        Jbutton_MasterPage_Viewpanel_posButton.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_Viewpanel_posButton.setPreferredSize(new Dimension(120,65));
        
        Jbutton_MasterPage_Viewpanel_posButton.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				if(e.getSource()==Jbutton_MasterPage_Viewpanel_posButton)
				{
					Jpanel_MasterPage_TabPanel.setVisible(true);					
				}					
	        }
	    }); 
        
        final JButton Jbutton_MasterPage_Viewpanel_kitchenviewButton=new JButton("Kitchen View");
        Jbutton_MasterPage_Viewpanel_kitchenviewButton.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_Viewpanel_kitchenviewButton.setPreferredSize(new Dimension(150,65));
        
        Jbutton_MasterPage_Viewpanel_kitchenviewButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {

				if(e.getSource()==Jbutton_MasterPage_Viewpanel_kitchenviewButton)
				{
					Jpanel_MasterPage_TabPanel.setVisible(false);	
					Panel_kitchen_view.setVisible(true);					

				}
            	
            }
        });
        
        Jpanel_MasterPage_Viewpanel.add(Jbutton_MasterPage_Viewpanel_posButton);
        Jpanel_MasterPage_Viewpanel.add(Jbutton_MasterPage_Viewpanel_kitchenviewButton);
        
        JPanel Jpanel_MasterPage_Reportpanel=new JPanel();
        Jpanel_MasterPage_Reportpanel.setBackground(Color.GRAY);
        Jpanel_MasterPage_Reportpanel.setBorder(new TitledBorder("Report"));
        Jpanel_MasterPage_Reportpanel.setPreferredSize(new Dimension(300,100));
        
        JButton Jbutton_MasterPage_Reportpanel_todaysalesButton=new JButton("Today Sales");
        Jbutton_MasterPage_Reportpanel_todaysalesButton.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_Reportpanel_todaysalesButton.setPreferredSize(new Dimension(65,65));

        Jbutton_MasterPage_Reportpanel_todaysalesButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	Todays_Sales t=new Todays_Sales();
            	t.Todays_Sales();
        
            }
        });
        
        JButton Jbutton_MasterPage_Reportpanel_salesreportButton=new JButton("Sales Report");
        Jbutton_MasterPage_Reportpanel_salesreportButton.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_Reportpanel_salesreportButton.setPreferredSize(new Dimension(65,65));
        
        Jbutton_MasterPage_Reportpanel_salesreportButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	Sales_Report s=new Sales_Report();
            	s.Sales_Report();
            }
        });
        
        JButton Jbutton_MasterPage_Reportpanel_productReportButton=new JButton("Product Report");
        Jbutton_MasterPage_Reportpanel_productReportButton.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_Reportpanel_productReportButton.setPreferredSize(new Dimension(65,65));
        
        Jbutton_MasterPage_Reportpanel_productReportButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	Product_Report p=new Product_Report();   
            	p.Product_Report();
            }
        });
        
        JButton Jbutton_MasterPage_Reportpanel_orderlogreportButton=new JButton("Order Log Report");
        Jbutton_MasterPage_Reportpanel_orderlogreportButton.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_Reportpanel_orderlogreportButton.setPreferredSize(new Dimension(65,65));
        
        Jbutton_MasterPage_Reportpanel_orderlogreportButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	Order_Report o=new Order_Report();
            	o.Order_Report();
            }
        });
        
        Jpanel_MasterPage_Reportpanel.add(Jbutton_MasterPage_Reportpanel_todaysalesButton);
        Jpanel_MasterPage_Reportpanel.add(Jbutton_MasterPage_Reportpanel_salesreportButton);
        Jpanel_MasterPage_Reportpanel.add(Jbutton_MasterPage_Reportpanel_productReportButton);
        Jpanel_MasterPage_Reportpanel.add(Jbutton_MasterPage_Reportpanel_orderlogreportButton);
        
        JPanel Jpanel_MasterPage_Settingpanel=new JPanel();
        Jpanel_MasterPage_Settingpanel.setBackground(Color.GRAY);
        Jpanel_MasterPage_Settingpanel.setBorder(new TitledBorder("Setting"));
        Jpanel_MasterPage_Settingpanel.setPreferredSize(new Dimension(100,100));
        
        JButton Jbutton_MasterPage_Settingpanel_syncButton=new JButton("Sync");
        Jbutton_MasterPage_Settingpanel_syncButton.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_Settingpanel_syncButton.setPreferredSize(new Dimension(65,65));
        
        Jbutton_MasterPage_Settingpanel_syncButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
        
            }
        });
        
        Jpanel_MasterPage_Settingpanel.add(Jbutton_MasterPage_Settingpanel_syncButton);
        
        JPanel Jpanel_MasterPage_Systempanel=new JPanel();
        Jpanel_MasterPage_Systempanel.setBackground(Color.GRAY);
        Jpanel_MasterPage_Systempanel.setBorder(new TitledBorder("System"));
        Jpanel_MasterPage_Systempanel.setPreferredSize(new Dimension(250,100));
        
        JButton Jbutton_MasterPage_Systempanel_enddayButton=new JButton("End Day");
        Jbutton_MasterPage_Systempanel_enddayButton.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_Systempanel_enddayButton.setPreferredSize(new Dimension(65,65));
    
        Jbutton_MasterPage_Systempanel_enddayButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	EndDay endday=new EndDay();
            	endday.EndDay();
            }
        });
    
        
        
        JButton Jbutton_MasterPage_Systempanel_logoutButton=new JButton("Log Out");
        Jbutton_MasterPage_Systempanel_logoutButton.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_Systempanel_logoutButton.setPreferredSize(new Dimension(65,65));

        Jbutton_MasterPage_Systempanel_logoutButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
        
            }
        });
        
        JButton Jbutton_MasterPage_Systempanel_exitButton=new JButton("Exit");
        Jbutton_MasterPage_Systempanel_exitButton.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_Systempanel_exitButton.setPreferredSize(new Dimension(65,65));

        Jbutton_MasterPage_Systempanel_exitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	 System.exit(0);        
            }
        });
        
        Jpanel_MasterPage_Systempanel.add(Jbutton_MasterPage_Systempanel_enddayButton);
        Jpanel_MasterPage_Systempanel.add(Jbutton_MasterPage_Systempanel_logoutButton);
        Jpanel_MasterPage_Systempanel.add(Jbutton_MasterPage_Systempanel_exitButton);
        
        Jpanel_MasterPage_Mainpanel.add(Jpanel_MasterPage_Logopanel);
        Jpanel_MasterPage_Mainpanel.add(Jpanel_MasterPage_Viewpanel);
        Jpanel_MasterPage_Mainpanel.add(Jpanel_MasterPage_Reportpanel);
        Jpanel_MasterPage_Mainpanel.add(Jpanel_MasterPage_Settingpanel);
        Jpanel_MasterPage_Mainpanel.add(Jpanel_MasterPage_Systempanel);
        Jpanel_MasterPage_Mainpanel.add(Jpanel_MasterPage_TabPanel);
        Jpanel_MasterPage_Mainpanel.add(Panel_kitchen_view);
        
        frame.add(Jpanel_MasterPage_Mainpanel);
        frame.setVisible(true);
        frame.setSize(1370,730);      
	}	
	void reservation()
	{
		JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Reservation_Mainpanel=new JPanel();
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Reservation_Mainpanel.setBackground(Color.GRAY);
        
        JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel=new JPanel();
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel.setBackground(Color.GRAY);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel.setPreferredSize(new Dimension(1330,100));
        
        JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel=new JPanel();
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel.setLayout(new GridLayout(2,4,5,30));
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel.setBackground(Color.GRAY);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel.setPreferredSize(new Dimension(400,90));
        
        final JRadioButton JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_date=new JRadioButton("Date");
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_date.setBackground(Color.GRAY);
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_date.setPreferredSize(new Dimension(50,10));
        
        Properties p = new Properties();
        UtilDateModel model= new UtilDateModel();
        model.setSelected(true);
        JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
        final JDatePickerImpl JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_datePicker = new JDatePickerImpl(datePanel,null);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_datePicker.setBounds(530,45,110,30);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_datePicker.setBackground(Color.GRAY);
        
        JLabel JLabel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_TO=new JLabel("               TO");
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_TO.setBackground(Color.GRAY);
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_TO.setPreferredSize(new Dimension(30,10));
        
        UtilDateModel model1=new UtilDateModel();
        model1.setSelected(true);
        JDatePickerImpl JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_datePicker1 = new JDatePickerImpl(datePanel,null);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_datePicker1.setBounds(530,45,110,30);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_datePicker1.setBackground(Color.GRAY);

        final JRadioButton JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_keyword=new JRadioButton("Keyword");
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_keyword.setBackground(Color.GRAY);
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_keyword.setPreferredSize(new Dimension(120,30));
        
        final JTextField JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_KeywordText=new JTextField();
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_KeywordText.setBackground(Color.white);
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_KeywordText.setPreferredSize(new Dimension(70,10));
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_KeywordText.setEnabled(false);
        
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_keyword.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				if(JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_keyword.isSelected())
				{
					JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_KeywordText.setEnabled(true);					
				}
				else
				{
					JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_KeywordText.setEnabled(false);
				}
				
	        }
	    });
        
        JLabel empty=new JLabel("");
        empty.setBackground(Color.GRAY);
        empty.setPreferredSize(new Dimension(30,30));
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_changeType=new JButton("Change Type");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_changeType.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_changeType.setPreferredSize(new Dimension(120,40));
        
        JLabel empty1=new JLabel("");
        empty1.setBackground(Color.GRAY);
        empty1.setPreferredSize(new Dimension(30,100));
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_search=new JButton("Search");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_search.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_search.setPreferredSize(new Dimension(140,90));
        
        JLabel empty2=new JLabel("");
        empty2.setBackground(Color.GRAY);
        empty2.setPreferredSize(new Dimension(30,100));
        
        JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel1=new JPanel();
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel1.setLayout(new GridLayout(2,2,10,30));
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel1.setBackground(Color.GRAY);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel1.setPreferredSize(new Dimension(300,90));
        
        JLabel JLabel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_TotalReservation=new JLabel("Total Reservation");
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_TotalReservation.setBackground(Color.GRAY);
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_TotalReservation.setPreferredSize(new Dimension(110,30));
        
        JTextField JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_ReservationText=new JTextField();
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_ReservationText.setBackground(Color.white);
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_ReservationText.setPreferredSize(new Dimension(120,30));
        
        JLabel JLabel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_TotalSales=new JLabel("Total Sales");
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_TotalSales.setBackground(Color.GRAY);
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_TotalSales.setPreferredSize(new Dimension(80,30));
        
        JTextField JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_SalesText=new JTextField();
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_SalesText.setBackground(Color.white);
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_SalesText.setPreferredSize(new Dimension(120,30));
        
        JLabel empty3=new JLabel("");
        empty3.setBackground(Color.GRAY);
        empty3.setPreferredSize(new Dimension(200,100));
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_add=new JButton("Add");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_add.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_add.setPreferredSize(new Dimension(60,80));
        
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_add.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				POS_Reservation_Addd reser_add=new POS_Reservation_Addd();
				reser_add.POS_Reservation_Addd();
	        }
	    });
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_edit=new JButton("Edit");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_edit.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_edit.setPreferredSize(new Dimension(60,80));
        
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_edit.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				POS_Reservation_Addd reser_add=new POS_Reservation_Addd();
				reser_add.POS_Reservation_Addd();
	        }
	    });
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_delete=new JButton("Delete");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_delete.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_delete.setPreferredSize(new Dimension(60,80));
        
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel.add(JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_date);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel.add(JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_datePicker);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel.add(JLabel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_TO);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel.add(JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_datePicker1);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel.add(JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_keyword);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel.add(JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_KeywordText);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel.add(empty);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_changeType);
        
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel1.add(JLabel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_TotalReservation);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel1.add(JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_ReservationText);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel1.add(JLabel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_TotalSales);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel1.add(JTextField_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_SalesText);
        
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel.add(empty1);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_search);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel.add(empty2);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_GridPanel1);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel.add(empty3);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_add);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_edit);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel_delete);

        DefaultTableModel table_model=new DefaultTableModel(column,0);
		JTable Jtable_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_tablePanel_table = new JTable(table_model );
		JScrollPane jsp=new JScrollPane(Jtable_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_tablePanel_table);
		jsp.setPreferredSize(new Dimension(1330,445));
		
		
		
		
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Reservation_Mainpanel.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_ReservationButton_typePanel);
        
        reservation.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Reservation_Mainpanel);
        reservation.add(jsp);
	}
	
	void take_out()
	{
		JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOut_Mainpanel=new JPanel();
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOut_Mainpanel.setBackground(Color.GRAY);
        
        JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel=new JPanel();
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel.setBackground(Color.GRAY);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel.setPreferredSize(new Dimension(1330,100));
        
        JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel=new JPanel();
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel.setLayout(new GridLayout(2,4,5,30));
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel.setBackground(Color.GRAY);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel.setPreferredSize(new Dimension(400,90));
        
        JRadioButton JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_date=new JRadioButton("Date");
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_date.setBackground(Color.GRAY);
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_date.setPreferredSize(new Dimension(50,10));
        
        UtilDateModel model;
        JDatePanelImpl datePanel;
        model = new UtilDateModel();
        model.setSelected(true);
        Properties p = new Properties();
        datePanel = new JDatePanelImpl(model,p);
        JDatePickerImpl JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_datePicker = new JDatePickerImpl(datePanel,null);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_datePicker.setBounds(530,45,110,30);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_datePicker.setBackground(Color.GRAY);
        
        JLabel JLabel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_To=new JLabel("          TO");
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_To.setBackground(Color.GRAY);
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_To.setPreferredSize(new Dimension(30,10));
        
        UtilDateModel model1;
        model1 = new UtilDateModel();
        model1.setSelected(true);
        //JDatePanelImpl datePanel1 = new JDatePanelImpl(model,p);
        JDatePickerImpl JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_datePicker1 = new JDatePickerImpl(datePanel,null);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_datePicker1.setBounds(530,45,110,30);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_datePicker1.setBackground(Color.GRAY);
        
        final JRadioButton JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_keyword=new JRadioButton("Keyword");
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_keyword.setBackground(Color.GRAY);
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_keyword.setPreferredSize(new Dimension(120,30));
        
        final JTextField JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_KeywordText=new JTextField();
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_KeywordText.setBackground(Color.white);
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_KeywordText.setPreferredSize(new Dimension(70,10));
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_KeywordText.setEnabled(false);
        
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_keyword.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				if(JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_keyword.isSelected())
				{
					JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_KeywordText.setEnabled(true);					
				}
				else
				{
					JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_KeywordText.setEnabled(false);
				}
				
	        }
	    });
        
        JLabel empty=new JLabel("");
        empty.setBackground(Color.GRAY);
        empty.setPreferredSize(new Dimension(30,30));
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_changeType=new JButton("Change Type");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_changeType.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_changeType.setPreferredSize(new Dimension(120,40));
       
        JLabel empty1=new JLabel("");
        empty1.setBackground(Color.GRAY);
        empty1.setPreferredSize(new Dimension(30,100));
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_search=new JButton("Search");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_search.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_search.setPreferredSize(new Dimension(140,90));
        
        JLabel empty2=new JLabel("");
        empty2.setBackground(Color.GRAY);
        empty2.setPreferredSize(new Dimension(30,100));
       
        JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel1=new JPanel();
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel1.setLayout(new GridLayout(2,2,10,30));
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel1.setBackground(Color.GRAY);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel1.setPreferredSize(new Dimension(300,90));
        
        JLabel JLabel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_TotalTakeAway=new JLabel("Total Takeaway");
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_TotalTakeAway.setBackground(Color.GRAY);
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_TotalTakeAway.setPreferredSize(new Dimension(110,30));
        
        JTextField JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_TakeAwayText=new JTextField();
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_TakeAwayText.setBackground(Color.white);
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_TakeAwayText.setPreferredSize(new Dimension(120,30));
        
        JLabel JLabel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_TotalSales=new JLabel("Total Sales");
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_TotalSales.setBackground(Color.GRAY);
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_TotalSales.setPreferredSize(new Dimension(80,30));
        
        JTextField JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_SalesText=new JTextField();
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_SalesText.setBackground(Color.white);
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_SalesText.setPreferredSize(new Dimension(120,30));
        
        JLabel empty3=new JLabel("");
        empty3.setBackground(Color.GRAY);
        empty3.setPreferredSize(new Dimension(200,100));
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_add=new JButton("Add");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_add.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_add.setPreferredSize(new Dimension(60,80));
        
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_add.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				POS_Reservation_Addd reser_add=new POS_Reservation_Addd();
				reser_add.POS_Reservation_Addd();
	        }
	    });
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_edit=new JButton("Edit");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_edit.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_edit.setPreferredSize(new Dimension(60,80));
        
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_edit.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				POS_Reservation_Addd reser_add=new POS_Reservation_Addd();
				reser_add.POS_Reservation_Addd();
	        }
	    });
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_delete=new JButton("Delete");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_delete.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_delete.setPreferredSize(new Dimension(60,80));
        
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel.add(JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_date);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel.add(JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_datePicker);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel.add(JLabel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_To);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel.add(JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_datePicker1);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel.add(JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_keyword);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel.add(JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_KeywordText);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel.add(empty);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_changeType);
        
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel1.add(JLabel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_TotalTakeAway);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel1.add(JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_TakeAwayText);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel1.add(JLabel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_TotalSales);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel1.add(JTextField_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_SalesText);
        
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel.add(empty1);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_search);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel.add(empty2);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_GridPanel1);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel.add(empty3);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_add);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_edit);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel_delete);
        
        DefaultTableModel table_model=new DefaultTableModel(column1,0);
		JTable JTable_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_tablePanel_table = new JTable(table_model );
		JScrollPane jsp=new JScrollPane(JTable_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_tablePanel_table);
		jsp.setPreferredSize(new Dimension(1330,445));
        
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOut_Mainpanel.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOutButton_typePanel);

        take_out.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_TakeOut_Mainpanel);
        take_out.add(jsp);
	}
	
	void delivery()
	{
		JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_Mainpanel=new JPanel();
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_Mainpanel.setBackground(Color.GRAY);
        
        JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel=new JPanel();
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel.setBackground(Color.GRAY);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel.setPreferredSize(new Dimension(1330,100));
        
        JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel=new JPanel();
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel.setLayout(new GridLayout(2,4,5,30));
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel.setBackground(Color.GRAY);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel.setPreferredSize(new Dimension(400,90));
        
        JRadioButton JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_date=new JRadioButton("Date");
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_date.setBackground(Color.GRAY);
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_date.setPreferredSize(new Dimension(50,10));
    
        UtilDateModel model;
        JDatePanelImpl datePanel;
        model = new UtilDateModel();
        model.setSelected(true);
        Properties p = new Properties();
        datePanel = new JDatePanelImpl(model,p);
        JDatePickerImpl JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_datePicker = new JDatePickerImpl(datePanel,null);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_datePicker.setBounds(530,45,110,30);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_datePicker.setBackground(Color.GRAY);
        
        JLabel JLabel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_To=new JLabel("           TO");
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_To.setBackground(Color.GRAY);
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_To.setPreferredSize(new Dimension(30,10));
    
        UtilDateModel model1;
        model1 = new UtilDateModel();
        model1.setSelected(true);
       // JDatePanelImpl datePanel1 = new JDatePanelImpl(model,p);
        JDatePickerImpl JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_datePicker1 = new JDatePickerImpl(datePanel,null);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_datePicker1.setBounds(530,45,110,30);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_datePicker1.setBackground(Color.GRAY);
        
        final JRadioButton JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_keyword=new JRadioButton("Keyword");
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_keyword.setBackground(Color.GRAY);
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_keyword.setPreferredSize(new Dimension(120,30));
        
        final JTextField JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_KeywordText=new JTextField();
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_KeywordText.setBackground(Color.white);
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_KeywordText.setPreferredSize(new Dimension(70,10));
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_KeywordText.setEnabled(false);
        
        JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_keyword.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				if(JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_keyword.isSelected())
				{
					JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_KeywordText.setEnabled(true);					
				}
				else
				{
					JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_KeywordText.setEnabled(false);
				}
				
	        }
	    });
        
        JLabel empty=new JLabel("");
        empty.setBackground(Color.GRAY);
        empty.setPreferredSize(new Dimension(30,30));
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_changeType=new JButton("Change Type");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_changeType.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_changeType.setPreferredSize(new Dimension(120,40));
        
        JLabel empty1=new JLabel("");
        empty1.setBackground(Color.GRAY);
        empty1.setPreferredSize(new Dimension(30,100));
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_search=new JButton("Search");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_search.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_search.setPreferredSize(new Dimension(140,90));
        
        JLabel empty2=new JLabel("");
        empty2.setBackground(Color.GRAY);
        empty2.setPreferredSize(new Dimension(30,100));
        
        JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel1=new JPanel();
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel1.setLayout(new GridLayout(2,2,10,30));
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel1.setBackground(Color.GRAY);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel1.setPreferredSize(new Dimension(300,90));
        
        JLabel JLabel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_TotalDeliveries=new JLabel("Total Deliveries");
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_TotalDeliveries.setBackground(Color.GRAY);
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_TotalDeliveries.setPreferredSize(new Dimension(110,30));
        
        JTextField JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_DeliveryText=new JTextField();
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_DeliveryText.setBackground(Color.white);
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_DeliveryText.setPreferredSize(new Dimension(120,30));
        
        JLabel JLabel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_TotalSales=new JLabel("Total Sales");
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_TotalSales.setBackground(Color.GRAY);
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_TotalSales.setPreferredSize(new Dimension(80,30));
        
        JTextField JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_SalesText=new JTextField();
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_SalesText.setBackground(Color.white);
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_SalesText.setPreferredSize(new Dimension(120,30));
        
        JLabel empty3=new JLabel("");
        empty3.setBackground(Color.GRAY);
        empty3.setPreferredSize(new Dimension(140,100));
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_add=new JButton("Add");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_add.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_add.setPreferredSize(new Dimension(60,80));
        
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_add.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				POS_Reservation_Addd reser_add=new POS_Reservation_Addd();
				reser_add.POS_Reservation_Addd();
	        }
	    });
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_edit=new JButton("Edit");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_edit.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_edit.setPreferredSize(new Dimension(60,80));
        
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_edit.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				POS_Reservation_Addd reser_add=new POS_Reservation_Addd();
				reser_add.POS_Reservation_Addd();
	        }
	    });
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_delete=new JButton("Delete");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_delete.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_delete.setPreferredSize(new Dimension(60,80));
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_delivery=new JButton("Delivery");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_delivery.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_delivery.setPreferredSize(new Dimension(60,80));
        
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel.add(JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_date);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel.add(JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_datePicker);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel.add(JLabel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_To);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel.add(JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_datePicker1);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel.add(JRadioButton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_keyword);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel.add(JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_KeywordText);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel.add(empty);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_changeType);
        
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel1.add(JLabel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_TotalDeliveries);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel1.add(JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_DeliveryText);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel1.add(JLabel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_TotalSales);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel1.add(JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_SalesText);

        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel.add(empty1);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_search);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel.add(empty2);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_GridPanel1);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel.add(empty3);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_add);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_edit);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_delete);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel_delivery);
        
        DefaultTableModel table_model=new DefaultTableModel(column1,0);
		JTable Jtable_MasterPage_ViewPanel_POS_ButtonPanel_DeliveryButton_tablePanel_table = new JTable(table_model );
		JScrollPane jsp=new JScrollPane(Jtable_MasterPage_ViewPanel_POS_ButtonPanel_DeliveryButton_tablePanel_table);
		jsp.setPreferredSize(new Dimension(1330,445));
		
		
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_Mainpanel.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_typePanel);
        
        delivery.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_Mainpanel);
		delivery.add(jsp);
	}
	
	void dining()
	{
		JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_Mainpanel=new JPanel();
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_Mainpanel.setBackground(Color.GRAY);
		
		JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel=new JPanel();
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel.setBackground(Color.LIGHT_GRAY);
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel.setPreferredSize(new Dimension(1330,60));
				
		JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_allFirst=new JButton("All");
		Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_allFirst.setPreferredSize(new Dimension(180,50));
		Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_allFirst.setBackground(Color.LIGHT_GRAY);
		
		JTextField JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_textF=new JTextField();
		JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_textF.setPreferredSize(new Dimension(180,40));
				
		JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_searchTable=new JButton("Search Table");
		Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_searchTable.setPreferredSize(new Dimension(180,50));
		Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_searchTable.setBackground(Color.LIGHT_GRAY);
		
		JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_all=new JButton("All");
		Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_all.setPreferredSize(new Dimension(180,50));
		Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_all.setBackground(Color.LIGHT_GRAY);
		
		JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_busy=new JButton("Busy");
		Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_busy.setPreferredSize(new Dimension(180,50));
		Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_busy.setBackground(Color.LIGHT_GRAY);
		
		JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_free=new JButton("Free");
		Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_free.setPreferredSize(new Dimension(180,50));
		Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_free.setBackground(Color.LIGHT_GRAY);
		
		JLabel empty=new JLabel("");
		empty.setPreferredSize(new Dimension(200,50));
		empty.setBackground(Color.LIGHT_GRAY);
		
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_allFirst);
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel.add(JTextField_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_textF);
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_searchTable);
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_all);
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_busy);
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel_free);
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel.add(empty);
		
		JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_GridPanel=new JPanel();
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_GridPanel.setBackground(Color.LIGHT_GRAY);
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_GridPanel.setPreferredSize(new Dimension(1330,445));
		

		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_GridPanel.setLayout(new java.awt.GridLayout(4, 10, 10, 10));
		int n=40;
		
		for (int i = 0; i < n; i++) 
	     {
	    	 JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_GridPanel_button = new JButton(String.valueOf(i));
	    	 Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_GridPanel_button.setPreferredSize(new Dimension(50,30));
	    	 Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_GridPanel_button.setBackground(Color.ORANGE);
	    	 Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_GridPanel_button.addActionListener(new java.awt.event.ActionListener() 
	         {
	        	 public void actionPerformed(java.awt.event.ActionEvent e) 
	             {        		              
	        		 
	             }
        	 });
	    	 
	    	 
	         Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_GridPanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_Dining_GridPanel_button);
        }
	
	    Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_Mainpanel.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_typePanel);
	
	    dining.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_Mainpanel);
	    dining.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Dining_GridPanel);
	}
	
	void receipt_on_hold()
	{
		JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_Mainpanel=new JPanel();
		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_Mainpanel.setBackground(Color.GRAY);
        
        JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel=new JPanel();
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel.setBackground(Color.GRAY);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel.setPreferredSize(new Dimension(1330,100));
                
        JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel=new JPanel();
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel.setLayout(new GridLayout(2,4,5,30));
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel.setBackground(Color.GRAY);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel.setPreferredSize(new Dimension(400,90));
                
        JRadioButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_date=new JRadioButton("Date");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_date.setBackground(Color.GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_date.setPreferredSize(new Dimension(160,30));
        
        UtilDateModel model;
        JDatePanelImpl datePanel;
        model = new UtilDateModel();
        model.setSelected(true);
        Properties p = new Properties();
        datePanel = new JDatePanelImpl(model,p);
        JDatePickerImpl JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_datePicker = new JDatePickerImpl(datePanel,null);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_datePicker.setBounds(530,45,110,30);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_datePicker.setBackground(Color.GRAY);
        
        JLabel JLabel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_To=new JLabel("            TO");
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_To.setBackground(Color.GRAY);
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_To.setPreferredSize(new Dimension(30,30));
            
        UtilDateModel model1;
        model1 = new UtilDateModel();
        model1.setSelected(true);
        //JDatePanelImpl datePanel1 = new JDatePanelImpl(model,p);
        JDatePickerImpl JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_datePicker1 = new JDatePickerImpl(datePanel,null);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_datePicker1.setBounds(530,45,110,30);
        JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_datePicker1.setBackground(Color.GRAY);
        
        
        final JRadioButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_keyword=new JRadioButton("Keyword");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_keyword.setBackground(Color.GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_keyword.setPreferredSize(new Dimension(120,30));
        
        final JTextField JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_KeywordText=new JTextField();
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_KeywordText.setBackground(Color.white);
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_KeywordText.setPreferredSize(new Dimension(120,30));
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_KeywordText.setEnabled(false);
        
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_keyword.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {	
				if(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_keyword.isSelected())
				{
					JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_KeywordText.setEnabled(true);					
				}
				else
				{
					JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_KeywordText.setEnabled(false);
				}
				
	        }
	    });
        
        JLabel empty=new JLabel("");
        empty.setBackground(Color.GRAY);
        empty.setPreferredSize(new Dimension(30,30));
        
        JLabel empty1=new JLabel("");
        empty1.setBackground(Color.GRAY);
        empty1.setPreferredSize(new Dimension(30,30));
        
        JLabel empty2=new JLabel("");
        empty2.setBackground(Color.GRAY);
        empty2.setPreferredSize(new Dimension(30,30));
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_search=new JButton("Search");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_search.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_search.setPreferredSize(new Dimension(150,90));
        
        JLabel empty3=new JLabel("");
        empty3.setBackground(Color.GRAY);
        empty3.setPreferredSize(new Dimension(30,30));
        
        JPanel Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel1=new JPanel();
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel1.setLayout(new GridLayout(2,2,10,30));
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel1.setBackground(Color.GRAY);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel1.setPreferredSize(new Dimension(300,90));
        
        JLabel JLabel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_TotalOnHold=new JLabel("Total On Hold");
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_TotalOnHold.setBackground(Color.GRAY);
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_TotalOnHold.setPreferredSize(new Dimension(110,30));
        
        JTextField JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_ReceiptsOnHoldText=new JTextField();
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_ReceiptsOnHoldText.setBackground(Color.white);
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_ReceiptsOnHoldText.setPreferredSize(new Dimension(120,30));
        
        JLabel JLabel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_TotalSales=new JLabel("Total Sales");
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_TotalSales.setBackground(Color.GRAY);
        JLabel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_TotalSales.setPreferredSize(new Dimension(80,30));
              
        JTextField JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_SalesText=new JTextField();
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_SalesText.setBackground(Color.white);
        JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_SalesText.setPreferredSize(new Dimension(120,30));
        
        JLabel empty4=new JLabel("");
        empty4.setBackground(Color.GRAY);
        empty4.setPreferredSize(new Dimension(230,30));
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_edit=new JButton("Edit");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_edit.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_edit.setPreferredSize(new Dimension(70,85));
        
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_edit.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e) 
	        {
				POS_Reservation_Addd reser_add=new POS_Reservation_Addd();
				reser_add.POS_Reservation_Addd();
	        }
	    });
        
        JButton Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_delete=new JButton("Delete");
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_delete.setBackground(Color.LIGHT_GRAY);
        Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_delete.setPreferredSize(new Dimension(70,85));
        
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_date);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel.add(JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_datePicker);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel.add(JLabel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_To);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel.add(JDatePicker_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_datePicker1);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_keyword);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel.add(JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_KeywordText);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel.add(empty);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel.add(empty1);
        
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel1.add(JLabel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_TotalOnHold);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel1.add(JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_ReceiptsOnHoldText);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel1.add(JLabel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_TotalSales);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel1.add(JTextField_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_SalesText);
            
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel.add(empty2);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_search);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel.add(empty3);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_GridPanel1);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel.add(empty4);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_edit);
        Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel.add(Jbutton_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel_delete);
        
        DefaultTableModel table_model=new DefaultTableModel(column1,0);
		JTable JTable_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_tablePanel_table = new JTable(table_model );
		JScrollPane jsp=new JScrollPane(JTable_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_tablePanel_table);
		jsp.setPreferredSize(new Dimension(1330,445));

		Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_Mainpanel.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_receiptsOnHoldButton_typePanel);
		
		receipt_on_hold.add(Jpanel_MasterPage_ViewPanel_POS_ButtonPanel_Delivery_Mainpanel);
		receipt_on_hold.add(jsp);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}