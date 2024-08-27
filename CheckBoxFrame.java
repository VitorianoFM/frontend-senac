// JCheckBoxes e eventos de itens.
import java.awt.*; // Conjunto de classes para criar interfaces gráficas básicas.
import java.awt.event.*; // Permite lidar com eventos gerados pela interface gráfica, como cliques de mouse e pressionamento de teclas.
import java.awt.font.*; // Fornece classes para trabalhar com fontes e formatação de texto.
import javax.swing.*; // Extende o pacote java.awt com componentes mais sofisticados para criar interfaces gráficas mais ricas.
import java.util.*; // Contém classes para diversas finalidades, como coletar dados, manipular datas e realizar operações matemáticas.

public class CheckBoxFrame extends JFrame // Define uma classe pública chamada CheckBoxFrame. Indica que essa classe herda todas as características e funcionalidades da classe JFrame, que representa uma janela em uma aplicação Java Swing.
{
   private final JTextField textField; // Declara que o campo de texto é privado, ou seja, só pode ser acessado dentro da classe. Indica que o campo de texto não pode ser reatribuído após a inicialização, ou seja, ele é constante. Declara um objeto do tipo JTextField, que é um componente gráfico utilizado para exibir e editar texto.
   private final JCheckBox boldJCheckBox; // Declara que o campo de texto é privado, ou seja, só pode ser acessado dentro da classe. Declara um objeto do tipo JCheckBox, que é um componente gráfico que permite ao usuário selecionar ou desmarcar uma opção. Nesse caso, ele será usado para selecionar o estilo negrito.
   private final JCheckBox italicJCheckBox; // Declara que o campo de texto é privado, ou seja, só pode ser acessado dentro da classe. Declara um objeto do tipo JCheckBox para selecionar o estilo itálico.
   private final JCheckBox underlinedJCheckBox; // Declara que o campo de texto é privado, ou seja, só pode ser acessado dentro da classe. Declara um objeto do tipo JCheckBox para selecionar o estilo sublinhado.

   // O construtor CheckBoxFrame adiciona JCheckBoxes ao JFrame
   public CheckBoxFrame() // Define um construtor público para a classe CheckBoxFrame. Construtor é um método especial que é chamado quando um objeto da classe é criado.
   {
      super("Teste JCheckBox"); // Chama o construtor da classe pai (JFrame) para criar a janela e define o título da janela como "JCheckBox Test".
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout. Isso significa que os componentes serão adicionados à janela na ordem em que são adicionados e serão posicionados da esquerda para a direita, quebrando para a próxima linha quando não houver mais espaço.

      // configure JTextField e defina sua fonte
      textField = new JTextField("Observe a mudança do estilo da fonte", 22); // Cria um novo objeto JTextField (campo de texto) com o texto inicial "Observe a mudança do estilo da fonte" e uma largura de 22 colunas.
      textField.setFont(new Font("Serif", Font.PLAIN, 14)); // Define a fonte do campo de texto como "Serif", com estilo normal (PLAIN) e tamanho 14.
      add(textField); // Adiciona o campo de texto à janela.

      boldJCheckBox = new JCheckBox("Bold"); // Cria uma nova caixa de seleção com o rótulo "Bold". Essa caixa será usada para controlar o estilo negrito do texto.
      italicJCheckBox = new JCheckBox("Italic"); // Cria uma nova caixa de seleção com o rótulo "Italic". Essa caixa será usada para controlar o estilo itálico do texto.
      underlinedJCheckBox = new JCheckBox("Underlined"); // Cria uma nova caixa de seleção com o rótulo "Underlined". Essa caixa será usada para controlar o estilo sublinhado do texto.
      add(boldJCheckBox); // Adiciona a caixa de seleção "Bold" à janela principal (JFrame). Isso fará com que a caixa seja exibida na interface gráfica da aplicação.
      add(italicJCheckBox); // Adiciona a caixa de seleção "Italic" à janela principal (JFrame).
      add(underlinedJCheckBox); // Adiciona a caixa de seleção "Underlined" à janela principal (JFrame).

      // registrar ouvintes para JCheckBoxes
      CheckBoxHandler handler = new CheckBoxHandler(); // Cria uma nova instância de uma classe chamada CheckBoxHandler. Essa classe (que você não mostrou o código completo) provavelmente contém o código que será executado quando o estado de uma das caixas de seleção mudar. O objeto criado é armazenado na variável handler, que servirá como um ouvinte (listener) para os eventos das caixas de seleção.
      boldJCheckBox.addItemListener(handler); // Adiciona o objeto handler como um ouvinte de eventos para a caixa de seleção boldJCheckBox. Isso significa que, sempre que o estado da caixa boldJCheckBox mudar (marcada ou desmarcada), o método itemStateChanged da classe CheckBoxHandler será chamado.
      italicJCheckBox.addItemListener(handler); // Adiciona um ouvinte: Faz o mesmo que a linha anterior, mas para a caixa de seleção italicJCheckBox.
      underlinedJCheckBox.addItemListener(handler); // Adiciona o ouvinte handler à caixa de seleção underlinedJCheckBox.
   } 

   // classe interna privada para manipulação de eventos ItemListener
   private class CheckBoxHandler implements ItemListener // Define uma classe interna privada chamada CheckBoxHandler que implementa a interface ItemListener. Essa classe será utilizada para criar um objeto que irá monitorar as mudanças de estado de um componente gráfico selecionável, como uma caixa de seleção, e executar um determinado código quando essas mudanças ocorrerem. 
   {
      // responder a eventos de caixa de seleção
      @Override // Essa anotação indica que o método está sobrescrevendo um método da classe pai. Em outras palavras, ele está redefinindo o comportamento de um método herdado.
      public void itemStateChanged(ItemEvent event) // Define um método chamado itemStateChanged que será chamado quando o estado de um item em uma lista ou combo box for alterado. Dentro desse método, é declarada uma variável font para armazenar uma fonte, mas ainda não é atribuído nenhum valor a ela.
      {
         Font font = null; // armazena a nova fonte

         // determinar quais CheckBoxes estão marcadas e criar Font
         if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected()) // // Se a caixa de seleção boldJCheckBox e a caixa de seleção italicJCheckBox estiverem selecionadas, então: Definir a fonte como "Serif", negrito e itálico, tamanho 14.
            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
         else if (boldJCheckBox.isSelected()) // Senão, se a caixa de seleção boldJCheckBox estiver selecionada, então: Definir a fonte como "Serif", negrito, tamanho 14.
            font = new Font("Serif", Font.BOLD, 14);
         else if (italicJCheckBox.isSelected()) // Senão, se a caixa de seleção italicJCheckBox estiver selecionada, então: Definir a fonte como "Serif", itálico, tamanho 14.
            font = new Font("Serif", Font.ITALIC, 14);
         else // Senão: Definir a fonte como "Serif", normal, tamanho 14.
            font = new Font("Serif", Font.PLAIN, 14);

         textField.setFont(font); // Essa linha define a fonte do campo de texto (textField) como sendo a fonte armazenada na variável font.

         if (underlinedJCheckBox.isSelected()) { // Verifica se a caixa de seleção underlinedJCheckBox está selecionada. Se sim, executa o bloco de código dentro do if.
            font = textField.getFont(); // Obtém a fonte atual do campo de texto e armazena na variável font.
            Map attributes =  font.getAttributes(); // Cria um mapa (Map) chamado attributes que armazenará atributos da fonte. Obtém os atributos da fonte atual e armazena no mapa attributes.
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON); // Adiciona um novo atributo ao mapa attributes: o atributo de sublinhado (TextAttribute.UNDERLINE) com o valor TextAttribute.UNDERLINE_ON. Isso indica que o texto deve ser sublinhado.
            textField.setFont(font.deriveFont(attributes)); // Cria uma nova fonte derivada da fonte atual (font), mas com os atributos modificados no mapa attributes. Aplica essa nova fonte ao campo de texto textField.
            font = new Font(attributes); // Cria uma nova fonte a partir dos atributos modificados no mapa attributes. Atualiza a variável font com essa nova fonte.
         }
      } 
   }
} // fim da classe CheckBoxFrame