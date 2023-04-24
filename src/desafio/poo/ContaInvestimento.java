package desafio.poo;

import desafio.poo.exceptions.SaldoInsuficienteException;

public class ContaInvestimento extends ContaCorrente {

    double valorInvestido = 0;

    Boolean baixaAutomaticaInvestimento = false;



    public ContaInvestimento(int agencia, int numeroConta, double saldoInicial, double limiteAutorizado, double valorInvestido, Boolean baixaAutomaticaInvestimento) {
        super(agencia, numeroConta, saldoInicial, limiteAutorizado);
        this.valorInvestido = valorInvestido;
        this.baixaAutomaticaInvestimento = baixaAutomaticaInvestimento;
    }


    @Override
    public double calcSaldoTotal() {

        return saldoConta + valorInvestido;
    }

    @Override
    public void sacarDaConta(double valorSaque) throws SaldoInsuficienteException {

        // Não há saque de valores negativos:
        if (valorSaque <= 0)
            return;

        // Se estamos sacando mais que o saldo em conta, porém, temos saldo em investimento:
        if ((valorSaque > saldoConta)               // Saque superior ao saldo em conta...
                && (baixaAutomaticaInvestimento)    // cliente optou por baixa automática
                && (valorSaque <= (saldoConta + valorInvestido)))  // tem saldo investido disponível para saque
            // Então, antes de sacar da conta, vamos sacar do investimento:
            sacarInvestimento(valorSaque - saldoConta);


        // Exceto pelo saque no valor do investimento, o saque é o mesmo da Conta Corrente. Portanto, chamamos ContaCorrente.sacarDaConta();
        super.sacarDaConta(valorSaque);

    }

    @Override
    public void depositarEmConta(double valorDeposito) {
        super.depositarEmConta(valorDeposito);
    }

    public void investir(double valorInvestimento) throws SaldoInsuficienteException {
        if (valorInvestimento > saldoConta)
        {
            System.out.println("O valor do investimento é superior ao saldo da conta. Favor realizar um depósito antes");
            throw new SaldoInsuficienteException();
        }
        saldoConta -= valorInvestimento;
        valorInvestido += valorInvestimento;
    }

    public void sacarInvestimento(double valorSaque) throws SaldoInsuficienteException {
        if (valorSaque <= valorInvestido) {
            valorInvestido -= valorSaque;
            saldoConta += valorSaque;
        }
        else throw new SaldoInsuficienteException();
    }

    @Override
    public String toString() {
        return "ContaInvestimento{" +
                "agencia=" + agencia +
                ", numConta=" + numConta +
                ", saldoConta=" + saldoConta +
                ", valorInvestido=" + valorInvestido +
                ", baixaAutomaticaInvestimento=" + baixaAutomaticaInvestimento +
                '}';
    }






    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public Boolean getBaixaAutomaticaInvestimento() {
        return baixaAutomaticaInvestimento;
    }

    public void setBaixaAutomaticaInvestimento(Boolean baixaAutomaticaInvestimento) {
        this.baixaAutomaticaInvestimento = baixaAutomaticaInvestimento;
    }
}
