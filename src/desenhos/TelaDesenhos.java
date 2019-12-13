package desenhos;

import java.util.List;

import javax.swing.JFrame;

import compilador.ExecutarCompilador;

public class TelaDesenhos {
	
	public void main(List<String> impressao) {

		 JFrame jframe = new JFrame ("compiladores é demais");
			jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Desenha d = new Desenha(impressao);
			jframe.add(d);
			jframe.setSize(425,400);
			jframe.setVisible(true);
	}

}
