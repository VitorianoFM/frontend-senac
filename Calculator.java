// import java.awt.FlowLayout; // importação de bliblioteca.modulo.componente
import java.awt.GridLayout;
import java.awt.event.ActionListener; // importação de bliblioteca.modulo.submodulo.componente.
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
// import javax.swing.JPasswordField;
// import javax.swing.JOptionPane;
// import java.awt.*; // carrega todos os componentes do módulo awt da biblioteca java || sugestão do professor para evitar o erro de não carregar algum componente do módulo
// import java.awt.event*; // carrega todos os componentes do módulo awt da biblioteca java || sugestão do professor para evitar o erro de não carregar algum componente do módulo
// import javax.swing.*; // carrega todos os componentes do módulo swing da biblioteca javax || sugestão do professor para evitar o erro de não carregar algum componente do módulo
// import java.util.*; // carrega todos os componentes do módulo swing da biblioteca java || sugestão do professor para evitar o erro de não carregar algum componente do módulo

public class Calculator extends JFrame {

    private final JTextField textField1; // criado (declarado) variável do tipo JTextField || campo de texto com tamanho definido || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura
    private final JTextField textField2; // criado (declarado) variável do tipo JTextField || campo de texto com texto || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura
    
    private final JLabel label1; // declarar um atributo privado e final chamado label1 do tipo JLabel
    private final JLabel label2; // declarar um atributo privado e final chamado label2 do tipo JLabel

    private final JButton btnCalcular; // declarar um atributo privado e final chamado btnCalcular do tipo JButton
    private final JLabel lblNotificacao; // declarar um atributo privado e final chamado lblNotificacao do tipo JLabel

    private final String[] numeros = {"1","2","3","4","5","6","7","8","9","0"};

    // O construtor TextFieldFrame adiciona JTextFields ao JFrame
    public Calculator()
    {
       super("Caluladora de soma"); // "super" é um método para definir o título da janela com o texto do parâmetro
       setLayout(new GridLayout(3,2,5,5)); // definir layout do quadro/janela || "new" é a criação de um novo objeto
       // setLayout(new FlowLayout()); // definir layout do quadro/janela || "new" é a criação de um novo objeto
 
       // construir campo de texto com 10 colunas
       label1 = new JLabel("Digite o primeiro número:", SwingConstants.RIGHT);
       add(label1); // adicionar label1 ao JFrame
       textField1 = new JTextField(10); // apresentar o campo de texto com tamanho de 10 colunas ao usuário || declarar variável || "=" é igual operador de atribuição
         textField1.setColumns(10);
       add(textField1); // adicionar textField1 ao JFrame
 
       // construir campo de texto com texto padrão
       label2 = new JLabel("Digite o segundo número:", SwingConstants.RIGHT);
       add(label2); // adicionar label2 ao JFrame
       textField2 = new JTextField(10); // apresentar o texto dentro do campo com tamanho do texto ao usuário || declarar variável || "=" é igual operador de atribuição
       add(textField2); // adicionar textField2 ao JFrame
 
       btnCalcular = new JButton("Calcular"); // criando uma nova variável chamada btnCalcular e atribuindo a ela um novo objeto. new JButton("Calcular"): Essa parte cria um novo botão (JButton) com o texto "Calcular" exibido nele
       add(btnCalcular); // adiciona o botão recém-criado a um container
       lblNotificacao = new JLabel("Reultado");
       add(lblNotificacao); // cria um novo rótulo (JLabel) vazio e o adiciona ao mesmo container que o botão

       // registrar manipuladores de eventos
       TextFieldHandler handler = new TextFieldHandler(); // Cria um objeto: Cria uma nova instância de uma classe chamada TextFieldHandler. Esta classe implementa a interface ActionListener e contém o código que será executado quando um evento de ação ocorrer em um dos TextFields
       btnCalcular.addActionListener(handler); // Registra o handler: registrar o objeto handler como um listener para os eventos de ação dos TextFields textField1. Isso significa que quando um usuário pressiona Enter em qualquer um desses campos, o método actionPerformed da classe TextFieldHandler será chamado
       textField1.addKeyListener(new KeyAdapter() { // Adiciona um ouvinte de eventos de teclado ao componente textField1. Isso significa que, sempre que uma tecla for pressionada nesse campo, o código dentro do ouvinte será executado. Cria um novo objeto da classe KeyAdapter. Essa classe é uma classe abstrata que implementa a interface KeyListener. Ao estender essa classe, você precisa sobrescrever apenas os métodos que te interessam, neste caso, o método keyReleased.
         @Override // Indica que este método está sobrescrevendo um método da classe pai (neste caso, da classe KeyAdapter).
         public void keyReleased(KeyEvent e) { // Este método é chamado sempre que uma tecla é solta no campo de texto. O parâmetro e contém informações sobre o evento de teclado.
            if (textField1.getText().length() > 9) { // Verifica se o comprimento do texto atual no campo textField1 é maior que 10 caracteres.
               String txtTextField1 = textField1.getText(); // Cria uma cópia do texto atual do campo.
               textField1.setText(txtTextField1.substring(0, 9)); // Define o texto do campo para os primeiros 9 caracteres da cópia, efetivamente truncando o texto.
               lblNotificacao.setText("Campo1 está limitado a apenas 9 números inteiros"); // Exibe uma mensagem de notificação informando o usuário sobre a limitação.
            }
         }
       });
       
       textField2.addKeyListener(new KeyAdapter() { // Adiciona um ouvinte de eventos de teclado ao componente textField1. Isso significa que, sempre que uma tecla for pressionada nesse campo, o código dentro do ouvinte será executado. Cria um novo objeto da classe KeyAdapter. Essa classe é uma classe abstrata que implementa a interface KeyListener. Ao estender essa classe, você precisa sobrescrever apenas os métodos que te interessam, neste caso, o método keyReleased.
         @Override // Indica que este método está sobrescrevendo um método da classe pai (neste caso, da classe KeyAdapter).
         public void keyReleased(KeyEvent e) { // Este método é chamado sempre que uma tecla é solta no campo de texto. O parâmetro e contém informações sobre o evento de teclado.
            if (textField2.getText().length() > 9) { // Verifica se o comprimento do texto atual no campo textField2 é maior que 10 caracteres.
               String txtTextField2 = textField2.getText(); // Cria uma cópia do texto atual do campo.
               textField2.setText(txtTextField2.substring(0, 9)); // Define o texto do campo para os primeiros 9 caracteres da cópia, efetivamente truncando o texto.
               lblNotificacao.setText("Campo2 está limitado a apenas 9 números inteiros"); // Exibe uma mensagem de notificação informando o usuário sobre a limitação.
            }
         }
       });
    } // fim do construtor TextFieldFrame
 
    // classe interna privada para manipulação de eventos
    private class TextFieldHandler implements ActionListener // definir uma classe interna e privada chamada TextFieldHandler que é responsável por lidar com eventos de ação em componentes da interface gráfica. Essa classe implementa a interface ActionListener e, portanto, deve implementar o método actionPerformed para definir a ação que será executada quando um evento ocorrer
    {
       // processar eventos de campo de texto
       @Override // Indica que este método está sobrescrevendo um método da classe pai (neste caso, da interface ActionListener)
       public void actionPerformed(ActionEvent event) // Este é o método que será chamado quando um evento de ação ocorrer em qualquer um dos JTextFields. O parâmetro event contém informações sobre o evento, incluindo qual componente o gerou
       {
         // usuário pressionou Enter em JTextField textField1
         if(textField1.getText().trim().length() == 0) { // Obtém o texto que está atualmente no campo textField1. Remove qualquer espaço em branco no início ou no final da string. Verifica se o comprimento da string resultante após o trim é zero. Se for, significa que o campo está vazio.
            // notificar usuário que o campo 1 está vazio
            lblNotificacao.setText("O primeiro campo está vazio!"); // Se o primeiro campo estiver vazio, o rótulo lblNotificacao é atualizado com a mensagem de erro e o foco é direcionado para o campo textField1 para que o usuário possa preencher o campo.
            textField1.requestFocus();
         } else {
            if(textField2.getText().trim().length() == 0) { // Obtém o texto que está atualmente no campo textField1. Remove qualquer espaço em branco no início ou no final da string. Verifica se o comprimento da string resultante após o trim é zero. Se for, significa que o campo está vazio.
               // notificar usuário que o campo 2 está vazio
               lblNotificacao.setText("O segundo campo está vazio!"); // Se o primeiro campo estiver vazio, o rótulo lblNotificacao é atualizado com a mensagem de erro e o foco é direcionado para o campo textField1 para que o usuário possa preencher o campo.
               textField2.requestFocus();
            } else { // Indica que este bloco será executado se a condição do if anterior (campos vazios) for falsa, ou seja, se ambos os campos estiverem preenchidos.
               // aqui será a soma
               try { // Inicia um bloco de código que pode lançar uma exceção.
                  textField1.setText(somenteNumeros(textField1.getText())); // Obtém o texto do textField1. Chama a função somenteNumeros para remover quaisquer caracteres não numéricos do texto. Atribui o texto limpo de volta ao textField1.
                  textField2.setText(somenteNumeros(textField2.getText())); // Obtém o texto do textField2. Chama a função somenteNumeros para remover quaisquer caracteres não numéricos do texto. Atribui o texto limpo de volta ao textField2.
                  int soma = Integer.valueOf(textField1.getText()) + Integer.valueOf(textField2.getText()); // Converte o texto dos campos para números inteiros usando Integer. valueOf. Realiza a soma dos dois números e armazena o resultado na variável soma.
                  lblNotificacao.setText(String.format("Resultado: %s", soma)); // Formata uma string com o resultado da soma e exibe essa string no rótulo lblNotificacao.
               } catch (Exception e) { // Captura qualquer exceção que possa ser lançada durante a execução do bloco try.
                  lblNotificacao.setText("Por favor digite apenas números inteiros"); // Se ocorrer uma exceção (provavelmente uma NumberFormatException se o usuário digitou algo que não é um número), exibe uma mensagem de erro no rótulo.
               }
            }
         }
       } 
    
    public String somenteNumeros(String strTexto) { // Define um método público chamado somenteNumeros que recebe uma string como entrada e retorna uma string como resultado.
      boolean achouNumero; // é um booleano usado para indicar se o caractere atual é um número.
      ArrayList<String> caracteresEncontrados = new ArrayList<String>(); // é uma lista de strings que armazenará os caracteres não numéricos encontrados.
       for (int c = 0; c < strTexto.length(); c++) { // Percorre cada caractere da string strTexto.
          String caracterTemp = strTexto.substring(c,c+1); // Extrai o caractere atual da string.
          achouNumero = false;
          for (int n = 0; n < numeros.length; n++) { // Percorre cada número do array numeros. Compara o caractere atual com cada número. Se encontrar uma correspondência, marca achouNumero como verdadeiro e sai do loop interno (usando break).
             if (caracterTemp.equals(numeros[n])) {
                achouNumero = true;
                break;
             }
          }
       if (achouNumero) {
          continue;
       } else {
          caracteresEncontrados.add(caracterTemp); // Se achouNumero for falso, adiciona o caractere não numérico à lista caracteresEncontrados.
       }
    }
    for (int c = 0; c < caracteresEncontrados.size(); c++) { // Percorre a lista de caracteres não numéricos.
       strTexto = strTexto.replace(caracteresEncontrados.get(c), ""); // Para cada caractere não numérico, remove todas as ocorrências desse caractere da string original strTexto usando o método replace.
    }
    return strTexto; // Retorna a string resultante com todos os caracteres não numéricos removidos.
   }
   } // fim da classe interna privada TextFieldHandler
    public static void main(String[] args) // criado (declarado) o método executor main || "[]" = matriz
   { 
      Calculator calculator = new Calculator(); 
      calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define o padrão de operação ao fechar para sair
      calculator.setSize(500, 180); // define o tamanho do frame largura e altura
      calculator.setVisible(true); // define a visibilidade do frame como visivel
   } 
}