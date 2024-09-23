import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TelaPesquisaTestchatgpt extends JFrame {
    private JTextField campoID, campoNome, campoEmail;
    private JButton botaoPesquisar;
    private JTextArea areaResultado;

    // Configurações do banco de dados
    private final String URL = "jdbc:mysql://localhost:3306/db_senac";
    private final String USER = "root";
    private final String PASSWORD = "senac@02";

    public TelaPesquisaTestchatgpt() {
        setTitle("Pesquisa no Banco de Dados");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        campoID = new JTextField();
        campoNome = new JTextField();
        campoEmail = new JTextField();
        botaoPesquisar = new JButton("Pesquisar");
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        // Adicionando componentes à tela
        add(new JLabel("ID:"));
        add(campoID);
        add(new JLabel("Nome:"));
        add(campoNome);
        add(new JLabel("Email:"));
        add(campoEmail);
        add(botaoPesquisar);
        add(new JScrollPane(areaResultado));

        botaoPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisar();
            }
        });
    }

    private void pesquisar() {
        String id = campoID.getText();
        String nome = campoNome.getText();
        String email = campoEmail.getText();
        StringBuilder resultado = new StringBuilder();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM tbl_senac WHERE "
                     + "(? IS NULL OR id = ?) AND "
                     + "(? IS NULL OR nome LIKE ?) AND "
                     + "(? IS NULL OR email LIKE ?)")) {

            stmt.setString(1, id.isEmpty() ? null : id);
            stmt.setString(2, id.isEmpty() ? null : id);
            stmt.setString(3, nome.isEmpty() ? null : nome);
            stmt.setString(4, nome.isEmpty() ? null : "%" + nome + "%");
            stmt.setString(5, email.isEmpty() ? null : email);
            stmt.setString(6, email.isEmpty() ? null : "%" + email + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                resultado.append("ID: ").append(rs.getInt("id"))
                         .append(", Nome: ").append(rs.getString("nome"))
                         .append(", Email: ").append(rs.getString("email"))
                         .append("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            resultado.append("Erro: ").append(e.getMessage());
        }

        areaResultado.setText(resultado.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPesquisaTestchatgpt tela = new TelaPesquisaTestchatgpt();
            tela.setVisible(true);
        });
    }
}