package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar() {
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Maria", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
//	@AfterEach
//	public void depoisDeCadaMetodo() {
//		Mesmo comportamento do @BeforeEach com a diferença que é executado após cada método.
//	}
//	
//	@BeforeAll
//	public static void antesDeTodosOsMetodos() {
//		É executado uma única vez, antes de todos os métodos. 
//	}
//	
//	@AfterAll
//	public static void depoisDeTodosOsMetodos() {
//		É executado uma única vez, após a execução de todos os métodos.
//	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
		
		service.concederReajuste(funcionario, Desempenho.BOM);
		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
		
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
}
