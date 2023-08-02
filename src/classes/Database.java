package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    public Connection con;

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties props = new Properties();
            props.load(new FileInputStream("E:/PROJETOS JAVA 2023/sgbd2023/config.properties"));
            String dbUrl = props.getProperty("db.url");
            String dbUser = props.getProperty("db.user");
            String dbPassword = props.getProperty("db.password");
            con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean ValidateUser(String user, String accessCode, String securityKey) {
        String sql = "SELECT FROM usuarios WHERE iduser = ? AND accessCode = ? AND securityKey = ?";
        try (var ps = con.prepareStatement(sql)) {
            ps.setString(1, user);
            ps.setString(2, accessCode);
            ps.setString(3, securityKey);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    // Método para salvar a descrição, preço e anotação no banco de dados
    public static void salvarDados(String descricao, double preco, String anotacao) {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        try {
            // Obtém a conexão com o banco de dados
            conexao = obterConexao();

            // Prepara a instrução SQL para a inserção
            String sql = "INSERT INTO produtos (descricao, preco, anotacao) VALUES (?, ?, ?)";
            preparedStatement = conexao.prepareStatement(sql);

            // Define os valores dos parâmetros da instrução SQL
            preparedStatement.setString(1, descricao);
            preparedStatement.setDouble(2, preco);
            preparedStatement.setString(3, anotacao);

            // Executa a instrução SQL para inserção
            preparedStatement.executeUpdate();

            System.out.println("Dados salvos no banco de dados com sucesso!");
        } catch (SQLException ec) {
            System.out.println("Erro ao salvar os dados no banco de dados!");
            ec.printStackTrace();
        } finally {
            // Fecha o PreparedStatement e a conexão com o banco de dados
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ed) {
                    ed.printStackTrace();
                }
            }
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ee) {
                    ee.printStackTrace();
                }
            }
        }
    }
}
