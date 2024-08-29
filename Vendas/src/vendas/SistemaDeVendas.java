package vendas;

 import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeVendas {
    private Produto[] estoque; // Array de produtos em estoque
    private int numeroDeProdutos; // Contador para o número de produtos cadastrados
    private ArrayList<Venda> historicoVendas; // Lista de histórico de vendas
    private final int TAMANHO_MAXIMO_ESTOQUE = 100; // Tamanho máximo do array de estoque

    // Construtor da classe SistemaDeVendas
    public SistemaDeVendas() {
        estoque = new Produto[TAMANHO_MAXIMO_ESTOQUE]; // Inicializa o array de estoque
        numeroDeProdutos = 0; // Inicializa o contador de produtos
        historicoVendas = new ArrayList<>(); // Inicializa a lista de histórico de vendas
    }

    // Método para cadastrar um novo produto no estoque
    public void cadastrarProduto() {
        if (numeroDeProdutos < TAMANHO_MAXIMO_ESTOQUE) {
            Scanner scanner = new Scanner(System.in); // Scanner para entrada de dados do usuário
            System.out.print("Digite o nome do produto: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o preço do produto: ");
            double preco = scanner.nextDouble();
            System.out.print("Digite a quantidade do produto: ");
            int quantidade = scanner.nextInt();

            // Adiciona o novo produto ao array de estoque
            estoque[numeroDeProdutos] = new Produto(nome, preco, quantidade);
            numeroDeProdutos++;
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Estoque cheio. Não é possível cadastrar mais produtos.");
        }
    }

    // Método para registrar uma nova venda
    public void registrarVenda() {
        Venda novaVenda = new Venda(); // Cria uma nova venda
        Scanner scanner = new Scanner(System.in);
        char continuar; // Variável para controle do loop

        // Loop para adicionar produtos à venda
        do {
            System.out.println("Escolha um produto para adicionar à venda: ");
            // Lista todos os produtos disponíveis em estoque
            for (int i = 0; i < numeroDeProdutos; i++) {
                System.out.println((i + 1) + " - " + estoque[i].toString());
            }
            int escolha = scanner.nextInt() - 1; // Lê a escolha do usuário

            // Verifica se a escolha é válida
            if (escolha >= 0 && escolha < numeroDeProdutos) {
                System.out.print("Digite a quantidade: ");
                int quantidade = scanner.nextInt();
                novaVenda.adicionarProduto(estoque[escolha], quantidade); // Adiciona o produto à venda
            } else {
                System.out.println("Produto inválido.");
            }

            // Pergunta se o usuário deseja adicionar mais produtos
            System.out.print("Deseja adicionar mais produtos? (s/n): ");
            continuar = scanner.next().charAt(0);
        } while (continuar == 's' || continuar == 'S'); // Continua enquanto o usuário quiser

        // Adiciona a nova venda ao histórico
        historicoVendas.add(novaVenda);
        System.out.println("Venda registrada com sucesso! Total da venda: " + novaVenda.getTotalVenda());
    }

    // Método para consultar o histórico de vendas
    public void consultarVendas() {
        // Verifica se há vendas registradas
        if (historicoVendas.isEmpty()) {
            System.out.println("Não há vendas registradas.");
            return;
        }

        // Exibe o histórico de vendas
        System.out.println("Histórico de Vendas:");
        for (Venda venda : historicoVendas) {
            System.out.println(venda.toString());
        }
    }
}
 

