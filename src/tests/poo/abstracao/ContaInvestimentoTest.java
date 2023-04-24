package tests.poo.abstracao;

import desafio.exceptions.SaldoInsuficienteException;
import desafio.poo.abstracao.ContaCorrente;
import desafio.poo.abstracao.ContaInvestimento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaInvestimentoTest {

    @Test
    void calcSaldoTotal() throws SaldoInsuficienteException {
        // Saldo inicial: R$600 ; Investimento: R$800
        // Na conta investimento, o saldoTotal é a soma do saldo mais o valor investido:
        ContaInvestimento ci1 = new ContaInvestimento(0001, 1234, 600, 800, false);
        Assertions.assertEquals(600, ci1.getSaldoConta());
        Assertions.assertEquals(800, ci1.getValorInvestido());
        Assertions.assertEquals(1400, ci1.calcSaldoTotal());

        ci1.sacarDaConta(100d);
        Assertions.assertEquals(500, ci1.getSaldoConta());
        Assertions.assertEquals(800, ci1.getValorInvestido());
        Assertions.assertEquals(1300, ci1.calcSaldoTotal());


        ci1.depositarEmConta(50d);
        Assertions.assertEquals(550, ci1.getSaldoConta());
        Assertions.assertEquals(800, ci1.getValorInvestido());
        Assertions.assertEquals(1350, ci1.calcSaldoTotal());
    }

    @Test
    void sacarDaConta() throws SaldoInsuficienteException {

        // Saldo inicial: R$600 ; Limite: R$200
        // Na conta corrente, o saldoTotal é a soma do saldo mais o limite pré-autorizado:
        ContaInvestimento cc1 = new ContaInvestimento(0001, 1234, 600,800, true);
        Assertions.assertEquals(1400, cc1.calcSaldoTotal());

        // Vamos realizar um saque normal:
        cc1.sacarDaConta(100d);
        Assertions.assertEquals(1300, cc1.calcSaldoTotal());

        // Vamos tentar sacar um valor negativo - não é para alterar o saldo em conta:
        cc1.sacarDaConta(-250d);
        Assertions.assertEquals(1300, cc1.calcSaldoTotal());

        // Sabendo que nosso saldo é de R$500 e nosso investimento é de R$800, vamos sacar R$1.000:
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
        // Na conta Investimento, o saldoTotal é a soma do saldo mais o limite pré-autorizado:
        ContaInvestimento ci1 = new ContaInvestimento(0001, 1234, 600,800, true);
        Assertions.assertEquals(1400, ci1.calcSaldoTotal());

        ci1.depositarEmConta(400d);
        Assertions.assertEquals(1800, ci1.calcSaldoTotal());

        // Vamos tentar depositar um valor negativo. Não é para alterar o saldo da conta:
        ci1.depositarEmConta(-200d);
        Assertions.assertEquals(1800, ci1.calcSaldoTotal());

    }

    @Test
    void investir() throws SaldoInsuficienteException {

        // Saldo inicial: R$600 ; Limite: R$200
        // Na conta Investimento, o saldoTotal é a soma do saldo mais o valor investido:
        ContaInvestimento ci1 = new ContaInvestimento(0001, 1234, 600,800, true);
        Assertions.assertEquals(1400, ci1.calcSaldoTotal());

        // Quando investimos, sacamos da conta e aplicamos no investimento. Portanto, o saldo final não altera:
        ci1.investir(200d);
        Assertions.assertEquals(1400, ci1.calcSaldoTotal());

        // Agora, temos R$400 em conta e R$1000 investido.
        // Vamos tentar investir R$500 e não é para ter saldo suficiente:
        Assertions.assertThrowsExactly(SaldoInsuficienteException.class, () -> {
            ci1.investir(500);
        });

    }

    @Test
    void sacarInvestimento() throws SaldoInsuficienteException {

        // Saldo inicial: R$600 ; Valor investido: R$800
        // Na conta investimento, o saldoTotal é a soma do saldo mais o valor investido:
        ContaInvestimento ci1 = new ContaInvestimento(0001, 1234, 600,800, true);
        Assertions.assertEquals(1400, ci1.calcSaldoTotal());

        // Vamos realizar um saque normal:
        ci1.sacarDaConta(100d);
        Assertions.assertEquals(1300, ci1.calcSaldoTotal());

        // Vamos tentar sacar um valor negativo - não é para alterar o saldo em conta:
        ci1.sacarDaConta(-250d);
        Assertions.assertEquals(1300, ci1.calcSaldoTotal());

        // Sabendo que nosso saldo é de R$500 e nosso limite é de R$800, vamos sacar R$1.000:
        ci1.sacarDaConta(1000d);
        Assertions.assertEquals(300, ci1.calcSaldoTotal());


        // Vamos tentar sacar mais do que temos em conta + limite:
        Assertions.assertThrowsExactly(SaldoInsuficienteException.class, () -> {
            // Saldo é R$300 e vamos tentar sacar R$800
            ci1.sacarDaConta(800);
        });

    }
}