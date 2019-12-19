package compilador;

import desenhos.TelaInicial;

public class Main {
	public static void main(String args[]) throws Exception {
		new GerarCompilador().main();
/*		new ExecutarCompilador().main("draw line -p1= 1,1 -p2= 327,432 blue 0 0\r\n" + 
				"draw ellipse -a=50 -b=100 green\r\n" + 
				"draw circle -radius= 50 red\r\n" + 
				"draw square -side= 100 yellow\r\n" + 
				"draw triangle -p1=1,1 -p2=327,432 -p3=843,0 black\r\n" + 
				"draw rectangle -a= 12 -b=123 white");*/
		new TelaInicial().main();
	}

}
