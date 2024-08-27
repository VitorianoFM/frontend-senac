// Testando CheckBoxFrame.
import javax.swing.JFrame; // javax.swing: É um pacote do Java que contém classes para criar interfaces gráficas com o usuário (GUIs), como janelas, botões, campos de texto e muito mais. JFrame: É uma classe que representa uma janela básica em uma aplicação Java Swing. Ela serve como a "tela" principal onde você coloca outros componentes da interface.
// import javax.swing.*; // carrega todos os componentes do módulo swing da biblioteca javax || sugestão do professor para evitar o erro de não carregar algum componente do módulo

public class CheckBoxTest // Criar uma nova classe pública chamada CheckBoxTest.
{
   public static void main(String[] args) // Este é o método principal do programa Java, o ponto de entrada.
   { 
      CheckBoxFrame checkBoxFrame = new CheckBoxFrame(); // Cria um novo objeto da classe CheckBoxFrame, provavelmente uma janela com caixas de seleção.
      checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define que ao fechar a janela, o programa será encerrado.
      checkBoxFrame.setSize(285, 100); // Define o tamanho da janela para 285 pixels de largura e 100 pixels de altura.
      checkBoxFrame.setVisible(true); // Torna a janela visível na tela.
   } 
} // fim da classe CheckBoxTest