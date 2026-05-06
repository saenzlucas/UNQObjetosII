package Unit.Two.UML;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class Contratado extends Empleado {
	private String medioDePago;
	private int numeroDeContrato;
	private Concepto gastosAdministrativos;
	
	public Contratado(String nombre, String direccion, String estadoCivil, LocalDate fechaDeNacimiento, double sueldoBasico, String medioDePago, int numeroDeContrato) {
		// Basics ~
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.medioDePago = medioDePago;
		this.numeroDeContrato = numeroDeContrato;
		
		// Retenciones ~
		this.gastosAdministrativos = new Concepto ("Gastos Administrativos Contractuales", -50);
	}
	
	@Override
	public double calcularSueldoBruto() {
		return (sueldoBasico);
	}
	
	@Override
	public double calcularRetenciones() {	
		retenciones.clear();
		retenciones.add(gastosAdministrativos);
		return (retenciones.stream().mapToDouble(Concepto::getMonto).sum());
	}
	
	@Override
	public double calcularSueldoNeto() {
		return (calcularSueldoBruto () - (-calcularRetenciones ()));
	}
}
