// JLabels com texto e ícones.
import java.awt.FlowLayout; // especifica como os componentes são organizados
import javax.swing.JFrame; // fornece recursos básicos de janela
import javax.swing.JLabel; // exibe texto e imagens
import javax.swing.SwingConstants; // constantes comuns usadas com Swing
import javax.swing.Icon; // interface usada para manipular imagens
import javax.swing.ImageIcon; // carrega imagens
// import javax.*; // carrega todos os componentes do módulo swing da biblioteca javax || sugestão do professor para evitar o erro de não carregar algum componente do módulo

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
      label1 = new JLabel("Etiqueta com texto"); // apresentar o texto "fixo" ao usuário
      label1.setToolTipText("Este é o label1");  // definir o parâmetro que será visualizado ao parar com o cursor do mouse sobre o componente
      add(label1); // adicionar label1 ao JFrame

      // Construtor JLabel com argumentos de string, ícone e alinhamento
      Icon bug = new ImageIcon(getClass().getResource("bug1.png")); // instancia a variável "bug" definindo pela imagem "bug1.png" contido na pasta
      label2 = new JLabel("Etiqueta com texto e ícone", bug, 
         SwingConstants.LEFT);
      label2.setToolTipText("Este é o label2");  // definir o parâmetro que será visualizado ao parar com o cursor do mouse sobre o componente
      add(label2); // adicionar label2 ao JFrame

      label3 = new JLabel(); // Construtor JLabel sem argumentos
      label3.setText("Etiqueta com ícone e texto na parte inferior");
      label3.setIcon(bug); // adicionar ícone ao JLabel
      label3.setHorizontalTextPosition(SwingConstants.CENTER);
      label3.setVerticalTextPosition(SwingConstants.BOTTOM);
      label3.setToolTipText("Este é o label3"); // definir o parâmetro que será visualizado ao parar com o cursor do mouse sobre o componente
      add(label3); // adicionar label3 ao JFrame
   } 
} // fim da classe LabelFrame