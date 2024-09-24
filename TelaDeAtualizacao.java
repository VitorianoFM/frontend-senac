import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class TelaDeAtualizacao extends JFrame {

    public static JLabel lblId;
    public static JComboBox cbxId;
    public static ArrayList<String> ids = new ArrayList<>();

    public static JLabel lblNome;
    public static JTextField txtNome;

    public static JLabel lblEmail;
    public static JTextField txtEmail;

    public static JLabel lblSenha;
    public static JTextField txtSenha;

    public static JLabel lblNotificacoes;

    public static int tamanhoInputs = 20;

    public TelaDeAtualizacao()
    {
        super("Tela de Atualização");
        setLayout(new GridLayout(6,1,5,5));

        JPanel linha_id = new JPanel(new GridLayout(1, 2));

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        linha_id.add(lblId);

        cbxId = new JComboBox();
        linha_id.add(cbxId);

        add(linha_id);

        JPanel linha_nome = new JPanel(new GridLayout(1, 2));

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        linha_nome.add(lblNome);

        txtNome = new JTextField(tamanhoInputs);
        txtNome.setEditable(false);
        linha_nome.add(txtNome);

        add(linha_nome);

        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        linha_email.add(lblEmail);

        txtEmail = new JTextField(10);
        txtEmail.setEditable(false);
        linha_email.add(txtEmail);

        add(linha_email);

        JPanel linha_botoes = new JPanel(new GridLayout(1, 4));

        btnPrimeiro = new JButton("<<");
        btnPrimeiro.setEnabled(false);
        linha_botoes.add(btnPrimeiro);

        btnAnterior = new JButton("<");
        btnAnterior.setEnabled(false);
        linha_botoes.add(btnAnterior);

        btnProximo = new JButton(">");
        btnProximo.setEnabled(false);
        linha_botoes.add(btnProximo);

        btnUltimo = new JButton(">>");
        btnUltimo.setEnabled(false);
        linha_botoes.add(btnUltimo);

        add(linha_botoes);

        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linha_notificacoes.add(lblNotificacoes);

        add(linha_notificacoes);

        btnPesquisar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (txtPesquisa.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("Por favor, digite algo e tente novamente."));
                        txtPesquisa.requestFocus();
                        return;
                    } else {
                        NavegadorDeRegistro.pesquisar();
                    }
                }
            }
        );

        btnPrimeiro.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (ntfCampoVazio() == false) {
                        NavegadorDeRegistro.primeiroRegistro();
                    }
                }
            }
        );

        btnAnterior.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (ntfCampoVazio() == false) {
                        NavegadorDeRegistro.registroAnterior();
                    }
                }
            }
        );

        btnProximo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (ntfCampoVazio() == false) {
                        NavegadorDeRegistro.proximoRegistro();
                    }
                }
            }
        );

        btnUltimo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (ntfCampoVazio() == false) {
                        NavegadorDeRegistro.ultimoRegistro();
                    }
                }
            }
        );

        txtPesquisa.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (txtPesquisa.getText().trim().equals(txtUsuario) == false && txtPesquisa.getText().trim().length() > 0) {
                        if (e.getKeyCode() == 10) {
                            NavegadorDeRegistro.pesquisar();
                        }
                    } else {
                        limparCampos("Digite algo para continuar.");
                    }
                    btnPesquisar.setEnabled(true);
                }
            }
        );

        setSize(250, 300);
        ImageIcon img = new ImageIcon("./senac-logo.png");
        setIconImage(img.getImage());
        setVisible(true);
        txtPesquisa.requestFocus();
    }

    public static boolean ntfCampoVazio() {
        if (txtPesquisa.getText().trim().length() <= 0) {
            lblNotificacoes.setText(setHtmlFormat("Ops! Campo vazio. Por favor, digite algo e tente novamente."));
            txtPesquisa.requestFocus();
            return true;
        } else {
            return false;
        }
    }

    public static void limparCampos(String notificacao) { // limparCampos("")
        btnPesquisar.setEnabled(false);
        txtId.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        btnPrimeiro.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(false);
        btnUltimo.setEnabled(false);
        if (notificacao.trim().length() > 0) {
            lblNotificacoes.setText(setHtmlFormat(notificacao));
        }
    }

    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static void main(String[] args) {
        TelaDeAtualizacao appTelaDeAtualizacao = new TelaDeAtualizacao();
        appTelaDeAtualizacao.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
