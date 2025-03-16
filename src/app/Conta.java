package app;

public class Conta {
    // Atributos privados (Encapsulamento)
    private String conta;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    // Getters e Setters (para acessar e modificar os atributos)
    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Métodos para realizar operações bancárias
    public int sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return 1; // OK, saque realizado
        }
        return 0; // Falha, saldo insuficiente
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void imprimir() {
        System.out.println("=== Dados da Conta ===");
        System.out.println("Número da Conta: " + conta);
        System.out.println("Agência: " + agencia);
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Saldo: R$ " + saldo);
    }
}
