// JList que exibe uma lista de cores.
import java.awt.*; // Conjunto de classes para criar interfaces gráficas básicas.
import javax.swing.*; // Extende o pacote java.awt com componentes mais sofisticados para criar interfaces gráficas mais ricas.
import javax.swing.event.*; // Permite que você use essas classes para criar componentes gráficos e lidar com os eventos que ocorrem nesses componentes.

public class ListFrame extends JFrame // Define uma classe pública chamada ListFrame. Indica que essa classe herda todas as características e funcionalidades da classe JFrame, que representa uma janela em uma aplicação Java Swing.
{
   private final JList<String> colorJList; // Declara uma variável chamada colorJList que armazenará uma lista de cores em formato de texto. Essa lista será exibida visualmente na interface do usuário como um componente gráfico do tipo JList.
   private static final String[] colorNames = {"Preto", "Azul", "Ciano",
   "Cinza Escuro", "Cinza", "Verde", "Cinza Claro", "Magenta",
   "Laranja", "Rosa", "Vermelho", "Branco", "Amarelo"}; // Declara um array (vetor) privado, estático e final de strings, chamado colorNames. Esse array contém uma lista de nomes de cores.
   private static final Color[] colors = {Color.BLACK, Color.BLUE,
      Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
      Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
      Color.RED, Color.WHITE, Color.YELLOW}; // Cria uma matriz constante privada chamada cores que armazena um conjunto predefinido de cores. Essas cores podem ser acessadas em qualquer lugar dentro da classe usando cores[indice], onde indice é um número inteiro representando o índice da cor desejada na matriz (por exemplo, cores[0] para preto).

   // Construtor ListFrame adiciona JScrollPane contendo JList ao JFrame
   public ListFrame() // Define um construtor público para a classe ComboBoxFrame. Construtor é um método especial que é chamado quando um objeto da classe é criado.
   {
      super("Teste de Lista"); // Chama o construtor da classe pai (JFrame) para criar a janela e define o título da janela como "JCheckBox Test".
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout. Isso significa que os componentes serão adicionados à janela na ordem em que são adicionados e serão posicionados da esquerda para a direita, quebrando para a próxima linha quando não houver mais espaço.

      colorJList = new JList<String>(colorNames); // Cria uma lista visual (um componente gráfico) onde serão exibidos os nomes das cores contidos na variável colorNames. O usuário poderá ver e selecionar esses nomes da lista.
      colorJList.setVisibleRowCount(5); // Controla a aparência visual da lista de cores, limitando o número de itens visíveis na tela e tornando a interface mais organizada e fácil de usar.
      
      // não permitir seleções múltiplas
      colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Garante que o usuário só possa escolher uma cor por vez na lista.

      // adicione um JScrollPane contendo JList ao quadro
      add(new JScrollPane(colorJList)); // Cria uma barra de rolagem e a adicionando à interface do seu programa Java. Essa barra de rolagem estará associada à lista de cores, permitindo que o usuário role a lista se ela for maior do que a área visível.

      colorJList.addListSelectionListener(
         new ListSelectionListener() // Adiciona um ouvinte de seleção de lista (ListSelectionListener) ao componente JList chamado colorJList. Um ouvinte de seleção de lista é um objeto que é notificado quando um item na lista é selecionado ou desselecionado.
         {   
            // manipular eventos de seleção de lista
            @Override // Essa anotação indica que o método está sobrescrevendo um método da classe pai. Em outras palavras, ele está redefinindo o comportamento de um método herdado.
            public void valueChanged(ListSelectionEvent event) // Atualiza a interface do usuário quando um item é selecionado em uma lista. Por exemplo, se um usuário seleciona um item em uma lista de produtos, o método valueChanged pode ser usado para exibir os detalhes do produto selecionado.
            {
               getContentPane().setBackground(
                  colors[colorJList.getSelectedIndex()]); // Define a cor de fundo do componente principal da janela (o getContentPane()) para a cor selecionada na lista de cores (colors[colorJList.getSelectedIndex()]).
            } 
         } 
      ); 
   } 
} // fim da classe ListFrame