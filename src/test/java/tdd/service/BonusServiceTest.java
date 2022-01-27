package tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import tdd.domain.Funcionario;

public class BonusServiceTest {
	
	@Test
	void bonusDeveSerZeroParaFuncionarioComSalarioMuitoAlto() {
		Funcionario funcionario = new Funcionario("Jo�o", LocalDate.now(), new BigDecimal("16000"));
		BonusService service = new BonusService();
				
		assertThrows(RegraBonusException.class, () -> service.calcularBonus(funcionario));
	}
	
	@Test
	void bonusDeveSer10PorCentoDoSalario() {
		Funcionario funcionario = new Funcionario("Jo�o", LocalDate.now(), new BigDecimal("4000"));
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(funcionario);
		
		assertEquals(new BigDecimal("400.00"), bonus);
	}
	
	@Test
	void bonusDeveSer10PorCentoParaSalarioDeExatamente10000() {
		Funcionario funcionario = new Funcionario("Jo�o", LocalDate.now(), new BigDecimal("10000"));
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(funcionario);
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
