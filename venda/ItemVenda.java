
package venda;

public class ItemVenda {
    private Produto produto;
    private int quantidade;
    private double precoUnitario;

    public ItemVenda(Produto produto, int quantidade, double precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return produto.getNome() + " - Quantidade: " + quantidade + ", Preço unitário: " + precoUnitario;
    }
}
