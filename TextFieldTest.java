// Testando TextFieldFrame.
import javax.swing.JFrame; // importação de bliblioteca.modulo.componente

public class TextFieldTest // criado (declarado) a classe TextFieldTest
{
   public static void main(String[] args) // criado (declarado) o método executor main || "[]" = matriz
   { 
      TextFieldFrame textFieldFrame = new TextFieldFrame(); 
      textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define o padrão de operação ao fechar para sair
      textFieldFrame.setSize(375, 100); // define o tamanho do frame largura e altura
      textFieldFrame.setVisible(true); // define a visibilidade do frame como visivel
   } 
} // fim da classe TextFieldTest