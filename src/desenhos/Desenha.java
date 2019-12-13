package desenhos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Desenha extends JPanel {

	private List<String> impressao = new ArrayList<String>();

	public Desenha() {
		
	}
	public Desenha(List<String> impressao) {
		this.impressao = impressao;
	}
	public Color returnColor(String s) {
		switch(s) {
		case "blue":
			return Color.blue;
		case "pink":
			return Color.pink;
		case "yellow":
			return Color.yellow;
		case "black":
			return Color.black;
		case "green":
			return Color.green;
		case "red":
			return Color.red;
		default:
			return null;
		}
		
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent( g ); // call superclass's paintComponent
		Graphics2D g2d = ( Graphics2D ) g;// cast g to Graphics2D
		
/*		for(String s : impressao) {
			String[] tokens = s.split(",");
			
			switch(tokens[0]) {
			case "square":
				g2d.setColor(returnColor(tokens[2]));
				g2d.fill(new Rectangle2D.Double(0, 0, Double.parseDouble(tokens[1]), Double.parseDouble(tokens[1]) ) );
			}
			
		}
*/
		for(int i = 0; i< impressao.size(); i++) {	
			String[] tokens = impressao.get(i).split(",");
			
			switch(tokens[0]) {
			case "square":
				g2d.setColor(returnColor(tokens[2].trim()));
				g2d.fill(new Rectangle2D.Double(0, 0, Double.parseDouble(tokens[1]), Double.parseDouble(tokens[1]) ) );
				break;
			case "line":
				g2d.setColor(returnColor(tokens[5].trim()));
				g2d.fill(new Line2D.Double( Double.valueOf(tokens[1]), Double.valueOf(tokens[2]), Double.valueOf(tokens[3]), Double.valueOf(tokens[4]) ));
				break;
			case "circle":
				g2d.setColor(returnColor(tokens[2].trim()));
				g2d.fill(new Ellipse2D.Double( 0, 0,Double.valueOf(tokens[1]), Double.valueOf(tokens[1]) ) );
				break;
			case "rectangle":
				g2d.setColor(returnColor(tokens[3].trim()));
				g2d.fill(new Rectangle2D.Double(0, 0, Double.valueOf(tokens[1]), Double.valueOf(tokens[2]) ));
				break;
			case "ellipse":
				g2d.setColor(returnColor(tokens[3].trim()));
				g2d.fill(new Ellipse2D.Double( 0, 0,Double.valueOf(tokens[1]), Double.valueOf(tokens[2]) ) );
				break;
			case "triangle":
				g2d.setColor(returnColor(tokens[7].trim()));
				int x[] = {(int) ((double) Double.valueOf(tokens[1])), (int) ((double) Double.valueOf(tokens[3])), (int) ((double) Double.valueOf(tokens[5]))};
				int y[] = {(int) ((double) Double.valueOf(tokens[2])), (int) ((double) Double.valueOf(tokens[4])), (int) ((double) Double.valueOf(tokens[6]))};
				g2d.fill(new Polygon(x,y,3));
			}
		}
		
	}
}
