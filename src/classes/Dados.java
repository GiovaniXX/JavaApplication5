package classes;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dados {

    public Connection cnn;

    public Dados() {
        cnn = getConnection();
    }

    private Connection getConnection() {
        try {
            // Substitua "url_do_banco", "usuario" e "senha" pelas informações corretas do seu banco de dados.
            String url = "jdbc:mysql://localhost:3306/nome_do_banco_de_dados";
            String usuario = "seu_usuario";
            String senha = "sua_senha";
            cnn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, "Erro ao conectar ao banco de dados", ex);
        }
        return null;
    }

//-----------------------------------------------CONFIRMAÇÕES------------------------------------------------------//
    public boolean existeProduto(String produto) throws SQLException {
        String sql = "SELECT COUNT(*) FROM produtos WHERE idProduto = ?";
        try (var ps = cnn.prepareStatement(sql)) {
            ps.setString(1, produto);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;

            } catch (SQLException ex) {
                Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    }

    //------------------------------------------ADICIONANDO NO SGBD---------------------------------------------------//
    public String adicionarProduto(Produto mProduto) {
        String query = "INSERT INTO produtos (idProduto, descricao, preco, imposto, notas) VALUES (?, ?, ?, ?, ?)";
        try (var ps = cnn.prepareStatement(query)) {
            ps.setString(1, mProduto.getIdProduto());
            ps.setString(2, mProduto.getDescricao());
            ps.setDouble(3, mProduto.getPreco());
            ps.setInt(4, mProduto.getImposto());
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

    //---------------------------------------DELETANDO----------------------------------------------------//
    public String deletarProduto(String idProduto) {
        String sql = "DELETE FROM produtos WHERE idProduto = ?";
        try (var ps = cnn.prepareStatement(sql)) {
            ps.setString(1, idProduto);
            int result = ps.executeUpdate();

            if (result > 0) {
                return "Produto deletado com sucesso!";
            } else {
                return "Não foi possível deletar este produto!";

            }

        } catch (SQLException ex) {
            Logger.getLogger(Dados.class
                    .getName()).log(Level.SEVERE, null, ex);
            return "Não foi possível deletar este produto!";
        }
    }
    //------------------------------------------------MÉTODOS GETS-------------------------------------------------------//

    public List<Produto> getProdutos() {
        try {
            List<Produto> produtos = new ArrayList<>();
            String sql = "SELECT * FROM produtos";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getString("idProduto"),
                        rs.getString("descricao"),
                        rs.getFloat("preco"),
                        rs.getInt("imposto"),
                        rs.getString("notas"));
                produtos.add(produto);
            }

            return produtos;

        } catch (SQLException ex) {
            Logger.getLogger(Dados.class
                    .getName()).log(Level.SEVERE, "Erro ao obter os produtos", ex);
            return null;
        }
    }

    public Produto getProduto(String idProduto) {
        try {
            Produto mProduto = null;
            String sql = "SELECT * FROM produtos " + "WHERE idProduto = '" + idProduto + "'";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                mProduto = new Produto(
                        rs.getString("idProduto"),
                        rs.getString("descricao"),
                        rs.getFloat("preco"),
                        rs.getInt("imposto"),
                        rs.getString("notas"));
            }
            return mProduto;

        } catch (SQLException ex) {
            Logger.getLogger(Dados.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //--------------------------------------------------NÚMEROS-------------------------------------------------------------//
    public int numeroProdutos() {
        try {
            String sql = "SELECT COUNT(*) AS num FROM produtos";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("num");
            } else {
                return 0;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class
                    .getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
