package classes;

public class Produto {

    private int Produto;
    private String descricao;
    private double preco;
    private String anotacao;

    public Produto(int Produto, String descricao, double preco, String anotacao) {
        this.Produto = Produto;
        this.descricao = descricao;
        this.preco = preco;
        this.anotacao = anotacao;
    }

    public int getProduto() {
        return Produto;
    }

    public void setProduto(int Produto) {
        this.Produto = Produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
