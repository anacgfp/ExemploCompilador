package desenhos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DesenhaQuadrado extends JPanel{
	private float side;
	private String color;
	
	public DesenhaQuadrado() {
		
	}
	public DesenhaQuadrado(float side, String color) {
		this.side = side;
		this.color = color;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = ( Graphics2D ) g; // cast g to Graphics2D
		g2d.fill(new Rectangle2D.Double( 80, 30, 65, 100 ) );
	}

}
