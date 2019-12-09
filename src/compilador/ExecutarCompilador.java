package compilador;
import javax.script.*;

import compilador.*;

import java.io.*;
import java.util.*;

public class ExecutarCompilador {

	public void println(String s) {
		System.out.println(s);
	}
	
	//Map<String,Integer> vars = new HashMap<String,Integer>();
	public void avaliador(Object obj) {
		if (!(obj instanceof TreeNode))
			throw new RuntimeException("Nao sei avaliar: "+obj);
		
		TreeNode expr = (TreeNode)obj;
		Object childs[] = expr.childs;
		
		switch (expr.label) {
		//Comandos
		case "draw": 
			   System.out.println("draw: ");
			   avaliador(childs[0]);
			   break;
		case "square":
				System.out.println("square: ");
			   avaliador(childs[0]);
			   if(childs[1] != null) {
				   avaliador(childs[1]);
			   }
			   break;
		case "circle":
			System.out.println("circle : O radius:= " + Float.parseFloat(childs[0].toString()));
			avaliador(childs[1]);
			break;
		case "line":
			System.out.println("p1: " + childs[0].toString() +" p2: " +  childs[1].toString());
			break;
			
		case "color":  
			System.out.println("b"+ Integer.parseInt((String)childs[0]));
			break;
		case "center":  
			System.out.println("cor "+childs[0].toString());
			break;
		case "point" : 
			System.out.println("ponto: " + childs[0].toString() + childs[1].toString());
			break;
		case "int":  
			System.out.println(" int "+ Float.parseFloat((String)childs[0]));
			break;

		}
//		throw new RuntimeException("Nao sei avaliar: "+expr);
	}
	
/*	int ifLabel = 0;
	int whileLabel = 0;
	public int compilador(Object obj) {
		if (!(obj instanceof TreeNode))
			throw new RuntimeException("Nao sei avaliar: "+obj);
		
		TreeNode expr = (TreeNode)obj;
		Object childs[] = expr.childs;
		
		switch (expr.label) {
		//Comandos
		case "corForma": 
			int labelAtual = ifLabel++;
			compilador(childs[0]);
			println("jumpf else"+labelAtual);
			compilador(childs[1]);
			println("jump fim-se"+labelAtual);
			println("else"+labelAtual+":");
			compilador(childs[2]);
			println("fim-se"+labelAtual+":");

		case "linha":
			for (int c=0;c<childs.length;c++)
				compilador(childs[c]);
			return 0;
		case "circulo":
			compilador(childs[1]);
			println("store in "+childs[0]);
			return 0;
		case "ponto":
			compilador(childs[0]);
			println("write");
			return 0;

		
		case "cor":  println("load " + childs[0]); return 0;
		}
		throw new RuntimeException("Nao sei compilar: "+expr);
	}
*/
	public  void main() throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.put("factory", new Factory());
		engine.eval("parser = load('parser.js');");
		
		//engine.put("src","draw circle -radius= 5");
		engine.put("src", "draw line -p1= 8,1 -p2= 2,5");
		Object result = engine.eval("parser.parse(src);");
		System.out.println("Codigo Fonte = " + engine.get("src"));
		System.out.println("Arvore = " + result);
		System.out.println("Execucao:");
		avaliador(result);

	}

		

}
