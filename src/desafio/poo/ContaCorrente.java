package desafio.poo;

import desafio.poo.exceptions.SaldoInsuficienteException;

public class ContaCorrente extends Conta {

    double limiteAutorizado = 0;

    public ContaCorrente(int agencia, int numeroConta, double saldoInicial, double limiteAutorizado) {
        super.agencia = agencia;
        super.numConta = numeroConta;
        super.saldoConta = saldoInicial;
        this.limiteAutorizado = limiteAutorizado;
    }

    @Override
    public double calcSaldoTotal() {
        return saldoConta + limiteAutorizado;
    }

    @Override
    public void sacarDaConta(double valorSaque) throws SaldoInsuficienteException {

        // Não há saque de valores negativos:
        if (valorSaque <= 0)
            return;

        if (saldoConta - valorSaque < -limiteAutorizado)
        {
            System.out.println("Debitar da Conta Corrente: saldo insuficiente");
            throw new SaldoInsuficienteException();
        }

        saldoConta -= valorSaque;
    }

    @Override
    public void depositarEmConta(double valorDeposito) {
        if (valorDeposito > 0)
            saldoConta += valorDeposito;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "agencia='" + agencia + '\'' +
                ", numConta='" + numConta + '\'' +
                ", saldoConta=" + saldoConta +
                ", limiteAutorizado=" + limiteAutorizado +
                '}';
    }
}
