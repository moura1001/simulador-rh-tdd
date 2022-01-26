package tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import tdd.domain.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal dezPorCento = new BigDecimal("0.10");
		BigDecimal bonus = funcionario.getSalario().multiply(dezPorCento);
		if(bonus.compareTo(new BigDecimal("1000")) > 0) {
			bonus = BigDecimal.ZERO;
		}
		return bonus.setScale(2, RoundingMode.HALF_UP);
	}

}
