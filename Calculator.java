// import java.awt.FlowLayout; // importação de bliblioteca.modulo.componente
import java.awt.GridLayout;
import java.awt.event.ActionListener; // importação de bliblioteca.modulo.submodulo.componente.
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
// import java.awt.*; // carrega todos os componentes do módulo awt da biblioteca java || sugestão do professor para evitar o erro de não carregar algum componente do módulo
// import java.awt.event*; // carrega todos os componentes do módulo awt da biblioteca java || sugestão do professor para evitar o erro de não carregar algum componente do módulo
// import javax.swing.*; // carrega todos os componentes do módulo swing da biblioteca javax || sugestão do professor para evitar o erro de não carregar algum componente do módulo

public class Calculator extends JFrame {

    private final JTextField textField1; // criado (declarado) variável do tipo JTextField || campo de texto com tamanho definido || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura
    private final JTextField textField2; // criado (declarado) variável do tipo JTextField || campo de texto com texto || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura
    private final JTextField textField3; // criado (declarado) variável do tipo JTextField || campo de texto com texto e tamanho || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura
    private final JPasswordField passwordField; // criado (declarado) variável do tipo JPasswordField || campo de senha com texto || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura
 
    private final JLabel label1; // declarar um atributo privado e final chamado label1 do tipo JLabel
    private final JLabel label2; // declarar um atributo privado e final chamado label2 do tipo JLabel
    private final JLabel label3; // declarar um atributo privado e final chamado label3 do tipo JLabel
    private final JLabel label4; // declarar um atributo privado e final chamado label4 do tipo JLabel

    // O construtor TextFieldFrame adiciona JTextFields ao JFrame
    public Calculator()
    {
       super("Testando JTextField e JPasswordField"); // "super" é um método para definir o título da janela com o texto do parâmetro
       setLayout(new GridLayout(4,2,5,5));
       // setLayout(new FlowLayout()); // definir layout do quadro/janela || "new" é a criação de um novo objeto
 
       // construir campo de texto com 10 colunas
       label1 = new JLabel("label1:", SwingConstants.RIGHT);
       add(label1);
       textField1 = new JTextField(10); // apresentar o campo de texto com tamanho de 10 colunas ao usuário || declarar variável || "=" é igual operador de atribuição
       add(textField1); // adicionar textField1 ao JFrame
 
       // construir campo de texto com texto padrão
       label2 = new JLabel("label2:", SwingConstants.RIGHT);
       add(label2);
       textField2 = new JTextField("Insira o texto aqui"); // apresentar o texto dentro do campo com tamanho do texto ao usuário || declarar variável || "=" é igual operador de atribuição
       add(textField2); // adicionar textField2 ao JFrame
 
       // construir campo de texto com texto padrão e 21 colunas
       label3 = new JLabel("label3:", SwingConstants.RIGHT);
       add(label3);
       textField3 = new JTextField("Campo de texto não editável", 21); // apresentar o texto dentro do campo com tamanho de 21 colunas ao usuário || declarar variável || "=" é igual operador de atribuição
       textField3.setEditable(false); // bloquear edição
       // textField3.setEnabled(false); // desabilitar edição e seleção
       add(textField3); // adicionar textField3 ao JFrame
 
       // construir passwordfield com texto padrão
       label4 = new JLabel("label4:", SwingConstants.RIGHT);
       add(label4);
       passwordField = new JPasswordField("Texto oculto"); // apresentar o texto em forma de asterisco ao usuário || declarar variável || "=" é igual operador de atribuição
       add(passwordField); // adicionar passwordField ao JFrame
 
       // registrar manipuladores de eventos
       TextFieldHandler handler = new TextFieldHandler(); // Cria um objeto: Cria uma nova instância de uma classe chamada TextFieldHandler. Esta classe implementa a interface ActionListener e contém o código que será executado quando um evento de ação ocorrer em um dos TextFields
       textField1.addActionListener(handler); // Registra o handler: registrar o objeto handler como um listener para os eventos de ação dos TextFields textField1. Isso significa que quando um usuário pressiona Enter em qualquer um desses campos, o método actionPerformed da classe TextFieldHandler será chamado
       textField2.addActionListener(handler); // Registra o handler: registrar o objeto handler como um listener para os eventos de ação dos TextFields textField2. Isso significa que quando um usuário pressiona Enter em qualquer um desses campos, o método actionPerformed da classe TextFieldHandler será chamado
       textField3.addActionListener(handler); // Registra o handler: registrar o objeto handler como um listener para os eventos de ação dos TextFields textField3. Isso significa que quando um usuário pressiona Enter em qualquer um desses campos, o método actionPerformed da classe TextFieldHandler será chamado
       passwordField.addActionListener(handler); // Registra o handler: registrar o objeto handler como um listener para os eventos de ação do TextFields passwordField. Isso significa que quando um usuário pressiona Enter em qualquer um desses campos, o método actionPerformed da classe TextFieldHandler será chamado
    } // fim do construtor TextFieldFrame
 
    // classe interna privada para manipulação de eventos
    private class TextFieldHandler implements ActionListener // definir uma classe interna e privada chamada TextFieldHandler que é responsável por lidar com eventos de ação em componentes da interface gráfica. Essa classe implementa a interface ActionListener e, portanto, deve implementar o método actionPerformed para definir a ação que será executada quando um evento ocorrer
    {
       // processar eventos de campo de texto
       @Override // indica que este método está sobrescrevendo um método da classe pai (neste caso, da interface ActionListener)
       public void actionPerformed(ActionEvent event) // este é o método que será chamado quando um evento de ação ocorrer em qualquer um dos JTextFields. O parâmetro event contém informações sobre o evento, incluindo qual componente o gerou
       {
          String string = ""; // Declara uma variável string do tipo String e inicializa com uma string vazia. Essa variável será usada para armazenar o texto a ser exibido na mensagem
          // usuário pressionou Enter em JTextField textField1
          if (event.getSource() == textField1) 
             string = String.format("textField1: %s",
                event.getActionCommand()); // Verifica se o componente que gerou o evento é o textField1. se for, formata uma string indicando que o evento veio do textField1 e inclui o comando da ação (geralmente o texto digitado) usando String.format. || "==" é um operador de comparação
 
                // usuário pressionou Enter em JTextField textField2
          else if (event.getSource() == textField2)
             string = String.format("textField2: %s",
                event.getActionCommand()); // Verifica se o componente que gerou o evento é o textField2. se for, formata uma string indicando que o evento veio do textField2 e inclui o comando da ação
 
          // usuário pressionou Enter em JTextField textField3
          else if (event.getSource() == textField3)
             string = String.format("textField3: %s", 
                event.getActionCommand()); // Verifica se o componente que gerou o evento é o textField3. se for, formata uma string indicando que o evento veio do textField3 e inclui o comando da ação
 
          // usuário pressionou Enter em JTextField passwordField
          else if (event.getSource() == passwordField)
             string = String.format("passwordField: %s", 
                event.getActionCommand()); // Verifica se o componente que gerou o evento é o passwordField. Se for, formata uma string indicando que o evento veio do passwordField e inclui o comando da ação
 
          // exibir conteúdo JTextField
          JOptionPane.showMessageDialog(null, string); // Exibe uma mensagem de diálogo com o conteúdo da string formada anteriormente
       } 
    } // fim da classe interna privada TextFieldHandler
    public static void main(String[] args) // criado (declarado) o método executor main || "[]" = matriz
   { 
      Calculator calculator = new Calculator(); 
      calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define o padrão de operação ao fechar para sair
      calculator.setSize(375, 180); // define o tamanho do frame largura e altura
      calculator.setVisible(true); // define a visibilidade do frame como visivel
   } 
}