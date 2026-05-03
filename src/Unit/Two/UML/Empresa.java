package Unit.Two.UML;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
	String nombre;
	String CUIT;
	List<Empleado> empleados = new ArrayList<>();
	List<Recibo> recibos = new ArrayList<>();
	
	public Empresa(String nombre, String CUIT, List<Empleado> empleados) {
		this.nombre = nombre;
		this.CUIT = CUIT;
		this.empleados = empleados;
	}

	public List<Recibo> getRecibos() {
		return recibos;
	}

	public double montoTotalDeSueldosBrutos() {
		double montoTotalDeSueldosBrutos = 0;
		for (Empleado empleado : empleados) {
			montoTotalDeSueldosBrutos += empleado.calcularSueldoBruto();
		}
		return (montoTotalDeSueldosBrutos);
	}

	public double montoTotalDeRetenciones() {
		double montoTotalDeRetenciones = 0;
		for (Empleado empleado : empleados) {
			montoTotalDeRetenciones += empleado.calcularRetenciones();
		}
		return (montoTotalDeRetenciones);
	}

	public double gastoTotalEnSueldos() {
		return (montoTotalDeSueldosBrutos() - montoTotalDeRetenciones());
	}

	public void liquidarSueldos() {
		for (Empleado empleado : empleados) {
			List<String> desgloce = new ArrayList<>();
			/* Aca se puede agregar cada concepto al desgloce */
			Recibo recibo = new Recibo(empleado.getNombre(), empleado.getDireccion(), LocalDate.now(), desgloce, empleado.calcularSueldoBruto(), empleado.calcularSueldoNeto());
			recibos.add(recibo);
		}
	}
}
