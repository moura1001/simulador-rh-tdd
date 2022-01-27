package tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.domain.model.Desempenho;
import tdd.domain.model.Funcionario;

public class ReajusteServiceTest {
	
	private Funcionario funcionario;
	private ReajusteService service;
	
	@BeforeEach
	void inicializar() {
		funcionario = new Funcionario("Maria", LocalDate.now(), new BigDecimal("4000"));
		service = new ReajusteService();
	}

	@Test
	void reajusteSalarialDeveSerDe3PorcentoQuandoDesempenhoForADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("4120.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteSalarialDeveSerDe15PorcentoQuandoDesempenhoForBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		
		assertEquals(new BigDecimal("4600.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteSalarialDeveSerDe20PorcentoQuandoDesempenhoForOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		
		assertEquals(new BigDecimal("4800.00"), funcionario.getSalario());
	}

}
