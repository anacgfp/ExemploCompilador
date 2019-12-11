package desenhos;

import java.awt.BorderLayout;
import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
/**
 * @author Ana Catarina
 *
 */
public class Desenhar extends JFrame{
 
	 public static void main() {
		 JFrame jframe = new JFrame("Compiladores é demais!:)");
		 jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		 
		 JLabel label = new JLabel("I'm a label, don't you just know it?", SwingConstants.CENTER);
		 jframe.getContentPane().add(label,BorderLayout.CENTER);		 
		 jframe.setLocationRelativeTo(null);
		 jframe.pack();
		 jframe.setVisible(true);	 }

}
