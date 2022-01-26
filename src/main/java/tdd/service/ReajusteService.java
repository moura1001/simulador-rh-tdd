package tdd.service;

import java.math.BigDecimal;

import tdd.domain.Desempenho;
import tdd.domain.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
		BigDecimal percentualReajuste = desempenho.percentualReajuste();
		BigDecimal reajuste = funcionario.getSalario().multiply(percentualReajuste);
		funcionario.reajustarSalario(reajuste);
	}

}
