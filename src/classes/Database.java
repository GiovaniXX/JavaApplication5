package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    public static Connection con;

    public Database() {
        con = getConnection();
    }

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties props = new Properties();
            props.load(new FileInputStream("E:/PROJETOS JAVA 2023/sgbd2023/config.properties"));
            String dbUrl = props.getProperty("db.url");
            String dbUser = props.getProperty("db.user");
            String dbPassword = props.getProperty("db.password");

            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Erro ao carregar o driver ou ler as propriedades", ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Erro ao estabelecer a conexão com o banco de dados", ex);
            return null;
        }
    }

//    public Database() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Properties props = new Properties();
//            props.load(new FileInputStream("E:/PROJETOS JAVA 2023/sgbd2023/config.properties"));
//            String dbUrl = props.getProperty("db.url");
//            String dbUser = props.getProperty("db.user");
//            String dbPassword = props.getProperty("db.password");
//            con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
//        } catch (ClassNotFoundException | SQLException | IOException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
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

    public boolean existeProduto(String produto) {
        String sql = "SELECT COUNT(*) FROM tbprodutos WHERE idProduto = ?";
        try (var ps = con.prepareStatement(sql)) {
            ps.setString(1, produto);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String adicionarProduto(Produto mProduto) {
        String query = "INSERT INTO tbprodutos (idProduto, descricao, preco, idImposto, notas) VALUES (?, ?, ?, ?, ?)";
        try (var ps = con.prepareStatement(query)) {
            ps.setString(2, mProduto.getDescricao());
            ps.setDouble(3, mProduto.getPreco());
            ps.setString(5, mProduto.getAnotacao());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 1) {
                return "Produto cadastrado com sucesso!";
            } else {
                return "Produto não pode ser cadastrado!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Não foi possível cadastrar o produto", ex);
            return "Produto não pode ser cadastrado devido a um erro de comunicação com o SGBD!";
        }
    }

    public String deletarProduto(String idProduto) {
        String sql = "DELETE FROM tbprodutos WHERE idProduto = ?";
        try (var ps = con.prepareStatement(sql)) {
            ps.setString(1, idProduto);
            int result = ps.executeUpdate();

            if (result > 0) {
                return "Produto deletado com sucesso!";
            } else {
                return "Não foi possível deletar este produto!";
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return "Não foi possível deletar este produto!";
        }
    }

    public ResultSet getProdutos() {
        try {
            String sql = "SELECT * FROM tbprodutos";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Erro ao obter os produtos", ex);

            return null;
        }
    }

    public int numeroProdutos() {
        try {
            String sql = "SELECT COUNT(*) AS num FROM tbprodutos";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("num");
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public Produto getProduto(String Produto) {
        try {
            Produto produto = null;
            String sql = "SELECT * FROM tbprodutos " + "WHERE idProduto = '" + Produto + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                produto = new Produto(
                        rs.getInt("Produto"),
                        rs.getString("descricao"),
                        rs.getDouble("preco"),
                        rs.getString("anotacao"));
            }
            return produto;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//    private Object getConnection() {
//        con = (Connection) getConnection();
//        return null;
//    }
}
