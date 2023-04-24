package tests.desafio.poo;

import desafio.poo.exceptions.SaldoInsuficienteException;
import desafio.poo.ContaPoupanca;
import org.junit.jupiter.api.Assertions;

class ContaPoupancaTest {

    @org.junit.jupiter.api.Test
    void calcSaldoTotal() throws SaldoInsuficienteException {

        ContaPoupanca cp1 = new ContaPoupanca(0001, 1234, 600);

        cp1.sacarDaConta(100d);
        Assertions.assertEquals(500, cp1.calcSaldoTotal());

        cp1.depositarEmConta(50d);
        Assertions.assertEquals(550, cp1.calcSaldoTotal());

    }

    @org.junit.jupiter.api.Test
    void sacarDaConta() throws SaldoInsuficienteException {

        // Iniciando conta poupança com saldo de R$600
        ContaPoupanca cp1 = new ContaPoupanca(0001, 1234, 600);

        // Vamos realizar um saque normal:
        cp1.sacarDaConta(100d);
        Assertions.assertEquals(500, cp1.calcSaldoTotal());

        // Vamos tentar sacar um valor negativo - não é para alterar o saldo em conta:
        cp1.sacarDaConta(-250d);
        Assertions.assertEquals(500, cp1.calcSaldoTotal());

        // Vamos tentar sacar mais do que temos em conta:
        Assertions.assertThrowsExactly(SaldoInsuficienteException.class, () -> {
            // Saldo é R$500 e vamos tentar sacar R$800
            cp1.sacarDaConta(800);
        });
    }

    @org.junit.jupiter.api.Test
    void depositarEmConta() {

        // Iniciando conta poupança com saldo de R$600
        ContaPoupanca cp1 = new ContaPoupanca(0001, 1234, 600);

        cp1.depositarEmConta(400d);
        Assertions.assertEquals(1000, cp1.calcSaldoTotal());

        // Vamos tentar depositar um valor negativo - não é para alterar o saldo da conta:
        cp1.depositarEmConta(-200d);
        Assertions.assertEquals(1000, cp1.calcSaldoTotal());
    }
}