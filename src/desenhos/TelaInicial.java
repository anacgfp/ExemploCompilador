package desenhos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import compilador.ExecutarCompilador;

@SuppressWarnings("serial")
public class TelaInicial extends JFrame implements ActionListener{
	private JTextField code;
	private JButton button;
	private String retorno;
	public String main () {
		JFrame jframe = new JFrame("Projeto de Compiladores");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		JLabel label = new JLabel("Código: ", SwingConstants.CENTER);
		label.setBounds(10, 10, 100, 40);
		jframe.add(label);	
		 code = new JTextField();
		 code.setBounds(50, 50, 200, 40);
		 button =new JButton(" Submit ");  
		 button.setBounds(90,150,100,40);
		 button.addActionListener(this);
		 jframe.add(code);
		 jframe.add(button);
		 jframe.setLocationRelativeTo(null);
	     jframe.setLayout(null);  

		 jframe.setSize(325,300);
//		 jframe.setBackground(Color.pink);
		 jframe.getContentPane().setBackground(Color.pink);
		 jframe.setVisible(true);
		return retorno;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String s1 = code.getText();
		retorno = s1;
		try {
			new ExecutarCompilador().main(s1);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

}
