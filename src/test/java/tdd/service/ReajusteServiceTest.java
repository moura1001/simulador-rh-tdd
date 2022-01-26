package tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import tdd.domain.Desempenho;
import tdd.domain.Funcionario;

public class ReajusteServiceTest {
	
	@Test
	void reajusteSalarialDeveSerDe3PorcentoQuandoDesempenhoForADesejar() {
		Funcionario funcionario = new Funcionario("Maria", LocalDate.now(), new BigDecimal("4000"));
		ReajusteService service = new ReajusteService();
		
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("4120.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteSalarialDeveSerDe15PorcentoQuandoDesempenhoForBom() {
		Funcionario funcionario = new Funcionario("Maria", LocalDate.now(), new BigDecimal("4000"));
		ReajusteService service = new ReajusteService();
		
		service.concederReajuste(funcionario, Desempenho.BOM);
		
		assertEquals(new BigDecimal("4600.00"), funcionario.getSalario());
	}

}
