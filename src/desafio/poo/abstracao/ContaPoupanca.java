package desafio.poo.abstracao;

import desafio.exceptions.SaldoInsuficienteException;

public class ContaPoupanca extends Conta {
    @Override
    public double calcSaldoTotal() {
        return saldoConta;
    }

    public ContaPoupanca(int agencia, int numeroConta, double saldoInicial) {
        super.agencia = agencia;
        super.numConta = numeroConta;
        super.saldoConta = saldoInicial;
    }

    @Override
    public void sacarDaConta(double valorSaque) throws SaldoInsuficienteException {

        // Não há saque de valores negativos:
        if (valorSaque <= 0)
            return;

        if (saldoConta < valorSaque)
            throw new SaldoInsuficienteException();

        saldoConta -= valorSaque;
        System.out.println("Conta Poupança: saque realizado com sucesso no valor de R$ " + valorSaque);

    }

    @Override
    public void depositarEmConta(double valorDeposito) {
        if (valorDeposito > 0) {
            {
                saldoConta += valorDeposito;
                System.out.println("Conta Poupança: deposito realizado com sucesso no valor de R$ " + valorDeposito);
            }

        }
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "agencia=" + agencia +
                ", numConta=" + numConta +
                ", saldoConta=" + saldoConta +
                '}';
    }
}
