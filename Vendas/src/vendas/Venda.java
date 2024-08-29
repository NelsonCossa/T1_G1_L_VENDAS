package vendas;






import java.util.ArrayList; // Importa a classe ArrayList para armazenar produtos vendidos

public class Venda {
    private ArrayList<Produto> produtosVendidos; // Lista de produtos vendidos
    private double totalVenda; // Total da venda

    // Construtor da classe Venda
    public Venda() {
        produtosVendidos = new ArrayList<>(); // Inicializa a lista de produtos vendidos
        totalVenda = 0.0; // Inicializa o total da venda
    }

    // Método para adicionar um produto à venda
    public void adicionarProduto(Produto produto, int quantidade) {
        // Verifica se a quantidade desejada está disponível em estoque
        if (quantidade <= produto.getQuantidade()) {
            // Atualiza a quantidade do produto em estoque
            produto.setQuantidade(produto.getQuantidade() - quantidade);
            // Adiciona o produto vendido à lista
            produtosVendidos.add(new Produto(produto.getNome(), produto.getPreco(), quantidade));
            // Atualiza o total da venda
            totalVenda += produto.getPreco() * quantidade;
        } else {
            // Mensagem de erro se a quantidade não estiver disponível
            System.out.println("Quantidade indisponível em estoque.");
        }
    }

    

    // Método para obter o total da venda
    public double getTotalVenda() {
        return totalVenda;
    }

    // Método para retornar uma representação em String do objeto Venda
    @Override
    public String toString() {
        return "Venda{" + "produtosVendidos=" + produtosVendidos + ", totalVenda=" + totalVenda + '}';
    }
}
