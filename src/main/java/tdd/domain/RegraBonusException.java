package tdd.domain;

public class RegraBonusException extends RuntimeException {
	
	public RegraBonusException() {
		super("Funcionário com salário maior que R$ 10000 não pode receber bônus.");
	}
	
	public RegraBonusException(String mensagemDeErro) {
		super(mensagemDeErro);
	}
}
