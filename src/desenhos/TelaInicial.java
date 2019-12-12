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

@SuppressWarnings("serial")
public class TelaInicial extends JFrame implements ActionListener{
	private JTextField code;
	private JButton button;
	private String retorno;
	public String main () {
		JFrame jframe = new JFrame("Projeto de Compiladores 2019.2");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		jframe.setBackground(Color.LIGHT_GRAY);
		JLabel label = new JLabel("Código: ", SwingConstants.CENTER);
		 jframe.getContentPane().add(label,BorderLayout.CENTER);	
		 code = new JTextField();
		 code.setBounds(50, 50, 50, 50);
		 button =new JButton(" Submit ");  
		 button.setBounds(200,200,50,50);
		 button.addActionListener(this);
		 jframe.add(code);
		 jframe.add(button);
		 jframe.setLocationRelativeTo(null);
	     jframe.setLayout(null);  

		 jframe.setSize(500,500);
		 jframe.setVisible(true);
		return retorno;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String s1 = code.getText();
		retorno = s1;
		
	}

}
