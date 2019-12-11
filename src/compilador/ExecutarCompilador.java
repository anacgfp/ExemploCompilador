package compilador;
import javax.script.*;

import desenhos.DesenhaLinha;
import desenhos.Desenhar;
import desenhos.RegistrationFormApplication;

import java.awt.geom.*;
import java.util.*;

public class ExecutarCompilador {

	public void println(String s) {
		System.out.println(s);
	}


	@SuppressWarnings("unused")
	public String avaliador(Object obj) {
		if (!(obj instanceof TreeNode))
			throw new RuntimeException("Nao sei avaliar: "+obj);
		
		TreeNode expr = (TreeNode)obj;
		Object childs[] = expr.childs;
		
		switch (expr.label) {
		case "draw": 
			   System.out.println("draw: ");
			   avaliador(childs[0]);
			   break;
		case "square":
				System.out.println("square: ");
			   avaliador((TreeNode)childs[0]);
			   if((TreeNode)childs[1] != null) {
				   avaliador(childs[1]);
			   }
			   break;
		case "circle":
			System.out.println("circle : O radius:= " + Float.parseFloat(childs[0].toString()) + " color :" + childs[1].toString());
			break;
		case "line":
			System.out.println("p1: " + childs[0].toString() +" p2: " +  childs[1].toString() + "color: "+ childs[2].toString());
			String[] x1x2 = avaliador(childs[0]).split(",");
			Float x1 = Float.valueOf(x1x2[0]);
			Float x2 = Float.valueOf(x1x2[1]);
			String[] y1y2 = avaliador(childs[1]).split(",");
			Float y1 = Float.valueOf(y1y2[0]);
			Float y2 = Float.valueOf(y1y2[1]);
			String color = (childs[2]).toString();
			DesenhaLinha desenhaLinha = new DesenhaLinha(x1,x2,y1,y2,color);
			desenhaLinha.main(desenhaLinha);
			break;
			
		case "color":  
			System.out.println("b"+ Integer.parseInt((String)childs[0]));
			break;

		case "point" : 
			System.out.println("ponto: " + childs[0].toString() + " , " + childs[1].toString());
			return childs[0].toString() +","+ childs[1].toString();
		case "int":  
			System.out.println(" int "+ Float.parseFloat((String)childs[0]));
			break;
		case "triangle":
			println("triangle");
			break;
		case "rectangle":
			println("rectangle");
			break;
		case "ellipse":
			println("ellipse");
			break;
			default:
				throw new RuntimeException("Nao sei avaliar: "+expr);
		}
		return null;

	}; 

	public void main() throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.put("factory", new Factory());
		engine.eval("parser = load('parser.js');");
		//engine.put("src","draw circle -radius= 5");
		engine.put("src", "draw line -p1= 1,1 -p2= 327,432 blue");
		Object result = engine.eval("parser.parse(src);");
		System.out.println("Codigo Fonte = " + engine.get("src"));
		System.out.println("Arvore = " + result);
		System.out.println("Execucao:");
		avaliador(result);
		Desenhar.main();
		

	}

		

}
