import java.awt.*; // Importa todos os componentes do módulo AWT.
import java.awt.event.*; // import java.awt.event.*;
// import java.sql.*; // Importa todos os caomponentes do modulos sql para usar o banco de dados do MySQL.
import javax.swing.*; // Importa todos os componentes do módulo Swing.

// Classe TelaDeLogin que herda de JFrame para criar uma interface gráfica de login.
public class TelaDePesquisa extends JFrame 
{   
   // Declaração dos componentes da interface gráfica.
   public static JLabel lblId; // Rótulo para o campo de nome.
   public static JTextField txtId; // Campo de texto para o nome.
   
   public static JLabel lblNome; // Rótulo para o campo de nome.
   public static JTextField txtNome; // Campo de texto para o nome.

   public static JLabel lblEmail; // Rótulo para o campo de email.
   public static JTextField txtEmail; // Campo de texto para o email.

   public static JLabel lblPesquisa; // Rótulo para o campo de nome.
   public static JTextField txtPesquisa; // Campo de texto para o email.

   public static JButton btnPesquisar; // Botão para submeter o cadastro.
   public static JButton btnComeco; // Botão para submeter o cadastro.
   public static JButton btnVoltar; // Botão para submeter o cadastro.
   public static JButton btnAvancar; // Botão para submeter o cadastro.
   public static JButton btnFim; // Botão para submeter o cadastro.

   public static JLabel lblNotificacoes; // Rótulo para exibir notificações ou mensagens ao usuário.

   public static int tamanhoInputs = 20;
   public static String txtUsuario = "";

   // Construtor da classe TelaDeCadastro, onde os componentes são configurados e adicionados à janela.
   public TelaDePesquisa() 
   {
      super("Tela de Pesquisa"); // Define o título da janela.
      setLayout(new GridLayout(7,1,5,5)); // Define o layout da janela como GridLayout.

      JPanel linha_lblPesquisa = new JPanel(new GridLayout(1, 2));

      lblPesquisa = new JLabel("Pesquisa:", SwingConstants.CENTER); // Cria um rótulo com o texto "Pesquisa:".
      linha_lblPesquisa.add(lblPesquisa);
      
      btnPesquisar = new JButton("🔍"); // Cria um botão com o texto "Cadastrar".
      btnPesquisar.setToolTipText("Pesquisar");
      btnPesquisar.setEnabled(false);
      linha_lblPesquisa.add(btnPesquisar);

      add(linha_lblPesquisa);

      JPanel linha_inputPesquisa = new JPanel(new GridLayout(1, 1));

      txtPesquisa = new JTextField(tamanhoInputs); // Cria um campo de texto com largura de 20 colunas.
      linha_inputPesquisa.add(txtPesquisa); // Adiciona o campo de texto à janela.

      add(linha_inputPesquisa);

      JPanel linha_id = new JPanel(new GridLayout(1, 2));

      lblId = new JLabel("ID:", SwingConstants.RIGHT); // Cria um rótulo com o texto "ID".
      linha_id.add(lblId); // Adiciona o rótulo à janela.

      txtId = new JTextField(tamanhoInputs); // Cria um campo de texto com largura de 20 colunas.
      txtId.setEnabled(false);
      linha_id.add(txtId); // Adiciona o campo de texto à janela.

      add(linha_id);

      JPanel linha_nome = new JPanel(new GridLayout(1, 2));

      lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Cria um rótulo com o texto "Nome".
      linha_nome.add(lblNome); // Adiciona o rótulo à janela.

      txtNome = new JTextField(tamanhoInputs); // Cria um campo de texto com largura de 20 colunas.
      txtNome.setEditable(false);
      linha_nome.add(txtNome); // Adiciona o campo de texto à janela.

      add(linha_nome);

      JPanel linha_email = new JPanel(new GridLayout(1, 2));

      lblEmail = new JLabel("E-mail:", SwingConstants.RIGHT); // Cria um rótulo com o texto "E-mail".
      linha_email.add(lblEmail); // Adiciona o rótulo à janela.

      txtEmail = new JTextField(tamanhoInputs); // Cria um campo de texto com largura de 20 colunas.
      txtEmail.setEditable(false);
      linha_email.add(txtEmail); // Adiciona o campo de texto à janela.

      add(linha_email);

      JPanel linha_botoes = new JPanel(new GridLayout(1, 4));
      
      btnComeco = new JButton("<<"); // Cria um botão com o texto "<<".
      btnComeco.setEnabled(false);
      linha_botoes.add(btnComeco); // Adiciona o botão à janela.

      btnVoltar = new JButton("<"); // Cria um botão com o texto "<".
      btnVoltar.setEnabled(false);
      linha_botoes.add(btnVoltar); // Adiciona o botão à janela.

      btnAvancar = new JButton(">"); // Cria um botão com o texto ">".
      btnAvancar.setEnabled(false);
      linha_botoes.add(btnAvancar); // Adiciona o botão à janela.

      btnFim = new JButton(">>"); // Cria um botão com o texto ">>".
      btnFim.setEnabled(false);
      linha_botoes.add(btnFim); // Adiciona o botão à janela.

      add(linha_botoes);

      JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

      //add(new JLabel("     ")); // Adiciona um rótulo vazio para espaçamento.
      lblNotificacoes = new JLabel("Notificações:", SwingConstants.CENTER); // Cria um rótulo centralizado para notificações.
      linha_notificacoes.add(lblNotificacoes); // Adiciona o rótulo à janela.

      add(linha_notificacoes);

      btnPesquisar.addActionListener(
         new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent event) {
                 if (txtPesquisa.getText().trim().length() <= 0) {
                     lblNotificacoes.setText(setHtmlFormat("Por favor, digite algo e tente novamente."));
                     txtPesquisa.requestFocus();
                     return;
                 }

                 NavegadorDeRegistro.pesquisar();
             }
         }
     );

     txtPesquisa.addKeyListener(
      new KeyAdapter() {
         @Override
         public void keyReleased(KeyEvent e) {
            if (txtPesquisa.getText().trim().equals(txtUsuario) == false && txtPesquisa.getText().trim().length() > 0) {
               btnPesquisar.setEnabled(true);
            } else {
               btnPesquisar.setEnabled(false);
            }
            // System.out.println(e.getKeyCode());
            if (e.getKeyCode() == 10) {
               NavegadorDeRegistro.pesquisar();
            }
         }
      }
     );

      setSize(270, 300); // Define o tamanho da janela para 270 pixels de largura e 220 pixels de altura.
      setVisible(true); // Torna a janela visível.
      txtPesquisa.requestFocus();  
   }
   
   public static String setHtmlFormat(String strTexto) { // O método setHtmlFormat recebe uma string como argumento e retorna essa string formatada como um documento HTML básico.
      return "<html><body>" + strTexto + "</body></html>";
   }
   // Método main, ponto de entrada do programa.
   public static void main(String[] args) {
    TelaDePesquisa appTelaDePesquisa = new TelaDePesquisa(); // Cria uma variável da janela de login.
      appTelaDePesquisa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define que ao fechar a janela, o programa será encerrado.
   }
}