package Unit.Two.UML;

@SuppressWarnings("unused")
public class Concepto {
	private String nombre;
	private double monto;
	
	public Concepto(String nombre, double monto) {
		this.nombre = nombre;
		this.monto = monto;
	}

	public double getMonto() {
		return monto;
	}
}
