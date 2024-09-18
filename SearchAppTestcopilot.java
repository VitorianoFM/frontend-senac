import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class SearchAppTestcopilot {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_senac";
    private static final String USER = "root";
    private static final String PASS = "senac@02";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pesquisa no Banco de Dados");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField idField = new JTextField(5);
        JTextField nameField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JButton searchButton = new JButton("Pesquisar");
        JTextArea resultArea = new JTextArea(10, 40);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                String email = emailField.getText();
                searchDatabase(id, name, email, resultArea);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Nome:"));
        panel.add(nameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(searchButton);
        panel.add(new JScrollPane(resultArea));

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void searchDatabase(String id, String name, String email, JTextArea resultArea) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tbl_senac WHERE id LIKE ? AND nome LIKE ? AND email LIKE ?")) {
            stmt.setString(1, "%" + id + "%");
            stmt.setString(2, "%" + name + "%");
            stmt.setString(3, "%" + email + "%");
            ResultSet rs = stmt.executeQuery();

            resultArea.setText("");
            while (rs.next()) {
                resultArea.append("ID: " + rs.getString("id") + ", Nome: " + rs.getString("nome") + ", Email: " + rs.getString("email") + "\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}