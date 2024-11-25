package venda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaDeVendas sistema = new SistemaDeVendas(); // Cria instância do sistema de vendas
        Scanner scanner = new Scanner(System.in); // Scanner para entrada de dados do usuário
        int opcao = 0; // Variável para armazenar a opção do usuário

        // Usa while para repetir até o usuário escolher sair (opção 4)
        while (opcao != 4) {
            try {
                // Exibe o menu de opções
                System.out.println("\n--- Sistema de Vendas ---");
                System.out.println("1. Cadastrar Produto");
                System.out.println("2. Registrar Venda");
                System.out.println("3. Consultar Vendas");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário

                // Valida a opção escolhida
                if (opcao < 1 || opcao > 4) {
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 4.");
                    continue;
                }

                switch (opcao) {
                    case 1:
                        // Cadastrar um novo produto
                        sistema.cadastrarProduto();
                        break;
                    case 2:
                        // Registrar uma nova venda
                        sistema.registrarVenda();
                        break;
                    case 3:
                        // Consultar o histórico de vendas
                        sistema.consultarVendas();
                        break;
                    case 4:
                        // Sair do programa
                        System.out.println("Encerrando o sistema...");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.nextLine(); // Limpa o buffer
            }
        }

        scanner.close(); // Fecha o scanner
    }
}
