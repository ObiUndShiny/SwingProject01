import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToggleButton extends JPanel {
	
	private JButton btn1;
	private JButton btn2;
	
	public ToggleButton(String btn1, String btn2) {
		super();
		super.setLayout(new GridLayout(1, 2));
		this.btn1 = new JButton(btn1);
		this.btn2 = new JButton(btn2);
		super.add(this.btn1);
		super.add(this.btn2);
		this.btn1.addActionListener(new ToggleListener(this.btn1, this.btn2));
		this.btn2.addActionListener(new ToggleListener(this.btn2, this.btn1));
		this.btn2.setEnabled(false);
	}
	
	private class ToggleListener implements ActionListener {

		private JButton own;
		private JButton other;
		
		public ToggleListener(JButton own, JButton other) {
			this.own = own;
			this.other = other;
		}
		
		@Override
		public void actionPerformed(ActionEvent action) {
			
			this.own.setEnabled(false);
			this.other.setEnabled(true);
			
		}
		
	}
	
}
