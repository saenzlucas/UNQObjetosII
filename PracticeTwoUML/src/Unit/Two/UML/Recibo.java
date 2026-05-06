package Unit.Two.UML;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Recibo {
	private String nombreDelEmpleado;
	private String direccion;
	private LocalDate fechaDeEmision;
	private List<Concepto> desgloceDeConceptos = new ArrayList<>();
	private double sueldoBruto;
	private double sueldoNeto;

	public Recibo(String nombreDelEmpleado, String direccion, LocalDate fechaDeEmision, List<Concepto> desgloceDeConceptos, double sueldoBruto, double sueldoNeto) {
		this.nombreDelEmpleado = nombreDelEmpleado;
		this.direccion = direccion;
		this.fechaDeEmision = fechaDeEmision;
		this.desgloceDeConceptos = desgloceDeConceptos;
		this.sueldoBruto = sueldoBruto;
		this.sueldoNeto = sueldoNeto;
	}
}
