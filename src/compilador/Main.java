package compilador;

import desenhos.TelaInicial;

public class Main {
	public static void main(String args[]) throws Exception {
//		new GerarCompilador().main();
//		new ExecutarCompilador().main();
		String s = new TelaInicial().main();
		System.out.println("s: "+ s);
	}

}
