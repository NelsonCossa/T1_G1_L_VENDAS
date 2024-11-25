package venda;

public class ProdutoPromocional extends Produto {
    private double percentualDesconto; // Desconto em porcentagem

    // Construtor da classe ProdutoPromocional
    public ProdutoPromocional(String nome, double preco, int quantidade, double percentualDesconto) {
        // Chama o construtor da classe Produto para inicializar os dados
        super(nome, preco, quantidade);

        // Valida o percentual de desconto
        if (percentualDesconto < 0 || percentualDesconto > 100) {
            throw new IllegalArgumentException("O percentual de desconto deve ser entre 0 e 100.");
        }

        this.percentualDesconto = percentualDesconto;
    }

    // Método para calcular o preço com desconto
    public double calcularPrecoComDesconto() {
        return getPreco() * (1 - percentualDesconto / 100);
    }

    // Método para exibir informações do produto promocional
    @Override
    public String toString() {
        return super.toString() + ", Desconto: " + percentualDesconto + "%, Preço com desconto: " + calcularPrecoComDesconto();
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }
}
