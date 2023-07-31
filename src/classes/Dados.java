package classes;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public final class Dados {

    public static Connection cnn;
    private final int maxPro = 50;
    private final Produto msProdutos[] = new Produto[maxPro];
    private int conPro = 0;

    public Dados() {
        cnn = getConnection();
        preencherProdutos();
    }

    //-------------------------------------------CONEXÃO----------------------------------------------------------------//
    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties props = new Properties();
            props.load(new FileInputStream("E:/PROJETOS JAVA 2023/Umbrella_Pharmaceutical_Inc/config.properties"));
            String dbUrl = props.getProperty("db.url");
            String dbUser = props.getProperty("db.user");
            String dbPassword = props.getProperty("db.password");

            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, "Erro ao carregar o driver ou ler as propriedades", ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, "Erro ao estabelecer a conexão com o banco de dados", ex);
            return null;
        }
    }

    //-----------------------------------------VALIDAÇÃO---------------------------------------------------------------------//
    public boolean validarUsuario(String usuario, String senha, String chave) {
        String sql = "SELECT 1 FROM tbusuarios WHERE idUsuario = ? AND senha = ? AND chave = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario);
            statement.setString(2, senha);
            statement.setString(3, chave);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //-------------------------------------------------PERFIL------------------------------------------------------------------//
    public int getPerfil(String usuario) {
        String sql = "SELECT idPerfil FROM tbusuarios WHERE idUsuario = ?";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("idPerfil");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, "Erro ao obter o perfil do usuário", ex);
        }
        return -1;
    }
    //-------------------------------------------------------------------------------------------------------------------------//

    public boolean existeUsuario(String usuario) {
        String sql = "SELECT COUNT(*) FROM tbusuarios WHERE idUsuario = ?";
        try (var ps = cnn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int numeroProdutos() {
        return conPro;
    }

    public Produto[] getProdutos() {
        return msProdutos;
    }

    public int posicaoProduto(String produto) {
        for (int i = 0; i < conPro; i++) {
            if (msProdutos[i].getIdProduto().equals(produto)) {
                return i;
            }
        }
        return -1;
    }

    public String adicionarProduto(Produto mProduto) {
        if (conPro == maxPro) {
            return "Não é possível cadastrar mais produtos";
        }
        msProdutos[conPro] = mProduto;
        conPro++;
        return "Produto cadastrado com sucesso";
    }

    public void salvarTodo() {
        salvarProdutos();
    }

    public void salvarProdutos() {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("Data/produtos.txt");
            pw = new PrintWriter(fw);

            for (int i = 0; i < conPro; i++) {
                pw.println(msProdutos[i].toString());
            }

            System.out.println("Produtos salvos com sucesso!");
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void preencherProdutos() {
        File arquivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            arquivo = new File("Data/produtos.txt");
            fr = new FileReader(arquivo);
            br = new BufferedReader(fr);

            int pos;
            String aux;
            String linha;
            String idProduto;
            String descricao;
            double preco;
            int imposto;
            String anotacao;

            while ((linha = br.readLine()) != null) {
                pos = linha.indexOf("|");
                aux = linha.substring(0, pos);
                idProduto = aux;
                linha = linha.substring(pos + 1);

                pos = linha.indexOf("|");
                aux = linha.substring(0, pos);
                descricao = aux;
                linha = linha.substring(pos + 1);

                pos = linha.indexOf("|");
                aux = linha.substring(0, pos);
                preco = Double.parseDouble(aux);
                linha = linha.substring(pos + 1);

                pos = linha.indexOf("|");
                aux = linha.substring(0, pos);
                imposto = Integer.parseInt(aux);
                linha = linha.substring(pos + 1);

                anotacao = linha;

                Produto mProduto = new Produto(idProduto, descricao, preco, imposto, anotacao);
                msProdutos[conPro] = mProduto;
                conPro++;
            }
        } catch (IOException | NumberFormatException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
