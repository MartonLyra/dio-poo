import desafio.exceptions.SaldoInsuficienteException;
import desafio.poo.abstracao.Conta;
import desafio.poo.abstracao.ContaCorrente;
import desafio.poo.abstracao.ContaPoupanca;

import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {

        System.out.println("Vamos abrir uma Conta Poupança");
        Conta cPoupanca1 = new ContaPoupanca(1, 1122, 100);
        System.out.println("Status da Conta Poupança: " + cPoupanca1);

        System.out.println("Vamos depositar R$300 na Conta Poupança");
        cPoupanca1.depositarEmConta(300);
        System.out.println("Status da Conta Poupança: " + cPoupanca1);

        System.out.println("Vamos depositar mais R$200 na Conta Poupança");
        cPoupanca1.depositarEmConta(200);
        System.out.println("Status da Conta Poupança: " + cPoupanca1);

        System.out.println("Vamos sacar R$1.000 na Conta Poupança");
        try {
            cPoupanca1.sacarDaConta(1000);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Não é possível sacar R$1.000 na Conta Poupança - Saldo Insuficiente");
        }
        System.out.println("Status da Conta Poupança: " + cPoupanca1);

        System.out.println("------------------------------------");
        System.out.println("");
        System.out.println("------------------------------------");


        System.out.println("Vamos abrir uma Conta Corrente com saldo inicial de R$200 e limite pré-autorizado de R$1.200");
        Conta cCorrente1 = new ContaCorrente(1, 1133, 200,  1200);
        System.out.println("Status da Conta Corrente: " + cCorrente1);

        System.out.println("Vamos depositar R$300 da Conta Corrente");
        cCorrente1.depositarEmConta(300);
        System.out.println("Status da Conta Corrente: " + cCorrente1);

        System.out.println("Vamos sacar R$1.500 da Conta Corrente");
        try {
            cCorrente1.sacarDaConta(1600);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Não é possível sacar R$1.500 na Conta Corrente - Saldo Insuficiente");
        }
        System.out.println("Status da Conta Corrente: " + cCorrente1);

        System.out.println("Vamos sacar mais R$200 da Conta Corrente");
        try {
            cCorrente1.sacarDaConta(200);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Não é possível sacar R$200 da Conta Corrente - Saldo Insuficiente");
        }
        System.out.println("Status da Conta Corrente: " + cCorrente1);
    }
}