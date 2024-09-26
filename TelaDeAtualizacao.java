import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeAtualizacao extends JFrame {
    public static JLabel lblId;
    public static JComboBox<String> cbxId;
    public static String[] ids;

    public static JLabel lblNome;
    public static JTextField txtNome;
    public static String nomeAtual;

    public static JLabel lblEmail;
    public static JTextField txtEmail;
    public static String emailAtual;

    public static JLabel lblSenha;
    public static JPasswordField txtSenha;
    public static String senhaAtual;

    public static JLabel lblNotificacoes;

    public static JButton btnAtualizar;
    public static JButton btnCancelar;

    public static int tamanhoInputs = 20;

    public TelaDeAtualizacao()
    {
        super("Tela de Atualização");
        setLayout(new GridLayout(6,1,5,5));

        JPanel linha_id = new JPanel(new GridLayout(1, 2));

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        linha_id.add(lblId);

        NavegadorDeRegistro.popularIds();
        cbxId = new JComboBox(ids);
        linha_id.add(cbxId);

        add(linha_id);

        JPanel linha_nome = new JPanel(new GridLayout(1, 2));

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        linha_nome.add(lblNome);

        txtNome = new JTextField(tamanhoInputs);
        linha_nome.add(txtNome);

        add(linha_nome);

        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        linha_email.add(lblEmail);

        txtEmail = new JTextField(tamanhoInputs);
        linha_email.add(txtEmail);

        add(linha_email);

        JPanel linha_senha = new JPanel(new GridLayout(1, 2));

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);
        linha_senha.add(lblSenha);

        txtSenha = new JPasswordField(tamanhoInputs);
        linha_senha.add(txtSenha);

        add(linha_senha);

        JPanel linha_botoes = new JPanel(new GridLayout(1, 2));

        btnAtualizar = new JButton("Atualizar");
        linha_botoes.add(btnAtualizar);

        btnCancelar = new JButton("Cancelar");
        linha_botoes.add(btnCancelar);

        add(linha_botoes);

        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linha_notificacoes.add(lblNotificacoes);

        add(linha_notificacoes);

        btnAtualizar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (txtNome.getText().trim().length() <= 2) { // Verifica se um campo de texto, identificado por txtNome, contém algum valor válido antes de prosseguir com um cadastro.
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar ao menos 3 letras para atualizar o nome. Por favor, digite pelo menos 3 letras tente novamente."));
                        txtNome.requestFocus();
                        return;
                    }
   
                    if (txtEmail.getText().trim().length() <= 10) { // Verifica se um campo de texto, identificado por txtEmail, contém algum valor válido antes de prosseguir com um cadastro.
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar ao menos 11 letras para atualizar o Email. Por favor, digite pelo menos 11 letras tente novamente."));
                        txtEmail.requestFocus();
                        return;
                    }
   
                    if (String.valueOf(txtSenha.getPassword()).trim().length() <= 7) { // Verifica se um campo de texto, identificado por txtSenha, contém algum valor válido antes de prosseguir com um cadastro.
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar uma Senha com 8 digitos para atualizar. Por favor, digite pelo menos 8 letras tente novamente."));
                        txtSenha.requestFocus();
                        return;
                    }
                    NavegadorDeRegistro.atualizarId();
                }
            }
        );

        btnCancelar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.limparCampos();
                }
            }
        );

        cbxId.addItemListener(
            new ItemListener() {
            @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        NavegadorDeRegistro.atualizarCampos(cbxId.getSelectedItem().toString());
                    }
                } 
            }
        );

        setSize(285, 300);
        ImageIcon img = new ImageIcon("./senac-logo.png");
        setIconImage(img.getImage());
        setVisible(true);
        cbxId.requestFocus();
    }

    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static void main(String[] args) {
        TelaDeAtualizacao appTelaDeAtualizacao = new TelaDeAtualizacao();
        appTelaDeAtualizacao.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
