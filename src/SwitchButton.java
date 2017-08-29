import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SwitchButton extends JButton {
	
	public SwitchButton() {
		super("OFF");
		super.setBackground(Color.RED);
		super.addActionListener(new SwitchListener());
	}
	
	private class SwitchListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent action) {
			if (SwitchButton.super.getBackground() == Color.RED) {
				SwitchButton.super.setBackground(Color.GREEN);
				SwitchButton.super.setText("ON");
			} else {
				SwitchButton.super.setBackground(Color.RED);
				SwitchButton.super.setText("OFF");
			}
			
		}
		
	}
	
}
