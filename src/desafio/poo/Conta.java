package desafio.poo;

import desafio.poo.exceptions.SaldoInsuficienteException;

public abstract class Conta {

    // public Pessoa pessoa;

    public int agencia;
    public int numConta;

    protected double saldoConta = 0;



    public abstract double calcSaldoTotal();

    public abstract void sacarDaConta(double valorSaque) throws SaldoInsuficienteException;

    public abstract void depositarEmConta(double valorDeposito);


    public static void transferir (Conta contaOrigem, Conta contaDestino, double valorTransferencia) throws SaldoInsuficienteException {
        contaOrigem.sacarDaConta(valorTransferencia);
        contaDestino.depositarEmConta(valorTransferencia);
    }


    public int getAgencia() {
        return agencia;
    }

    public int getNumConta() {
        return numConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }


}
