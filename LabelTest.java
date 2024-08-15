// Testando LabelFrame.
import javax.swing.JFrame; // importação de bliblioteca.modulo.componente

public class LabelTest 
{
   public static void main(String[] args)
   { 
      LabelFrame labelFrame = new LabelFrame(); 
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define o padrão de operação ao fechar para sair
      labelFrame.setSize(260, 180); // define o tamanho do frame largura e altura
      labelFrame.setVisible(true);  // define a visibilidade do frame como visivel
   } 
} // fim da classe LabelTest