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




    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }


}
