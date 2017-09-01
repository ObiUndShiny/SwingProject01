
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class MainFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField username_field;
	private JPasswordField password_field;

	public MainFrame() {
		try {
			super.setDefaultCloseOperation(EXIT_ON_CLOSE);
			FrameInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Component initialization.
	 *
	 * @throws java.lang.Exception
	 */
	private void FrameInit() throws Exception {
		
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(new BorderLayout());
		super.setSize(new Dimension(400, 300));
		super.setTitle("Frame Title");
		
		EmptyBorder border1 = new EmptyBorder(35, 40, 40, 10);
		EtchedBorder border2 = new EtchedBorder();
		CompoundBorder cborder = BorderFactory.createCompoundBorder(border1, border2);
		
		JPanel login_report = new JPanel(new GridLayout(2,2));
		login_report.setBackground(Color.WHITE);
		
		JLabel username_label = new JLabel("Username:");
		username_label.setBorder(border1);
		login_report.add(username_label);
		
		username_field = new JTextField();
		username_field.setBorder(cborder);
		login_report.add(username_field);
		
		JLabel password_label = new JLabel("Password:");
		password_label.setBorder(border1);
		login_report.add(password_label);
		
		password_field = new JPasswordField();
		password_field.setBorder(cborder);
		login_report.add(password_field);
		
		JPanel control_buttons = new JPanel(new FlowLayout());
		
		JButton login = new JButton("LOGIN");
		LoginListener llistener = new LoginListener();
		login.addActionListener(llistener);		
		control_buttons.add(login);
		
//		JButton remember = new JButton("Remember me?");
//		RememberListener rlistener = new RememberListener();
//		login.addActionListener((ActionListener) rlistener);		
//		control_buttons.add(remember);
		
		JCheckBox remeber_me = new JCheckBox("Remeber me?");
		remeber_me.addActionListener(new RememberListener());
		control_buttons.add(remeber_me);
		
		JPanel group_buttons = new JPanel(new GridLayout(4, 1));
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton test1 = new JRadioButton("Test1");
		group_buttons.add(test1);
		JRadioButton test2 = new JRadioButton("Test2");
		group_buttons.add(test2);
		JRadioButton test3 = new JRadioButton("Test3");
		group_buttons.add(test3);
		JRadioButton test4 = new JRadioButton("Test4");
		group_buttons.add(test4);
		
		group.add(test1);
		group.add(test2);
		group.add(test3);
		group.add(test4);
		
		JMenuBar bar = new JMenuBar();
		contentPane.add(bar, BorderLayout.NORTH);
		
		List<String> items = new ArrayList<>();
		items.add("Elem1");
		items.add("3");
		items.add("10");
		
		Collections.sort(items);
		
		bar.add(generateMenuItems("Menu1", items));

		contentPane.add(group_buttons, BorderLayout.WEST);
		
		SwitchButton cancel = new SwitchButton();
		control_buttons.add(cancel);
		
		contentPane.add(login_report, BorderLayout.CENTER);
		contentPane.add(control_buttons, BorderLayout.SOUTH);
		
	}
	
	/**
	 * generates a new menu + n menu raadio buttons
	 * 
	 * @param name of menu
	 * @param n radio buttons
	 * @return the menu
	 */
	private JMenu generateMenuItems(String menu_name, List<String> items) {
		
		JMenu menu = new JMenu(menu_name);
		ButtonGroup group = new ButtonGroup();
		
		for (String item : items) {
			
			JRadioButtonMenuItem radio = new JRadioButtonMenuItem(item);
			menu.add(radio);
			group.add(radio);
			
		}
		
		return menu;
		
	}
	
	private class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			char[] chars = password_field.getPassword();
			String password = new String(chars);
			
			System.out.println(username_field.getText() + "|" + password);
			
		}
		
		
	}
	
	private class RememberListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Wir werden uns dich Merken!");
				
		}
			
	}
		
}