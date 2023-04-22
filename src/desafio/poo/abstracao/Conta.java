package desafio.poo.abstracao;

import desafio.exceptions.SaldoInsuficienteException;

public abstract class Conta {

    // public Pessoa pessoa;

    public int agencia;
    public int numConta;

    protected double saldoConta = 0;

    public abstract double calcSaldoTotal();

    public abstract void sacarDaConta(double valorSaque) throws SaldoInsuficienteException;

    public abstract void depositarEmConta(double valorDeposito);



}
