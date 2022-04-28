package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void TesteSalarioMaiorNaoDeveRetornarBonus() {
		BonusService service = new BonusService();
		
		assertThrows(IllegalArgumentException.class, 
				() -> service.calcularBonus(new Funcionario("Edelson", LocalDate.now(), new BigDecimal("15000"))));

		// ou
		
		/*
		 * try { service.calcularBonus(new Funcionario("Edelson", LocalDate.now(), new
		 * BigDecimal("15000"))); fail("N�o deu exception!"); } catch (Exception e) {
		 * assertEquals("Funcion�rio com sal�rio maior que R$10.000 n�o pode receber b�nus"
		 * , e.getMessage()); }
		 */
	}
	
	@Test
	void TesteSalarioMenorDeveRetornarBonus() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Edelson", LocalDate.now(), new BigDecimal("5000")));
		
		assertEquals(new BigDecimal("500.00"), bonus);
	}
	
	@Test
	void TesteSalarioComBonusIgualAMil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Edelson", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
