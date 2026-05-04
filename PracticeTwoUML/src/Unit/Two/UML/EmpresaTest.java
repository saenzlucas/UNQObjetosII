package Unit.Two.UML;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class EmpresaTest {
	
	Permanente permanente = new Permanente ("Rodrigo Garcia", "Avellaneda", "Casado", LocalDate.of(2005, 5, 9), 15000, 2, 21);
	Contratado contratado = new Contratado ("Juan Suarez", "Berazategui", "Soltero", LocalDate.of(2004, 4, 10), 12500, "Transferencia", 540793);
	Temporario temporario = new Temporario ("Ezequiel Robles", "Quilmes", "Divorciado", LocalDate.of(2006, 11, 5), 10000, LocalDate.of(2026, 11, 24), 5);

	List<Empleado> empleados = new ArrayList<>(List.of(permanente, contratado, temporario));
	
	Empresa empresa = new Empresa ("IAVA", "20361425186", empleados);
	
	@Test
	void Arithmetic() {
		assertEquals (empresa.montoTotalDeSueldosBrutos(), 39150.0);
		assertEquals (empresa.montoTotalDeRetenciones(), 6267.5);
		assertEquals (empresa.gastoTotalEnSueldos(), 32882.5);
	}

	@Test
	void Actions() {
		empresa.liquidarSueldos();
		assertFalse (empresa.getRecibos().isEmpty());
	}
	
}
