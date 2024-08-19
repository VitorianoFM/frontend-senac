// JLabels com texto e ícones.
import java.awt.FlowLayout; // especifica como os componentes são organizados
import javax.swing.JFrame; // fornece recursos básicos de janela
import javax.swing.JLabel; // exibe texto e imagens
import javax.swing.SwingConstants; // constantes comuns usadas com Swing
import javax.swing.Icon; // interface usada para manipular imagens
import javax.swing.ImageIcon; // carrega imagens
// import java.awt.*; // carrega todos os componentes do módulo awt da biblioteca java || sugestão do professor para evitar o erro de não carregar algum componente do módulo
// import javax.swing.*; // carrega todos os componentes do módulo swing da biblioteca javax || sugestão do professor para evitar o erro de não carregar algum componente do módulo

public class LabelFrame extends JFrame 
{
   private final JLabel label1; // JLabel com apenas texto || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura
   private final JLabel label2; // JLabel construído com texto e ícone || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura
   private final JLabel label3; // JLabel com texto e ícone adicionados || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura

   // O método construtor LabelFrame adiciona JLabels ao JFrame
   public LabelFrame()
   {
      super("Testando JLabel"); // "super" é um método para definir o título da janela com o texto do parâmetro
      setLayout(new FlowLayout()); // definir layout do quadro/janela || "new" é a criação de um novo objeto

      // Construtor JLabel com um argumento de string
      label1 = new JLabel("Etiqueta com texto"); // apresentar o texto "fixo" ao usuário || declarar variável || "=" é igual operador de atribuição
      label1.setToolTipText("Este é o label1");  // definir o parâmetro que será visualizado ao parar com o cursor do mouse sobre o componente
      add(label1); // adicionar label1 ao JFrame

      // Construtor JLabel com argumentos de string, ícone e alinhamento
      Icon bug = new ImageIcon(getClass().getResource("bug1.png")); // declarar a variável "bug" definindo pela imagem "bug1.png" contido na pasta || "." é igual operador de invocador de método
      label2 = new JLabel("Etiqueta com texto e ícone", bug, // declarar variável atribuindo os parâmetros String/texto e bug || atribuição de valor a variável || "," serve para separar parâmetros
         SwingConstants.LEFT); // realizar o alinhamento do parâmetro bug para esquerda
      label2.setToolTipText("Este é o label2");  // definir o parâmetro que será visualizado ao parar com o cursor do mouse sobre o componente
      add(label2); // adicionar label2 ao JFrame

      label3 = new JLabel(); // Construtor JLabel sem argumentos || declarar variável || "=" é igual operador de atribuição
      label3.setText("Etiqueta com ícone e texto na parte inferior");  // definir o parâmetro String/texto || adicionar texto ao JLabel
      label3.setIcon(bug); // atribuir o objeto bug do tipo Icon || adicionar ícone ao JLabel
      label3.setHorizontalTextPosition(SwingConstants.CENTER); // realizar o alinhamento horizontal do parâmetro para centralizado
      label3.setVerticalTextPosition(SwingConstants.BOTTOM); // realizar o alinhamento vertical do parâmetro para baixo
      label3.setToolTipText("Este é o label3"); // definir o parâmetro que será visualizado ao parar com o cursor do mouse sobre o componente
      add(label3); // adicionar label3 ao JFrame
   } 
} // fim da classe LabelFrame