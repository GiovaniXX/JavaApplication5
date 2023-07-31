package classes;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.io.FileInputStream;
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
import java.io.IOException;

public final class Dados {

    private int conPro = 0;
    public static Connection cnn;

    public Dados() {
        cnn = getConnection();
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
    //-----------------------------------------------CONFIRMAÇÕES------------------------------------------------------//

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

    public boolean existeCliente(String cliente) {
        String sql = "SELECT COUNT(*) FROM tbclientes WHERE idClientes = ?";
        try (var ps = cnn.prepareStatement(sql)) {
            ps.setString(1, cliente);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean existeProduto(String produto) {
        String sql = "SELECT COUNT(*) FROM tbprodutos WHERE idProduto = ?";
        try (var ps = cnn.prepareStatement(sql)) {
            ps.setString(1, produto);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //------------------------------------------ADICIONANDO NO SGBD--------------------------------------------------------------//
    public String adicionarUsuario(Usuario mUsuario) {
        String query = "INSERT INTO tbusuarios (idUsuario, nome, snome, senha, chave, idPerfil) VALUES (?, ?, ?, ?, ?, ?)";
        try (var ps = cnn.prepareStatement(query)) {
            ps.setString(1, mUsuario.getIdUsuario());
            ps.setString(2, mUsuario.getNome());
            ps.setString(3, mUsuario.getSnome());
            ps.setString(4, mUsuario.getSenha());
            ps.setString(5, mUsuario.getChave());
            ps.setInt(6, mUsuario.getPerfil());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 1) {
                return "Usuário cadastrado com sucesso!";
            } else {
                return "Usuário não pode ser cadastrado!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return "Usuário não pode ser cadastrado devido a um erro de comunicação com o SGBD!";
        }
    }

    public String adicionarProduto(Produto mProduto) {
        String query = "INSERT INTO tbprodutos (idProduto, descricao, preco, idImposto, notas) VALUES (?, ?, ?, ?, ?)";
        try (var ps = cnn.prepareStatement(query)) {
            ps.setInt(1, mProduto.getIdProduto());
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

    public String adicionarCliente(Cliente mCliente) {
        String query = "INSERT INTO tbclientes (idClientes, idTipo, nome, snome, endereco, telefone, idCidade, dataNascimento, dataCadastro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (var ps = cnn.prepareStatement(query)) {
            ps.setString(1, mCliente.getIdCliente());
            ps.setInt(2, mCliente.getIdTipo());
            ps.setString(3, mCliente.getNome());
            ps.setString(4, mCliente.getSNome());
            ps.setString(5, mCliente.getEndereco());
            ps.setString(6, mCliente.getTelefone());
            ps.setInt(7, mCliente.getIdCidade());
            ps.setString(8, Utilidades.formatDate(mCliente.getDNascimento()));
            ps.setString(9, Utilidades.formatDate(mCliente.getData()));
            ps.executeUpdate();
            return "Cliente cadastrado com sucesso!";
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return "Cliente não pode ser cadastrado devido a um erro de comunicação com o SGBD!";
        }
    }

    public void adicionarVendas(int idVenda, String idCliente, Date fdata, int idProduto, String descricaoProduto, double precoProduto, int quantidadeProduto, double valorProduto) {
        try {
            String sql = "INSERT INTO tbvendas (idVenda, idProduto, idCliente, fdata, descricao, preco, quantidade, valor) VALUES ("
                    + idVenda + ", "
                    + idProduto + ", '"
                    + idCliente + "', '"
                    + Utilidades.formatDate(fdata) + "', '"
                    + descricaoProduto + "', "
                    + precoProduto + ", "
                    + quantidadeProduto + ", "
                    + valorProduto + ")";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void adicionarDetalheVendas(int idVenda, int idLinha, String idProduto, String descricao, int preco, int quantidade) {
        try {
            String sql = "INSET INTO tbdetalhevendas VALUES("
                    + idVenda + ", "
                    + idLinha + ", '"
                    + idProduto + "', '"
                    + descricao + "', "
                    + preco + ", "
                    + quantidade + ")";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //---------------------------------------------EDITANDO----------------------------------------------------//
    public String editarUsuario(Usuario mUsuario) {
        String sql = "UPDATE tbusuario SET nome = ?, snome = ?, senha = ?, chave = ?, idPerfil = ? WHERE idUsuario = ?";
        try (var ps = cnn.prepareStatement(sql)) {
            ps.setString(1, mUsuario.getNome());
            ps.setString(2, mUsuario.getSnome());
            ps.setString(3, mUsuario.getSenha());
            ps.setString(4, mUsuario.getChave());
            ps.setInt(5, mUsuario.getPerfil());
            ps.setInt(6, Integer.parseInt(mUsuario.getIdUsuario()));
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 1) {
                return "Usuário editado com sucesso";
            } else {
                return "Não foi possível editar este usuário!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return "Não foi possível editar este usuário devido a um erro de comunicação com o SGBD!";
        }
    }

    public String editarCliente(Cliente mCliente) {
        String sql = "UPDATE tbclientes SET idTipo = ?, nome = ?, snome = ?, endereco = ?, telefone = ?, idCidade = ?, dataNascimento = ?, dataCadastro = ? WHERE idClientes = ?";
        try (var ps = cnn.prepareStatement(sql)) {
            ps.setInt(1, mCliente.getIdTipo());
            ps.setString(2, mCliente.getNome());
            ps.setString(3, mCliente.getSNome());
            ps.setString(4, mCliente.getEndereco());
            ps.setString(5, mCliente.getTelefone());
            ps.setInt(6, mCliente.getIdCidade());
            ps.setString(7, Utilidades.formatDate(mCliente.getDNascimento()));
            ps.setString(8, Utilidades.formatDate(mCliente.getData()));
            ps.setInt(9, Integer.parseInt(mCliente.getIdCliente()));
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 1) {
                return "Cliente editado com sucesso";
            } else {
                return "Não foi possível editar este cliente!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return "Não foi possível editar este cliente devido a um erro de comunicação com o SGBD!";
        }
    }

    public String editarProduto(Produto mProduto) {
        String sql = "UPDATE tbprodutos SET descricao = ?, preco = ?, idImposto = ?, notas = ? WHERE idProduto = ?";
        try (var ps = cnn.prepareStatement(sql)) {
            ps.setString(1, mProduto.getDescricao());
            ps.setDouble(2, mProduto.getPreco());
            ps.setInt(3, mProduto.getImposto());
            ps.setString(4, mProduto.getAnotacao());
            ps.setInt(5, mProduto.getIdProduto());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return "Produto editado com sucesso";
            } else {
                return "Não foi possível editar este produto!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return "Não foi possível editar este produto devido a um erro de comunicação com o SGBD!";
        }
    }

    //---------------------------------------DELETANDO----------------------------------------------------//
    public String deletarUsuario(String usuarioId) {
        try {
            String sql = "DELETE FROM tbusuarios WHERE idUsuario = ?";
            var ps = cnn.prepareStatement(sql);
            ps.setString(1, usuarioId);
            ps.executeUpdate();

            return "Usuário deletado com sucesso!";
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return "Não foi possível deletar este usuário!";
        }
    }

    public String deletarCliente(String idCliente) {
        String sql = "DELETE FROM tbclientes WHERE idCliente = ?";
        try (var ps = cnn.prepareStatement(sql)) {
            ps.setString(1, idCliente);
            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                return "Cliente deletado com sucesso!";
            } else {
                return "Não foi possível encontrar um cliente com o id informado!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return "Não foi possível deletar este cliente!";
        }
    }

    public String deletarProduto(String idProduto) {
        String sql = "DELETE FROM tbprodutos WHERE idProduto = ?";
        try (var ps = cnn.prepareStatement(sql)) {
            ps.setString(1, idProduto);
            int result = ps.executeUpdate();

            if (result > 0) {
                return "Produto deletado com sucesso!";
            } else {
                return "Não foi possível deletar este produto!";
            }

        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return "Não foi possível deletar este produto!";
        }
    }
    //------------------------------------------------MÉTODOS GETS-------------------------------------------------------//

    public ResultSet getUsuarios() {
        try {
            String sql = "SELECT * FROM tbusuarios";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, "Erro ao obter os usuários", ex);

            return null;
        }
    }

    public ResultSet getClientes() {
        try {
            String sql = "SELECT * FROM tbclientes";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, "Erro ao obter os clientes", ex);

            return null;
        }
    }

    public ResultSet getProdutos() {
        try {
            String sql = "SELECT * FROM tbprodutos";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, "Erro ao obter os produtos", ex);

            return null;
        }
    }

    public ResultSet getVendas() {
        try {
            String sql = "SELECT * FROM tbvendas";
            PreparedStatement statement = cnn.prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, "Erro ao obter as vendas", ex);

            return null;
        }
    }

    public ResultSet getConsulta(String sql) {
        try {
            PreparedStatement statement = cnn.prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, "Erro ao executar consulta", ex);

            return null;
        }
    }

    public Produto getProduto(String idProduto) {
        try {
            Produto mProduto = null;
            String sql = "SELECT * FROM tbprodutos " + "WHERE idProduto = '" + idProduto + "'";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                mProduto = new Produto(
                        rs.getInt("idProduto"),
                        rs.getString("descricao"),
                        rs.getFloat("preco"),
                        rs.getInt("idImposto"),
                        rs.getString("notas"));
            }
            return mProduto;
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int getNumeroVenda() {
        try {
            String sql = "select max(idVenda) as from tbvendas";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("num") + 1;
            } else {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }

    //--------------------------------------------------NÚMEROS-------------------------------------------------------------//
    public int numeroUsuarios() {
        try {
            String sql = "SELECT COUNT(*) AS num FROM tbusuarios";

            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("num");
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int numeroClientes() {
        try {
            String sql = "SELECT COUNT(*) AS num FROM tbclientes";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("num");
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int numeroProdutos() {
        try {
            String sql = "SELECT COUNT(*) AS num FROM tbprodutos";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("num");
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    //-----------------------------------------TROCA DE SENHA---------------------------------------------------//
    public void trocarSenha(String usuario, String senha) {
        try {
            String chave = null;
            String sql = "UPDATE tbusuarios SET"
                    + "senha = '" + senha + "' "
                    + "chave = '" + chave + "' "
                    + "WHERE idUsuario = '" + usuario + "'";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//--------------------------------------------CADASTRO DE INFORMAÇÕES-----------------------------------------------//
    public static void cadastrarInformacoesAvon(String cedente, double codigoBarras, Date dataVencimento, float valorPagamento, String situacao) {
        String query = "INSERT INTO avon (cedente, codigoBarras, dataVencimento, valorPagamento, situacao) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = cnn.prepareStatement(query);
            statement.setString(1, cedente);
            statement.setDouble(2, codigoBarras);
            statement.setDate(3, new java.sql.Date(dataVencimento.getTime()));
            statement.setFloat(4, valorPagamento);
            statement.setString(5, situacao);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cadastrarInformacoesBoticario(String cedente, double codigoBarras, Date dataVencimento, float valorPagamento, String situacao) {
        String query = "INSERT INTO boticario (cedente, codigoBarras, dataVencimento, valorPagamento, situacao) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = cnn.prepareStatement(query);
            statement.setString(1, cedente);
            statement.setDouble(2, codigoBarras);
            statement.setDate(3, new java.sql.Date(dataVencimento.getTime()));
            statement.setFloat(4, valorPagamento);
            statement.setString(5, situacao);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cadastrarInformacoesEudora(String cedente, double codigoBarras, Date dataVencimento, float valorPagamento, String situacao) {
        String query = "INSERT INTO eudora (cedente, codigoBarras, dataVencimento, valorPagamento, situacao) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = cnn.prepareStatement(query);
            statement.setString(1, cedente);
            statement.setDouble(2, codigoBarras);
            statement.setDate(3, new java.sql.Date(dataVencimento.getTime()));
            statement.setFloat(4, valorPagamento);
            statement.setString(5, situacao);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cadastrarInformacoesGolfran(String cedente, double codigoBarras, Date dataVencimento, float valorPagamento, String situacao) {
        String query = "INSERT INTO golfran (cedente, codigoBarras, dataVencimento, valorPagamento, situacao) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = cnn.prepareStatement(query);
            statement.setString(1, cedente);
            statement.setDouble(2, codigoBarras);
            statement.setDate(3, new java.sql.Date(dataVencimento.getTime()));
            statement.setFloat(4, valorPagamento);
            statement.setString(5, situacao);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cadastrarInformacoesNatura(String cedente, double codigoBarras, Date dataVencimento, float valorPagamento, String situacao) {
        String query = "INSERT INTO natura (cedente, codigoBarras, dataVencimento, valorPagamento, situacao) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = cnn.prepareStatement(query);
            statement.setString(1, cedente);
            statement.setDouble(2, codigoBarras);
            statement.setDate(3, new java.sql.Date(dataVencimento.getTime()));
            statement.setFloat(4, valorPagamento);
            statement.setString(5, situacao);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluirBoleto(String cedente, double codigoBarras) {
        String query = "DELETE FROM boletos WHERE cedente = ? AND codigoBarras = ?";

        try {
            PreparedStatement statement = cnn.prepareStatement(query);
            statement.setString(1, cedente);
            statement.setDouble(2, codigoBarras);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void atualizarTabelaAvon(DefaultTableModel tableModel) {
        // Consulte o banco de dados para obter os registros da tabela avon
        String query = "SELECT * FROM avon";
        atualizarTabela(query, tableModel);
    }

    public static void atualizarTabelaBoticario(DefaultTableModel tableModel) {
        // Consulte o banco de dados para obter os registros da tabela boticario
        String query = "SELECT * FROM boticario";
        atualizarTabela(query, tableModel);
    }

    public static void atualizarTabelaNatura(DefaultTableModel tableModel) {
        // Consulte o banco de dados para obter os registros da tabela natura
        String query = "SELECT * FROM natura";
        atualizarTabela(query, tableModel);
    }

    public static void atualizarTabelaEudora(DefaultTableModel tableModel) {
        // Consulte o banco de dados para obter os registros da tabela eudora
        String query = "SELECT * FROM eudora";
        atualizarTabela(query, tableModel);
    }

    public static void atualizarTabelaGolfran(DefaultTableModel tableModel) {
        // Consulte o banco de dados para obter os registros da tabela golfran
        String query = "SELECT * FROM golfran";
        atualizarTabela(query, tableModel);
    }

    private static void atualizarTabela(String query, DefaultTableModel tableModel) {
        try {
            PreparedStatement statement = cnn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            tableModel.setRowCount(0);

            while (resultSet.next()) {
                int idboleto = resultSet.getInt("idboleto");
                String cedente = resultSet.getString("cedente");
                double codigoBarras = resultSet.getDouble("codigoBarras");
                Date dataVencimento = resultSet.getDate("dataVencimento");
                float valorPagamento = resultSet.getFloat("valorPagamento");
                String situacao = resultSet.getString("situacao");

                Object[] rowData = {idboleto, cedente, codigoBarras, dataVencimento, valorPagamento, situacao};
                tableModel.addRow(rowData);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel pesquisarNoBanco(String tabela, String coluna, String valor) {
        DefaultTableModel tableModel = new DefaultTableModel();

        String query = "SELECT * FROM " + tabela;
        boolean hasCondition = false;

        if (!coluna.isEmpty() && !valor.isEmpty()) {
            if (coluna.equals("dataVencimento") && valor.equals("A vencer")) {
                // Adicionar condição para boletos a vencer
                query += " WHERE dataVencimento <= ?";
                hasCondition = true;
            } else if (coluna.equals("status") && valor.equals("Pagos")) {
                // Adicionar condição para boletos pagos (data de pagamento um dia após a data de vencimento)
                query += " WHERE dataVencimento <= DATE_ADD(CURDATE(), INTERVAL 1 DAY)";
                hasCondition = true;
            } else {
                query += " WHERE " + coluna + " = ?";
                hasCondition = true;
            }
        }

        try {
            PreparedStatement statement = cnn.prepareStatement(query);

            if (hasCondition) {
                if (coluna.equals("dataVencimento") && valor.equals("A vencer")) {
                    // Definir o valor com a data de vencimento atual
                    Date dataVencimento = new Date();
                    statement.setDate(1, new java.sql.Date(dataVencimento.getTime()));
                } else {
                    statement.setString(1, valor);
                }
            }

            ResultSet resultSet = statement.executeQuery();

            // Obtenha os metadados do ResultSet para criar as colunas do modelo da tabela
            ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                tableModel.addColumn(metaData.getColumnLabel(column));
            }

            // Preencha o modelo da tabela com os dados do ResultSet
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int column = 1; column <= columnCount; column++) {
                    rowData[column - 1] = resultSet.getObject(column);
                }
                tableModel.addRow(rowData);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tableModel;
    }

//    public int posicaoProduto(String valor) {
//        for (int i = 0; i < conPro; i++) {
//            if (msProdutos[i].getIdProduto().equals(produto)) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
