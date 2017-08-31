
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
		
		JButton remember = new JButton("Remember me?");
		RememberListener rlistener = new RememberListener();
		login.addActionListener((ActionListener) rlistener);		
		control_buttons.add(remember);
		
		SwitchButton cancel = new SwitchButton();
		control_buttons.add(cancel);
		
		contentPane.add(login_report, BorderLayout.CENTER);
		contentPane.add(control_buttons, BorderLayout.SOUTH);
		
	}
	
	private class CancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
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