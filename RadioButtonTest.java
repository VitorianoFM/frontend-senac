// Testando RadioButtonFrame.
import javax.swing.JFrame; // javax.swing: É um pacote do Java que contém classes para criar interfaces gráficas com o usuário (GUIs), como janelas, botões, campos de texto e muito mais. JFrame: É uma classe que representa uma janela básica em uma aplicação Java Swing. Ela serve como a "tela" principal onde você coloca outros componentes da interface.

public class RadioButtonTest  // Criar uma nova classe pública chamada RadioButtonTest
{
   public static void main(String[] args) // Este é o método principal do programa Java, o ponto de entrada.
   {
      RadioButtonFrame radioButtonFrame = new RadioButtonFrame(); // Cria um novo objeto da classe CheckBoxFrame, provavelmente uma janela com caixas de seleção. || Declaração de variável.
      radioButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define que ao fechar a janela, o programa será encerrado.
      radioButtonFrame.setSize(300, 135); // Define o tamanho da janela para 300 pixels de largura e 100 pixels de altura.
      radioButtonFrame.setVisible(true); // Torna a janela visível na tela.
   } 
} // fim da classe RadioButtonTest