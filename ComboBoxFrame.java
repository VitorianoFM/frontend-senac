// JComboBox que exibe uma lista de nomes de imagens.
import java.awt.*; // Conjunto de classes para criar interfaces gráficas básicas.
import java.awt.event.*; // Permite lidar com eventos gerados pela interface gráfica, como cliques de mouse e pressionamento de teclas.
import javax.swing.*; // Extende o pacote java.awt com componentes mais sofisticados para criar interfaces gráficas mais ricas.

public class ComboBoxFrame extends JFrame // Define uma classe pública chamada ComboBoxFrame. Indica que essa classe herda todas as características e funcionalidades da classe JFrame, que representa uma janela em uma aplicação Java Swing.
{
    private final JComboBox<String> imagesJComboBox; // Caixa de combinação final e privada para armazenar os nomes dos ícones.
    private final JLabel label; // Rótulo final e privado para exibir o ícone selecionado.

    private static final String[] names = 
        {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif", "bugdog.gif"}; // cria uma matriz estática privada de strings chamada 'names', contendo os nomes de quatro arquivos GIF: 'bug1.gif', 'bug2.gif', 'travelbug.gif', 'buganim.gif' e 'bugdog.gif'. 
    private final Icon[] icons = { 
        new ImageIcon(getClass().getResource(names[0])),
        new ImageIcon(getClass().getResource(names[1])), 
        new ImageIcon(getClass().getResource(names[2])),
        new ImageIcon(getClass().getResource(names[3])),
        new ImageIcon(getClass().getResource(names[4]))}; // Declara um array privado e final de ícones chamado 'icons', contendo quatro ícones carregados a partir de arquivos de imagem especificados nos nomes do array 'names'.

   // O construtor ComboBoxFrame adiciona JComboBox ao JFrame
    public ComboBoxFrame() // Define um construtor público para a classe ComboBoxFrame. Construtor é um método especial que é chamado quando um objeto da classe é criado.
    {
        super("Testando JComboBox"); // Chama o construtor da classe pai (JFrame) para criar a janela e define o título da janela como "JCheckBox Test".
        setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout. Isso significa que os componentes serão adicionados à janela na ordem em que são adicionados e serão posicionados da esquerda para a direita, quebrando para a próxima linha quando não houver mais espaço.

        imagesJComboBox = new JComboBox<String>(names); // imagesJComboBox: Cria uma nova instância de um componente JComboBox (caixa de combinação) e a armazena na variável imagesJComboBox. Um JComboBox permite ao usuário selecionar um item de uma lista. new JComboBox<String>(names): Inicializa o JComboBox com uma lista de strings. A lista de strings é armazenada no array "names". Cada string da lista será exibida como uma opção no JComboBox.
        imagesJComboBox.setMaximumRowCount(3); // Define o número máximo de linhas visíveis no JComboBox para 3. Isso significa que apenas 3 opções serão visíveis ao mesmo tempo na caixa de combinação. Se houver mais opções, o usuário precisará rolar a lista para vê-las.

        imagesJComboBox.addItemListener(
            new ItemListener() // adiciona um ouvinte de eventos ao componente 'imagesJComboBox'. Isso significa que, quando o usuário selecionar uma nova imagem na lista, o código dentro do ouvinte será executado.
            {
                // manipular evento JComboBox
                @Override
                public void itemStateChanged(ItemEvent event) // Método está sendo sobrescrito (redefinido) de uma classe pai. O método itemStateChanged é geralmente usado para lidar com eventos de mudança de estado em componentes de interface gráfica, como caixas de seleção, botões de rádio ou listas. Quando o estado de um desses componentes muda (por exemplo, uma caixa de seleção é marcada ou desmarcada), o método itemStateChanged é chamado.
                {
                    // determinar se o item selecionado
                    if (event.getStateChange() == ItemEvent.SELECTED) // Verifica se o estado da mudança do evento (provavelmente um evento de seleção em um componente GUI) é igual a ItemEvent.SELECTED. Se for verdadeiro, significa que um item foi selecionado.
                        label.setIcon(icons[
                            imagesJComboBox.getSelectedIndex()]); // Se a condição acima for verdadeira, define o ícone do rótulo (label) para o ícone correspondente ao índice selecionado na caixa de combinação de imagens (imagesJComboBox). O índice selecionado é obtido usando o método getSelectedIndex(). O array icons provavelmente contém uma lista de ícones que podem ser selecionados na caixa de combinação.
                } 
            } // fim da classe interna anônima
        ); // fim da chamada para addItemListener

        add(imagesJComboBox); // Adiciona o componente imagesJComboBox a um container (um componente que pode conter outros componentes).
        label = new JLabel(icons[0]); // Cria um novo rótulo (label) e define a imagem inicial como o primeiro elemento do array icons.
        add(label); // Adiciona o rótulo recém-criado ao container.
    }
} // fim da classe ComboBoxFrame