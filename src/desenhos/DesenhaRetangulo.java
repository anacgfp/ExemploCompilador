package desenhos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DesenhaRetangulo extends JPanel{
	private Double a;
	private Double b;
	private Color color;
	
	public DesenhaRetangulo() {
		
	}
	public DesenhaRetangulo(Double a, Double b, Color color) {
		this.a = a;
		this.b = b;
		this.color = color;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = ( Graphics2D ) g; // cast g to Graphics2D
		//TODO: COLOR
		g2d.setColor(color);
		g2d.fill(new Rectangle2D.Double(0, 0, a, b ) );
	}
	@SuppressWarnings("unused")
	public void main(DesenhaRetangulo desenhaRetangulo) {
		JFrame frame = new JFrame ("desenha retangulo :D");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.add(desenhaRetangulo);
		frame.setSize( 200, 200 );
		frame.setVisible(true);
	}

}
