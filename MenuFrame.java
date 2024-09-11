// Demonstrating menus.
import java.awt.*; // É uma biblioteca mais antiga do Java, que oferece um conjunto básico de classes para criar componentes visuais como botões, rótulos, janelas e outros elementos gráficos.
import java.awt.event.*; // Este pacote contém interfaces que permitem que sua aplicação responda a eventos do usuário, como cliques de mouse, pressionamento de teclas, etc.
import javax.swing.*; // É uma biblioteca mais moderna do Java que oferece componentes visuais mais ricos e personalizáveis em comparação com o AWT. Ela foi construída sobre o AWT, mas oferece uma API mais fácil de usar e componentes com melhor aparência.

public class MenuFrame extends JFrame // Definir uma nova classe chamada MenuFrame que estende a classe JFrame. Cria uma nova classe chamada MenuFrame que pode ser usada para criar uma janela com um menu em uma aplicação Java.
{
   private final Color[] colorValues = 
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW}; // cria uma lista fixa de cores que será utilizada dentro da classe. Essas cores podem ser usadas para pintar elementos gráficos, como linhas, formas ou texto, em uma aplicação Java.
   private final JRadioButtonMenuItem[] colorItems; // Declara um array privado e final chamado colorItems. Esse array será usado para armazenar uma coleção de itens de menu do tipo JRadioButtonMenuItem. Esses itens de menu, quando adicionados a um menu, geralmente representam opções de cores que o usuário pode selecionar.
   private final JRadioButtonMenuItem[] fonts; // Declara um array privado e final de itens de menu de rádio que serão utilizados para representar diferentes fontes em uma aplicação Java com interface gráfica (GUI).
   private final JCheckBoxMenuItem[] styleItems; // Cria um conjunto fixo de itens de menu com caixas de seleção, que serão utilizados para controlar diferentes estilos ou opções dentro do programa. Esses itens de menu não podem ser modificados após a sua criação e só podem ser acessados dentro da classe onde foram declarados.
   private final JLabel displayJLabel; // Cria um componente visual (o rótulo) que será usado para mostrar alguma informação na tela. Como é privado e final, esse rótulo só poderá ser configurado uma vez, dentro da classe onde foi declarado, e seu conteúdo não poderá ser alterado depois disso.
   private final ButtonGroup fontButtonGroup; // Declara um grupo de botões de rádio que será usado para escolher diferentes fontes em um aplicativo Java. Esse grupo de botões é privado, ou seja, só pode ser usado dentro da classe onde foi criado, e é final, ou seja, não pode ser alterado após sua criação.
   private final ButtonGroup colorButtonGroup; // Cria um grupo de botões de rádio privado e final (não modificável) dentro da classe. Esse grupo será utilizado para permitir que o usuário selecione uma cor entre várias opções, sendo que apenas uma cor pode ser escolhida por vez.
   private int style; // Cria uma variável interna à classe, que armazena um número inteiro e serve para controlar algum tipo de estilo ou configuração dentro do programa.

   // construtor sem argumentos configura GUI
   public MenuFrame()
   {
      super("Using JMenus");     

      JMenu fileMenu = new JMenu("File"); // criar menu de arquivo
      fileMenu.setMnemonic('F'); // definir mnemônico para F

      // criar Sobre... item de menu
      JMenuItem aboutItem = new JMenuItem("About...");
      aboutItem.setMnemonic('A'); // definir mnemônico para A
      fileMenu.add(aboutItem); // adicionar item sobre ao menu de arquivo
      aboutItem.addActionListener(
         new ActionListener() // classe interna anônima
         {  
            // exibir caixa de diálogo de mensagem quando o usuário selecionar Sobre...
            @Override
            public void actionPerformed(ActionEvent event)
            {
               JOptionPane.showMessageDialog(MenuFrame.this,
                  "This is an example\nof using menus",
                  "About", JOptionPane.PLAIN_MESSAGE);
            } 
         } 
      ); 
 
      JMenuItem exitItem = new JMenuItem("Exit"); // criar item de saída
      exitItem.setMnemonic('x'); // definir mnemônico para x
      fileMenu.add(exitItem); // adicionar item de saída ao menu de arquivo
      exitItem.addActionListener(
         new ActionListener() // classe interna anônima
         {  
            // encerrar o aplicativo quando o usuário clicar em exitItem
            @Override
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0); // sair do aplicativo
            } 
         }
      ); 

      JMenuBar bar = new JMenuBar(); // criar barra de menu
      setJMenuBar(bar); // adicionar barra de menu ao aplicativo
      bar.add(fileMenu); // adicionar menu de arquivo à barra de menu

      JMenu formatMenu = new JMenu("Format"); // criar menu de formato
      formatMenu.setMnemonic('r'); // definir mnemônico para r

      // lista de cores de strings de matriz
      String[] colors = {"Black", "Blue", "Red", "Green", "Yellow"};

      JMenu colorMenu = new JMenu("Color"); // criar menu de cores
      colorMenu.setMnemonic('C'); // definir mnemônico para C

      // criar itens de menu de botões de opção para cores
      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup(); // gerencia cores
      ItemHandler itemHandler = new ItemHandler(); // manipulador de cores

      // criar itens de menu de botões de opção coloridos
      for (int count = 0; count < colors.length; count++) 
      {
         colorItems[count] = 
            new JRadioButtonMenuItem(colors[count]); // criar item
         colorMenu.add(colorItems[count]); // adicionar item ao menu de cores
         colorButtonGroup.add(colorItems[count]); // adicionar ao grupo
         colorItems[count].addActionListener(itemHandler);
      }

      colorItems[0].setSelected(true); // selecione o primeiro item de cor

      formatMenu.add(colorMenu); // adicionar menu de cores ao menu de formato
      formatMenu.addSeparator(); // adicionar separador no menu

      // lista de matriz de nomes de fontes
      String[] fontNames = {"Serif", "Monospaced", "SansSerif", "Verdana"};
      JMenu fontMenu = new JMenu("Font"); // criar menu de fontes
      fontMenu.setMnemonic('n'); // definir mnemônico para n

      // crie itens de menu de botões de opção para nomes de fontes
      fonts = new JRadioButtonMenuItem[fontNames.length];
      fontButtonGroup = new ButtonGroup(); // gerencia nomes de fontes

      // criar itens de menu de botão de opção de fonte
      for (int count = 0; count < fonts.length; count++) 
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
         fontMenu.add(fonts[count]); // adicionar fonte ao menu de fontes
         fontButtonGroup.add(fonts[count]); // adicionar ao grupo de botões
         fonts[count].addActionListener(itemHandler); // adicionar manipulador
      } 

      fonts[0].setSelected(true); // selecione o primeiro item do menu Fonte
      fontMenu.addSeparator(); // adicionar barra separadora ao menu de fontes

      String[] styleNames = {"Bold", "Italic"}; // nomes de estilos
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler(); // manipulador de estilo

      // criar itens de menu de caixa de seleção de estilo
      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = 
            new JCheckBoxMenuItem(styleNames[count]); // para estilo
         fontMenu.add(styleItems[count]); // adicionar ao menu de fontes
         styleItems[count].addItemListener(styleHandler); // manipulador
      }

      formatMenu.add(fontMenu); // adicionar menu Fonte ao menu Formato
      bar.add(formatMenu); // adicionar menu Formatar à barra de menu
     
      // configurar rótulo para exibir texto
      displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
      displayJLabel.setForeground(colorValues[0]);
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));

      getContentPane().setBackground(Color.CYAN); // definir plano de fundo
      add(displayJLabel, BorderLayout.CENTER); // adicionar displayJLabel
   } // fim Construtor MenuFrame

   // classe interna para manipular eventos de ação de itens de menu
   private class ItemHandler implements ActionListener 
   {
      // seleção de cores e fontes do processo
      @Override
      public void actionPerformed(ActionEvent event)
      {
         // seleção de cores do processo
         for (int count = 0; count < colorItems.length; count++)
         {
            if (colorItems[count].isSelected()) 
            {
               displayJLabel.setForeground(colorValues[count]);
               break;
            } 
         } 

         // processo de seleção de fonte
         for (int count = 0; count < fonts.length; count++)
         {
            if (event.getSource() == fonts[count]) 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, 72));
            }
         }

         repaint(); // redesenhar aplicação
      } 
   } // fim da classe ItemHandler

   // classe interna para manipular eventos de itens de itens de menu de caixa de seleção
   private class StyleHandler implements ItemListener 
   {
      // processar seleções de estilo de fonte
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         String name = displayJLabel.getFont().getName(); // Fonte atual
         Font font; // nova fonte com base nas seleções do usuário

         // determinar quais caixas de seleção estão marcadas e criar fonte
         if (styleItems[0].isSelected() && 
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, 72);
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, 72);
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, 72);
         else
            font = new Font(name, Font.PLAIN, 72);

         displayJLabel.setFont(font);
         repaint(); // redesenhar aplicação
      } 
   } // fim da classe StyleHandler
} // fim da aula MenuFrame