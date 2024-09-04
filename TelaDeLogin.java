import java.awt.*; // Importa todos os componentes do módulo AWT.
import java.awt.event.*; // Importa todos componentes dos eventos do módulo AWT.
import javax.swing.*; // Importa todos os componentes do módulo Swing.

// Classe TelaDeLogin que herda de JFrame para criar uma interface gráfica de login.
public class TelaDeLogin extends JFrame 
{   
   // Declaração dos componentes da interface gráfica.
   private final JLabel lblLogin; // Rótulo para o campo de login.
   private final JTextField txtLogin; // Campo de texto para o login.

   private final JLabel lblSenha; // Rótulo para o campo de senha.
   private final JPasswordField txtSenha; // Campo de texto para a senha, que oculta os caracteres digitados.

   private final JButton btnEntrar; // Botão para submeter o login e a senha.

   private final JLabel lblNotificacoes; // Rótulo para exibir notificações ou mensagens ao usuário.

   // Construtor da classe TelaDeLogin, onde os componentes são configurados e adicionados à janela.
   public TelaDeLogin() 
   {
      super("Tela de Login"); // Define o título da janela.
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout.

      lblLogin = new JLabel("Login"); // Cria um rótulo com o texto "Login".
      add(lblLogin); // Adiciona o rótulo à janela.

      txtLogin = new JTextField(10); // Cria um campo de texto com largura de 10 colunas.
      add(txtLogin); // Adiciona o campo de texto à janela.
      
      lblSenha = new JLabel("Senha"); // Cria um rótulo com o texto "Senha".
      add(lblSenha); // Adiciona o rótulo à janela.

      txtSenha = new JPasswordField(10); // Cria um campo de senha com largura de 10 colunas.
      add(txtSenha); // Adiciona o campo de senha à janela.

      btnEntrar = new JButton("Entrar"); // Cria um botão com o texto "Entrar".
      add(btnEntrar); // Adiciona o botão à janela.

      add(new JLabel("     ")); // Adiciona um rótulo vazio para espaçamento.
      lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Cria um rótulo centralizado para notificações.
      add(lblNotificacoes); // Adiciona o rótulo à janela.

      setSize(50, 250); // Define o tamanho da janela.
      setVisible(true); // Torna a janela visível.

      MySQLConnector.conectar(); // Chama o método para conectar ao banco de dados MySQL.
   }

   // Método main, ponto de entrada do programa.
   public static void main(String[] args) {
      TelaDeLogin appTelaDeLogin = new TelaDeLogin(); // Cria uma variável da janela de login.
      appTelaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação de fechamento da janela.
   }
}