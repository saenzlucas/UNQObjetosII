package Unit.Two.UML;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class Temporario extends Empleado {
	private LocalDate fechaDeFinalizacion;
	private int cantHorasExt;
	private Concepto horasExtra;
	private Concepto obraSocial;
	private Concepto aportesJubilatorios;
	
	public Temporario(String nombre, String direccion, String estadoCivil, LocalDate fechaDeNacimiento, double sueldoBasico, LocalDate fechaDeFinalizacion, int cantHorasExt) {
		// Basics ~
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.sueldoBasico = sueldoBasico;
		this.fechaDeFinalizacion = fechaDeFinalizacion;
		this.cantHorasExt = cantHorasExt;
		
		// Bonos ~
		this.horasExtra = new Concepto ("Horas Extra", 40 * cantHorasExt);
		
		// Retenciones ~
		this.aportesJubilatorios = new Concepto ("Aportes Jubilatorios", -((calcularSueldoBruto () * 0.1) + (cantHorasExt * 5)));
	}

	@Override
	public double calcularSueldoBruto () {
		bonos.clear();
		bonos.add(horasExtra);
		return (sueldoBasico + bonos.stream().mapToDouble(Concepto::getMonto).sum());
	}
	
	@Override
	public double calcularRetenciones () {
		retenciones.clear();
		retenciones.add(aportesJubilatorios);
		if (calcularEdad () > 50) {
			obraSocial = new Concepto ("Obra Social", -((calcularSueldoBruto () * 0.1) + 25));
			retenciones.add(obraSocial);
		} else {
			obraSocial = new Concepto ("Obra Social", -(calcularSueldoBruto () * 0.1));
			retenciones.add(obraSocial);
		}
		return (retenciones.stream().mapToDouble(Concepto::getMonto).sum());
	}
	
	@Override
	public double calcularSueldoNeto () {
		return (calcularSueldoBruto () - (-calcularRetenciones ()));
	}
}
