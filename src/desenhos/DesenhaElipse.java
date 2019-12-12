package desenhos;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DesenhaElipse extends JPanel{
	@SuppressWarnings("unused")
	private double a;
	private double b;
	@SuppressWarnings("unused")
	private Color color;
	
	public DesenhaElipse() {
		
	}
	public DesenhaElipse(double a, double b, Color color) {
		this.a = a;
		this.b = b;
		this.color = color;
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent( g ); // call superclass's paintComponent

		Graphics2D g2d = ( Graphics2D ) g; // cast g to Graphics2D
		// draw 2D ellipse filled with a blue-yellow gradient
		g2d.setColor(color);
		//Ellipse2D.Double(double x, double y, double w, double h)

		g2d.fill( new Ellipse2D.Double( 0, 0, a, b ) );
		
	}
	
	public void main(DesenhaElipse desenhaCirculo) {
		JFrame jframe = new JFrame("Círculo");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(desenhaCirculo);
		jframe.setSize(425,200);
		jframe.setVisible(true);
	}

}
