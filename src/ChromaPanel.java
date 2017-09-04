import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ChromaPanel extends JPanel {
	
	private static final float SPEED = 0.001f;
	
	private int r;
	private int g;
	private int b;
	
	private int x;
	
	public ChromaPanel() {
		
		this.r = 0;
		this.g = (256/3);
		this.b = (256/3)*2;
		
	}
	
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		
		x++;
		
		this.r=(int) (127.5*Math.sin(x*SPEED)+127.5)%256;
		this.g=(int) (127.5*Math.sin(x*SPEED+(2*Math.PI/3))+127.5)%256;
		this.b=(int) (127.5*Math.sin(x*SPEED+2*(2*Math.PI/3))+127.5)%256;
		
		super.setBackground(new Color(r, g, b));
		
		super.repaint();
	}

}
