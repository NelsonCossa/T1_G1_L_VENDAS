package venda;

import java.util.ArrayList;

public class Venda {
    private ArrayList<ItemVenda> itens;
    private double totalVenda;

    public Venda() {
        itens = new ArrayList<>();
        totalVenda = 0.0;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        double precoFinal = produto.getPreco();

        if (produto instanceof ProdutoPromocional) {
            ProdutoPromocional produtoPromo = (ProdutoPromocional) produto;
            precoFinal = produtoPromo.calcularPrecoComDesconto();
        }

        itens.add(new ItemVenda(produto, quantidade, precoFinal));
        totalVenda += precoFinal * quantidade;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    @Override
    public String toString() {
        StringBuilder detalhesVenda = new StringBuilder("Itens da venda:\n");
        for (ItemVenda item : itens) {
            detalhesVenda.append(item.toString()).append("\n");
        }
        detalhesVenda.append("Total da venda: ").append(totalVenda);
        return detalhesVenda.toString();
    }
}
