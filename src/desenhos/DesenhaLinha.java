package desenhos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DesenhaLinha extends JPanel {

	private Float x1,x2,y1,y2;
	private String color;
	public DesenhaLinha() {
		
	}
	public DesenhaLinha(Float x1, Float x2, Float y1, Float y2, String color) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = color;
	}
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);
		
		Graphics2D g2d = ( Graphics2D ) g;
		
		
		g2d.setPaint( Color.blue );
		g2d.draw( new Line2D.Double( x1, x2, y1, y2 ) );
		
	}
	
	public  void main(DesenhaLinha desenhaLinha) {
		JFrame frame = new JFrame( "Desenha Linha" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.add(desenhaLinha);
		frame.setSize( 425, 200 );
		frame.setVisible(true);
	}
}
