// Testando LabelFrame.
import javax.swing.JFrame; // importação de bliblioteca.modulo.componente

public class LabelTest  // criado (declarado) a classe LabelTest
{
   public static void main(String[] args) // criado (declarado) o método executor main || "[]" = matriz
   { 
      LabelFrame labelFrame = new LabelFrame(); 
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define o padrão de operação ao fechar para sair
      labelFrame.setSize(280, 180); // define o tamanho do frame largura e altura
      labelFrame.setVisible(true);  // define a visibilidade do frame como visivel
   } 
} // fim da classe LabelTest