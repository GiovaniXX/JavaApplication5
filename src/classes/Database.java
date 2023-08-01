package classes;

import com.sun.jdi.connect.spi.Connection;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/sgbd2023";
    private static final String USUARIO = "root";
    private static final String SENHA = "PerfectWorld2023@$";

    // Método para obter a conexão com o banco de dados
    public static Connection obterConexao() {
        Connection conexao = null;
        try {
            // Carrega o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Estabelece a conexão com o banco de dados
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao estabelecer a conexão com o banco de dados!");
            e.printStackTrace();
        }
        return conexao;
    }
}
