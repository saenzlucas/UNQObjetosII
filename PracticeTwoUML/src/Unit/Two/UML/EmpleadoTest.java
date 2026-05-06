package Unit.Two.UML;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class EmpleadoTest {
	
	private Permanente permanente = new Permanente("Rodrigo Garcia", "Avellaneda", "Casado", LocalDate.of(2005, 5, 9), 15000, 2,21);
	private Permanente permanenteSoltero = new Permanente("Rodrigo Garcia", "Avellaneda", "Soltero", LocalDate.of(2005, 5, 9), 15000, 2,21);
	
	private Contratado contratado = new Contratado("Juan Suarez", "Berazategui", "Soltero", LocalDate.of(2004, 4, 10), 12500,"Transferencia", 540793);
	
	private Temporario temporario = new Temporario("Ezequiel Robles", "Quilmes", "Divorciado", LocalDate.of(2006, 11, 5), 10000,LocalDate.of(2026, 11, 24), 5);
	private Temporario temporarioMas50 = new Temporario("Ezequiel Robles", "Quilmes", "Divorciado", LocalDate.of(1956, 11, 5), 10000,LocalDate.of(2026, 11, 24), 5);
	
	@Test
	void Basics () {
		assertEquals (permanente.getNombre(), "Rodrigo Garcia");
		assertEquals (contratado.getDireccion(), "Berazategui");
		assertEquals (temporario.calcularEdad (), 19);
	}
	
	@Test
	void SueldoBruto () {
		assertEquals(permanente.calcularSueldoBruto(), 16450.0);
		assertEquals(permanenteSoltero.calcularSueldoBruto(), 16350.0);
		assertEquals(contratado.calcularSueldoBruto(), 12500.0);
		assertEquals(temporario.calcularSueldoBruto(), 10200.0);
	}

	@Test
	void Retenciones () {
		assertEquals(permanente.calcularRetenciones(), -4152.5);
		assertEquals(contratado.calcularRetenciones(), -50.0);
		assertEquals(temporario.calcularRetenciones(), -2065.0);
		assertEquals(temporarioMas50.calcularRetenciones(), -2090.0);
		
	}

	@Test
	void SueldoNeto () {
		assertEquals(permanente.calcularSueldoNeto(), 12297.5);
		assertEquals(contratado.calcularSueldoNeto(), 12450.0);
		assertEquals(temporario.calcularSueldoNeto(), 8135.0);
	}
	
}
