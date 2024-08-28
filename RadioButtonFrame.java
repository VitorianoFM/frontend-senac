// Criando botões de opção usando ButtonGroup e JRadioButton.
import java.awt.*; // Conjunto de classes para criar interfaces gráficas básicas.
import java.awt.event.*; // Permite lidar com eventos gerados pela interface gráfica, como cliques de mouse e pressionamento de teclas.
import javax.swing.*; // Extende o pacote java.awt com componentes mais sofisticados para criar interfaces gráficas mais ricas.

public class RadioButtonFrame extends JFrame  // Define uma classe pública chamada RadioButtonFrame. Indica que essa classe herda todas as características e funcionalidades da classe JFrame, que representa uma janela em uma aplicação Java Swing.
{
   private JTextField textField; // usado para exibir alterações de fonte
   
   private Font plainFont; // fonte para texto simples
   private Font boldFont; // fonte para texto em negrito
   private Font italicFont; // fonte para texto itálico
   private Font boldItalicFont; // fonte para texto em negrito e itálico
  
   private JRadioButton plainJRadioButton; // seleciona texto simples
   private JRadioButton boldJRadioButton; // seleciona texto em negrito
   private JRadioButton italicJRadioButton; // seleciona texto em itálico
   private JRadioButton boldItalicJRadioButton; // negrito e itálico
   private ButtonGroup radioGroup; // grupo de botões para armazenar botões de opção

   private JRadioButton blackJRadioButton; // seleciona texto 
   private JRadioButton redJRadioButton; // seleciona texto em 
   private JRadioButton blueJRadioButton; // seleciona texto em 
   private JRadioButton yellowJRadioButton; // seleciona texto em 
   private ButtonGroup colorRadioGroup; // grupo de botões para armazenar botões de opção

   private Color blackColor; // fonte para texto simples
   private Color redColor; // Colore para texto em negrito
   private Color blueColor; // Colore para texto itálico
   private Color yellowColor; // fonte para texto em negrito e itálico
  

   // O construtor do RadioButtonFrame adiciona JRadioButtons ao JFrame
   public RadioButtonFrame()
   {
      super("Teste de RadioButton");
      setLayout(new FlowLayout()); 

      textField = new JTextField("Observe a mudança do estilo da fonte", 25);
      add(textField); // adicionar textField ao JFrame

      // criar botões de opção
      plainJRadioButton = new JRadioButton("Plain", true);
      boldJRadioButton = new JRadioButton("Bold", false);
      italicJRadioButton = new JRadioButton("Italic", false);
      boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
      add(plainJRadioButton); // adicionar botão simples ao JFrame
      add(boldJRadioButton); // adicionar botão em negrito ao JFrame
      add(italicJRadioButton); // adicionar botão itálico ao JFrame
      add(boldItalicJRadioButton); // adicionar botão negrito e itálico

      // criar relacionamento lógico entre JRadioButtons
      radioGroup = new ButtonGroup(); // criar ButtonGroup
      radioGroup.add(plainJRadioButton); // adicionar plana ao grupo
      radioGroup.add(boldJRadioButton); // adicionar negrito ao grupo
      radioGroup.add(italicJRadioButton); // adicionar itálico ao grupo
      radioGroup.add(boldItalicJRadioButton); // adicionar negrito e itálico

      blackJRadioButton = new JRadioButton("Black", true);
      redJRadioButton = new JRadioButton("Red", false);
      blueJRadioButton = new JRadioButton("Blue", false);
      yellowJRadioButton = new JRadioButton("Yellow", false);
      add(blackJRadioButton); // adicionar botão preto ao JFrame
      add(redJRadioButton); // adicionar botão em vermelho ao JFrame
      add(blueJRadioButton); // adicionar botão azul ao JFrame
      add(yellowJRadioButton); // adicionar botão amarelo e itálico

      // criar relacionamento lógico entre JRadioButtons
      colorRadioGroup = new ButtonGroup(); // criar ButtonGroup
      colorRadioGroup.add(blackJRadioButton); // adicionar preto ao grupo
      colorRadioGroup.add(redJRadioButton); // adicionar vermelho ao grupo
      colorRadioGroup.add(blueJRadioButton); // adicionar azul ao grupo
      colorRadioGroup.add(yellowJRadioButton); // adicionar amarelo e itálico

      // criar objetos de fonte
      plainFont = new Font("Serif", Font.PLAIN, 14);
      boldFont = new Font("Serif", Font.BOLD, 14);
      italicFont = new Font("Serif", Font.ITALIC, 14);
      boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
      textField.setFont(plainFont);

      blackColor = new Color(0, 0, 0);
      redColor = new Color(255, 0, 0);
      blueColor = new Color(0, 0, 255);
      yellowColor = new Color(255, 255, 0);

      // registrar eventos para JRadioButtons
      plainJRadioButton.addItemListener(
         new RadioButtonHandler(plainFont));
      boldJRadioButton.addItemListener(
         new RadioButtonHandler(boldFont));
      italicJRadioButton.addItemListener(
         new RadioButtonHandler(italicFont));
      boldItalicJRadioButton.addItemListener(
         new RadioButtonHandler(boldItalicFont));

      blackJRadioButton.addItemListener(
         new ColorRadioButtonHandler(blackColor));
      redJRadioButton.addItemListener(
         new ColorRadioButtonHandler(redColor));
      blueJRadioButton.addItemListener(
         new ColorRadioButtonHandler(blueColor));
      yellowJRadioButton.addItemListener(
         new ColorRadioButtonHandler(yellowColor));   
   } 

   // classe interna privada para manipular eventos de botão de opção
   private class RadioButtonHandler implements ItemListener 
   {
      private Font font; // fonte associada a este ouvinte

      public RadioButtonHandler(Font f)
      {
         font = f; 
      } 
   
      // manipular eventos de botão de opção
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         textField.setFont(font); 
      } 
   } 
   
   private class ColorRadioButtonHandler implements ItemListener 
   {
      private Color color;

      public ColorRadioButtonHandler(Color c)
      {
         color = c; 
      } 
   
      // manipular eventos de botão de opção
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         textField.setForeground(color); 
      } 
   } 
} // fim da classe RadioButtonFrame