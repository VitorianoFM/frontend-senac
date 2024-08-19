// JTextFields e JPasswordFields.
import java.awt.FlowLayout; // importação de bliblioteca.modulo.componente
import java.awt.event.ActionListener; // importação de bliblioteca.modulo.componente.
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
// import java.awt.*; // carrega todos os componentes do módulo awt da biblioteca java || sugestão do professor para evitar o erro de não carregar algum componente do módulo
// import javax.swing.*; // carrega todos os componentes do módulo swing da biblioteca javax || sugestão do professor para evitar o erro de não carregar algum componente do módulo

public class TextFieldFrame extends JFrame // criado (declarado) a classe TextFieldFrame herdada do JFrame
{
   private final JTextField textField1; // criado (declarado) variável do tipo JTextField || campo de texto com tamanho definido || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura
   private final JTextField textField2; // criado (declarado) variável do tipo JTextField || campo de texto com texto || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura
   private final JTextField textField3; // criado (declarado) variável do tipo JTextField || campo de texto com texto e tamanho || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura
   private final JPasswordField passwordField; // criado (declarado) variável do tipo JPasswordField || campo de senha com texto || private define a variavel para uso exclusivo dentro da classe e final define para apenas leitura

   // O construtor TextFieldFrame adiciona JTextFields ao JFrame
   public TextFieldFrame()
   {
      super("Testando JTextField e JPasswordField"); // "super" é um método para definir o título da janela com o texto do parâmetro
      setLayout(new FlowLayout()); // definir layout do quadro/janela || "new" é a criação de um novo objeto

      // construir campo de texto com 10 colunas
      textField1 = new JTextField(10); // apresentar o campo de texto com tamanho de 10 colunas ao usuário || declarar variável || "=" é igual operador de atribuição
      add(textField1); // adicionar textField1 ao JFrame

      // construir campo de texto com texto padrão
      textField2 = new JTextField("Insira o texto aqui");
      add(textField2); // adicionar textField2 ao JFrame

      // construir campo de texto com texto padrão e 21 colunas
      textField3 = new JTextField("Campo de texto não editável", 21);
      textField3.setEditable(false); // bloquear edição
      // textField3.setEnabled(false); // desabilitar edição e seleção
      add(textField3); // adicionar textField3 ao JFrame

      // construir passwordfield com texto padrão
      passwordField = new JPasswordField("Texto oculto");
      add(passwordField); // adicionar passwordField ao JFrame

      // registrar manipuladores de eventos
      TextFieldHandler handler = new TextFieldHandler();
      textField1.addActionListener(handler);
      textField2.addActionListener(handler);
      textField3.addActionListener(handler);
      passwordField.addActionListener(handler);
   } // fim do construtor TextFieldFrame

   // classe interna privada para manipulação de eventos
   private class TextFieldHandler implements ActionListener 
   {
      // processar eventos de campo de texto
      @Override
      public void actionPerformed(ActionEvent event)
      {
         String string = ""; 
         // usuário pressionou Enter em JTextField textField1
         if (event.getSource() == textField1)
            string = String.format("textField1: %s",
               event.getActionCommand());

         // usuário pressionou Enter em JTextField textField2
         else if (event.getSource() == textField2)
            string = String.format("textField2: %s",
               event.getActionCommand());

         // usuário pressionou Enter em JTextField textField3
         else if (event.getSource() == textField3)
            string = String.format("textField3: %s", 
               event.getActionCommand());

         // usuário pressionou Enter em JTextField passwordField
         else if (event.getSource() == passwordField)
            string = String.format("passwordField: %s", 
               event.getActionCommand());

         // exibir conteúdo JTextField
         JOptionPane.showMessageDialog(null, string); 
      } 
   } // fim da classe interna privada TextFieldHandler
} // fim da classe TextFieldFrame