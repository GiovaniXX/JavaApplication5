package classes;

public class Opcoes {

    private final String valor;
    private final String descricao;

    public Opcoes(String valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    /**
     * Retorna o valor associado a esta opção.
     *
     * @return
     */
    public String getValor() {
        return valor;
    }

    /**
     * Retorna a descrição desta opção.
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Retorna uma representação em String desta opção.
     */
    @Override
    public String toString() {
        return descricao;
    }
}
