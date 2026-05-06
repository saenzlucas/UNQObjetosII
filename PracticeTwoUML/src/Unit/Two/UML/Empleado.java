package Unit.Two.UML;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
	protected String nombre;
	protected String direccion;
	protected String estadoCivil;
	protected LocalDate fechaDeNacimiento;
	protected double sueldoBasico;
	protected List<Concepto> bonos = new ArrayList<>();
	protected List<Concepto> retenciones = new ArrayList<>();
	
	public abstract double calcularSueldoBruto();

	public abstract double calcularRetenciones();
	
	public abstract double calcularSueldoNeto();

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	
	public List<Concepto> getBonos() {
		return bonos;
	}
	
	public List<Concepto> getRetenciones() {
		return retenciones;
	}

	protected int calcularEdad () {
		LocalDate fechaActual = LocalDate.now();
		return (Period.between(fechaDeNacimiento, fechaActual).getYears());
	}
}
