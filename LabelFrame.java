// JLabels com texto e ícones.
import java.awt.FlowLayout; // especifica como os componentes são organizados
import javax.swing.JFrame; // fornece recursos básicos de janela
import javax.swing.JLabel; // exibe texto e imagens
import javax.swing.SwingConstants; // constantes comuns usadas com Swing
import javax.swing.Icon; // interface usada para manipular imagens
import javax.swing.ImageIcon; // carrega imagens

public class LabelFrame extends JFrame 
{
   private final JLabel label1; // JLabel com apenas texto
   private final JLabel label2; // JLabel construído com texto e ícone
   private final JLabel label3; // JLabel com texto e ícone adicionados

   // O construtor LabelFrame adiciona JLabels ao JFrame
   public LabelFrame()
   {
      super("Testing JLabel");
      setLayout(new FlowLayout()); // definir layout do quadro

      // Construtor JLabel com um argumento de string
      label1 = new JLabel("Label with text");
      label1.setToolTipText("This is label1");
      add(label1); // adicionar label1 ao JFrame

      // Construtor JLabel com argumentos de string, ícone e alinhamento
      Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
      label2 = new JLabel("Label with text and icon", bug, 
         SwingConstants.LEFT);
      label2.setToolTipText("This is label2");
      add(label2); // adicionar label2 ao JFrame

      label3 = new JLabel(); // Construtor JLabel sem argumentos
      label3.setText("Label with icon and text at bottom");
      label3.setIcon(bug); // adicionar ícone ao JLabel
      label3.setHorizontalTextPosition(SwingConstants.CENTER);
      label3.setVerticalTextPosition(SwingConstants.BOTTOM);
      label3.setToolTipText("This is label3");
      add(label3); // adicionar label3 ao JFrame
   } 
} // fim da classe LabelFrame