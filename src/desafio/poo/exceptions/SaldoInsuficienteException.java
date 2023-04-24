package desafio.poo.exceptions;

public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException() {
        super();
    }

    public SaldoInsuficienteException(String mensagemErro) {
        super(mensagemErro);
    }
}
