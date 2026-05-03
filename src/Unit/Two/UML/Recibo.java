package Unit.Two.UML;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Recibo {
	String nombreDelEmpleado;
	String direccion;
	LocalDate fechaDeEmision;
	List<String> desgloceDeConceptos = new ArrayList<>();
	double sueldoBruto;
	double sueldoNeto;

	public Recibo(String nombreDelEmpleado, String direccion, LocalDate fechaDeEmision, List<String> desgloceDeConceptos, double sueldoBruto, double sueldoNeto) {
		this.nombreDelEmpleado = nombreDelEmpleado;
		this.direccion = direccion;
		this.fechaDeEmision = fechaDeEmision;
		this.desgloceDeConceptos = desgloceDeConceptos;
		this.sueldoBruto = sueldoBruto;
		this.sueldoNeto = sueldoNeto;
	}
}
