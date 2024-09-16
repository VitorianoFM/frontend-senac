import java.awt.*; // Importa todos os componentes do módulo AWT.
import java.awt.event.*; // import java.awt.event.*;
import java.sql.*; // Importa todos os caomponentes do modulos sql para usar o banco de dados do MySQL.
import javax.swing.*; // Importa todos os componentes do módulo Swing.

// Classe TelaDeLogin que herda de JFrame para criar uma interface gráfica de login.
public class TelaDeCadastro extends JFrame 
{   
   // Declaração dos componentes da interface gráfica.
   private final JLabel lblNome; // Rótulo para o campo de login.
   private final JTextField txtNome; // Campo de texto para o login.

   private final JLabel lblEmail; // Rótulo para o campo de login.
   private final JTextField txtEmail; // Campo de texto para o login.

   private final JLabel lblSenha; // Rótulo para o campo de senha.
   private final JPasswordField txtSenha; // Campo de texto para a senha, que oculta os caracteres digitados.

   private final JButton btnEntrar; // Botão para submeter o login e a senha.

   private final JLabel lblNotificacoes; // Rótulo para exibir notificações ou mensagens ao usuário.

   // Construtor da classe TelaDeLogin, onde os componentes são configurados e adicionados à janela.
   public TelaDeCadastro() 
   {
      super("Tela de Cadastro"); // Define o título da janela.
      setLayout(new GridLayout(4, 2, 5, 5)); // Define o layout da janela como FlowLayout.

      lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Cria um rótulo com o texto "Login".
      add(lblNome); // Adiciona o rótulo à janela.

      txtNome = new JTextField(25); // Cria um campo de texto com largura de 10 colunas.
      add(txtNome); // Adiciona o campo de texto à janela.

      lblEmail = new JLabel("E-mail:", SwingConstants.RIGHT); // Cria um rótulo com o texto "Login".
      add(lblEmail); // Adiciona o rótulo à janela.

      txtEmail = new JTextField(25); // Cria um campo de texto com largura de 10 colunas.
      add(txtEmail); // Adiciona o campo de texto à janela.
      
      lblSenha = new JLabel("Senha:", SwingConstants.RIGHT); // Cria um rótulo com o texto "Senha".
      add(lblSenha); // Adiciona o rótulo à janela.

      txtSenha = new JPasswordField(25); // Cria um campo de senha com largura de 10 colunas.
      add(txtSenha); // Adiciona o campo de senha à janela.

      btnEntrar = new JButton("Cadastrar"); // Cria um botão com o texto "Entrar".
      add(btnEntrar); // Adiciona o botão à janela.

      //add(new JLabel("     ")); // Adiciona um rótulo vazio para espaçamento.
      lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Cria um rótulo centralizado para notificações.
      add(lblNotificacoes); // Adiciona o rótulo à janela.

      btnEntrar.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               try {
                  Connection conexao = MySQLConnector.conectar();
                  String strSqlLogin = "select * from `db_senac`.`tbl_senac` where `email` = '" + txtNome.getText() + "' and `senha` = '" + String.valueOf(txtSenha.getPassword()) + "';";
                  Statement stmSqlLogin = conexao.createStatement();
                  ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
                  rstSqlLogin.next();
                  stmSqlLogin.close();
                  lblNotificacoes.setText("Conectado com sucesso!");
               } catch (Exception e) {
                  lblNotificacoes.setText("Não foi possível encontrar o login e/ou senha digitados/informados! Por favor, verifique e tente novamente. Veja o erro: " + e);
               }
            }
         }
      );
      setSize(270, 220); // Define o tamanho da janela.
      setVisible(true); // Torna a janela visível.

      
   }
   
   private String setHtmlFormat(String strTexto) {
      return "<html><body>" + strTexto + "</body></html>";
   }
   // Método main, ponto de entrada do programa.
   public static void main(String[] args) {
      TelaDeCadastro appTelaDeCadastro = new TelaDeCadastro(); // Cria uma variável da janela de login.
      appTelaDeCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define que ao fechar a janela, o programa será encerrado.
      appTelaDeCadastro.setSize(270, 220); // Define o tamanho da janela para 150 pixels de largura e 200 pixels de altura.
      appTelaDeCadastro.setVisible(true); // Torna a janela visível na tela.
   }
}