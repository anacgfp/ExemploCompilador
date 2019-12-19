package compilador;

import java.util.ArrayList;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import desenhos.TelaDesenhos;

public class ExecutarCompilador {
	
	private List<String> impressao = new ArrayList<String>();	
	
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
		case "programa":
			println("programa: ");
			
			for (int i =0; i<childs.length; i++) {
				avaliador(childs[i]);
			}
			break;
		case "draw": 
			   System.out.println("draw: ");
			   avaliador(childs[0]);
			   break;
		case "square":
				Double side = (Double) childs[0];
				Double xsquare = (Double) childs[2];
				Double ysquare = (Double) childs[3];
			    String quadrado = "square" + "," +side.toString() + "," + (String) childs[1] + "," + xsquare.toString() +","+ ysquare.toString();
			    println(quadrado);
			    impressao.add(quadrado);			   
			   break;
		case "circle":
			Double radius = (Double) childs[0];
			println(radius.toString());
			Double xcircle = (Double) childs[2];
			Double ycircle = (Double) childs[3];
			String circulo = "circle" + "," + radius.toString() + "," + (String) childs[1] + "," + xcircle.toString() + "," + ycircle.toString();
			println(circulo);
			impressao.add(circulo);
			break;
		case "line":
			//Float x1 = Float.valueOf(x1x2[0]);
			String color = (childs[2]).toString();
			String linha = "line" + "," + avaliador(childs[0]) + "," +avaliador(childs[1]) + "," + (String) childs[2].toString();
			println(linha);
			impressao.add(linha);
			break;
			
		case "color":  
			System.out.println("cor:"+ Integer.parseInt((String)childs[0]));
			break;

		case "point" : 
			System.out.println("ponto: " + childs[0].toString() + " , " + childs[1].toString());
			return childs[0].toString() +","+ childs[1].toString();
		case "int":  
			System.out.println(" int "+ Float.parseFloat((String)childs[0]));
			break;
		case "triangle":
			String triangulo = "triangle" + "," + avaliador(childs[0]) + "," +avaliador(childs[1]) + "," + avaliador(childs[2]) + "," + (String) childs[3].toString();
			println(triangulo);
			impressao.add(triangulo);
			break;
		case "rectangle":
			Double arec = (Double) childs[0];
			Double brec = (Double) childs[1];
			Double xrect = (Double) childs[3];
			Double yrect = (Double) childs[4];
			String retangulo = "rectangle" + "," + arec.toString() + "," + brec.toString() + "," + (String) childs[2].toString() + "," + xrect.toString() + "," + yrect.toString();
			println(retangulo);
			impressao.add(retangulo);
			break;
		case "ellipse":
			Double a = (Double) childs[0];
			Double b = (Double) childs[1];
			String elipse = "ellipse" + "," + a.toString() + "," + b.toString() + "," + (String) childs[2].toString() + "," + ((Double)childs[3]).toString() + "," + ((Double) childs[4]).toString();
			println(elipse);
			impressao.add(elipse);
			break;
			default:
				throw new RuntimeException("Nao sei avaliar: "+expr);
		}
		return null;

	}; 

	public void main(String s) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.put("factory", new Factory());
		engine.eval("parser = load('parser.js');");
//		engine.put("src","draw circle -radius= 50 blue");
//		engine.put("src", "draw ellipse -a=50 -b=100 blue");
		//engine.put("src", "draw line -p1= 1,1 -p2= 327,432 blue");
		engine.put("src", s);
		Object result = engine.eval("parser.parse(src);");
		System.out.println("Codigo Fonte = " + engine.get("src"));
		System.out.println("Arvore = " + result);
		System.out.println("Execucao:");
		avaliador(result);
		new TelaDesenhos().main(impressao);
		

	}

		

}
