// import java.awt.FlowLayout; // importação de bliblioteca.modulo.componente
import java.awt.GridLayout;
import java.awt.event.ActionListener; // importação de bliblioteca.modulo.submodulo.componente.
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

public class Calculator extends JFrame {

    private final JTextField textField1; // criado (declarado) variável do tipo JTextField || campo de texto com tamanho definido || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura
    private final JTextField textField2; // criado (declarado) variável do tipo JTextField || campo de texto com texto || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura
    
    private final JLabel label1; // declarar um atributo privado e final chamado label1 do tipo JLabel
    private final JLabel label2; // declarar um atributo privado e final chamado label2 do tipo JLabel

    private final JButton btnCalcular; // declarar um atributo privado e final chamado btnCalcular do tipo JButton
    private final JLabel lblNotificacao; // declarar um atributo privado e final chamado lblNotificacao do tipo JLabel

    // O construtor TextFieldFrame adiciona JTextFields ao JFrame
    public Calculator()
    {
       super("Caluladora de soma"); // "super" é um método para definir o título da janela com o texto do parâmetro
       setLayout(new GridLayout(3,2,5,5)); // definir layout do quadro/janela || "new" é a criação de um novo objeto
       // setLayout(new FlowLayout()); // definir layout do quadro/janela || "new" é a criação de um novo objeto
 
       // construir campo de texto com 10 colunas
       label1 = new JLabel("Digite o primeiro número:", SwingConstants.RIGHT);
       add(label1);
       textField1 = new JTextField(10); // apresentar o campo de texto com tamanho de 10 colunas ao usuário || declarar variável || "=" é igual operador de atribuição
       add(textField1); // adicionar textField1 ao JFrame
 
       // construir campo de texto com texto padrão
       label2 = new JLabel("Digite o segundo número:", SwingConstants.RIGHT);
       add(label2);
       textField2 = new JTextField(10); // apresentar o texto dentro do campo com tamanho do texto ao usuário || declarar variável || "=" é igual operador de atribuição
       add(textField2); // adicionar textField2 ao JFrame
 
       btnCalcular = new JButton("Calcular"); // criando uma nova variável chamada btnCalcular e atribuindo a ela um novo objeto. new JButton("Calcular"): Essa parte cria um novo botão (JButton) com o texto "Calcular" exibido nele
       add(btnCalcular); // adiciona o botão recém-criado a um container
       lblNotificacao = new JLabel("Reultado");
       add(lblNotificacao); // cria um novo rótulo (JLabel) vazio e o adiciona ao mesmo container que o botão

       // registrar manipuladores de eventos
       TextFieldHandler handler = new TextFieldHandler(); // Cria um objeto: Cria uma nova instância de uma classe chamada TextFieldHandler. Esta classe implementa a interface ActionListener e contém o código que será executado quando um evento de ação ocorrer em um dos TextFields
       btnCalcular.addActionListener(handler); // Registra o handler: registrar o objeto handler como um listener para os eventos de ação dos TextFields textField1. Isso significa que quando um usuário pressiona Enter em qualquer um desses campos, o método actionPerformed da classe TextFieldHandler será chamado
    } // fim do construtor TextFieldFrame
 
    // classe interna privada para manipulação de eventos
    private class TextFieldHandler implements ActionListener // definir uma classe interna e privada chamada TextFieldHandler que é responsável por lidar com eventos de ação em componentes da interface gráfica. Essa classe implementa a interface ActionListener e, portanto, deve implementar o método actionPerformed para definir a ação que será executada quando um evento ocorrer
    {
       // processar eventos de campo de texto
       @Override // Indica que este método está sobrescrevendo um método da classe pai (neste caso, da interface ActionListener)
       public void actionPerformed(ActionEvent event) // Este é o método que será chamado quando um evento de ação ocorrer em qualquer um dos JTextFields. O parâmetro event contém informações sobre o evento, incluindo qual componente o gerou
       {
          // usuário pressionou Enter em JTextField textField1
         if(textField1.getText().trim().length() == 0) {
            // notificar usuário que o campo 1 está vazio
            lblNotificacao.setText("O primeiro campo está vazio!");
            textField1.requestFocus();
         } else {
            if(textField2.getText().trim().length() == 0) {
               // notificar usuário que o campo 2 está vazio
               lblNotificacao.setText("O segundo campo está vazio!");
               textField2.requestFocus();
            } else {
               // aqui será a soma
               try {
                  int soma = Integer.valueOf(textField1.getText()) + Integer.valueOf(textField2.getText());
               lblNotificacao.setText(String.format("Resultado: %s", soma));
               } catch (Exception e) {
                  lblNotificacao.setText("Por favor digite apenas números inteiros");
               }
            }
         }
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