import java.sql.*; // Essencial para qualquer aplicação Java que precise se conectar a um banco de dados relacional. Ela permite que você utilize as funcionalidades do JDBC para executar operações de banco de dados de forma eficiente.

public class NavegadorDeRegistro extends TelaDePesquisa { // Cria uma classe pública chamada NavegadorDeRegistro que é uma extensão da classe TelaDePesquisa. Isso significa que NavegadorDeRegistro é um tipo mais específico de tela de pesquisa, com funcionalidades adicionais ou modificadas.
    public static void pesquisar() { // Define um método público e estático chamado pesquisar que não retorna nenhum valor. Esse método pode ser chamado de qualquer lugar do seu código e provavelmente realiza alguma operação de pesquisa, mas o comportamento específico do método dependerá da implementação dentro das suas chaves {}.
        try {
            if (txtPesquisa.getText().trim().equals(txtUsuario) == false) {
                limparCampos();
                Connection conexao = MySQLConnector.conectar();
                String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%';";
                Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
                if (rstSqlPesquisa.next()) {
                    rstSqlPesquisa.last();
                    int rowNumbers = rstSqlPesquisa.getRow();
                    rstSqlPesquisa.first();

                    lblNotificacoes.setText(setHtmlFormat("Legal! Foi(Foram) encontrado(s) " + rowNumbers + " resultado(s)."));
                    txtId.setText(rstSqlPesquisa.getString("id"));
                    txtNome.setText(rstSqlPesquisa.getString("nome"));
                    txtEmail.setText(rstSqlPesquisa.getString("email"));
                    txtUsuario = txtPesquisa.getText();
                    btnPesquisar.setEnabled(false);
                    if (rowNumbers > 1) {
                        btnAvancar.setEnabled(true);
                        btnFim.setEnabled(true);
                    }  
                } else {
                    txtUsuario = txtPesquisa.getText();
                    btnPesquisar.setEnabled(false);
                    lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\"."));
                }
                stmSqlPesquisa.close();
            }
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }
    public static void primeiroRegistro() {

    }

    public static void registroAnterior() {
        
    }

    public static void proximoRegistro() {
        String idAtual = txtId.getText();
        limparCampos();
        Connection conexao = MySQLConnector.conectar();
        String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%') and `id` >  " + idAtual + " order by `id` asc;";
        Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
        if (rstSqlPesquisa.next()) {

    }

    public static void ultimoRegistro() {
        
    }
}
