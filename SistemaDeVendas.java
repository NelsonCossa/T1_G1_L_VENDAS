package venda;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeVendas {
    private Produto[] estoque;
    private int numeroDeProdutos;
    private ArrayList<Venda> historicoVendas;
    private final int TAMANHO_MAXIMO_ESTOQUE = 100;

    public SistemaDeVendas() {
        estoque = new Produto[TAMANHO_MAXIMO_ESTOQUE];
        numeroDeProdutos = 0;
        historicoVendas = new ArrayList<>();
    }

    public void cadastrarProduto() {
        if (numeroDeProdutos < TAMANHO_MAXIMO_ESTOQUE) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print("Digite o nome do produto: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o preço do produto: ");
                double preco = scanner.nextDouble();
                if (preco <= 0) {
                    System.out.println("O preço deve ser maior que zero.");
                    return;
                }
                System.out.print("Digite a quantidade do produto: ");
                int quantidade = scanner.nextInt();
                if (quantidade < 0) {
                    System.out.println("A quantidade não pode ser negativa.");
                    return;
                }

                System.out.print("Esse produto está em promoção? (s/n): ");
                char promocao = scanner.next().charAt(0);

                if (promocao == 's' || promocao == 'S') {
                    System.out.print("Digite o percentual de desconto: ");
                    double percentualDesconto = scanner.nextDouble();
                    ProdutoPromocional produtoPromocional = new ProdutoPromocional(nome, preco, quantidade, percentualDesconto);
                    estoque[numeroDeProdutos] = produtoPromocional;
                } else {
                    Produto produto = new Produto(nome, preco, quantidade);
                    estoque[numeroDeProdutos] = produto;
                }
                numeroDeProdutos++;
                System.out.println("Produto cadastrado com sucesso!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida. Tente novamente.");
            }
        } else {
            System.out.println("Estoque cheio. Não é possível cadastrar mais produtos.");
        }
    }

    public void registrarVenda() {
        Venda novaVenda = new Venda();
        Scanner scanner = new Scanner(System.in);
        char continuar = 0;

        do {
            System.out.println("Escolha um produto para adicionar à venda: ");
            for (int i = 0; i < numeroDeProdutos; i++) {
                if (estoque[i] instanceof ProdutoPromocional) {
                    ProdutoPromocional produtoPromo = (ProdutoPromocional) estoque[i];
                    System.out.println((i + 1) + " - " + produtoPromo.toString() + " (Em Promoção)");
                } else {
                    System.out.println((i + 1) + " - " + estoque[i].toString());
                }
            }

            try {
                int escolha = scanner.nextInt() - 1;
                if (escolha >= 0 && escolha < numeroDeProdutos) {
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    if (quantidade > estoque[escolha].getQuantidade()) {
                        System.out.println("Quantidade indisponível em estoque.");
                        continue;
                    }
                    novaVenda.adicionarProduto(estoque[escolha], quantidade);
                } else {
                    System.out.println("Produto inválido.");
                }

                System.out.print("Deseja adicionar mais produtos? (s/n): ");
                continuar = scanner.next().charAt(0);
            } catch (Exception e) {
                System.out.println("Entrada inválida, tente novamente.");
                scanner.nextLine(); // Limpa o buffer
                continuar = 'n'; // Para evitar loop infinito em caso de erro
            }
        } while (continuar == 's' || continuar == 'S');

        historicoVendas.add(novaVenda);
        System.out.println("Venda registrada com sucesso! Total da venda: " + novaVenda.getTotalVenda());
    }

    public void consultarVendas() {
        if (historicoVendas.isEmpty()) {
            System.out.println("Não há vendas registradas.");
            return;
        }

        System.out.println("Histórico de Vendas:");
        for (Venda venda : historicoVendas) {
            System.out.println(venda.toString());
        }
    }
}
