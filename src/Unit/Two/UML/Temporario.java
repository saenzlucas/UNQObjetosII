package Unit.Two.UML;

import java.time.LocalDate;

public class Temporario extends Empleado {
	LocalDate fechaDeFinalizacion;
	int cantHorasExt;
	
	public Temporario(String nombre, String direccion, String estadoCivil, LocalDate fechaDeNacimiento, double sueldoBasico, LocalDate fechaDeFinalizacion, int cantHorasExt) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.fechaDeFinalizacion = fechaDeFinalizacion;
		this.cantHorasExt = cantHorasExt;
	}

	@Override
	public double calcularSueldoBruto () {
		return (sueldoBasico + (cantHorasExt * 40));
	}
	
	@Override
	public double calcularRetenciones () {
		double retenciones = (calcularSueldoBruto () * 0.1) + (calcularSueldoBruto () * 0.1) + (cantHorasExt*5);
		if (calcularEdad () > 50) {
			return (retenciones + 25);
		} else {
			return (retenciones);
		}
	}
	
	@Override
	public double calcularSueldoNeto () {
		return (calcularSueldoBruto () - calcularRetenciones ());
	}
}
