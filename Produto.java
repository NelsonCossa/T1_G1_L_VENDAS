package venda;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    // Construtor da classe Produto
    public Produto(String nome, double preco, int quantidade) {
        if (nome.matches(".*\\d.*")) {
            throw new IllegalArgumentException("O nome do produto não pode conter números.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + ", Preço: " + preco + ", Quantidade: " + quantidade;
    }
}
