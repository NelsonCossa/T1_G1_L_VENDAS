package vendas;






public class Produto {
    private String nome; // Nome do produto
    private double preco; // Preço do produto
    private int quantidade; // Quantidade em estoque do produto

    // Construtor da classe Produto
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Métodos getters para acessar as propriedades do produto
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Método setter para atualizar a quantidade do produto
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método para retornar uma representação em String do objeto Produto
    @Override
    public String toString() {
        return "Produto: " + nome + ", Preço: " + preco + ", Quantidade: " + quantidade;
    }
}
