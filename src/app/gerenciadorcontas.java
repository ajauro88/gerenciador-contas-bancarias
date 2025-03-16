package app;

import java.util.ArrayList;
import java.util.Scanner;

public class gerenciadorcontas {

    private static final ArrayList<Conta> contas = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== Gerenciador de Contas Bancárias =====");
            System.out.println("1 - Cadastrar nova conta");
            System.out.println("2 - Consultar conta");
            System.out.println("3 - Listar todas as contas");
            System.out.println("4 - Depositar");
            System.out.println("5 - Sacar");
            System.out.println("6 - Excluir conta");
            System.out.println("7 - Encerrar programa");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer do scanner

            switch (opcao) {
                case 1 -> cadastrarConta();
                case 2 -> consultarConta();
                case 3 -> listarContas();
                case 4 -> realizarDeposito();
                case 5 -> realizarSaque();
                case 6 -> excluirConta();
                case 7 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 7);
        scanner.close();
    }

    private static void cadastrarConta() {
        Conta novaConta = new Conta();

        System.out.print("Número da conta: ");
        novaConta.setConta(scanner.nextLine());

        System.out.print("Nome da agência: ");
        novaConta.setAgencia(scanner.nextLine());

        System.out.print("Nome do cliente: ");
        novaConta.setNomeCliente(scanner.nextLine());

        novaConta.setSaldo(0.0); // Conta começa com saldo zero

        contas.add(novaConta);
        System.out.println("Conta cadastrada com sucesso!");
    }

    private static void consultarConta() {
        System.out.print("Digite o número da conta: ");
        String numero = scanner.nextLine();
        for (Conta conta : contas) {
            if (conta.getConta().equals(numero)) {
                conta.imprimir();
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    private static void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (Conta conta : contas) {
                conta.imprimir();
                System.out.println("--------------------");
            }
        }
    }

    private static void realizarDeposito() {
        System.out.print("Número da conta: ");
        String numero = scanner.nextLine();
        for (Conta conta : contas) {
            if (conta.getConta().equals(numero)) {
                System.out.print("Valor do depósito: R$ ");
                double valor = scanner.nextDouble();
                scanner.nextLine();
                if (valor > 0) {
                    conta.depositar(valor);
                    System.out.println("Depósito realizado com sucesso!");
                } else {
                    System.out.println("Valor inválido para depósito.");
                }
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    private static void realizarSaque() {
        System.out.print("Número da conta: ");
        String numero = scanner.nextLine();
        for (Conta conta : contas) {
            if (conta.getConta().equals(numero)) {
                System.out.print("Valor do saque: R$ ");
                double valor = scanner.nextDouble();
                scanner.nextLine();
                if (valor > 0) {
                    int resultado = conta.sacar(valor);
                    if (resultado == 1) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                } else {
                    System.out.println("Valor inválido.");
                }
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    private static void excluirConta() {
        System.out.print("Número da conta a ser excluída: ");
        String numero = scanner.nextLine();
        for (Conta conta : contas) {
            if (conta.getConta().equals(numero)) {
                contas.remove(conta);
                System.out.println("Conta excluída com sucesso.");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
}
