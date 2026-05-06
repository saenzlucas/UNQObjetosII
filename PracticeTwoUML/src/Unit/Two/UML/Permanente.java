package Unit.Two.UML;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class Permanente extends Empleado {
	private int cantidadDeHijos;
	private int antiguedad;
	private Concepto asignacionPorHijo;
	private Concepto bonoPorAntiguedad;
	private Concepto asignacionPorConyugue;
	private Concepto obraSocial;
	private Concepto aportesJubilatorios;
	
	public Permanente(String nombre, String direccion, String estadoCivil, LocalDate fechaDeNacimiento, double sueldoBasico, int cantidadDeHijos, int antiguedad) {
		// Basics ~
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.cantidadDeHijos = cantidadDeHijos;
		this.antiguedad = antiguedad;
		
		// Bonos ~
		this.asignacionPorHijo = new Concepto ("Asignación por hijo", 150 * cantidadDeHijos);
		this.bonoPorAntiguedad = new Concepto ("Bono por Antiguedad", 50 * antiguedad);
		
		// Retenciones ~
		this.obraSocial = new Concepto ("Obra Social", -((calcularSueldoBruto () * 0.1) + (cantidadDeHijos * 20)));
		this.aportesJubilatorios = new Concepto ("Aportes Jubilatorios", -(calcularSueldoBruto () * 0.15));
	}

	@Override
	public double calcularSueldoBruto () {
		bonos.clear();
		bonos.add(asignacionPorHijo);
		bonos.add(bonoPorAntiguedad);
		if (estadoCivil == "Casado") {
			asignacionPorConyugue = new Concepto ("Asignación por conyugue", 100);
			bonos.add(asignacionPorConyugue);
		} else { 
			asignacionPorConyugue = new Concepto ("Asignación por conyugue", 0);
			bonos.add(asignacionPorConyugue);
		}
		return (sueldoBasico + bonos.stream().mapToDouble(Concepto::getMonto).sum());
	}
	
	@Override
	public double calcularRetenciones () {
		retenciones.clear();
		retenciones.add(obraSocial);
		retenciones.add(aportesJubilatorios);
		return (retenciones.stream().mapToDouble(Concepto::getMonto).sum());
	}
	
	@Override
	public double calcularSueldoNeto () {
		return (calcularSueldoBruto () - (-calcularRetenciones ()));
	}
}
