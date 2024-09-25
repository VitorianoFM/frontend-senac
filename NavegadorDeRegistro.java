import java.sql.*;
import java.util.*;

public class NavegadorDeRegistro extends TelaDeAtualizacao {
    public static void popularIds() {
        try {
            ArrayList<String> idsTemp = new ArrayList<>();
            Connection conexao = MySQLConnector.conectar();
            String strSqlPopularIds = "UPDATE usuarios SET nome = ?, email = ?, senha = ? WHERE id = ?";
            Statement stmSqlPopularIds = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPopularIds = stmSqlPopularIds.executeQuery(strSqlPopularIds);
            while (rstSqlPopularIds.next()) {
                idsTemp.add(rstSqlPopularIds.getString("id"));
            }
            ids = idsTemp.toArray(new String[0]);
            stmSqlPopularIds.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    private static void atualizarRegistro() {
        try { // O programa está tentando se conectar ao banco de dados MySQL, executar uma consulta SQL para buscar registros com um determinado endereço de email e armazenar o resultado em um objeto ResultSet.
            Connection conexao = MySQLConnector.conectar();
            String strSqlEmail = "select * from `db_senac`.`tbl_senac` where `email` = '" + txtEmail.getText() + "';";
            Statement stmSqlEmail = conexao.createStatement();
            ResultSet rstSqlEmail = stmSqlEmail.executeQuery(strSqlEmail);
            if (rstSqlEmail.next()) { // Verifica a existência de um usuário com determinado e-mail em um banco de dados.
                lblNotificacoes.setText(setHtmlFormat("Ops! Já existe um usuário utilizando este email. Por favor, digite outro email e tente novamente."));
            } else { // Verifica se o login é válido. Caso não seja, ele permite que o usuário realize um cadastro. Os dados do cadastro são inseridos em um banco de dados e uma mensagem de confirmação é exibida para o usuário.
                lblNotificacoes.setText(setHtmlFormat("Login liberado para cadastro."));
                String strSqlCadastrar = "insert into `db_senac`.`tbl_senac` (`nome`, `email`, `senha`) values ('" + txtNome.getText() + "', '" + txtEmail.getText() + "', '" + String.valueOf(txtSenha.getPassword()) + "');";
                // System.out.println(strSqlCadastrar);
                Statement stmSqlCadastrar = conexao.createStatement();
                stmSqlCadastrar.addBatch(strSqlCadastrar);
                stmSqlCadastrar.executeBatch();
                lblNotificacoes.setText(setHtmlFormat("Atualização realizado com sucesso"));
            }
            stmSqlEmail.close(); // Encerra a comunicação com o banco de dados que estava sendo utilizada para realizar as operações relacionadas ao envio de e-mails.
        } catch (Exception e) { // Se der algum problema ao cadastrar, mostrar uma mensagem de erro para o usuário e imprimir uma mensagem feinha para o programador.
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a atualização! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

}
