package Unit.Two.UML;

import java.time.LocalDate;

public class Contratado extends Empleado {
	String medioDePago;
	int numeroDeContrato;
	
	public Contratado(String nombre, String direccion, String estadoCivil, LocalDate fechaDeNacimiento, double sueldoBasico, String medioDePago, int numeroDeContrato) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.medioDePago = medioDePago;
		this.numeroDeContrato = numeroDeContrato;
	}

	@Override
	public double calcularSueldoBruto() {
		return (sueldoBasico);
	}

	@Override
	public double calcularRetenciones() {
		return (50);
	}
	
	@Override
	public double calcularSueldoNeto() {
		return (calcularSueldoBruto() - calcularRetenciones());
	}
}
