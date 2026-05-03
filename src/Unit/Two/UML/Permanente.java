package Unit.Two.UML;

import java.time.LocalDate;

public class Permanente extends Empleado {
	int cantidadDeHijos;
	int antiguedad;
	
	public Permanente(String nombre, String direccion, String estadoCivil, LocalDate fechaDeNacimiento, double sueldoBasico, int cantidadDeHijos, int antiguedad) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.cantidadDeHijos = cantidadDeHijos;
		this.antiguedad = antiguedad;
	}

	@Override
	public double calcularSueldoBruto () {
		double sueldoBruto = sueldoBasico + (cantidadDeHijos *  150) + (antiguedad * 50);
		if (estadoCivil == "Casado") {
			return (sueldoBruto + 100);
		} else { 
			return (sueldoBruto);
		}
	}
	
	@Override
	public double calcularRetenciones () {
		return ((calcularSueldoBruto () * 0.1) + (cantidadDeHijos * 20) + (calcularSueldoBruto () * 0.15));
	}
	
	@Override
	public double calcularSueldoNeto () {
		return (calcularSueldoBruto () - calcularRetenciones ());
	}
}
