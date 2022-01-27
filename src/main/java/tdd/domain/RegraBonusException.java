package tdd.domain;

public class RegraBonusException extends RuntimeException {
	
	public RegraBonusException() {
		super("Funcion�rio com sal�rio maior que R$ 10000 n�o pode receber b�nus.");
	}
	
	public RegraBonusException(String mensagemDeErro) {
		super(mensagemDeErro);
	}
}
