
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	
	private JPanel contentPane;

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
		contentPane.setLayout(new GridLayout(3,2));
		super.setSize(new Dimension(400, 300));
		super.setTitle("Frame Title");
		
		JLabel username_label = new JLabel("Username:");
		contentPane.add(username_label);
		
		JTextField username_field = new JTextField();
		contentPane.add(username_field);
		
		JLabel password_label = new JLabel("Password:");
		contentPane.add(password_label);
		
		JTextField password_field = new JTextField();
		contentPane.add(password_field);
		
	}
}
