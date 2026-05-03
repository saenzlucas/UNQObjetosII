package Unit.Two.UML;

import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado {
	String nombre;
	String direccion;
	protected String estadoCivil;
	LocalDate fechaDeNacimiento;
	protected double sueldoBasico;
	
	public abstract double calcularSueldoBruto();
	
	public abstract double calcularRetenciones();
	
	public abstract double calcularSueldoNeto();

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	protected int calcularEdad () {
		LocalDate fechaActual = LocalDate.now();
		return (Period.between(fechaDeNacimiento, fechaActual).getYears());
	}
}
