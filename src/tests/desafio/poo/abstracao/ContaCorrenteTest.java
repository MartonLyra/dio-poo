package tests.desafio.poo.abstracao;

import desafio.exceptions.SaldoInsuficienteException;
import desafio.poo.abstracao.ContaCorrente;
import desafio.poo.abstracao.ContaPoupanca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaCorrenteTest {

    @Test
    void calcSaldoTotal() throws SaldoInsuficienteException {

        // Saldo inicial: R$600 ; Limite: R$800
        // Na conta corrente, o saldoTotal é a soma do saldo mais o limite pré-autorizado:
        ContaCorrente cc1 = new ContaCorrente(0001, 1234, 600, 800);
        Assertions.assertEquals(1400, cc1.calcSaldoTotal());

        cc1.sacarDaConta(100d);
        Assertions.assertEquals(1300, cc1.calcSaldoTotal());

        cc1.depositarEmConta(50d);
        Assertions.assertEquals(1350, cc1.calcSaldoTotal());

    }

    @Test
    void sacarDaConta() throws SaldoInsuficienteException {

        // Saldo inicial: R$600 ; Limite: R$200
        // Na conta corrente, o saldoTotal é a soma do saldo mais o limite pré-autorizado:
        ContaCorrente cc1 = new ContaCorrente(0001, 1234, 600,800);
        Assertions.assertEquals(1400, cc1.calcSaldoTotal());

        // Vamos realizar um saque normal:
        cc1.sacarDaConta(100d);
        Assertions.assertEquals(1300, cc1.calcSaldoTotal());

        // Vamos tentar sacar um valor negativo - não é para alterar o saldo em conta:
        cc1.sacarDaConta(-250d);
        Assertions.assertEquals(1300, cc1.calcSaldoTotal());

        // Sabendo que nosso saldo é de R$500 e nosso limite é de R$800, vamos sacar R$1.000:
        cc1.sacarDaConta(1000d);
        Assertions.assertEquals(300, cc1.calcSaldoTotal());


        // Vamos tentar sacar mais do que temos em conta + limite:
        Assertions.assertThrowsExactly(SaldoInsuficienteException.class, () -> {
            // Saldo é R$300 e vamos tentar sacar R$800
            cc1.sacarDaConta(800);
        });



    }

    @Test
    void depositarEmConta() {

        // Saldo inicial: R$600 ; Limite: R$200
        // Na conta corrente, o saldoTotal é a soma do saldo mais o limite pré-autorizado:
        ContaCorrente cc1 = new ContaCorrente(0001, 1234, 600,800);
        Assertions.assertEquals(1400, cc1.calcSaldoTotal());

        cc1.depositarEmConta(400d);
        Assertions.assertEquals(1800, cc1.calcSaldoTotal());

        // Vamos tentar depositar um valor negativo - não é para alterar o saldo da conta:
        cc1.depositarEmConta(-200d);
        Assertions.assertEquals(1800, cc1.calcSaldoTotal());
    }
}