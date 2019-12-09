package desenhos;
  
import java.applet.*;
import java.awt.*;
  
public class DesenhaReta extends Applet {
        
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width, height;
  
   /*
    * Método init() do Applet, é análogo ao método main() de uma
    * classe Java Comum. Aqui colocamos os objetos e componentes que
    * desejamos inicializar
    * */
   public void init() {  
           
         //Capturamos a largura da janela
      width = getSize().width;
       
      //Capturamos a altura da janela
      height = getSize().height;
       
      //Configuramos o fundo da janela para ficar na cor preta.
      //Lembre-se que estamos trabalhando com Applet's, por isso
      //é possível usar métodos como "this.setBackground(Color.black);"
      setBackground( Color.black );
   }
  
   /*
    * Este é o principal método que realiza os "desenhos" na sua tela.
    * Toda vez que chamamos o "repaint()" este método é chamado, 
    * realizando o "redesenho" da sua janela.
    * */
   public void paint( Graphics g ) {
           
         /*
          * O objeto Graphics é que utilizaremos para desenhar na tela as mais
          * diversas formas geométricas. Então antes de desenhar qualquer coisa
          * vamos colocar dizer que o objeto desenhado deverá estar na cor 
          * "Verde/green".
          * */
      g.setColor( Color.cyan );
       
      /*
       * Criamos um laço for para desenhar as linhas/retas. 
       * Aqui já começa um pouco de matemática
       * básica, afinal o mundo de Softwares é pura matemática.
       *
       * O laço funciona da seguinte forma: A cada iteração 
       * desenhamos uma linha na tela nas
       * posições correspondentes as variáveis 'width' e 'height', 
       * ou seja, as posições das linhas
       * são relativas ao tamanho da tela.
       *
       * A forma mais fácil de entender o cálculo que foi realizado 
       * abaixo é desenhando um EIXO CARTESIANO em um papel, 
       * colocando as coordenadas e mapeando cada ponto x,y como
       * no código abaixo.
       * */
      for ( int i = 0; i < 10; ++i ) {
         g.drawLine( 50, 100, i * width / 10, 0 );
      }
      g.setColor(Color.orange);
      g.drawLine(100, 50, 10, 0);
   }
}