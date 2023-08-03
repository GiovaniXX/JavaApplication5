package classes;

import java.io.File;
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
            //props.load(new FileInputStream("E:" + File.separator + "PROJETOS JAVA 2023" + File.separator + "JavaApplication5" + File.separator + "sgbd2023" + File.separator + "config.properties"));
            props.load(new FileInputStream("E:/PROJETOS JAVA 2023/JavaApplication5/sgbd2023/config.properties"));
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

    public boolean ValidateUser(String username, String accessCode, String securityKey) {
        String sql = "SELECT FROM usuarios WHERE userName = ? accessCode = ? AND securityKey = ?";
        try (var ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
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
        String sql = "SELECT COUNT(*) FROM produtos WHERE produto = ?";
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

    public String adicionarProduto(Produto produto) {
        String query = "INSERT INTO produtos (produto, descricao, preco, anotacao) VALUES (?, ?, ?, ?)";
        try (var ps = con.prepareStatement(query)) {
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getPreco());
            ps.setString(5, produto.getAnotacao());
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

    public String deletarProduto(String produto) {
        String sql = "DELETE FROM produtos WHERE produto = ?";
        try (var ps = con.prepareStatement(sql)) {
            ps.setString(1, produto);
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
            String sql = "SELECT * FROM produtos";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Erro ao obter os produtos", ex);

            return null;
        }
    }

    public int numeroProdutos() {
        try {
            String sql = "SELECT COUNT(*) AS num FROM produtos";
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
            String sql = "SELECT * FROM produtos " + "WHERE produto = '" + produto + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                produto = new Produto(
                        rs.getInt("produto"),
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

    public int getNumeroVenda() {
        try {
            String sql = "select max(Venda) as from detalhevendas";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("num") + 1;
            } else {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }

    public void adicionarDetalheVendas(int venda, int produto, java.sql.Date dataAtual, String descricao, double preco, int quantidade, double valor) {
        try {
            String sql = "INSERT INTO detalhevendas (venda, produto, dataAtual, descricao, preco, quantidade, valor) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, venda);
            st.setInt(2, produto);
            st.setDate(3, dataAtual);
            st.setString(4, descricao);
            st.setDouble(5, preco);
            st.setInt(6, quantidade);
            st.setDouble(7, valor);

            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int posicaoProduto(String text) {
        try {
            String sql = "SELECT COUNT(*) AS posicao FROM produtos WHERE produto < ?";
            PreparedStatement ps = con.prepareStatement(sql);
            String produto = null;
            ps.setString(1, produto);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("posicao") + 1;
            } else {
                return -1; // Produto não encontrado ou erro na consulta.
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return -1; // Erro durante a execução da consulta.
        }
    }
}
