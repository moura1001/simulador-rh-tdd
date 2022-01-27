package tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.domain.model.Funcionario;
import tdd.domain.utils.RegraBonusException;

public class BonusServiceTest {
	
	private BonusService service;
	
	@BeforeEach
	void inicializar() {
		service = new BonusService();
	}

	@Test
	void funcionarioComSalarioMuitoAltoNaoDeveReceberBonus() {
		Funcionario funcionario = new Funcionario("João", LocalDate.now(), new BigDecimal("16000"));
		
		assertThrows(RegraBonusException.class, () -> service.calcularBonus(funcionario));
	}
	
	@Test
	void bonusDeveSer10PorCentoDoSalario() {
		Funcionario funcionario = new Funcionario("João", LocalDate.now(), new BigDecimal("4000"));
		BigDecimal bonus = service.calcularBonus(funcionario);
		
		assertEquals(new BigDecimal("400.00"), bonus);
	}
	
	@Test
	void bonusDeveSer10PorCentoParaSalarioDeExatamente10000() {
		Funcionario funcionario = new Funcionario("João", LocalDate.now(), new BigDecimal("10000"));
		BigDecimal bonus = service.calcularBonus(funcionario);
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
