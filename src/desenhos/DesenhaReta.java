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
    * M�todo init() do Applet, � an�logo ao m�todo main() de uma
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
      //� poss�vel usar m�todos como "this.setBackground(Color.black);"
      setBackground( Color.black );
   }
  
   /*
    * Este � o principal m�todo que realiza os "desenhos" na sua tela.
    * Toda vez que chamamos o "repaint()" este m�todo � chamado, 
    * realizando o "redesenho" da sua janela.
    * */
   public void paint( Graphics g ) {
           
         /*
          * O objeto Graphics � que utilizaremos para desenhar na tela as mais
          * diversas formas geom�tricas. Ent�o antes de desenhar qualquer coisa
          * vamos colocar dizer que o objeto desenhado dever� estar na cor 
          * "Verde/green".
          * */
      g.setColor( Color.cyan );
       
      /*
       * Criamos um la�o for para desenhar as linhas/retas. 
       * Aqui j� come�a um pouco de matem�tica
       * b�sica, afinal o mundo de Softwares � pura matem�tica.
       *
       * O la�o funciona da seguinte forma: A cada itera��o 
       * desenhamos uma linha na tela nas
       * posi��es correspondentes as vari�veis 'width' e 'height', 
       * ou seja, as posi��es das linhas
       * s�o relativas ao tamanho da tela.
       *
       * A forma mais f�cil de entender o c�lculo que foi realizado 
       * abaixo � desenhando um EIXO CARTESIANO em um papel, 
       * colocando as coordenadas e mapeando cada ponto x,y como
       * no c�digo abaixo.
       * */
      for ( int i = 0; i < 10; ++i ) {
         g.drawLine( 50, 100, i * width / 10, 0 );
      }
      g.setColor(Color.orange);
      g.drawLine(100, 50, 10, 0);
   }
}